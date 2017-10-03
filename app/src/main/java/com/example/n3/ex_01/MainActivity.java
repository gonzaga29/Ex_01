package com.example.n3.ex_01;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ArrayAdapter;
import android.widget.Adapter;
import android.app.Activity;
import android.view.ContextMenu;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import android.view.Menu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;

import static com.example.n3.ex_01.Constantes.LISTA;
import static com.example.n3.ex_01.Constantes.SMS;
import static com.example.n3.ex_01.Constantes.VALUE;


public class MainActivity extends AppCompatActivity{

    private ListView list;
    private EditText edtToast;
    private Button btnToast;
    private Button btnTela2;
    private ArrayList<Studant> studants;
    private Studant studant;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {

            studants = (ArrayList<Studant>) savedInstanceState.getSerializable(LISTA);

        } else {
            studants = new ArrayList<Studant>();
        }

        edtToast = (EditText) findViewById(R.id.edtToast);
        btnToast = (Button) findViewById(R.id.btnToast);
        btnTela2 = (Button) findViewById(R.id.btnTela2);
        list = (ListView) findViewById(R.id.list_studant);
        studant = new Studant();
        preencheLista();
        registerForContextMenu(list);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, edtToast.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        btnTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, StudantActivity.class);
                startActivityForResult(it, 1);

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                studant = (Studant) data.getSerializableExtra(VALUE);
                studants.add(studant);
                preencheLista();
            }
            if (resultCode == Activity.RESULT_CANCELED) {

                //Toast.makeText(MainActivity.this, "fudeu", Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putSerializable(LISTA, studants);
        super.onSaveInstanceState(outState);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        // super.onCreateContextMenu(menu,v,menuInfo);
        menu.setHeaderTitle(R.string.menu_titulo);
        getMenuInflater().inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Studant obj = (Studant) list.getItemAtPosition(acmi.position);

        switch (item.getItemId()) {
            case R.id.ligar:

                Uri uri = Uri.parse("tel:"+obj.getTelefone());
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
                return true;

            case R.id.sms:

                //LayoutInflater li = getLayoutInflater();
                //li.inflate( R.layout.sms_context, null );
                Intent it_sms = new Intent(MainActivity.this,Send_SMS.class);
                it_sms.putExtra(SMS,obj.getTelefone().toString());
                startActivity(it_sms);


                /*Intent enviarSMS = new Intent(Intent.ACTION_VIEW);
                enviarSMS.putExtra("texto da mensagem",obj.getTelefone().toString());
                enviarSMS.setType("vnd.android-dir/mms-sms");
                startActivity(enviarSMS);*/

                //SmsManager smsManager = SmsManager.getDefault();
                //smsManager.sendTextMessage(obj.getTelefone().toString(), null, "texto do SMS", null, null);
                return true;

            case R.id.mapa:

                Uri gmmIntentUri = Uri.parse("geo:0,0?q=1600"+obj.getEnereço());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);


                return true;

            case R.id.site:

                Uri uri1 = Uri.parse("http://"+obj.getSite_pessoal());
                Intent it_site = new Intent(Intent.ACTION_VIEW, uri1);
                startActivity(it_site);
                return true;

            default:

                return super.onOptionsItemSelected(item);
        }

    }

    private void preencheLista(){

        ArrayAdapter<Studant> adapter = new ArrayAdapter<Studant>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, studants);
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


}
