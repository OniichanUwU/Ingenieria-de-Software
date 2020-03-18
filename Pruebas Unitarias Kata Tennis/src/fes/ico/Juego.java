package fes.ico;

import java.util.Random;

public class Juego {

    private Jugador jugador1 = new Jugador();
    private Jugador jugador2 = new Jugador();
    private String sacador;

    public Juego(String jugador1, String jugador2) {
        this.jugador1.setJugador(jugador1);
        this.jugador2.setJugador(jugador2);
    }

    public void SimulaciónJuego() {//Ya sé que no lo pidió pero quise hacerlo :D
        CaraOCruzRandom();
        while (!ExisteGanador()) {
            PuntoRandom();
            System.out.println(getMarcador());
        }
    }

    public void CaraOCruzRandom() { //Necesario para la simulación
        Random randomcito = new Random();
        if (randomcito.nextBoolean() == true) {
            setSacador(jugador1.getJugador());
        } else {
            setSacador(jugador2.getJugador());
        }
    }

    private void PuntoRandom() { //Necesario para la simulación
        Random randomcito = new Random();
        if (randomcito.nextBoolean() == true) {
            PuntoJugador1();
        } else {
            PuntoJugador2();
        }
    }

    public String getMarcador() {
        if (ExisteGanador()) {
            return "Gana " + JugadorGanando() + ", " + Marcador();
        } else {
            if (ExisteVentaja()) {
                return "Ventaja " + Marcador();
            }
            if (ExisteDeuce()) {
                return "Deuce " + Marcador();
            } else {
                if (jugador1.getPuntos() == jugador2.getPuntos()) {
                    return "Empate " + Marcador();
                }
            }
        }
        return Marcador();
    }

    public String Marcador() {
        if (jugador2.getJugador().equals(sacador)) { //Según wikipedia siempre va primero la puntuación del sacador
            return jugador2.getJugador() + ":" + TraductorPuntos(jugador2.getPuntos()) + " , " + jugador1.getJugador() + ":" + TraductorPuntos(jugador1.getPuntos());
        } else {
            return jugador1.getJugador() + ":" + TraductorPuntos(jugador1.getPuntos()) + " , " + jugador2.getJugador() + ":" + TraductorPuntos(jugador2.getPuntos());
        }
    }

    private int TraductorPuntos(int puntos) {
        switch (puntos) {
            case 0:
                return 0;
            case 1:
                return 15;
            case 2:
                return 30;
            case 3:
                return 40;
            default:
                return 40;
        }
    }

    private String JugadorGanando() {
        if (jugador1.getPuntos() > jugador2.getPuntos()) {
            return jugador1.getJugador();
        } else {
            return jugador2.getJugador();
        }
    }

    private boolean ExisteVentaja() {
        return (jugador1.getPuntos() > 3 && jugador1.getPuntos() == jugador2.getPuntos() + 1)
                || (jugador2.getPuntos() > 3 && jugador2.getPuntos() == jugador1.getPuntos() + 1);
    }

    private Boolean ExisteDeuce() {
        return jugador1.getPuntos() > 2 && jugador1.getPuntos() == jugador2.getPuntos();
    }

    private Boolean ExisteGanador() {
        return (jugador1.getPuntos() > 3 && jugador1.getPuntos() > jugador2.getPuntos() + 1)
                || (jugador2.getPuntos() > 3 && jugador2.getPuntos() > jugador1.getPuntos() + 1);
    }

    public void PuntoJugador1() {
        jugador1.setPuntos(jugador1.getPuntos() + 1);
        System.out.println("Anota " + jugador1.getJugador());
    }

    public void PuntoJugador2() {
        jugador2.setPuntos(jugador2.getPuntos() + 1);
        System.out.println("Anota " + jugador2.getJugador());
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public String getSacador() {
        return sacador;
    }

    public void setSacador(String sacador) {
        System.out.println("\n------------------Comienza el set------------------\n------------------Saca " + sacador + "------------------");
        this.sacador = sacador;
    }
}
