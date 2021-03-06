package edu.fiuba.algo3.modelo;
import java.util.ArrayList;

public class GroupChoice extends Pregunta{

    private int modificadorPuntajeExito = 1;
    private int modificadorPuntajeFracaso = 0;

    public GroupChoice(String pregunta, ArrayList<Opcion> todasLasOpciones, Modalidad modalidad) {
        super(pregunta, todasLasOpciones, modalidad);
        if(!(modalidad instanceof Clasico)){
            throw new GroupChoiceModalidadInvalidaException("[Error]: la pregunta 'OrderedChoice' solo se puede crear con modalidad clasica");
        }
    }
}
/*
    @Override

    protected void comprobarRespuesta(Respuesta respuesta) {
        ArrayList<Opcion> respuestasJugador = respuesta.verRespuestaJugador();
        for (Opcion opcion : respuestasJugador){
            if(!opcion.esCorrecto()){
                respuesta.modificarPuntaje(modificadorPuntajeFracaso);
                return;
            }
        }
        respuesta.modificarPuntaje(modificadorPuntajeExito);
    }

 */