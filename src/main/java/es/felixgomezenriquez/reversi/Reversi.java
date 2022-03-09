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
     char turnoJugador = JUGADOR1;

    int contadorPiezasRivalAbajo;
    int contadorPiezasRivalArriba;
    int contadorPiezasRivalDer;
    int contadorPiezasRivalIzq;

    int contadorPiezasRivalDiagonal_1;
    int contadorPiezasRivalDiagonal_2;
    int contadorPiezasRivalDiagona2_1;
    int contadorPiezasRivalDiagona2_2;

    public Reversi() {

        tamXTablero = 8;
        tamYTablero = 8;
        tablero = new char[tamXTablero][tamYTablero];
        for (int x = 0; x < tamXTablero; x++) {
            for (int y = 0; y < tamYTablero; y++) {
                tablero[x][y] = VACIO;
            }
        }

        tablero[3][3] = 'B';
        tablero[4][3] = 'N';
        tablero[4][4] = 'B';
        tablero[3][4] = 'N';

    }

    public void mostrarTablero() {

        for (int y = 0; y < tamYTablero; y++) {
            for (int x = 0; x < tamXTablero; x++) {
                System.out.print(tablero[x][y]);
            }
            System.out.println();
        }
        System.out.println();

    }

    public boolean colocarFicha(int columna, int fila, char jugador) {

        if (this.comprobarPosicionEscogida(columna, fila, jugador) == true) {
            System.out.println("colocando ficha: " + jugador);

            if (this.contadorPiezasRivalIzq > 0) {

                if (tablero[columna - contadorPiezasRivalIzq - 1][fila] == jugador) {

                    System.out.println("colocando fichas bucle a la izquierda");
                    for (int x = columna; x >= columna - contadorPiezasRivalIzq; x--) {
                        tablero[x][fila] = jugador;
                    }
                    return true;// NO deja seguir las com`probaciones del metodo

                } else {

                    System.out.println("No se puede colocar hacia izquierda");

                }

            }

            if (this.contadorPiezasRivalDer > 0) {

                if (tablero[columna + contadorPiezasRivalDer + 1][fila] == jugador) {

                    System.out.println("colocando fichas bucle a la derecha");
                    for (int x = columna; x <= columna + contadorPiezasRivalDer; x++) {
                        tablero[x][fila] = jugador;
                    }

                    return true;

                } else {

                    System.out.println("No se puede colocar a la derecha");
                }

            }

            if (this.contadorPiezasRivalAbajo > 0) {

                if (tablero[columna][fila + contadorPiezasRivalAbajo + 1] == jugador) {

                    System.out.println("colocando fichas bucle hacia abajo");
                    for (int y = fila; y <= fila + contadorPiezasRivalAbajo; y++) {
                        tablero[columna][y] = jugador;

                    }
                    return true;

                } else {

                    System.out.println("No se puede colocar hacia abajo");

                }

            }

            if (this.contadorPiezasRivalArriba > 0) {

                if (tablero[columna][fila - contadorPiezasRivalArriba - 1] == jugador) {

                    System.out.println("colocando fichas bucle hacia arriba");
                    for (int y = fila; y >= fila - contadorPiezasRivalArriba; y--) {
                        tablero[columna][y] = jugador;
                    }
                    return true;

                } else {

                    System.out.println("No se puede colocar hacia arriba");

                }

            }

            if (this.contadorPiezasRivalDiagonal_1 > 0) {

                if (tablero[columna - contadorPiezasRivalDiagonal_1 - 1][fila - contadorPiezasRivalDiagonal_1 - 1] == jugador) {

                    System.out.println("colocando fichas bucle hacia Diagonal_1");
                    int xDiagonal1_1 = columna;
                    for (int y = fila; y >= fila - contadorPiezasRivalDiagonal_1; y--) {
                        tablero[xDiagonal1_1][y] = jugador;
                        xDiagonal1_1--;
                    }
                    return true;

                } else {

                    System.out.println("No se puede colocar en diagonal1_1");

                }

            }

            if (this.contadorPiezasRivalDiagonal_2 > 0) {
                
                
                if (tablero[columna + contadorPiezasRivalDiagonal_2 + 1][fila + contadorPiezasRivalDiagonal_2 + 1] == jugador) {

                    System.out.println("colocando fichas bucle hacia Diagonal_2");
                    int xDiagonal1_2 = columna;
                    for (int y = fila; y <= fila + contadorPiezasRivalDiagonal_2; y++) {
                        tablero[xDiagonal1_2][y] = jugador;
                        xDiagonal1_2++;
                    }
                    return true;
                } else {

                    System.out.println("No se puede colocar en diagonal 1_2");

                }

            }

            if (this.contadorPiezasRivalDiagona2_1 > 0) {

                if (tablero[columna + contadorPiezasRivalDiagona2_1 + 1][fila - contadorPiezasRivalDiagona2_1 - 1] == jugador) {

                    System.out.println("colocando fichas bucle hacia Diagona2_1");
                    int xDiagonal2_1 = columna;

                    for (int y = fila; y >= fila - contadorPiezasRivalDiagona2_1; y--) {
                        tablero[xDiagonal2_1][y] = jugador;
                        xDiagonal2_1++;
                    }
                    return true;

                } else {

                    System.out.println("No se puede colocar");

                }

            }

            if (this.contadorPiezasRivalDiagona2_2 > 0) {

                if (tablero[columna - contadorPiezasRivalDiagona2_2 - 1][fila + contadorPiezasRivalDiagona2_2 + 1] == jugador) {

                    System.out.println("colocando fichas bucle hacia Diagona2_2");

                    int xDiagonal2_2 = columna;

                    for (int y = fila; y <= fila + contadorPiezasRivalDiagona2_2; y++) {
                        tablero[xDiagonal2_2][y] = jugador;
                        xDiagonal2_2--;

                    }
                    return true;
                } else {

                    System.out.println("No se puede colocar");

                }

            }
        } else if (this.comprobarPosicionEscogida(columna, fila, jugador) == false) {
            System.out.println("No se puede poner la ficha");
            return false;
        }

        return false;
    }

    public boolean comprobarPosicionEscogida(int columna, int fila, char jugador) {

        contadorPiezasRivalIzq = 0;
        // Recuento a la izquierda
        int posIzq = 1;
        //Mientras la columna menos la pos sea mayor o igual a 0 y la siguiente posicion sea distinto de vacio
        while (columna - posIzq >= 0 && tablero[columna - posIzq][fila] != VACIO) {

            if (tablero[columna - posIzq][fila] == jugador) {
                System.out.println("Las piezas del rival a la izquierda hasta el jugador " + jugador + " son:" + contadorPiezasRivalIzq);

                break;
            } else {
                contadorPiezasRivalIzq++;
            }
            posIzq++;

        }

        System.out.println("Las piezas del rival a la izquierdo son:" + contadorPiezasRivalIzq);

        contadorPiezasRivalDer = 0;
        int posDer = 1;
        while (columna + posDer < tamXTablero && tablero[columna + posDer][fila] != VACIO) {

            if (tablero[columna + posDer][fila] == jugador) {
                System.out.println("Las piezas del rival a la derecha hasta el jugador:" + jugador + " son:" + contadorPiezasRivalDer);
                break;
            } else {
                contadorPiezasRivalDer++;
            }
            posDer++;
        }

        System.out.println("Las piezas del rival a la derecha son:" + contadorPiezasRivalDer);

        contadorPiezasRivalArriba = 0;
        int posArr = 1;
        while (fila - posArr >= 0 && tablero[columna][fila - posArr] != VACIO) {
            System.out.println("fila-pos yendo parriba" + (fila - posArr));

            if (tablero[columna][fila - posArr] == jugador) {
                System.out.println("Las piezas del rival  hacia arrriba hasta jugador:" + jugador + " son:" + contadorPiezasRivalArriba);

                break;
            } else {
                contadorPiezasRivalArriba++;
            }
            posArr++;
        }

        System.out.println("Las piezas del rival a hacia arriba son:" + contadorPiezasRivalArriba);

        contadorPiezasRivalAbajo = 0;
        int posAba = 1;
        while (fila + posAba < tamYTablero && tablero[columna][fila + posAba] != VACIO) {

            if (tablero[columna][fila + posAba] == jugador) {
                System.out.println("Las piezas del rival hacia abajo hasta jugador " + jugador + " son:" + contadorPiezasRivalAbajo);
                break;
            } else {
                contadorPiezasRivalAbajo++;
            }
            posAba++;
        }

        System.out.println("Las piezas del rival a hacia abajo son:" + contadorPiezasRivalAbajo);

        contadorPiezasRivalDiagonal_1 = 0;
        int posD1_1 = 1;

        while (fila - posD1_1 >= 0 && columna - posD1_1 >= 0 && tablero[columna - posD1_1][fila - posD1_1] != VACIO) {

            if (tablero[columna - posD1_1][fila - posD1_1] == jugador) {
                System.out.println("Las piezas del rival diagonal 1_1 hasta jugador " + jugador + " son:" + contadorPiezasRivalDiagonal_1);
                break;
            } else {
                contadorPiezasRivalDiagonal_1++;
            }
            posD1_1++;
        }

        System.out.println("Las piezas del rival a diagonal 1_1 son:" + contadorPiezasRivalDiagonal_1);

        /*      /
                /
                    /   
                        /
        esta es diagonal 1_1 HACIA ARRIBA
         */
        contadorPiezasRivalDiagonal_2 = 0;
        int posD1_2 = 1;

        while (fila + posD1_2 < 8 && columna + posD1_2 < 8 && tablero[columna + posD1_2][fila + posD1_2] != VACIO) {

            if (tablero[columna + posD1_2][fila + posD1_2] == jugador) {
                System.out.println("Las piezas del rival diagonal 1_2 hasta jugador " + jugador + " son:" + contadorPiezasRivalDiagonal_2);
                break;
            } else {
                contadorPiezasRivalDiagonal_2++;
            }
            posD1_2++;
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
        int posD2_1 = 1;

        while (fila - posD2_1 == 0 && columna + posD2_1 == 7 && tablero[columna + posD2_1][fila - posD2_1] != VACIO) {

            if (tablero[columna + posD2_1][fila - posD2_1] == jugador) {
                System.out.println("Las piezas del rival diagonal 2_1 hasta jugador " + jugador + " son:" + contadorPiezasRivalDiagona2_1);
                break;
            } else {
                contadorPiezasRivalDiagona2_1++;
            }
            posD2_1++;
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
        int posD2_2 = 1;

        while (fila + posD2_2 == 7 && columna - posD2_2 == 0 && tablero[columna - posD2_2][fila + posD2_2] != VACIO) {

            if (tablero[columna - posD2_2][fila + posD2_2] == jugador) {
                System.out.println("Las piezas del rival diagonal 2_2 hasta jugador " + jugador + " son:" + contadorPiezasRivalDiagona2_2);
                break;
            } else {
                contadorPiezasRivalDiagona2_2++;
            }
            posD2_2++;
        }

        System.out.println("Las piezas del rival a diagonal 2_2 son:" + contadorPiezasRivalDiagona2_2);

        /*
            
            
                        /
                    /
                /
            /
        
                Hacia abajo

         */
        if (contadorPiezasRivalAbajo > 0 && tablero[columna][fila + posAba] != VACIO
                || contadorPiezasRivalArriba > 0 && tablero[columna][fila - posArr] != VACIO
                || contadorPiezasRivalDer > 0 && tablero[columna + posDer][fila] != VACIO
                || contadorPiezasRivalIzq > 0 && tablero[columna - posIzq][fila] != VACIO
                || contadorPiezasRivalDiagonal_1 > 0 && tablero[columna - posD1_1][fila - posD1_1] != VACIO
                || contadorPiezasRivalDiagonal_2 > 0 && tablero[columna + posD1_2][fila + posD1_2] != VACIO
                || contadorPiezasRivalDiagona2_1 > 0 && tablero[columna + posD2_1][fila - posD2_1] != VACIO
                || contadorPiezasRivalDiagona2_2 > 0 && tablero[columna - posD2_2][fila + posD2_2] != VACIO) {

            return true;    //Devuelve verdadero, significa que se puede colocar una pieza
        } else {

            return false; //Devuelve falso no se puede colocar ninguna pieza
        }

    }

     public char cambiarTurnoJugador() {

        if (turnoJugador == JUGADOR1) {
            turnoJugador = JUGADOR2;
            return turnoJugador;
        } else {
            turnoJugador = JUGADOR1;
            return turnoJugador;
        }
    }

}
