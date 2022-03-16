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
    
    static int numFichasBlancas;
    static int numFichasNegras;
    
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
        
        colocarFicha();
        
        
 
        
    }
    
    
    public void colocarFicha(){
    
        this.setOnMouseClicked((event) -> {
            
            System.out.println("ESTAMOS CLICKANDO");
            columna = (int) (event.getX() / Ficha.TAM_FICHA);
            fila = (int) (event.getY() / Ficha.TAM_FICHA);
            System.out.println("El turno es de: "+ reversi.turnoJugador);
            compruebaCondiciones();

            
            if (reversi.turnoJugador == Reversi.JUGADOR1
                    && reversi.colocarFicha(columna, fila, Reversi.JUGADOR1)) { 
                
                System.out.println("Turno de JUGADOR 1");
                
                PanelMensajes.mostrarMensaje("Es turno de las piezas negras");
                
                this.ganarFichas(columna, fila, Reversi.JUGADOR1);
                
                
                reversi.cambiarTurnoJugador();
                
                renovarPuntos();
                
                quienGana();
                
                reversi.mostrarTablero();
                
            }  else if(reversi.turnoJugador == Reversi.JUGADOR2
                    && reversi.colocarFicha(columna, fila, Reversi.JUGADOR2)){
                
                System.out.println("Turno de JUGADOR 2");
                
                this.ganarFichas(columna, fila, Reversi.JUGADOR2);
                
                
                reversi.cambiarTurnoJugador();
                
                //Muestra por pantalla el turno del siguiente jugador
                PanelMensajes.mostrarMensaje("Es turno de las piezas blancas");

                renovarPuntos();
                
                quienGana();              
                
                reversi.mostrarTablero();
            }
        });
    }

    public void ganarFichas(int columna , int fila, char jugador){
        
        if (reversi.contadorPiezasRivalIzq > 0 && 
                reversi.tablero[reversi.posXFinalIzq][fila] == jugador) {
            System.out.println("colocando fichas grafico bucle a la izquierda");
            for (int x = columna; x >= columna - reversi.contadorPiezasRivalIzq; x--) {
                Ficha ficha = new Ficha(jugador);
                ficha.setCenterX(x * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                ficha.setCenterY(fila * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                this.getChildren().add(ficha);

            }
        } 
        
        if (reversi.contadorPiezasRivalDer > 0 && 
                reversi.tablero[reversi.posXFinalDer][fila] == jugador) {

            System.out.println("colocando fichas grafico bucle a la derecha");
            for (int x = columna; x <= columna + reversi.contadorPiezasRivalDer; x++) {
                Ficha ficha = new Ficha(jugador);
                ficha.setCenterX(x * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                ficha.setCenterY(fila * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                this.getChildren().add(ficha);
            }

        }
        
        if (reversi.contadorPiezasRivalAbajo > 0 
                && reversi.tablero[columna][reversi.posYFinalAbajo] == jugador) {

            System.out.println("colocando fichas grafico bucle a la abajo");

            for (int y = fila; y <= fila + reversi.contadorPiezasRivalAbajo; y++) {
                Ficha ficha = new Ficha(jugador);
                ficha.setCenterX(columna * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                ficha.setCenterY(y * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                this.getChildren().add(ficha);
            }
        }
        
        if (reversi.contadorPiezasRivalArriba > 0 
                && reversi.tablero[columna][reversi.posYFinalArriba] == jugador) {
            System.out.println("colocando fichas grafico bucle arriba");

            for (int y = fila; y >= fila - reversi.contadorPiezasRivalArriba; y--) {
                Ficha ficha = new Ficha(jugador);
                ficha.setCenterX(columna * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                ficha.setCenterY(y * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                this.getChildren().add(ficha);
            }

        }
        
        if (reversi.contadorPiezasRivalDiagonal_1>0 
                && reversi.tablero[reversi.posXFinalD1_1][reversi.posYFinalD1_1] == jugador){

            System.out.println("colocando fichas grafico bucle Diagonal1_1");

            int xDiagonal1_1 = columna;
            for (int y = fila; y >= fila - reversi.contadorPiezasRivalDiagonal_1; y--) {
                
                Ficha ficha = new Ficha(jugador);
                ficha.setCenterX(xDiagonal1_1 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                ficha.setCenterY(y * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                this.getChildren().add(ficha);
                xDiagonal1_1--;
                
            }
        }
        
        if (reversi.contadorPiezasRivalDiagonal_2>0 &&
                reversi.tablero[reversi.posXFinalD1_2][reversi.posYFinalD1_2] == jugador){
            System.out.println("colocando fichas grafico bucle Diagonal1_2");
            int xDiagonal1_2 = columna;
            for (int y = fila; y <= fila + reversi.contadorPiezasRivalDiagonal_2; y++) {
                Ficha ficha = new Ficha(jugador);
                ficha.setCenterX(xDiagonal1_2 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                ficha.setCenterY(y * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                this.getChildren().add(ficha);
                xDiagonal1_2++;
            }
        
        }
        
        if (reversi.contadorPiezasRivalDiagona2_1>0 && 
                reversi.tablero[reversi.posXFinalD2_1][reversi.posYFinalD2_1] == jugador){
            System.out.println("colocando fichas grafico bucle Diagonal2_1");
            int xDiagonal2_1 = columna;

            for (int y = fila; y >= fila - reversi.contadorPiezasRivalDiagona2_1; y--) {
                Ficha ficha = new Ficha(jugador);
                ficha.setCenterX(xDiagonal2_1 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                ficha.setCenterY(y * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                this.getChildren().add(ficha);
                xDiagonal2_1++;
            }
        
        }
        
        if (reversi.contadorPiezasRivalDiagona2_2>0 
                && reversi.tablero[reversi.posXFinalD2_2][reversi.posYFinalD2_2] == jugador){
            System.out.println("colocando fichas grafico bucle Diagonal2_2");
            int xDiagonal2_2 = columna;

            for (int y = fila; y <= fila + reversi.contadorPiezasRivalDiagona2_2; y++) {
                Ficha ficha = new Ficha(jugador);
                ficha.setCenterX(xDiagonal2_2 * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                ficha.setCenterY(y * Ficha.TAM_FICHA + Ficha.TAM_FICHA / 2);
                this.getChildren().add(ficha);
                xDiagonal2_2--;

            }
        
        }
        
    }
    
    
    public void renovarPuntos(){
        
        //Uso variable que contenga el resultado de el metodo cambiar puntuacion
        // para usar ese resultado en la logica y ver quien gana
                
        numFichasBlancas=PanelPuntos.cambiarPuntuacion(Reversi.JUGADOR1,reversi);
        PanelPuntos.fichasBlancas.setText("Blancas: " + numFichasBlancas);
        
        numFichasNegras=PanelPuntos.cambiarPuntuacion(Reversi.JUGADOR2,reversi);
        PanelPuntos.fichasNegras.setText("Negras: " + numFichasNegras);
    
        
    }

    
    public void quienGana(){
        
        switch (reversi.victoria()) {
            case 'N':
                System.out.println("HA ganado NEGRO");
                PanelMensajes.mostrarMensaje("HA GANADO EL JUGADOR CON LAS PIEZAS NEGRAS");
                
                break;
            case 'B':
                System.out.println("HA ganado Blanco");
                PanelMensajes.mostrarMensaje("HA GANADO EL JUGADOR CON LAS PIEZAS BLANCAS");
                break;
            default:
                System.out.println("No ha ganado nadie");
                break;
        }
    
    }
    
    public void compruebaCondiciones(){
    
        if(reversi.movPosibles(Reversi.JUGADOR1)==true &&
                reversi.movPosibles(Reversi.JUGADOR2)==false){
            PanelMensajes.mostrarMensaje("Las negras no tienen movimientos posibles, pasan turno");
            reversi.turnoJugador=Reversi.JUGADOR1;
            
        }else if(reversi.movPosibles(Reversi.JUGADOR1)==false &&
            reversi.movPosibles(Reversi.JUGADOR2)==true){
            
            PanelMensajes.mostrarMensaje("Las Blancas no tienen movimientos posibles, pasan turno");
            reversi.turnoJugador=Reversi.JUGADOR2;
        }
        
    
    }
    
    
    //METODO pasar turno porq no tienes movimientos


}


            