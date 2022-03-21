/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.reversi;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 *
 * @author Felix
 */
//Esta clase reflejara toda la informacion relativa al tablero 
public class Tablero extends Pane {

    Reversi reversi;
    final int COLUMNA_INICIAL_1 = 3;
    final int FILA_INICIAL_1 = 3;
    final int COLUMNA_INICIAL_2 = 4;
    final int FILA_INICIAL_2 = 3;
    final int COLUMNA_INICIAL_3 = 3;
    final int FILA_INICIAL_3 = 4;
    final int COLUMNA_INICIAL_4 = 4;
    final int FILA_INICIAL_4 = 4;

    public Tablero(Reversi reversi) {

        this.reversi = reversi;
        this.setBackground(new Background(
                new BackgroundFill(Color.FORESTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        final double TAM_PANTALLA_X = Ficha.TAM_FICHA * reversi.TAM_X_TABLERO;
        final double TAM_PANTALLA_Y = Ficha.TAM_FICHA * reversi.TAM_Y_TABLERO;

        this.setMinWidth(TAM_PANTALLA_X);
        this.setMinHeight(TAM_PANTALLA_Y);
        this.setMaxWidth(TAM_PANTALLA_X);
        this.setMaxHeight(TAM_PANTALLA_Y);

//Con estos bucles for creamos las lineas de el tablero 
        for (int i = 0; i <= TAM_PANTALLA_X; i += Ficha.TAM_FICHA) {
            Line lineasx = new Line(i, 0, i, 320);

            lineasx.setFill(Color.BLACK);
            this.getChildren().add(lineasx);

        }

        for (int i = 0; i <= TAM_PANTALLA_Y; i += Ficha.TAM_FICHA) {
            Line lineasy = new Line(0, i, 320, i);

            lineasy.setFill(Color.BLACK);
            this.getChildren().add(lineasy);

        }

// con las siguientes lineas de codigo creamos los objetos ficha, que corresponden
//Con las fichas iniciales, tambien se ajusta su posicion y se añaden al tablero.
        Ficha fichaB1 = new Ficha('B');
        fichaB1.setCenterX(COLUMNA_INICIAL_1 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
        fichaB1.setCenterY(FILA_INICIAL_1 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
        this.getChildren().add(fichaB1);

        Ficha fichaN1 = new Ficha('N');
        fichaN1.setCenterX(COLUMNA_INICIAL_2 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
        fichaN1.setCenterY(FILA_INICIAL_2 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
        this.getChildren().add(fichaN1);

        Ficha fichaN2 = new Ficha('N');
        fichaN2.setCenterX(COLUMNA_INICIAL_3 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
        fichaN2.setCenterY(FILA_INICIAL_3 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
        this.getChildren().add(fichaN2);

        Ficha fichaB2 = new Ficha('B');
        fichaB2.setCenterX(COLUMNA_INICIAL_4 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
        fichaB2.setCenterY(FILA_INICIAL_4 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
        this.getChildren().add(fichaB2);

        colocarFicha();

    }

//Este metodo se encarga de colocar la ficha en el tablero 
    public void colocarFicha() {

        this.setOnMouseClicked((event) -> {

            System.out.println("Se detecta un click");
            int columna = (int) (event.getX() / Ficha.TAM_FICHA);
            int fila = (int) (event.getY() / Ficha.TAM_FICHA);
            System.out.println("El turno es de: " + reversi.turnoJugador);

            this.compruebaCondiciones();

            //Si el turno es del jugador 1 y se puede colocar una ficha en la posicion
            //del click entra dentro del if, sino si es el turno del jugador 2 y se
            //puede colocar en la posicion clickada se ejecutan las lineas correspondientes
            //a su condicion, sino se cumple ninguna de estas condiciones, se muestra
            //el mensaje "Movimiento invalido"
            if (reversi.turnoJugador == Reversi.JUGADOR1
                    && reversi.colocarFicha(columna, fila, Reversi.JUGADOR1)) {

                //Muestra por pantalla el turno del siguiente jugador
                PanelMensajes.mostrarMensaje("Es turno de las piezas negras");

                this.ganarFichas(columna, fila, Reversi.JUGADOR1);

                reversi.cambiarTurnoJugador();

                PanelPuntos.renovarPuntos();

                reversi.mostrarTablero();

            } else if (reversi.turnoJugador == Reversi.JUGADOR2
                    && reversi.colocarFicha(columna, fila, Reversi.JUGADOR2)) {

                this.ganarFichas(columna, fila, Reversi.JUGADOR2);

                reversi.cambiarTurnoJugador();

                //Muestra por pantalla el turno del siguiente jugador
                PanelMensajes.mostrarMensaje("Es turno de las piezas blancas");

                PanelPuntos.renovarPuntos();
                reversi.mostrarTablero();
            } else {
                PanelMensajes.mostrarMensaje("Movimiento inválido");

            }
        });
    }

    //Este metodo crea las fichas del jugador que corresponda 
    //en las posiciones correspondientes, dependiendo de el numero 
    //de piezas del rival en las distintas direcciones
    public void ganarFichas(int columna, int fila, char jugador) {

//Todas las siguientes sentecias if funcionan de forma similar, por eso solo 
//explicare el caso del primer if
        //Si el numero de piezas del rival a la izquierda es mayor que 0  y la posicion
        // con la variable (posXFinalIzq) que controla lo que hay 1 posicion mas para
        //saber que hay mas alla de la suma de las piezas rivales, es decir saber si 
        //en esa posicion hay una pieza aliada.
        //EJEMPLO:  posXFinalIzq = columna - contadorPiezasRivalIzq-1 
        //se ejecutan las sentencias pertinentes que manipulan las fichas
        if (reversi.contadorPiezasRivalIzq > 0
                && reversi.tablero[reversi.posXFinalIzq][fila] == jugador) {
            System.out.println("colocando fichas de forma grafica a la izquierda");
            for (int x = columna; x >= columna - reversi.contadorPiezasRivalIzq; x--) {
                Ficha ficha = new Ficha(jugador);
                ficha.setCenterX(x * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                ficha.setCenterY(fila * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                this.getChildren().add(ficha);

            }
        }

        if (reversi.contadorPiezasRivalDer > 0
                && reversi.tablero[reversi.posXFinalDer][fila] == jugador) {

            System.out.println("colocando fichas de forma grafica a la derecha");
            for (int x = columna; x <= columna + reversi.contadorPiezasRivalDer; x++) {
                Ficha ficha = new Ficha(jugador);
                ficha.setCenterX(x * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                ficha.setCenterY(fila * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                this.getChildren().add(ficha);
            }

        }

        if (reversi.contadorPiezasRivalAbajo > 0
                && reversi.tablero[columna][reversi.posYFinalAbajo] == jugador) {

            System.out.println("colocando fichas de forma grafica a la abajo");

            for (int y = fila; y <= fila + reversi.contadorPiezasRivalAbajo; y++) {
                Ficha ficha = new Ficha(jugador);
                ficha.setCenterX(columna * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                ficha.setCenterY(y * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                this.getChildren().add(ficha);
            }
        }

        if (reversi.contadorPiezasRivalArriba > 0
                && reversi.tablero[columna][reversi.posYFinalArriba] == jugador) {
            System.out.println("colocando fichas de forma grafica arriba");

            for (int y = fila; y >= fila - reversi.contadorPiezasRivalArriba; y--) {
                Ficha ficha = new Ficha(jugador);
                ficha.setCenterX(columna * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                ficha.setCenterY(y * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                this.getChildren().add(ficha);
            }

        }

        if (reversi.contadorPiezasRivalDiagonal_1 > 0
                && reversi.tablero[reversi.posXFinalD1_1][reversi.posYFinalD1_1] == jugador) {

            System.out.println("colocando fichas de forma grafica Diagonal1_1");

            int xDiagonal1_1 = columna;
            for (int y = fila; y >= fila - reversi.contadorPiezasRivalDiagonal_1; y--) {

                Ficha ficha = new Ficha(jugador);
                ficha.setCenterX(xDiagonal1_1 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                ficha.setCenterY(y * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                this.getChildren().add(ficha);
                xDiagonal1_1--;

            }
        }

        if (reversi.contadorPiezasRivalDiagonal_2 > 0
                && reversi.tablero[reversi.posXFinalD1_2][reversi.posYFinalD1_2] == jugador) {
            System.out.println("colocando fichas de forma grafica Diagonal1_2");
            int xDiagonal1_2 = columna;
            for (int y = fila; y <= fila + reversi.contadorPiezasRivalDiagonal_2; y++) {
                Ficha ficha = new Ficha(jugador);
                ficha.setCenterX(xDiagonal1_2 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                ficha.setCenterY(y * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                this.getChildren().add(ficha);
                xDiagonal1_2++;
            }

        }

        if (reversi.contadorPiezasRivalDiagona2_1 > 0
                && reversi.tablero[reversi.posXFinalD2_1][reversi.posYFinalD2_1] == jugador) {
            System.out.println("colocando fichas de forma grafica Diagonal2_1");
            int xDiagonal2_1 = columna;

            for (int y = fila; y >= fila - reversi.contadorPiezasRivalDiagona2_1; y--) {
                Ficha ficha = new Ficha(jugador);
                ficha.setCenterX(xDiagonal2_1 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                ficha.setCenterY(y * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                this.getChildren().add(ficha);
                xDiagonal2_1++;
            }

        }

        if (reversi.contadorPiezasRivalDiagona2_2 > 0
                && reversi.tablero[reversi.posXFinalD2_2][reversi.posYFinalD2_2] == jugador) {
            System.out.println("colocando fichas de forma grafica Diagonal2_2");
            int xDiagonal2_2 = columna;

            for (int y = fila; y <= fila + reversi.contadorPiezasRivalDiagona2_2; y++) {
                Ficha ficha = new Ficha(jugador);
                ficha.setCenterX(xDiagonal2_2 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                ficha.setCenterY(y * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                this.getChildren().add(ficha);
                xDiagonal2_2--;

            }

        }

    }

//Este metodo ejecuta el metodo comprobarCondiciones de la logica del juego que 
//devuelve un char, y en funcion de el caracter que devuelva ejecuta unas lineas u otras.
    public void compruebaCondiciones() {
        //Crea un timeline para que se comprueben las condiciones cada 2 segundos sin necesidad 
        //de que se clicke en la pantalla
        Timeline quienGana = new Timeline(
                new KeyFrame(Duration.seconds(2), (ActionEvent ae) -> {

                    switch (reversi.comprobarCondiciones()) {
                        case 'N':
                            System.out.println("HA GANADO EL JUGADOR CON LAS PIEZAS NEGRAS");
                            PanelMensajes.mostrarMensaje("HA GANADO EL JUGADOR CON LAS PIEZAS NEGRAS");

                            break;
                        case 'B':
                            System.out.println("HA GANADO EL JUGADOR CON LAS PIEZAS BLANCAS");
                            PanelMensajes.mostrarMensaje("HA GANADO EL JUGADOR CON LAS PIEZAS BLANCAS");
                            break;
                        case 'H':
                            PanelMensajes.mostrarMensaje("Negras sin movimientos, pasan turno a las blancas");
                            reversi.turnoJugador = Reversi.JUGADOR1;
                            break;
                        case 'U':
                            PanelMensajes.mostrarMensaje("Blancas sin movimientos, pasan turno a las negras");
                            reversi.turnoJugador = Reversi.JUGADOR2;

                            break;

                        case 'E':
                            PanelMensajes.mostrarMensaje("EMPATE!!");

                        default:
                            System.out.println("No ha ganado nadie");
                            break;
                    }

                }));
        quienGana.setCycleCount(Timeline.INDEFINITE);
        quienGana.play();

    }
}
