package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class MultipleChoiceClasicoTest {

    @Test
    public void test03_1CrearMultipleChoiceClasico() {

        OpcionChoice opcion1 = new OpcionChoice("Si",true);
        OpcionChoice opcion2 = new OpcionChoice("Totalmente",true);
        OpcionChoice opcion3 = new OpcionChoice("no",false);
        OpcionChoice opcion4 = new OpcionChoice("para nada",false);
        OpcionChoice opcion5 = new OpcionChoice("nunca",false);

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        todasLasOpciones.add(opcion3);
        todasLasOpciones.add(opcion4);
        todasLasOpciones.add(opcion5);

        Jugador jugador = new Jugador("Nicolas");
        ArrayList<Opcion> opcionesJugador = new ArrayList<Opcion>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion2);

        Respuesta respuesta = new Respuesta(opcionesJugador,jugador.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuesta);

        //Se crea la pregunta con la lista de opciones y la modalidad elegida.
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todasLasOpciones, new Clasico());
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1,jugador.puntaje().getPuntaje());

    }

    @Test
    public void test03_2ResponderMultipleChoiceyAsignarPuntajesCorrectamente(){

        OpcionChoice opcion1 = new OpcionChoice("Si",true);
        OpcionChoice opcion2 = new OpcionChoice("Totalmente",true);
        OpcionChoice opcion3 = new OpcionChoice("no",false);
        OpcionChoice opcion4 = new OpcionChoice("para nada",false);
        OpcionChoice opcion5 = new OpcionChoice("nunca",false);

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        todasLasOpciones.add(opcion3);
        todasLasOpciones.add(opcion4);
        todasLasOpciones.add(opcion5);

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
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todasLasOpciones, sinPenalidad);

        //Se pasan las respuestas de los jugadores a la pregunta.
        preguntaTest.responderPregunta(respuestas);

        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());

    }
    @Test
    public void test03_3ResponderMultipleChoiceyAsignarPuntajesCorrectamenteConUnaDeDosBien(){

        OpcionChoice opcion1 = new OpcionChoice("Si",true);
        OpcionChoice opcion2 = new OpcionChoice("Totalmente",true);
        OpcionChoice opcion3 = new OpcionChoice("no",false);
        OpcionChoice opcion4 = new OpcionChoice("para nada",false);
        OpcionChoice opcion5 = new OpcionChoice("nunca",false);

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        todasLasOpciones.add(opcion3);
        todasLasOpciones.add(opcion4);
        todasLasOpciones.add(opcion5);

        Jugador jugador1 = new Jugador("Federico");

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion2);
        opcionesJugador1.add(opcion3);

        //Se instancian las respuestas con la lista de opciones elegidas y el puntaje del jugador.
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);

        Clasico sinPenalidad = new Clasico();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todasLasOpciones, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);

        assertEquals(0, jugador1.puntaje().getPuntaje());

    }

    @Test
    public void test03_4ResponderMultipleChoiceyAsignarPuntajesCorrectamenteConUnaTodasBienYUnaMal(){

        OpcionChoice opcion1 = new OpcionChoice("Si",true);
        OpcionChoice opcion2 = new OpcionChoice("Totalmente",true);
        OpcionChoice opcion3 = new OpcionChoice("no",false);
        OpcionChoice opcion4 = new OpcionChoice("para nada",false);
        OpcionChoice opcion5 = new OpcionChoice("nunca",false);

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        todasLasOpciones.add(opcion1);
        todasLasOpciones.add(opcion2);
        todasLasOpciones.add(opcion3);
        todasLasOpciones.add(opcion4);
        todasLasOpciones.add(opcion5);

        Jugador jugador1 = new Jugador("Federico");

        ArrayList<Opcion> opcionesJugador1 = new ArrayList<Opcion>();
        opcionesJugador1.add(opcion4);
        opcionesJugador1.add(opcion3);

        //Se instancian las respuestas con la lista de opciones elegidas y el puntaje del jugador.
        Respuesta respuestaJugador1 = new Respuesta(opcionesJugador1, jugador1.puntaje());
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();
        respuestas.add(respuestaJugador1);

        Clasico sinPenalidad = new Clasico();
        MultipleChoice preguntaTest = new MultipleChoice("Es Tomas su primer nombre?", todasLasOpciones, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador1.puntaje().getPuntaje());

    }

}