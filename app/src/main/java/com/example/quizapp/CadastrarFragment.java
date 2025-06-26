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
            mButtonCadastrar = getActivity().findViewById(R.id.btnJogar);



    }
}