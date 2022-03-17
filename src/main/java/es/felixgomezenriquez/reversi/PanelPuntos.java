/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.reversi;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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
public class PanelPuntos extends StackPane{
    
    Reversi reversi;
    
    static Text fichasBlancas = new Text();
    
    static Text fichasNegras = new Text();

    
    public PanelPuntos (Reversi reversi, Tablero tablero){
        
        this.reversi=reversi;
        this.setAlignment(Pos.CENTER);
        
        CornerRadii cornerradii=new CornerRadii(50);
        
        this.setBackground(new Background(
            new BackgroundFill(Color.GAINSBORO, cornerradii, Insets.EMPTY)));
        
        this.setPadding(new Insets(20));
        
        VBox puntos =new VBox();
        puntos.setSpacing(10);
        puntos.setAlignment(Pos.CENTER);
        
        Text numFichas = new Text();
        numFichas.setText("Numero de fichas");
        numFichas.setFont(Font.font(20));
        numFichas.setFill(Color.BLACK);
        

        //Anadimos los textos al layout
        puntos.getChildren().add(numFichas);

         
        
        fichasBlancas.setText("Blancas: 0");
        fichasBlancas.setFont(Font.font(15));
        fichasBlancas.setFill(Color.rgb(219, 123, 0));
        

        //Anadimos los textos al layout
        puntos.getChildren().add(fichasBlancas);
        
        
        fichasNegras.setText("Negras: 0");
        fichasNegras.setFont(Font.font(15));
        fichasNegras.setFill(Color.rgb(219, 123, 0));
        
        
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
   
    

