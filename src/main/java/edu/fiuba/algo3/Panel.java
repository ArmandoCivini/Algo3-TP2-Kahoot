package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.*;
import java.util.ArrayList;

public class Panel { // Panel es el modelo de un MVC
    Jugador jugador1;
    Jugador jugador2;
    Pregunta preguntaActual;
    public boolean juegoPuedeComenzar(){
        if(jugador2 != null){ return true;}
        return false;
    }
    public void agregarJugador(String nombre){
        if (this.jugador1 == null){
            this.jugador1 = new Jugador(nombre);
            return;
        }
        this.jugador2 = new Jugador(nombre);
    }

    //public void tienePenalidad(){
        //si tiene penalidad
       // if(jugador.getTieneMultiplicadorx2){
            //mostrarBoton
        //}
        //si tiene mostrar MultiplicadorX3


    public Pregunta crearPregunta(){
        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        Opcion verdadero1 = new OpcionChoice("verdadero", true);
        Opcion verdadero2 = new OpcionChoice("ya te dije verdadero", true);
        Opcion falso1 = new OpcionChoice("falso", false);
        Opcion falso2 = new OpcionChoice("A veces", false);
        todas.add(verdadero1);
        todas.add(verdadero2);
        todas.add(falso1);
        todas.add(falso2);
        Pregunta vyf = new MultipleChoice("El mate es rico?", todas, new Clasico());
        this.preguntaActual = vyf;
        return vyf;
    }
    public String nombreJugador(int cualJugador){
        if(cualJugador == 1){
            return jugador1.verNombre();
        }
        return jugador2.verNombre();
    }
}
