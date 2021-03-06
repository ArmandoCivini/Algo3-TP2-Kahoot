package edu.fiuba.algo3.modelo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.ArrayList;

public class VyFSinPenalidadTest {

    @Test
    public void test01_1CrearVyFSinPenalidad() {

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionChoice opcionVerdadero = new OpcionChoice("verdadero", true);
        OpcionChoice opcionFalso = new OpcionChoice("falso", false);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, new Clasico());
        assertEquals(todasLasOpciones, preguntaTest.verBotones());

    }

    @Test
    public void test01_2ResponderVerdaderoYFalsoYAsignarPuntajesCorrectamente(){

        Jugador jugador1 = new Jugador("Federico");
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionChoice opcionVerdadero = new OpcionChoice("verdadero", true);
        OpcionChoice opcionFalso = new OpcionChoice("falso", false);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Opcion> opcionJugador1 = new ArrayList<Opcion>();
        opcionJugador1.add(opcionVerdadero);

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        Clasico sinPenalidad = new Clasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());

    }

    @Test
    public void test01_3ResponderVerdaderoYFalsoYAsignarPuntajesIncorrectamente(){

        Jugador jugador1 = new Jugador("Federico");
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionChoice opcionVerdadero = new OpcionChoice("verdadero", true);
        OpcionChoice opcionFalso = new OpcionChoice("falso", false);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);
        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Opcion> opcionJugador1 = new ArrayList<Opcion>();
        opcionJugador1.add(opcionFalso);

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        respuestas.add(respuestaJugador1);
        Clasico sinPenalidad = new Clasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(0, jugador1.puntaje().getPuntaje());

    }

    @Test
    public void test01_4ResponderVerdaderoYFalsoYAsignarPuntajesDosJugadoresCorrectamenteEIncorrectamente(){

        Jugador jugador1 = new Jugador("Federico");
        Jugador jugador2 = new Jugador("Jose");
        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionChoice opcionVerdadero = new OpcionChoice("verdadero", true);
        OpcionChoice opcionFalso = new OpcionChoice("falso", false);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);

        ArrayList<Respuesta> respuestas = new ArrayList<Respuesta>();

        ArrayList<Opcion> opcionJugador1 = new ArrayList<Opcion>();
        opcionJugador1.add(opcionVerdadero);

        ArrayList<Opcion> opcionJugador2 = new ArrayList<Opcion>();
        opcionJugador2.add(opcionFalso);

        Respuesta respuestaJugador1 = new Respuesta(opcionJugador1, jugador1.puntaje());
        Respuesta respuestaJugador2 = new Respuesta(opcionJugador2, jugador2.puntaje());
        respuestas.add(respuestaJugador1);
        respuestas.add(respuestaJugador2);
        Clasico sinPenalidad = new Clasico();
        VerdaderoFalso preguntaTest = new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, sinPenalidad);
        preguntaTest.responderPregunta(respuestas);
        assertEquals(1, jugador1.puntaje().getPuntaje());
        assertEquals(0, jugador2.puntaje().getPuntaje());

    }

    @Test
    public void test01_5CrearVyFLanzaErrorPorCorrectasMultiples() {

        ArrayList<Opcion> todasLasOpciones = new ArrayList<Opcion>();
        OpcionChoice opcionVerdadero = new OpcionChoice("verdadero", true);
        OpcionChoice opcionFalso = new OpcionChoice("falso", true);
        todasLasOpciones.add(opcionVerdadero);
        todasLasOpciones.add(opcionFalso);
        assertThrows(VyFMasDeDosOpcionesException.class, () ->
            {new VerdaderoFalso("Es Tomas su primer nombre?", todasLasOpciones, new Clasico());
        });

    }

}