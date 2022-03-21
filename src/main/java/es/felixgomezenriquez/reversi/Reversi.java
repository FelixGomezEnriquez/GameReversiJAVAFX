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
//Esta clase es la encargada de almacenar toda la logica del juego, por tanto es 
//la mas extensa y compleja.
public class Reversi {

    //Variables tamaño del tablero y inicializacion del array bidimensional
    final int TAM_X_TABLERO;
    final int TAM_Y_TABLERO;
    char[][] tablero;

    //Inicializacion de constantes y variables de jugadores y control del turno
    static final char JUGADOR1 = 'B';
    static final char JUGADOR2 = 'N';
    final char VACIO = '.';
    char turnoJugador = JUGADOR1;
    //Variables que controlan si tiene movimientos posibles o no 

//    boolean movJugadorBlanco;
//    boolean movJugadorNegro;
    //Variables que almacenan la cantidad de piezas del rival que hay entre 2 piezas aliadas
    int contadorPiezasRivalAbajo;
    int contadorPiezasRivalArriba;
    int contadorPiezasRivalDer;
    int contadorPiezasRivalIzq;
    int contadorPiezasRivalDiagonal_1;
    int contadorPiezasRivalDiagonal_2;
    int contadorPiezasRivalDiagona2_1;
    int contadorPiezasRivalDiagona2_2;

//Variables que controlan lo que hay 1 posicion mas o una posicion menos para
//saber que hay mas alla de la suma de las piezas rivales, es decir saber si 
//en esa posicion hay una pieza aliada
//EJEMPLO:  tablero[posXFinalIzq][fila]= tablero[columna- contadorPiezasRivalIzq-1][fila] 
    int posXFinalIzq;
    int posXFinalDer;
    int posYFinalAbajo;
    int posYFinalArriba;
    int posXFinalD1_1;
    int posYFinalD1_1;
    int posXFinalD1_2;
    int posYFinalD1_2;
    int posXFinalD2_1;
    int posYFinalD2_1;
    int posXFinalD2_2;
    int posYFinalD2_2;

//Metodo constructor que crea un objeto Reversi
    public Reversi() {

//Le damos un valor a las siguientes variables para la posterior creacion del array
        TAM_X_TABLERO = 8;
        TAM_Y_TABLERO = 8;
//Creamos el array bidimensional con los tamaños dados por las variables y usamos
//un for para hacerlo

        tablero = new char[TAM_X_TABLERO][TAM_Y_TABLERO];
        for (int x = 0; x < TAM_X_TABLERO; x++) {
            for (int y = 0; y < TAM_Y_TABLERO; y++) {
                tablero[x][y] = VACIO;
            }
        }
//Colocamos las fichas iniciales
        tablero[3][3] = 'B';
        tablero[4][3] = 'N';
        tablero[4][4] = 'B';
        tablero[3][4] = 'N';

    }

