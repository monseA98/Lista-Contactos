package com.example.listacontactos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private Adapter adaptador;

    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Tostada", Toast.LENGTH_SHORT).show();

        contactos = new ArrayList<>();
        contactos.add(new Contacto("Monse", "monse@gmail.com", "@MonseAlmanzaZ", "4451151261", "18/02/1998"));
        adaptador = new Adapter(this, contactos);

        lista = (ListView) findViewById(R.id.listContacto);
        lista.setAdapter(adaptador);


        findViewById(R.id.btnAgregar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivityForResult(intent, 1000);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == MainActivity.RESULT_OK){
            Contacto c = (Contacto)data.getSerializableExtra("contact");
            contactos.add(c);

            Toast.makeText(this, "Guardando : " + c.getUsuario(), Toast.LENGTH_SHORT).show();
            actualizar();
        }else{
            Toast.makeText(this, "Se canceló la operación", Toast.LENGTH_SHORT).show();
        }

    }

    public void actualizar(){
        adaptador = new Adapter(this, contactos);
        lista.setAdapter(adaptador);
    }

    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle objetoRecibido = data.getExtras();

        Contacto c = null;
        if (requestCode == 1) {
            c = (Contacto) objetoRecibido.getSerializable("contact");
            Toast.makeText(getApplicationContext(), "Ha llegado " +c.getUsuario().toString(), Toast.LENGTH_SHORT).show();

            if (c != null)
                lista.add(c);
                Toast.makeText(this, "User " + lista.get(0).getUsuario(), Toast.LENGTH_SHORT).show();
        }
    }

     */

}
