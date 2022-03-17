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
 * @author usuario
 */
public class PanelMensajes extends StackPane{

    static Label labelMensaje = new Label();
    
    public PanelMensajes(){
        
        CornerRadii cornerradii=new CornerRadii(50);
        
        this.setPadding(new Insets(20));
        this.setBackground(new Background(
            new BackgroundFill(Color.GAINSBORO, cornerradii, Insets.EMPTY)));
        this.setMinHeight(100);
        this.setMaxHeight(200);
        this.getChildren().add(labelMensaje);
        labelMensaje.setFont(new Font("Arial", 22));
        labelMensaje.setText("Aqui apareceran mensajes de ayuda");
    }
    
    public static void mostrarMensaje(String mensaje) {
        labelMensaje.setText(mensaje);
    }
     
    
    

  
    
}


    