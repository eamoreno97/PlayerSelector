package com.example.andresacosta.playerselector;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView ltView;
    public ArrayList<Jugadores> jugador;
    int jugador_edit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jugador = new ArrayList<Jugadores>();
        jugador.add(new Jugadores("David", "Ospina", "Arquero", true, 28));
        jugador.add(new Jugadores("Santiago", "Silva", "Defensa", false, 27));
        jugador.add(new Jugadores("Jeison", "Murillo", "Defensa", true, 26));
        jugador.add(new Jugadores("Roberto", "Dasilva", "Lateral", true, 29));
        jugador.add(new Jugadores("Camilo", "Zuñiga", "Lateral", true, 28));
        jugador.add(new Jugadores("Carlos", "Sanchez", "Contención", false, 28));
        jugador.add(new Jugadores("Victor", "Cantillo", "Contención", true, 27));
        jugador.add(new Jugadores("Toni", "Kroos", "Medio campo", true, 28));
        jugador.add(new Jugadores("Neymar", "Dasilva", "Delantero", true, 27));
        jugador.add(new Jugadores("Robert", "Lewandowski", "Delantero", true, 29));
        jugador.add(new Jugadores("Luis", "Muriel", "Delantero", false, 28));

        ltView = findViewById(R.id.playerList);

        CustomAdapter customAdapter = new CustomAdapter(this, jugador);
        ltView.setAdapter(customAdapter);
        final Context context = ltView.getContext();

        ltView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(context, JugadoresID.class);
                intent.putExtra("Jugador", jugador.get(i));
                startActivityForResult(intent, 2);
            }
        });
    }

    public void onClickEdit(View view){
          Intent btnIntent = new Intent(this, EditPlayers.class);
          jugador_edit = (int) view.getTag();
          btnIntent.putExtra("Jugador",jugador.get(jugador_edit));
          startActivityForResult(btnIntent,1);
    }

    @Override
    protected void onActivityResult(int resquestCode, int resultCode, Intent data){
        if (resquestCode == 1){
            if (resultCode == RESULT_OK){
                Jugadores newPlayer = (Jugadores) data.getSerializableExtra("Jugador");
                jugador.set(jugador_edit, newPlayer);
                CustomAdapter adapter = new CustomAdapter(this, jugador);
                ltView.setAdapter(adapter);
            }
        }
    }
}
