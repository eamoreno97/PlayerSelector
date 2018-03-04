package com.example.andresacosta.playerselector;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class JugadoresID extends AppCompatActivity {

    private String[] name, lastname, rol, age;
    private TextView tvNombre, tvApellido, tvPosicion, tvEdad;
    private ToggleButton btnSelected;
    private Button btnRegresar;
    private String[] select;
    private boolean status = false;
    private int ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores_id);

        Intent intent = getIntent();
        Jugadores players = (Jugadores) intent.getSerializableExtra("Jugador");

        tvNombre = findViewById(R.id.tvName);
        tvApellido = findViewById(R.id.tvLastName);
        tvPosicion = findViewById(R.id.tvRole);
        tvEdad = findViewById(R.id.tvAge);

        btnSelected = findViewById(R.id.btnSelected);
        btnRegresar = findViewById(R.id.btnReturn);

        name = getResources().getStringArray(Integer.parseInt(players.Nombre));
        lastname = getResources().getStringArray(Integer.parseInt(players.Apellido));
        rol = getResources().getStringArray(Integer.parseInt(players.Posicion));
        age = getResources().getStringArray(players.Edad);

        tvNombre.setText(tvNombre.getText().toString()+name[ed]);
        tvApellido.setText(tvApellido.getText().toString()+lastname[ed]);
        tvPosicion.setText(tvPosicion.getText().toString()+rol[ed]);
        tvEdad.setText(tvEdad.getText().toString()+age[ed]);

        btnSelected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    System.out.println("True");
                    status = true;
                    select[ed] = "Convocado";
                }else{
                    System.out.println("False");
                    status = false;
                    select[ed] = "No Convocado";
                }
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }
}
