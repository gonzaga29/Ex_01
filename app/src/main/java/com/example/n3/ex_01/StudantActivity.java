package com.example.n3.ex_01;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.app.Activity;


import java.io.Serializable;

import static com.example.n3.ex_01.Constantes.VALUE;


public class StudantActivity extends AppCompatActivity{

    private EditText edtNome,edtFoto,edtEndereço,edtNota,edtSite_pessoal;
    private EditText edtTelefone;
    private Button btnCadastro;
    private Studant studant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studant);

        edtTelefone = (EditText) findViewById(R.id.telefone);
        edtEndereço = (EditText) findViewById(R.id.endereço);
        edtNome = (EditText) findViewById(R.id.nome);
        edtNota = (EditText) findViewById(R.id.nota);
        edtFoto = (EditText) findViewById(R.id.foto);
        edtSite_pessoal = (EditText) findViewById(R.id.site_pessoal);
        btnCadastro = (Button) findViewById(R.id.btnCadastra);
        studant = new Studant();

        edtSite_pessoal.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS|InputType.TYPE_TEXT_FLAG_AUTO_COMPLETE);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                studant.setNome(edtNome.getText().toString());
                studant.setTelefone(edtTelefone.getText().toString());
                studant.setFoto(edtFoto.getText().toString());
                studant.setEnereço(edtEndereço.getText().toString());
                studant.setSite_pessoal(edtSite_pessoal.getText().toString());

                Intent intent = new Intent();

                intent.putExtra(VALUE,studant);
                setResult(Activity.RESULT_OK, intent);
                finish();


            }
        });
    }
}
