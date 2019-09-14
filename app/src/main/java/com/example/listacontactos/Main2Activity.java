package com.example.listacontactos;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etEmail;
    private EditText etTwitter;
    private EditText etTel;
    private EditText etFecha;


    //List<Contacto> contactos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Igualar EditText con los elementos de la interfaz para que sean editables
        // La clase R es la intermediaria entre Java y XML
        etUsuario =  findViewById(R.id.txtUsuario);
        etEmail = findViewById(R.id.txtEmail);
        etTwitter = findViewById(R.id.txtTwitter);
        etTel = findViewById(R.id.txtTel);
        etFecha =  findViewById(R.id.txtFecha);


        findViewById(R.id.btnGuardar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contacto c = new Contacto(etUsuario.getText().toString(), etEmail.getText().toString(), etTwitter.getText().toString(), etTel.getText().toString(), etFecha.getText().toString());

                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("contact", c);

                intent.putExtras(bundle);
                setResult(-1, intent);
                finish();
            }
        });

    }



    /*
    public void Guardar (View v){
        c = new Contacto(etUsuario.getText().toString(), etEmail.getText().toString(), etTwitter.getText().toString(), etTel.getText().toString(),etFecha.getText().toString());
        //contactos.add(c);
        Toast.makeText(this, "Elem" + c.toString(), Toast.LENGTH_SHORT);

        Intent intent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("contact", c);

        intent.putExtras(bundle);
        setResult(RESULT_OK, intent);
        finish();
        //startActivity(intent);


    }

     */
}
