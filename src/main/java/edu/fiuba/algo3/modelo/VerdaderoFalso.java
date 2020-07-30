package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class VerdaderoFalso extends Choice {
    public VerdaderoFalso(String pregunta, ArrayList<Integer> correcta, Modalidad penalidad) throws VyFMasDeDosOpcionesException {
        super(pregunta, correcta, penalidad);
        if (correcta.size()>1) {
            throw new VyFMasDeDosOpcionesException("no es posible más de una opcion correcta en VerdaderoYFalso");
        }
    }
}
