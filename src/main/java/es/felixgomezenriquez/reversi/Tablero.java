/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.reversi;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

/**
 *
 * @author usuario
 */
public class Tablero extends Pane{
    
    
    Reversi reversi;
    int columna;
    int fila;
    final int COLUMNAINICIAL1=3;
    final int FILAINICIAL1=3;
    final int COLUMNAINICIAL2=4;
    final int FILAINICIAL2=3;
    final int COLUMNAINICIAL3=3;
    final int FILAINICIAL3=4;
    final int COLUMNAINICIAL4=4;
    final int FILAINICIAL4=4;
    
    
    
    public Tablero( Reversi reversi){
        
        this.reversi=reversi;
         this.setBackground(new Background(
            new BackgroundFill(Color.FORESTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
         
        this.setMinWidth(Ficha.TAM_FICHA * reversi.tamXTablero );
        this.setMinHeight(Ficha.TAM_FICHA * (reversi.tamYTablero)); 
        this.setMaxWidth(Ficha.TAM_FICHA * reversi.tamXTablero);
        this.setMaxHeight(Ficha.TAM_FICHA * (reversi.tamYTablero));
        
        for (int i = 0; i <= 320; i+=40) {
            Line lineasx=new Line(i, 0, i, 320);
            
            lineasx.setFill(Color.BLACK);
            this.getChildren().add(lineasx);
            
        }
        
        for (int i = 0; i <= 320; i+=40) {
            Line lineasy=new Line(0, i, 320, i);
            
            lineasy.setFill(Color.BLACK);
            this.getChildren().add(lineasy);
            
        }
        
        Ficha fichaB1=new Ficha('B');
        fichaB1.setCenterX(COLUMNAINICIAL1 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
        fichaB1.setCenterY(FILAINICIAL1 *Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
        this.getChildren().add(fichaB1);
        
        Ficha fichaN1 =new Ficha('N');
        fichaN1.setCenterX(COLUMNAINICIAL2 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
        fichaN1.setCenterY(FILAINICIAL2 *Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
        this.getChildren().add(fichaN1);
        
        
        Ficha fichaN2 =new Ficha('N');
        fichaN2.setCenterX(COLUMNAINICIAL3 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
        fichaN2.setCenterY(FILAINICIAL3 *Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
        this.getChildren().add(fichaN2);
        
        Ficha fichaB2=new Ficha('B');
        fichaB2.setCenterX(COLUMNAINICIAL4 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
        fichaB2.setCenterY(FILAINICIAL4 *Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
        this.getChildren().add(fichaB2);
        
                
        
        
 
        
    }
    
    
    public void colocarFicha(){
    
        this.setOnMouseClicked((event) -> {
                columna=(int)(event.getX()/Ficha.TAM_FICHA);
                fila=(int)(event.getY()/ Ficha.TAM_FICHA);
            if (Reversi.cambiarTurnoJugador()==Reversi.JUGADOR1 
                    && reversi.colocarFicha(columna, fila, 'N') ){
                
                Ficha ficha=new Ficha('N');
                ficha.setCenterX(columna * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                ficha.setCenterY(fila *Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                this.getChildren().add(ficha);
                reversi.mostrarTablero();
                //Reversi.cambiarTurnoJugador();
                
            }
//                
//            } else if (Reversi.cambiarTurnoJugador()== Reversi.JUGADOR2
                    //&& reversi.colocarFicha(columna, fila, 'B')){
//                System.out.println("esta es la x: "+event.getX());
//                System.out.println("esta es la Y: "+event.getY());
//                System.out.println(columna);
//                System.out.println(fila);
//                Ficha ficha=new Ficha('B');
//                ficha.setCenterX(columna * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
//                ficha.setCenterY(fila *Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
//                this.getChildren().add(ficha);
//                reversi.mostrarTablero();
//                Reversi.cambiarTurnoJugador();
//                
//            }
            
            
        });
    
    
    }
    
    public void ganarFichas(){
        
        //CREAR FOR PARA convertir fichas rivales al color del jugador
        
    }


    //metodo comprueba cada casilla haciendole un for para devolverte las casillas en las que puedes colocar
    
    
}
