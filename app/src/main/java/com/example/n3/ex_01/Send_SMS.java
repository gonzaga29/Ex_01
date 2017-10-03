package com.example.n3.ex_01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.n3.ex_01.Constantes.SMS;

public class Send_SMS extends AppCompatActivity {

    private EditText edt_sms;
    private Button btn_sms;
    private String sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send__sms);

        edt_sms = (EditText) findViewById(R.id.edt_sms);
        btn_sms = (Button) findViewById(R.id.btn_sms);

        enviar();

    }

    private String get_telefone(){

        Intent it = getIntent();
        return it.getStringExtra(SMS);


    }

    private void enviar(){

        btn_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sms = edt_sms.getText().toString();

                if(sms.equals(null) || sms.equals("")) {

                    Toast.makeText(Send_SMS.this,"sem mensagem",Toast.LENGTH_SHORT).show();
                }else{

                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(get_telefone(), null, sms, null, null);
                    Toast.makeText(Send_SMS.this,"Feliz",Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
