
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.reversi;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Felix
 */
//Esta clase extiende de StackPane
public class PanelMensajes extends StackPane {

    //Se hace estatico para poder utilizarlo en el metodo mostrarMensaje
    static Label labelMensaje = new Label();

    public PanelMensajes() {

        //Creamos objeto CornerRadi para usarlo en el backgroung
        CornerRadii cornerradii = new CornerRadii(50);

        this.setPadding(new Insets(20));
        this.setBackground(new Background(
                new BackgroundFill(Color.GAINSBORO, cornerradii, Insets.EMPTY)));
        this.setMinHeight(100);
        this.setMaxHeight(200);
        this.getChildren().add(labelMensaje);
        labelMensaje.setFont(new Font("Arial", 22));
        labelMensaje.setText("Primer turno de blancas");
    }

    public static void mostrarMensaje(String mensaje) {
        labelMensaje.setText(mensaje);
    }

}
