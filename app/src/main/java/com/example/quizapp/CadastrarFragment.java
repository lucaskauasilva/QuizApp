package com.example.quizapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CadastrarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CadastrarFragment extends Fragment {

    private EditText mEditTextPergunta;
    private EditText mEditTextResposta;
    private Button mButtonCadastrar;
    private Button mButtonJogar;

    public CadastrarFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastrar, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            mEditTextPergunta = getActivity().findViewById(R.id.etPergunta);
            mEditTextResposta = getActivity().findViewById(R.id.etResposta);
            mButtonCadastrar = getActivity().findViewById(R.id.btnCadastrar);
            mButtonJogar = getActivity().findViewById(R.id.btnJogar);

            /* @+id/etPergunta (mEditTextPergunta) */ //{ à implementar }

            /* @+id/etResposta (mEditTextResposta) */ //{ à implementar }

            /* @+id/btnCadastrar (mButtonCadastrar) */ //{ à implementar }
            mButtonCadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String pergunta = mEditTextPergunta.getText().toString();
                    String resposta = mEditTextResposta.getText().toString();

                    if(!pergunta.isEmpty() && !resposta.isEmpty()){
                        // Cria um objeto do tipo Questoes com os valores digitados pelo usuário
                        Questoes questoes =  new Questoes(pergunta, resposta);

                        // através da classe DAO insere questoes no BD
                        BancoDeDados.getBancoDeDados(getActivity())
                                .meuDAO().inserirQuestoes(questoes);

                        mEditTextPergunta.setText("");
                        mEditTextResposta.setText("");

                        Toast.makeText(getActivity(), "inserido com sucesso!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            /* @+id/btnJogar (mButtonJogar) */ //{ à implementar }
            mButtonJogar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frameLayout, new JogarFragment()).commit();
                }
            });
    }
}