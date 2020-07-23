package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalso extends Pregunta {
    String pregunta;
    ArrayList<Integer> respuestasCorrectas;
    TipoPenalidad penalidad;
    public VerdaderoFalso(String pregun, ArrayList<Integer> correcta, TipoPenalidad pena) {
        this.respuestasCorrectas = correcta;
        this.pregunta = pregun;
        this.penalidad = pena;
    }
    public ArrayList<Integer> verRespuestaCorrecta(){
        return respuestasCorrectas;
    }
    @Override
    public void comprobarrespuesta(Respuesta respuesta){
        penalidad.calcularpuntaje(respuesta, respuestasCorrectas);
    }

    @Override
    public void verPreguntayBotones() {

    }
}