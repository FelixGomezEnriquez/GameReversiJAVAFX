/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.reversi;

import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author usuario
 */
public class PanelPuntos extends StackPane{
    
    
   static Text fichasBlancas = new Text();
    
    Text numFichas = new Text();
    
    static Text fichasNegras = new Text();

    
    public PanelPuntos (){
        
        //this.setAlignment(Pos.BASELINE_LEFT);
        this.setMinHeight(100);
        this.setMaxHeight(200);
        
        VBox puntos =new VBox();
        puntos.setPadding(new Insets(20));
        puntos.setSpacing(20);
       
        
        numFichas.setText("Numero de fichas");
        numFichas.setFont(Font.font(20));
        numFichas.setFill(Color.BLACK);
        

        //Anadimos los textos al layout
        puntos.getChildren().add(numFichas);

         
        
        fichasBlancas.setText("Blancas: 0");
        fichasBlancas.setFont(Font.font(15));
        fichasBlancas.setFill(Color.DARKCYAN);
        

        //Anadimos los textos al layout
        puntos.getChildren().add(fichasBlancas);
        
        
        fichasNegras.setText("Negras: 0");
        fichasNegras.setFont(Font.font(15));
        fichasNegras.setFill(Color.DARKCYAN);
        
        
        //Anadimos los textos al layout
        puntos.getChildren().add(fichasNegras);
    
        
        
        this.getChildren().add(puntos);
        


    
    }
    
    
    static public int cambiarPuntuacion( char jugador, Reversi reversi){
        
        int numFichasJugador=0;

        for (int i = 0 ; i < 8 ; i++) {
            for (int j = 0; j < 8; j++) {
                
                if (reversi.tablero[i][j]==jugador ) {
                    
                    numFichasJugador++;
                                 
                }
            }
        }
        return numFichasJugador;   
    }
}
   
    


