package com.example.listacontactos;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    private Context context;
    private ArrayList<Contacto> arrayList;

    public Adapter(Context context, ArrayList<Contacto> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView= layoutInflater.inflate(R.layout.item,null);

        }

        TextView usuario = (TextView) convertView.findViewById(R.id.i_usuario);
        TextView email = (TextView) convertView.findViewById(R.id.i_email);

        usuario.setText(arrayList.get(position).getUsuario());
        email.setText(arrayList.get(position).getEmail());

        return convertView;
    }
}
