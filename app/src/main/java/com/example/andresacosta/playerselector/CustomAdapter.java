package com.example.andresacosta.playerselector;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.TreeSet;

public class CustomAdapter extends BaseAdapter{

    protected Activity activity;
    protected ArrayList<Jugadores> values;

    public CustomAdapter(Activity activity, ArrayList<Jugadores> values){

        this.activity = activity;
        this.values = values;

    }

    @Override
    public int getCount() {
        return values.size();
    }

    @Override
    public Object getItem(int i) {
        return values.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.row,null);
        }

        Jugadores player = values.get(i);

        TextView nombre = v.findViewById(R.id.tvName);
        nombre.setText(player.Nombre);

        TextView apellido = v.findViewById(R.id.tvLastName);
        apellido.setText(player.Apellido);

        TextView posicion = v.findViewById(R.id.tvRole);
        posicion.setText(player.Posicion);

        TextView seleccionado = v.findViewById(R.id.tvSelected);
        seleccionado.setText(player.Convocado? "Si":"No");

        Button edit = v.findViewById(R.id.btnEdit);
        edit.setText("Editar");
        edit.setTag(i);
        edit.setFocusable(false);
        edit.setFocusableInTouchMode(false);
        return v;
    }
}
