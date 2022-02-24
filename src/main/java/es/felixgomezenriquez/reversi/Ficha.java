/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.reversi;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author usuario
 */
public class Ficha extends Group{
    
    
    static final double TAM_FICHA = 40;
    double posX;
    double posY;
    
    
    public Ficha(){
        
        if (Reversi.cambiarTurnoJugador()==true) {
            
            Circle blanco=new Circle();
        
            blanco.setRadius(TAM_FICHA/2);
            blanco.setFill(Color.WHITE);
            
        } else {
            
            Circle negro=new Circle();

            negro.setRadius(TAM_FICHA/2);
            negro.setFill(Color.BLACK);
        
        }
        
        //False es jugador 2 true es jugador 1
        
        //
        
    
        
    }
    
}
