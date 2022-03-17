/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.reversi;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author usuario
 */
public class Ficha extends Circle{
    
    
    static final double TAM_FICHA = 40;
    
    
    
    public Ficha(char jugador){

        if (jugador == 'N') {
            this.setRadius(TAM_FICHA/2);
            this.setFill(Color.BLACK);
        }else{
            this.setRadius(TAM_FICHA/2);
            this.setFill(Color.WHITE);

        
        }

    }
    
}
