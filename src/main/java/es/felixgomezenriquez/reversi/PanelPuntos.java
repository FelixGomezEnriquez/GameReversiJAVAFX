/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.reversi;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author usuario
 */
//Esta clase reflejara toda la informacion relativa a la puntuacion 
public class PanelPuntos extends StackPane {

    static int numFichasBlancas;
    static int numFichasNegras;
    static Reversi reversi;

    static Text fichasBlancas = new Text();

    static Text fichasNegras = new Text();

//Metodo constructor que se le pasa por parametro un objeto Reversi
    public PanelPuntos(Reversi reversi) {

        this.reversi = reversi;
        this.setAlignment(Pos.CENTER);

        CornerRadii cornerradii = new CornerRadii(50);

        this.setBackground(new Background(
                new BackgroundFill(Color.GAINSBORO, cornerradii, Insets.EMPTY)));

        this.setPadding(new Insets(20));

//Creamos objeto puntos que concatena cada nodo hijo verticalmente al
//ser un objeto de la clase VBox.
        VBox puntos = new VBox();
        puntos.setSpacing(10);
        puntos.setAlignment(Pos.CENTER);

//Creamos texto numFichas
        Text numFichas = new Text();
        numFichas.setText("Numero de fichas");
        numFichas.setFont(Font.font(20));
        numFichas.setFill(Color.BLACK);

//Anadimos el texto al layout
        puntos.getChildren().add(numFichas);
        //Modificamos los textos creados como atributos de la clase.
        fichasBlancas.setText("Blancas: 0");
        fichasBlancas.setFont(Font.font(15));
        fichasBlancas.setFill(Color.rgb(219, 123, 0));

//Anadimos el texto al layout
        puntos.getChildren().add(fichasBlancas);

//Modificamos los textos creados como atributos de la clase.
        fichasNegras.setText("Negras: 0");
        fichasNegras.setFont(Font.font(15));
        fichasNegras.setFill(Color.rgb(219, 123, 0));

        //Anadimos los textos al layout
        puntos.getChildren().add(fichasNegras);

        this.getChildren().add(puntos);
    }

//Este metodo se encarga de recorrer el array tablero en sus 64 posiciones para
//Comprobar el numero de fichas que tiene cada jugador y devuelve un numero
//entero que usamos para renovar los puntos
    public static int cambiarPuntuacion(char jugador, Reversi reversi) {

        int numFichasJugador = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (reversi.tablero[i][j] == jugador) {

                    numFichasJugador++;

                }
            }
        }
        return numFichasJugador;
    }

//Este metodo renueva los puntos tanto de las pieza blancas como negras
    public static void renovarPuntos() {

        //Uso la variable numFichasBlancas para guardar el resultado de              
        numFichasBlancas = PanelPuntos.cambiarPuntuacion(Reversi.JUGADOR1, reversi);

        PanelPuntos.fichasBlancas.setText("Blancas: " + numFichasBlancas);

        numFichasNegras = PanelPuntos.cambiarPuntuacion(Reversi.JUGADOR2, reversi);

        PanelPuntos.fichasNegras.setText("Negras: " + numFichasNegras);

    }
}
