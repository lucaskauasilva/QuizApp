package com.example.quizapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link JogarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JogarFragment extends Fragment {

    private TextView mTextViewPergunta;
    private TextView mTextViewResposta;
    private Button mButtonExibirResposta;
    private Button mButtonPular;
    private Button mButtonCadastrarPeR;
    private List<Questoes> mListQuestoes;

    public JogarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jogar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTextViewPergunta = getActivity().findViewById(R.id.tvPergunta);
        mTextViewResposta = getActivity().findViewById(R.id.tvResposta);
        mButtonExibirResposta = getActivity().findViewById(R.id.btnExibirResposta);
        mButtonPular = getActivity().findViewById(R.id.btnPular);
        mButtonCadastrarPeR = getActivity().findViewById(R.id.btnCadastrarPeR);

        /* @+id/tvPergunta (mTextViewPergunta) */ //(à implementar)
        /* @+id/tvResposta (mTextViewResposta) */ //(à implementar)
        /* @+id/btnExibirResposta (mButtonExibirResposta) */ //(à implementar)
        /* @+id/btnPular (mButtonPular) */ //(à implementar)
        /* mListQuestoes */ //(implementado)
        mListQuestoes = BancoDeDados.getBancoDeDados(getActivity())
                .meuDAO().pesquisarTodasQuestoes();

        /* @+id/btnCadastrarPeR (mButtonCadastrarPeR) */ //(à implementar)
        mButtonCadastrarPeR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, new CadastrarFragment()).commit();
            }
        });
    }

    private void proximaQuestao() {

        if (!mListQuestoes.isEmpty()) {
            int totalDeQuestoes = mListQuestoes.size();
            int indexAleatorio = new Random().nextInt(totalDeQuestoes);
            Questoes questoes = mListQuestoes.get(indexAleatorio);
            mTextViewPergunta.setText(questoes.getPergunta());
            mTextViewResposta.setText(questoes.getResposta());
            mTextViewResposta.setVisibility(View.GONE);
        }
    }
}