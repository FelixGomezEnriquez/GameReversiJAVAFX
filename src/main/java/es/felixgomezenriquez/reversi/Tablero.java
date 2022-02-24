/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.reversi;

import javafx.scene.layout.Pane;

/**
 *
 * @author usuario
 */
public class Tablero extends Pane{
    
    
    Reversi reversi;
    
    
    
    
    public Tablero( Reversi reversi){
        
        // HACER TABLERO FONDO GREEN y 2 for LINEAS EJE X y EJE Y PARA HACER CUADRICULAS 8x8
        
        //Con el metodo de controlar turno hacer q primero sea ficha negra y despues ficha blanca 
        //q ahora esta puesto en ficha.java
        
//PARA COMPROBAR LAS FICHAS Y COLOCARLAS DIVIDIR TABLERO EN filas y columnas como hizo javi dividiendo la x o y 
//del mouse entre el tam de la ficha


    //metodo comprueba cada casilla haciendole un for para devolverte las casillas en las que puedes colocar
        
        
        
        this.reversi = reversi;
        
        
        
        
        
    
    
        
    }
    
    
    
    
}
