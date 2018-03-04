package com.example.andresacosta.playerselector;

import java.io.Serializable;

public class Jugadores implements Serializable{

    String Nombre, Apellido, Posicion;
    boolean Convocado;
    int Edad;

    public Jugadores(String name, String lastname, String position, boolean selected, int age){

        this.Nombre = name;
        this.Apellido = lastname;
        this.Posicion = position;
        this.Convocado = selected;
        this.Edad = age;

    }

}
