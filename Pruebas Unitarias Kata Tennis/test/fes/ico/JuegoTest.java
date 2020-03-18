package fes.ico;

import static junit.framework.TestCase.assertEquals;
import org.junit.Test;

public class JuegoTest {

    Juego juego = new Juego("David", "Pepito");

    @Test
    public void Test1() {//Si omito asignarle un sacador por defecto sacará el Jugador1
        String marcador = juego.getMarcador();
        System.out.println(marcador);
        assertEquals("Empate David:0 , Pepito:0", marcador);
    }

    @Test
    public void Test2() {
        juego.setSacador("David");
        juego.PuntoJugador1();
        String marcador = juego.getMarcador();
        System.out.println(marcador);
        assertEquals("David:15 , Pepito:0", marcador);
    }

    @Test
    public void Test3() {
        juego.setSacador(juego.getJugador1().getJugador());//Otra forma de mandarle el nombre
        juego.PuntoJugador1();
        juego.PuntoJugador1();
        juego.PuntoJugador1();
        juego.PuntoJugador1();
        String marcador = juego.getMarcador();
        System.out.println(marcador);
        assertEquals("Gana David, David:40 , Pepito:0", marcador);
    }

    @Test
    public void Test4() {
        juego.setSacador("Pepito");//Dependiendo del sacador será el orden en que se muestre el marcador
        juego.PuntoJugador1();
        juego.PuntoJugador1();
        juego.PuntoJugador1();
        juego.PuntoJugador1();
        juego.PuntoJugador2();
        juego.PuntoJugador2();
        juego.PuntoJugador2();
        juego.PuntoJugador2();
        String marcador = juego.getMarcador();
        System.out.println(marcador);
        assertEquals("Deuce Pepito:40 , David:40", marcador);
    }

    @Test
    public void Test5() {
        juego.setSacador(juego.getJugador2().getJugador());
        juego.PuntoJugador1();
        juego.PuntoJugador1();
        juego.PuntoJugador1();
        juego.PuntoJugador2();
        String marcador = juego.getMarcador();
        System.out.println(marcador);
        assertEquals("Pepito:15 , David:40", marcador);
    }

    @Test
    public void Test6_Simulación() {//Simulación con resultados aleatorios
        System.out.print("\n----------------------Lo siguiente es una simulación aleatoria------------------");
        juego.SimulaciónJuego();
        assertEquals(2, 2);
    }
}
