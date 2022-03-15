/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.reversi;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author usuario
 */
public class PanelMensajes extends StackPane{

    static Label labelMensaje = new Label();
    final static byte TIEMPO_MENSAJE = 5;

    
    public PanelMensajes(){
    
    //this.setAlignment(Pos.BASELINE_LEFT);
        this.setMinHeight(100);
        this.setMaxHeight(200);
        this.getChildren().add(labelMensaje);
    }
    
    public static void mostrarMensaje(String mensaje) {
        labelMensaje.setText(mensaje);
        Timeline timelineMensaje = new Timeline(
            new KeyFrame(Duration.seconds(TIEMPO_MENSAJE), (ActionEvent t) -> {
                labelMensaje.setText("");
        })
        );
        timelineMensaje.setCycleCount(1);
        timelineMensaje.play();
    }
     

  
    
}


    