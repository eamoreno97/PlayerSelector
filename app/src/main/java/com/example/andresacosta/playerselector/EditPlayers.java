package com.example.andresacosta.playerselector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ToggleButton;

public class EditPlayers extends AppCompatActivity {

    private EditText nombre, apellido, posicion, edad;
    private ToggleButton btnSelect;
    private Button btnSave;
    private boolean status = false;
    private String[] select;
    private int ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_players);

        Intent editIntent = getIntent();
        Jugadores editPlayers = (Jugadores) editIntent.getSerializableExtra("Player");

        nombre = findViewById(R.id.etName);
        apellido = findViewById(R.id.etLastname);
        posicion = findViewById(R.id.etRol);
        edad = findViewById(R.id.etAge);
        btnSelect = findViewById(R.id.btnSelected);
        btnSave = findViewById(R.id.btnSave);

        nombre.setText(editPlayers.Nombre);
        apellido.setText(editPlayers.Apellido);
        posicion.setText(editPlayers.Posicion);
        edad.setText(editPlayers.Edad);

        btnSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
    }

    public Jugadores getNewPlayer(){
        String name = nombre.getText().toString();
        String lastname = apellido.getText().toString();
        String rol = posicion.getText().toString();
        int age = Integer.parseInt(edad.getText().toString());
        boolean selected = btnSelect.isSelected();

        return new Jugadores(name, lastname, rol, selected, age);
    }

    public void onClickSave(View view){
        Intent saveIntent = new Intent();
        Jugadores newPlayer = getNewPlayer();
        saveIntent.putExtra("Jugador",newPlayer);
        setResult(RESULT_OK,saveIntent);
        finish();
    }
}
