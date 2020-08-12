package edu.fiuba.algo3.modelo.preguntas;
import edu.fiuba.algo3.modelo.modalidades.ModalidadClasico;
import edu.fiuba.algo3.modelo.modalidades.Modalidad;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.util.ArrayList;

public class GroupChoice extends Pregunta {

    private int modificadorPuntajeExito = 1;
    private int modificadorPuntajeFracaso = 0;

    public GroupChoice(String pregunta, ArrayList<Opcion> todasLasOpciones) {
        super(pregunta, todasLasOpciones, new ModalidadClasico());
    }
}
