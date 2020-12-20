package com.fernandomarino.nuevopetagram;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;


public class Contacto extends AppCompatActivity {

    private EditText etNombre;
    private EditText etMail;
    private EditText etMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setIcon(R.mipmap.pataperro);
        ab.setDisplayShowHomeEnabled(true);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etMail = (EditText) findViewById(R.id.etMail);
        etMensaje = (EditText) findViewById(R.id.etMensaje);

    }

    public void enviarMail(View v){



        String eMail = etMail.getText().toString();
        Intent eMailIntent = new Intent((Intent.ACTION_SEND));
        eMailIntent.setData(Uri.parse("mailto:" + etNombre));
        eMailIntent.putExtra(Intent.EXTRA_EMAIL, eMail);
        eMailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(eMailIntent, "Email"));
    }




    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}