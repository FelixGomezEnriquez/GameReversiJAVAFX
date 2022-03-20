package es.felixgomezenriquez.reversi;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Felix
 */
//Esta clase Ficha extiende a la clase circulo 
public class Ficha extends Circle {

    static final double TAM_FICHA = 40;

//Metodo constructor de la clase ficha, que necesita como parametro un char.
    public Ficha(char jugador) {

        if (jugador == 'N') {
            this.setRadius(TAM_FICHA / 2);
            this.setFill(Color.BLACK);
        } else {
            this.setRadius(TAM_FICHA / 2);
            this.setFill(Color.WHITE);

        }

    }

}
