package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.lang.reflect.Array;
import java.util.ArrayList;
public class MultipleChoiceClasicoTest {
    @Test
    public void test03_1CrearMultipleChoiceClasico() {


        Opcion opcion1 = new Opcion("Si",true);
        Opcion opcion2 = new Opcion("Totalmente",true);
        Opcion opcion3 = new Opcion("no",false);
        Opcion opcion4 = new Opcion("para nada",false);
        Opcion opcion5 = new Opcion("nunca",false);

        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        todas.add(opcion1);
        todas.add(opcion2);
        todas.add(opcion3);
        todas.add(opcion4);
        todas.add(opcion5);

        Jugador jugador = new Jugador("Nicolas");
        ArrayList<Opcion> opcionesJugador = new ArrayList<Opcion>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion2);

        Respuesta respuesta = new Respuesta(opcionesJugador,jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);
        //Se crea la pregunta con la lista de opciones y la modalidad elegida.
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, new Clasico());
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1,jugador.puntaje().getPuntaje());
    }

    @Test
    public void test03_2ResponderMultipleChoiceyAsignarPuntajesCorrectamente(){
        Opcion opcion1 = new Opcion("Si",true);
        Opcion opcion2 = new Opcion("Totalmente",true);
        Opcion opcion3 = new Opcion("no",false);
        Opcion opcion4 = new Opcion("para nada",false);
        Opcion opcion5 = new Opcion("nunca",false);

        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        todas.add(opcion1);
        todas.add(opcion2);
        todas.add(opcion3);
        todas.add(opcion4);
        todas.add(opcion5);

        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Sofia");

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion1);
        opcionesJugador1.add(opcion2);

        ArrayList<Opcion> opcionesJugador2 = new ArrayList<Opcion>();
        opcionesJugador2.add(opcion3);
        opcionesJugador2.add(opcion4);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        //Se instancian las respuestas con la lista de opciones elegidas y el puntaje del jugador.
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionesJugador2, jugador2.puntaje());

        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        Clasico sinPenalidad = new Clasico(); //Modalidad de la pregunta

        //Se crea la pregunta con la lista de opciones y la modalidad elegida.
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, sinPenalidad);

        //Se pasan las respuestas de los jugadores a la pregunta.
        preguntaTest.responderPregunta(respuestas);

        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());
    }

    @Test
    public void test03_3ResponderMultipleChoiceyAsignarPuntajesCorrectamenteConUnaDeDosBien(){
        Opcion opcion1 = new Opcion("Si",true);
        Opcion opcion2 = new Opcion("Totalmente",true);
        Opcion opcion3 = new Opcion("no",false);
        Opcion opcion4 = new Opcion("para nada",false);
        Opcion opcion5 = new Opcion("nunca",false);

        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        todas.add(opcion1);
        todas.add(opcion2);
        todas.add(opcion3);
        todas.add(opcion4);
        todas.add(opcion5);

        Jugador jugador1 = new Jugador("Federico");

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion2);
        opcionesJugador1.add(opcion3);

        //Se instancian las respuestas con la lista de opciones elegidas y el puntaje del jugador.
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);

        Clasico sinPenalidad = new Clasico();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0, jugador1.puntaje().getPuntaje());
    }
    @Test
    public void test03_4ResponderMultipleChoiceyAsignarPuntajesCorrectamenteConUnaTodasBienYUnaMal(){
        Opcion opcion1 = new Opcion("Si",true);
        Opcion opcion2 = new Opcion("Totalmente",true);
        Opcion opcion3 = new Opcion("no",false);
        Opcion opcion4 = new Opcion("para nada",false);
        Opcion opcion5 = new Opcion("nunca",false);

        ArrayList<Opcion> todas = new ArrayList<Opcion>();
        todas.add(opcion1);
        todas.add(opcion2);
        todas.add(opcion3);
        todas.add(opcion4);
        todas.add(opcion5);

        Jugador jugador1 = new Jugador("Federico");

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion4);
        opcionesJugador1.add(opcion3);

        //Se instancian las respuestas con la lista de opciones elegidas y el puntaje del jugador.
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);

        Clasico sinPenalidad = new Clasico();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todas, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador1.puntaje().getPuntaje());
    }

}