    public void mostrarTablero() {

//Este metodo se encarga de mostrar el array bidimensional en forma de tablero
//segun este for por cada iteracion de y hace 7 iteraciones de x, en cada iteracion
//de y hace un System.out.println(); para darle un salto de linea y darle la forma de tablero
        for (int y = 0; y < TAM_Y_TABLERO; y++) {
            for (int x = 0; x < TAM_X_TABLERO; x++) {
                System.out.print(tablero[x][y]);
            }
            System.out.println();
        }
        System.out.println();

    }

//Este metodo se encarga de colocar las fichas en el array dependiendo del resultado del
//metodo comprobarPosicionEscogida que devuelve un boolean
    public boolean colocarFicha(int columna, int fila, char jugador) {

        //esta variable cambia su valor cuando se puede colocar cualquier ficha
        boolean seHaColocado = false;

        if (this.comprobarPosicionEscogida(columna, fila, jugador) == true) {
            System.out.println("colocando ficha: " + jugador);

            //Le damos valor a la variable inicializada arriba
            posXFinalIzq = columna - contadorPiezasRivalIzq - 1;

            //Comprobamos que el valor no pasa las dimensiones del array
            if (posXFinalIzq <= 0) {
                posXFinalIzq = 0;
            }

//Todas las siguientes sentecias if funcionan de forma similar, por eso solo 
//explicare el caso del primer if
            //Si el numero de piezas del rival a la izquierda es mayor que 0  y la posicion
            // con la variable (posXFinalIzq) que controla lo que hay 1 posicion mas para
            //saber que hay mas alla de la suma de las piezas rivales, es decir saber si 
            //en esa posicion hay una pieza aliada.
            //EJEMPLO:  posXFinalIzq = columna - contadorPiezasRivalIzq-1          
            //se ejecutan las lineas pertinentes que manipulan el array bidimensional
            //sino se cumple las condiciones manda un mensaje por consola de aviso
            if (this.contadorPiezasRivalIzq > 0
                    && tablero[posXFinalIzq][fila] == jugador) {

                System.out.println("colocando fichas bucle a la izquierda");
                for (int x = columna; x >= columna - contadorPiezasRivalIzq; x--) {
                    tablero[x][fila] = jugador;
                }
                seHaColocado = true;
            } else {

                System.out.println("No se puede colocar hacia izquierda");

            }

            posXFinalDer = columna + contadorPiezasRivalDer + 1;

            if (posXFinalDer >= 7) {
                posXFinalDer = 7;
            }

            if (this.contadorPiezasRivalDer > 0
                    && tablero[posXFinalDer][fila] == jugador) {

                System.out.println("colocando fichas bucle a la derecha");
                for (int x = columna; x <= columna + contadorPiezasRivalDer; x++) {
                    tablero[x][fila] = jugador;
                }

                seHaColocado = true;

            } else {

                System.out.println("No se puede colocar a la derecha");
            }

            posYFinalAbajo = fila + contadorPiezasRivalAbajo + 1;

            if (posYFinalAbajo >= 7) {
                posYFinalAbajo = 7;
            }

            if (this.contadorPiezasRivalAbajo > 0
                    && tablero[columna][posYFinalAbajo] == jugador) {

                System.out.println("colocando fichas bucle hacia abajo");
                for (int y = fila; y <= fila + contadorPiezasRivalAbajo; y++) {
                    tablero[columna][y] = jugador;

                }
                seHaColocado = true;

            } else {

                System.out.println("No se puede colocar hacia abajo");

            }

            posYFinalArriba = fila - contadorPiezasRivalArriba - 1;

            if (posYFinalArriba <= 0) {
                posYFinalArriba = 0;
            }

            if (this.contadorPiezasRivalArriba > 0
                    && tablero[columna][posYFinalArriba] == jugador) {

                System.out.println("colocando fichas bucle hacia arriba");
                for (int y = fila; y >= fila - contadorPiezasRivalArriba; y--) {
                    tablero[columna][y] = jugador;
                }
                seHaColocado = true;

            } else {

                System.out.println("No se puede colocar hacia arriba");

            }

            posXFinalD1_1 = columna - contadorPiezasRivalDiagonal_1 - 1;
            posYFinalD1_1 = fila - contadorPiezasRivalDiagonal_1 - 1;

            if (posXFinalD1_1 <= 0) {
                posXFinalD1_1 = 0;
            }

            if (posYFinalD1_1 <= 0) {
                posYFinalD1_1 = 0;
            }

            if (this.contadorPiezasRivalDiagonal_1 > 0
                    && tablero[posXFinalD1_1][posYFinalD1_1] == jugador) {

                System.out.println("colocando fichas bucle hacia Diagonal_1");
                int xDiagonal1_1 = columna;
                for (int y = fila; y >= fila - contadorPiezasRivalDiagonal_1; y--) {
                    tablero[xDiagonal1_1][y] = jugador;
                    xDiagonal1_1--;
                }
                seHaColocado = true;

            } else {

                System.out.println("No se puede colocar en diagonal1_1");

            }

            posXFinalD1_2 = columna + contadorPiezasRivalDiagonal_2 + 1;
            posYFinalD1_2 = fila + contadorPiezasRivalDiagonal_2 + 1;

            if (posXFinalD1_2 >= 7) {
                posXFinalD1_2 = 7;
            }

            if (posYFinalD1_2 >= 7) {
                posYFinalD1_2 = 7;
            }

            if (this.contadorPiezasRivalDiagonal_2 > 0
                    && tablero[posXFinalD1_2][posYFinalD1_2] == jugador) {

                System.out.println("colocando fichas bucle hacia Diagonal_2");
                int xDiagonal1_2 = columna;
                for (int y = fila; y <= fila + contadorPiezasRivalDiagonal_2; y++) {
                    tablero[xDiagonal1_2][y] = jugador;
                    xDiagonal1_2++;
                }
                seHaColocado = true;

            } else {

                System.out.println("No se puede colocar en diagonal 1_2");

            }

            posXFinalD2_1 = columna + contadorPiezasRivalDiagona2_1 + 1;
            posYFinalD2_1 = fila - contadorPiezasRivalDiagona2_1 - 1;

            if (posXFinalD2_1 >= 7) {
                posXFinalD2_1 = 7;
            }

            if (posYFinalD2_1 <= 0) {
                posYFinalD2_1 = 0;
            }

            if (this.contadorPiezasRivalDiagona2_1 > 0
                    && tablero[posXFinalD2_1][posYFinalD2_1] == jugador) {

                System.out.println("colocando fichas bucle hacia Diagona2_1");
                int xDiagonal2_1 = columna;

                for (int y = fila; y >= fila - contadorPiezasRivalDiagona2_1; y--) {
                    tablero[xDiagonal2_1][y] = jugador;
                    xDiagonal2_1++;
                }
                seHaColocado = true;

            } else {

                System.out.println("No se puede colocar en diagonal 2_1");

            }

            posXFinalD2_2 = columna - contadorPiezasRivalDiagona2_2 - 1;
            posYFinalD2_2 = fila + contadorPiezasRivalDiagona2_2 + 1;

            if (posXFinalD2_2 <= 0) {
                posXFinalD2_2 = 0;
            }

            if (posYFinalD2_2 >= 7) {
                posYFinalD2_2 = 7;
            }

            if (this.contadorPiezasRivalDiagona2_2 > 0
                    && tablero[posXFinalD2_2][posYFinalD2_2] == jugador) {

                System.out.println("colocando fichas bucle hacia Diagona2_2");

                int xDiagonal2_2 = columna;

                for (int y = fila; y <= fila + contadorPiezasRivalDiagona2_2; y++) {
                    tablero[xDiagonal2_2][y] = jugador;
                    xDiagonal2_2--;

                }

                seHaColocado = true;

            } else {

                System.out.println("No se puede colocaren diagonal 2_2");

            }

        } else {
            return false;
        }
        if (seHaColocado == true) {
            return true;
        } else {
            return false;
        }
    }

//Este metodo se ecarga de comprobar la posicion marcada por los parametros columna y fila para
//un jugador tambien pasado por parametros, devolviendo un boolean dependiendo de si se puede 
//colocar o no 
    public boolean comprobarPosicionEscogida(int columna, int fila, char jugador) {

        //este if se encarga de que no puedas poner una posicion en la que ya hay una pieza.
        if (tablero[columna][fila] != VACIO) {
            return false;
        }

        //Contador de las piezas del rival entre 2 piezas aliadas 
        contadorPiezasRivalIzq = 0;

        // Variable encargada almacenar la posicion dentro del bucle cuando comprueba 
        //hacia la izquierda.
        int posIzq = 1;

//Todos los bucles tienen sus variables de contador de las piezas y de la posicion para las 
//comprobaciones,funcionan de forma parecida a si que solo explicare el primero
        //Mientras la columna menos la posision sea mayor o igual a 0 y la siguiente 
        //posicion sea distinto de vacio
        while (columna - posIzq >= 0 && tablero[columna - posIzq][fila] != VACIO) {

            if (tablero[columna - posIzq][fila] == jugador) {
                System.out.println("Las piezas del rival a la izquierda hasta el jugador "
                        + jugador + " son: " + contadorPiezasRivalIzq);

                break;
            } else {
                contadorPiezasRivalIzq++;
            }
            posIzq++;

        }

        System.out.println("Las piezas del rival a la izquierda son:" + contadorPiezasRivalIzq);

        contadorPiezasRivalDer = 0;
        int posDer = 1;
        while (columna + posDer < TAM_X_TABLERO && tablero[columna + posDer][fila] != VACIO) {

            if (tablero[columna + posDer][fila] == jugador) {
                System.out.println("Las piezas del rival a la derecha hasta el jugador: "
                        + jugador + " son: " + contadorPiezasRivalDer);
                break;
            } else {
                contadorPiezasRivalDer++;
            }
            posDer++;
        }

        System.out.println("Las piezas del rival a la derecha son: " + contadorPiezasRivalDer);

        contadorPiezasRivalArriba = 0;
        int posArr = 1;
        while (fila - posArr >= 0 && tablero[columna][fila - posArr] != VACIO) {

            if (tablero[columna][fila - posArr] == jugador) {
                System.out.println("Las piezas del rival  hacia arriba hasta jugador: "
                        + jugador + " son: " + contadorPiezasRivalArriba);

                break;
            } else {
                contadorPiezasRivalArriba++;
            }
            posArr++;
        }

        System.out.println("Las piezas del rival a hacia arriba son: " + contadorPiezasRivalArriba);

        contadorPiezasRivalAbajo = 0;
        int posAba = 1;
        while (fila + posAba < TAM_Y_TABLERO && tablero[columna][fila + posAba] != VACIO) {

            if (tablero[columna][fila + posAba] == jugador) {
                System.out.println("Las piezas del rival hacia abajo hasta jugador "
                        + jugador + " son: " + contadorPiezasRivalAbajo);
                break;
            } else {
                contadorPiezasRivalAbajo++;
            }
            posAba++;
        }

        System.out.println("Las piezas del rival a hacia abajo son: " + contadorPiezasRivalAbajo);

        contadorPiezasRivalDiagonal_1 = 0;
        int posD1_1 = 1;

        while (fila - posD1_1 >= 0 && columna - posD1_1 >= 0
                && tablero[columna - posD1_1][fila - posD1_1] != VACIO) {

            if (tablero[columna - posD1_1][fila - posD1_1] == jugador) {
                System.out.println("Las piezas del rival diagonal 1_1 hasta jugador "
                        + jugador + " son:" + contadorPiezasRivalDiagonal_1);
                break;
            } else {
                contadorPiezasRivalDiagonal_1++;
            }
            posD1_1++;
        }

        System.out.println("Las piezas del rival a diagonal 1_1 son: " + contadorPiezasRivalDiagonal_1);

        /*      
                /
                    /   
                        /
        esta es diagonal 1_1 HACIA ARRIBA
         */
        contadorPiezasRivalDiagonal_2 = 0;
        int posD1_2 = 1;

        while (fila + posD1_2 < TAM_Y_TABLERO && columna + posD1_2 < TAM_X_TABLERO
                && tablero[columna + posD1_2][fila + posD1_2] != VACIO) {

            if (tablero[columna + posD1_2][fila + posD1_2] == jugador) {
                System.out.println("Las piezas del rival diagonal 1_2 hasta jugador "
                        + jugador + " son:" + contadorPiezasRivalDiagonal_2);
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

        while (fila - posD2_1 >= 0 && columna + posD2_1 < TAM_X_TABLERO
                && tablero[columna + posD2_1][fila - posD2_1] != VACIO) {

            if (tablero[columna + posD2_1][fila - posD2_1] == jugador) {
                System.out.println("Las piezas del rival diagonal 2_1 hasta jugador "
                        + jugador + " son:" + contadorPiezasRivalDiagona2_1);
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

        while (fila + posD2_2 < TAM_Y_TABLERO && columna - posD2_2 >= 0
                && tablero[columna - posD2_2][fila + posD2_2] != VACIO) {

            if (tablero[columna - posD2_2][fila + posD2_2] == jugador) {
                System.out.println("Las piezas del rival diagonal 2_2 hasta jugador "
                        + jugador + " son:" + contadorPiezasRivalDiagona2_2);
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

//Este metodo se encarga de cambiar el turno del jugador
    public char cambiarTurnoJugador() {

        if (turnoJugador == JUGADOR1) {
            turnoJugador = JUGADOR2;
            return turnoJugador;
        } else {
            turnoJugador = JUGADOR1;
            return turnoJugador;
        }
    }

//este metodo recorre el array y hace un recuento de todos los movimientos posibles
//para el jugador que reciba por parametros, y devuelve si tiene movimientos posibles 
//o no
    public boolean movPosibles(char jugador) {

        int movPosibles = 0;
        for (int i = 0; i < TAM_X_TABLERO; i++) {
            for (int j = 0; j < TAM_Y_TABLERO; j++) {
                if (tablero[i][j] == VACIO
                        && comprobarPosicionEscogidaSinConsola(i, j, jugador) == true) {
                    movPosibles++;
                }
            }
        }
        return movPosibles > 0;
    }

//Este metodo comprueba las condiciones segun si tiene movimientos los jugadores o no 
    public char comprobarCondiciones() {

        boolean movJugadorBlanco = this.movPosibles(Reversi.JUGADOR1);
        boolean movJugadorNegro = this.movPosibles(Reversi.JUGADOR2);

        if (movJugadorBlanco == false
                && movJugadorNegro == false
                && PanelPuntos.numFichasBlancas > PanelPuntos.numFichasNegras) {
            return 'B';
        } else if (movJugadorBlanco == false
                && movJugadorNegro == false
                && PanelPuntos.numFichasBlancas < PanelPuntos.numFichasNegras) {
            return 'N';
        } else if (movJugadorBlanco == true && movJugadorNegro == false) {
            return 'H';
        } else if (movJugadorBlanco == false && movJugadorNegro == true) {
            return 'U';
        } else if (movJugadorBlanco == false
                && movJugadorNegro == false
                && PanelPuntos.numFichasBlancas == PanelPuntos.numFichasNegras) {
            return 'E';
        } else {
            return '.';
        }
    }

//Este metodo ahce lo mismo que el comprobar posicion escogida pero sin mostrar mensajes
//por consola.
    public boolean comprobarPosicionEscogidaSinConsola(int columna, int fila, char jugador) {

        //Para no poder pinchar en una ficha ya puesta _-------------------------------
        if (tablero[columna][fila] != VACIO) {
            return false;
        }

        contadorPiezasRivalIzq = 0;
        // Recuento a la izquierda
        int posIzq = 1;
        //Mientras la columna menos la pos sea mayor o igual a 0 y la siguiente posicion sea distinto de vacio
        while (columna - posIzq >= 0 && tablero[columna - posIzq][fila] != VACIO) {

            if (tablero[columna - posIzq][fila] == jugador) {

                break;
            } else {
                contadorPiezasRivalIzq++;
            }
            posIzq++;

        }

        contadorPiezasRivalDer = 0;
        int posDer = 1;
        while (columna + posDer < 8 && tablero[columna + posDer][fila] != VACIO) {

            if (tablero[columna + posDer][fila] == jugador) {

                break;
            } else {
                contadorPiezasRivalDer++;
            }
            posDer++;
        }

        contadorPiezasRivalArriba = 0;
        int posArr = 1;
        while (fila - posArr >= 0 && tablero[columna][fila - posArr] != VACIO) {

            if (tablero[columna][fila - posArr] == jugador) {

                break;
            } else {
                contadorPiezasRivalArriba++;
            }
            posArr++;
        }

        contadorPiezasRivalAbajo = 0;
        int posAba = 1;
        while (fila + posAba < 8 && tablero[columna][fila + posAba] != VACIO) {

            if (tablero[columna][fila + posAba] == jugador) {

                break;
            } else {
                contadorPiezasRivalAbajo++;
            }
            posAba++;
        }

        contadorPiezasRivalDiagonal_1 = 0;
        int posD1_1 = 1;

        while (fila - posD1_1 >= 0 && columna - posD1_1 >= 0 && tablero[columna - posD1_1][fila - posD1_1] != VACIO) {

            if (tablero[columna - posD1_1][fila - posD1_1] == jugador) {

                break;
            } else {
                contadorPiezasRivalDiagonal_1++;
            }
            posD1_1++;
        }


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
                break;
            } else {
                contadorPiezasRivalDiagonal_2++;
            }
            posD1_2++;
        }


        /*
            \
                \
                    \
                        \
            
            HACIA ABAJO
         */
        contadorPiezasRivalDiagona2_1 = 0;
        int posD2_1 = 1;

        while (fila - posD2_1 >= 0 && columna + posD2_1 < 8
                && tablero[columna + posD2_1][fila - posD2_1] != VACIO) {

            if (tablero[columna + posD2_1][fila - posD2_1] == jugador) {
                break;
            } else {
                contadorPiezasRivalDiagona2_1++;
            }
            posD2_1++;
        }


        /*
            
            
                        /
                    /
                /
            /
        HACIA ARRIBA
         */
        contadorPiezasRivalDiagona2_2 = 0;
        int posD2_2 = 1;

        while (fila + posD2_2 <= 7 && columna - posD2_2 >= 0
                && tablero[columna - posD2_2][fila + posD2_2] != VACIO) {

            if (tablero[columna - posD2_2][fila + posD2_2] == jugador) {
                break;
            } else {
                contadorPiezasRivalDiagona2_2++;
            }
            posD2_2++;
        }


        /*
            
            
                        /
                    /
                /
            /
        
                Hacia abajo

         */
        posXFinalIzq = columna - contadorPiezasRivalIzq - 1;

        if (posXFinalIzq <= 0) {
            posXFinalIzq = 0;
        }

        posXFinalDer = columna + contadorPiezasRivalDer + 1;

        if (posXFinalDer >= 7) {
            posXFinalDer = 7;
        }

        posYFinalAbajo = fila + contadorPiezasRivalAbajo + 1;

        if (posYFinalAbajo >= 7) {
            posYFinalAbajo = 7;
        }

        posYFinalArriba = fila - contadorPiezasRivalArriba - 1;

        if (posYFinalArriba <= 0) {
            posYFinalArriba = 0;
        }

        posXFinalD1_1 = columna - contadorPiezasRivalDiagonal_1 - 1;
        posYFinalD1_1 = fila - contadorPiezasRivalDiagonal_1 - 1;

        if (posXFinalD1_1 <= 0) {
            posXFinalD1_1 = 0;
        }

        if (posYFinalD1_1 <= 0) {
            posYFinalD1_1 = 0;
        }

        posXFinalD1_2 = columna + contadorPiezasRivalDiagonal_2 + 1;
        posYFinalD1_2 = fila + contadorPiezasRivalDiagonal_2 + 1;

        if (posXFinalD1_2 >= 7) {
            posXFinalD1_2 = 7;
        }

        if (posYFinalD1_2 >= 7) {
            posYFinalD1_2 = 7;
        }

        posXFinalD2_1 = columna + contadorPiezasRivalDiagona2_1 + 1;
        posYFinalD2_1 = fila - contadorPiezasRivalDiagona2_1 - 1;

        if (posXFinalD2_1 >= 7) {
            posXFinalD2_1 = 7;
        }

        if (posYFinalD2_1 <= 0) {
            posYFinalD2_1 = 0;
        }

        posXFinalD2_2 = columna - contadorPiezasRivalDiagona2_2 - 1;
        posYFinalD2_2 = fila + contadorPiezasRivalDiagona2_2 + 1;

        if (posXFinalD2_2 <= 0) {
            posXFinalD2_2 = 0;
        }

        if (posYFinalD2_2 >= 7) {
            posYFinalD2_2 = 7;
        }

        if (contadorPiezasRivalAbajo > 0 && tablero[columna][posYFinalAbajo] == jugador
                || contadorPiezasRivalArriba > 0 && tablero[columna][posYFinalArriba] == jugador
                || contadorPiezasRivalDer > 0 && tablero[posXFinalDer][fila] == jugador
                || (contadorPiezasRivalIzq > 0 && tablero[posXFinalIzq][fila] == jugador)
                || contadorPiezasRivalDiagonal_1 > 0 && tablero[posXFinalD1_1][posYFinalD1_1] == jugador
                || contadorPiezasRivalDiagonal_2 > 0 && tablero[posXFinalD1_2][posYFinalD1_2] == jugador
                || contadorPiezasRivalDiagona2_1 > 0 && tablero[posXFinalD2_1][posYFinalD2_1] == jugador
                || contadorPiezasRivalDiagona2_2 > 0 && tablero[posXFinalD2_2][posYFinalD2_2] == jugador) {

            return true;    //Devuelve verdadero, significa que se puede colocar una pieza
        } else {

            return false; //Devuelve falso no se puede colocar ninguna pieza
        }

    }

//Este metodo resetea la logica del juego.
    public void resetLogica() {

        for (int x = 0; x < TAM_X_TABLERO; x++) {
            for (int y = 0; y < TAM_Y_TABLERO; y++) {
                tablero[x][y] = VACIO;
            }
        }
        //Colocamos las fichas iniciales
        tablero[3][3] = 'B';
        tablero[4][3] = 'N';
        tablero[4][4] = 'B';
        tablero[3][4] = 'N';
        turnoJugador = JUGADOR1;

    }

}
