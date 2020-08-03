package edu.fiuba.algo3.modelo;

public class OpcionGroup extends Opcion {
    private int grupoOriginal;
    private int grupoJugador;

    public OpcionGroup(String stringOpcion, int grupoOriginal){
        this.stringOpcion = stringOpcion;
        this.grupoOriginal = grupoOriginal;
    }

    @Override
    public boolean chequearOpcion(){
        return (grupoOriginal == grupoJugador);
    }

    public void setPosicionJugador(int grupoJugador) {
        this.grupoJugador = grupoJugador;
    }

    public int getposicionOriginal(){
        return grupoOriginal;
    }
}