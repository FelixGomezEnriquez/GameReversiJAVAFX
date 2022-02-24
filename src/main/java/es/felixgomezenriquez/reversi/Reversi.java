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
   
    
    static final char JUGADOR1 = 'B';
    static final char JUGADOR2 = 'N';
    final char VACIO = '.';
    static char turnoJugador = JUGADOR1;
    
    int contadorPiezasRivalAbajo;
    int contadorPiezasRivalArriba;
    int contadorPiezasRivalDer;
    int contadorPiezasRivalIzq;
    
    int contadorPiezasRivalDiagonal_1;
    int contadorPiezasRivalDiagonal_2; 
    int contadorPiezasRivalDiagona2_1; 
    int contadorPiezasRivalDiagona2_2;
    
        
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
        tablero[4][3]= 'N'; 
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
    
    
    
    public void colocarFicha(int columna,int fila,char jugador){
        

        if(this.comprobarPosicionEscogida(columna, fila, jugador)==true){
            System.out.println("colocandoficha");
            
            if(this.contadorPiezasRivalIzq>0){
                
                
                
                
                if (tablero[columna-contadorPiezasRivalIzq-1][fila] == jugador) {
                
                    System.out.println("colocando fichas bucle a la izquierda");
                    for (int x = columna; x >= columna - contadorPiezasRivalIzq; x--) {
                        tablero[x][fila] = jugador;
                    }
                    
                }else{

                    System.out.println("No se puede colocar hacia izquierda");

                }
                

                
                
                
                
            } else if (this.contadorPiezasRivalDer>0) {
                
                if (tablero[columna+contadorPiezasRivalDer+1][fila] == jugador) {
                    
                    System.out.println("colocando fichas bucle a la derecha");
                    for (int x = columna; x <= columna + contadorPiezasRivalDer; x++) {
                        tablero[x][fila] = jugador;
                    }
                }else{

                    System.out.println("No se puede colocar hacia derecha");

                }
                
            } else if (this.contadorPiezasRivalAbajo>0) {
                
                if (tablero[columna][fila+contadorPiezasRivalAbajo+1] == jugador) {
                    
                    System.out.println("colocando fichas bucle hacia abajo");
                    for (int y = fila; y <= fila + contadorPiezasRivalAbajo; y++) {
                        tablero[columna][y] = jugador;

                    }    

                }else{

                    System.out.println("No se puede colocar hacia abajo");

                }
                
                
                
                
            }else if (this.contadorPiezasRivalArriba > 0) {
                
                
                if (tablero[columna][fila-contadorPiezasRivalArriba-1] == jugador) {
                    
                    System.out.println("colocando fichas bucle hacia arriba");
                    for (int y = fila; y >= fila - contadorPiezasRivalArriba; y--) {
                        tablero[columna][y] = jugador;
                    }    

                }else{

                    System.out.println("No se puede colocar hacia arriba");

                }
                

            }else if (this.contadorPiezasRivalDiagonal_1 > 0) {
                
                if (tablero
                        [columna-contadorPiezasRivalDiagonal_1-1]
                        [fila-contadorPiezasRivalDiagonal_1-1] == jugador) {
                    
                    System.out.println("colocando fichas bucle hacia Diagonal_1");
                    int xDiagonal1_1 = columna;
                    for (int y = fila; y >= fila - contadorPiezasRivalDiagonal_1; y--) {
                        tablero[xDiagonal1_1][y] = jugador;
                        xDiagonal1_1--;
                    }

                }else{
                
                    System.out.println("No se puede colocar en diagonal1_1");
                
                }

                

            }else if (this.contadorPiezasRivalDiagonal_2 > 0) {
                
                if (tablero
                        [columna+contadorPiezasRivalDiagonal_1+1]
                        [fila+contadorPiezasRivalDiagonal_1+1] == jugador) {
                    
                    System.out.println("colocando fichas bucle hacia Diagonal_2");
                    int xDiagonal1_2=columna;
                    for (int y = fila; y <= fila + contadorPiezasRivalDiagonal_2; y++) {
                        tablero[xDiagonal1_2][y] = jugador;
                        xDiagonal1_2++;
                    }
                }else{
                    
                    System.out.println("No se puede colocar en diagonal 1_2");
                }

            }else if (this.contadorPiezasRivalDiagona2_1 > 0) {
                
                if (tablero
                        [columna+contadorPiezasRivalDiagona2_1+1]
                        [fila-contadorPiezasRivalDiagona2_1-1] == jugador) {
                    
                System.out.println("colocando fichas bucle hacia Diagona2_1");
                int xDiagonal2_1=columna;
                
                for (int y = fila; y >= fila - contadorPiezasRivalDiagona2_1; y--) {
                    tablero[xDiagonal2_1][y] = jugador;
                    xDiagonal2_1++;
                    
                }
                }else{
                    
                    System.out.println("No se puede colocar");
                }
                
                
            }else if (this.contadorPiezasRivalDiagona2_2 > 0) {
                
                if (tablero
                        [columna-contadorPiezasRivalDiagona2_2-1]
                        [fila+contadorPiezasRivalDiagona2_2+1] == jugador) {
                    
                System.out.println("colocando fichas bucle hacia Diagona2_2");
                
                int xDiagonal2_2=columna;
                
                for (int y = fila; y <= fila + contadorPiezasRivalDiagona2_2; y++) {
                    tablero[xDiagonal2_2][y] = jugador;
                    xDiagonal2_2--;
                    
                }
                }else{
                    
                    System.out.println("No se puede colocar");
                }
                
            }

        }else{
            System.out.println("No se puede poner la ficha");
            
        }
        

    } 
    
    
    public boolean  comprobarPosicionEscogida(int columna, int fila, char jugador){
        
        
        contadorPiezasRivalIzq = 0;
        // Recuento a la izquierda
        int pos = 1;
        while (columna - pos >= 0 && tablero[columna - pos][fila] != VACIO) {
            
            if (tablero[columna - pos][fila] == jugador) {
                System.out.println("Las piezas del rival a la izquierda hasta el jugador " + jugador + " son:" + contadorPiezasRivalIzq);

                break;
            } else {
                contadorPiezasRivalIzq++;
            }
            pos++;
        }
        
        System.out.println("Las piezas del rival a la izquierdo son:" + contadorPiezasRivalIzq);
        
        contadorPiezasRivalDer = 0;
        pos = 1;
        while (columna + pos < tamXTablero && tablero[columna + pos][fila] != VACIO) {
            
            if (tablero[columna + pos][fila] == jugador) {
                System.out.println("Las piezas del rival a la derecha hasta el jugador:" + jugador + " son:" + contadorPiezasRivalDer);
                break;
            } else {
                contadorPiezasRivalDer++;
            }
            pos++;
        }
        
        System.out.println("Las piezas del rival a la derecha son:" + contadorPiezasRivalDer);
        
        contadorPiezasRivalArriba = 0;
        pos = 1;
        while (fila - pos < tamXTablero && tablero[columna][fila - pos] != VACIO) {
            
            if (tablero[columna][fila - pos] == jugador) {
                System.out.println("Las piezas del rival  hacia arrriba hasta jugador:" + jugador + " son:" + contadorPiezasRivalArriba);
                
                break;
            } else {
                contadorPiezasRivalArriba++;
            }
            pos++;
        }
        
        System.out.println("Las piezas del rival a hacia arriba son:" + contadorPiezasRivalArriba);
        
        contadorPiezasRivalAbajo = 0;
        pos = 1;
        while (fila + pos < tamXTablero && tablero[columna][fila + pos] != VACIO) {
            
            if (tablero[columna][fila + pos] == jugador) {
                System.out.println("Las piezas del rival hacia abajo hasta jugador " + jugador + " son:" + contadorPiezasRivalAbajo);
                break;
            } else {
                contadorPiezasRivalAbajo++;
            }
            pos++;
        }
        
        System.out.println("Las piezas del rival a hacia abajo son:" + contadorPiezasRivalAbajo);
        
        contadorPiezasRivalDiagonal_1 = 0;        
        pos = 1;
        
        while (fila - pos >= 0 && columna - pos >= 0 && tablero[columna - pos][fila - pos] != VACIO) {
            
            if (tablero[columna - pos][fila - pos] == jugador) {
                System.out.println("Las piezas del rival diagonal 1_1 hasta jugador " + jugador + " son:" + contadorPiezasRivalDiagonal_1);
                break;
            } else {
                contadorPiezasRivalDiagonal_1++;
            }
            pos++;
        }
        
        System.out.println("Las piezas del rival a diagonal 1_1 son:" + contadorPiezasRivalDiagonal_1);

        /*      /
                /
                    /   
                        /
        esta es diagonal 1_1 HACIA ARRIBA
         */        
        contadorPiezasRivalDiagonal_2 = 0;        
        pos = 1;
        
        while (fila + pos >= 0 && columna + pos >= 0 && tablero[columna + pos][fila + pos] != VACIO) {
            
            if (tablero[columna + pos][fila + pos] == jugador) {
                System.out.println("Las piezas del rival diagonal 1_2 hasta jugador " + jugador + " son:" + contadorPiezasRivalDiagonal_2);
                break;
            } else {
                contadorPiezasRivalDiagonal_2++;
            }
            pos++;
        }
        
        System.out.println("Las piezas del rival a diagonal 1_2 son:" + contadorPiezasRivalDiagonal_2);

        /*
            \
                \
                    \
                        \
            
            HACIA ABAJO
         */        
        contadorPiezasRivalDiagona2_1 = 0;        
        pos = 1;
        
        while (fila - pos >= 0 && columna + pos >= 0 && tablero[columna + pos][fila - pos] != VACIO) {
            
            if (tablero[columna + pos][fila - pos] == jugador) {
                System.out.println("Las piezas del rival diagonal 2_1 hasta jugador " + jugador + " son:" + contadorPiezasRivalDiagona2_1);
                break;
            } else {
                contadorPiezasRivalDiagona2_1++;
            }
            pos++;
        }
        
        System.out.println("Las piezas del rival a diagonal 2_1 son:" + contadorPiezasRivalDiagona2_1);

        /*
            
            
                        /
                    /
                /
            /
        HACIA ARRIBA
         */
        
        
        contadorPiezasRivalDiagona2_2 = 0;        
        pos = 1;
        
        while (fila + pos >= 0 && columna - pos >= 0 && tablero[columna - pos][fila + pos] != VACIO) {
            
            if (tablero[columna - pos][fila + pos] == jugador) {
                System.out.println("Las piezas del rival diagonal 2_2 hasta jugador " + jugador + " son:" + contadorPiezasRivalDiagona2_2);
                break;
            } else {
                contadorPiezasRivalDiagona2_2++;
            }
            pos++;
        }
        
        System.out.println("Las piezas del rival a diagonal 2_2 son:" + contadorPiezasRivalDiagona2_2);

        /*
            
            
                        /
                    /
                /
            /
        
                Hacia abajo

         */
        
        



        
        
        if (contadorPiezasRivalAbajo > 0
                || contadorPiezasRivalArriba > 0
                || contadorPiezasRivalDer > 0
                || contadorPiezasRivalIzq > 0
                || contadorPiezasRivalDiagonal_1 > 0
                || contadorPiezasRivalDiagonal_2 > 0
                || contadorPiezasRivalDiagona2_1 > 0
                || contadorPiezasRivalDiagona2_2 > 0) {

            return true;    //Devuelve verdadero, significa que se puede colocar una pieza
        } else {

            return false; //Devuelve falso no se puede colocar ninguna pieza
        }

        
                  
       
    }
    
    

        static public boolean cambiarTurnoJugador() {
        if (turnoJugador == JUGADOR1) {
            turnoJugador = JUGADOR2;
            return false;
        } else {
            turnoJugador = JUGADOR1;
            return true;
        }
    }

    
    
}

        
       