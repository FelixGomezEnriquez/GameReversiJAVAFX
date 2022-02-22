/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.felixgomezenriquez.reversi;

/**
 *
 * @author usuario
 */
public class Reversi {
    
    int tamXTablero;
    int tamYTablero;
    char[][] tablero;
   
    
    final char JUGADOR1 = 'B';
    final char JUGADOR2 = 'N';
    final char VACIO = '.';
    
    int posJugador1[];
    int posJugador2[];

        
    public Reversi(){

        tamXTablero =8;
        tamYTablero = 8;
        tablero = new char[tamXTablero][tamYTablero];
        for(int x=0; x<tamXTablero; x++) {
            for(int y=0; y<tamYTablero; y++) {
                tablero[x][y] = VACIO;        
            }
        }
        
        tablero[3][3]='B';
        tablero[4][3]= 'N'; /*-------------------Cambiar N------------------------*/
        tablero[4][4]='B';
        tablero[3][4]='N';
        
    }
    
    public void mostrarTablero(){
    
        for(int y=0; y<tamYTablero; y++) {
            for(int x=0; x<tamXTablero; x++) {
                System.out.print(tablero[x][y]);
            }
            System.out.println();
        }    
        System.out.println();
    
    }
    
    
    
    public void colocarFicha(/*int columna,int fila,char jugador*/){
    
        tablero[5][4]='B';
        tablero[2][4]='B';
        tablero[2][4]='B';
        tablero[6][3]='B';
        tablero[6][2]='B';
        tablero[6][5]='B';
        tablero[6][6]='B';
        tablero[5][3]='B';
        tablero[4][2]='N';

        
        
        
        
//        if(columna >= 0 && columna < tamXTablero) {
//        
//            //this.metodocomprobarquepuedecolocarse
//            
//        }
    }
    
    
    public void comprobarPosicionEscogida(int columna, int fila, char jugador){
        
        
        
        
         int contadorPiezasRivalIzq = 0;
        // Recuento a la izquierda
        int pos = 1;
        while(columna-pos >= 0 && tablero[columna-pos][fila]!= VACIO) {
            
            if (tablero[columna-pos][fila]== jugador) {
                System.out.println("Las piezas del rival a la izquierda hasta el jugador "+ jugador+" son:"+contadorPiezasRivalIzq);
                //Comprobar que aunq haya piezas rivales si se encuentra con una ficha de jugador, no pueda poner ficha

                break;
            }else{
                contadorPiezasRivalIzq++;
            }
            pos++;
        }
        
        System.out.println("Las piezas del rival a la izquierdo son:"+contadorPiezasRivalIzq);
        
        
        int contadorPiezasRivalDer = 0;
        pos = 1;
        while(columna+pos < tamXTablero && tablero[columna+pos][fila]!= VACIO) {
            
            if (tablero[columna+pos][fila]== jugador) {
                System.out.println("Las piezas del rival a la derecha hasta el jugador:"+ jugador+" son:"+contadorPiezasRivalDer);
                break;
            }else{
                contadorPiezasRivalDer++;
            }
            pos++;
        }
        

        
        System.out.println("Las piezas del rival a la derecha son:"+contadorPiezasRivalDer);

      
         int contadorPiezasRivalArriba = 0;
        pos = 1;
        while(fila-pos < tamXTablero && tablero[columna][fila-pos]!= VACIO) {
            
            if (tablero[columna][fila-pos]== jugador) {
                System.out.println("Las piezas del rival  hacia arrriba hasta jugador:"+ jugador+" son:"+contadorPiezasRivalArriba);
                
                break;
            }else{
                contadorPiezasRivalArriba++;
            }
            pos++;
        }
                
        System.out.println("Las piezas del rival a hacia arriba son:"+contadorPiezasRivalArriba);
        
        
          int contadorPiezasRivalAbajo = 0;
        pos = 1;
        while(fila+pos < tamXTablero && tablero[columna][fila+pos]!= VACIO) {
            
            if (tablero[columna][fila+pos]== jugador) {
                System.out.println("Las piezas del rival hacia abajo hasta jugador "+ jugador+" son:"+contadorPiezasRivalAbajo);
                break;
            }else{
                contadorPiezasRivalAbajo++;
            }
            pos++;
        }
                
        System.out.println("Las piezas del rival a hacia abajo son:"+contadorPiezasRivalAbajo);
        
        
        
        int contadorPiezasRivalDiagonal_1 = 0;                    
        pos = 1;
         
        
        while(fila-pos >= 0 && columna-pos >=0 && tablero[columna-pos][fila-pos]!= VACIO) {
            
            if (tablero[columna-pos][fila-pos]== jugador) {
                System.out.println("Las piezas del rival diagonal 1_1 hasta jugador "+ jugador+" son:"+contadorPiezasRivalDiagonal_1);
                break;
            }else{
                contadorPiezasRivalDiagonal_1++;
            }
            pos++;
        }
              
        
            System.out.println("Las piezas del rival a diagonal 1_1 son:"+contadorPiezasRivalDiagonal_1);

    /*      /
                /
                    /   
                        /
        esta es diagonal 1_1
      */  
        
    

    int contadorPiezasRivalDiagonal_2 = 0;                    
        pos = 1;
         
        
        while(fila+pos >= 0 && columna+pos >=0 && tablero[columna+pos][fila+pos]!= VACIO) {
            
            if (tablero[columna+pos][fila+pos]== jugador) {
                System.out.println("Las piezas del rival diagonal 1_2 hasta jugador "+ jugador+" son:"+contadorPiezasRivalDiagonal_2);
                break;
            }else{
                contadorPiezasRivalDiagonal_2++;
            }
            pos++;
        }
              
        
            System.out.println("Las piezas del rival a diagonal 1_2 son:"+contadorPiezasRivalDiagonal_2);
    
        
  
                  /*
 . .. . . . ../ 
.. ...  ..../.  
.  .   .  ./..
. . .     /...
*/    
    
    
    
       
        //Este metodo o otro debe devolver el numero de piezas del rival que hay entre la posicion escogida
        //y la sioguiente pieza de jguado. 
        //Y tambien hacia donde estaba mirando,izq,der,arriba,abajo,diagonal
        
        //PARA COMPROBAR LAS FICHAS Y COLOCARLAS DIVIDIR TABLERO EN filas y columnas como hizo javi dividiendo la x o y 
        //del mouse entre el tam de la ficha
    }
    
    
}


  
   //metodo comprueba cada casilla haciendole un for para devolverte las casillas en las que puedes colocar