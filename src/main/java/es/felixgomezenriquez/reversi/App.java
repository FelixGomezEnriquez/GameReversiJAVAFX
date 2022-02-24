package es.felixgomezenriquez.reversi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
       
        
        int tamXPantalla = 640;
        int tamYPantalla = 480;
        
        Pane paneRoot = new Pane();
        var scene = new Scene(paneRoot, tamXPantalla, tamYPantalla);
        stage.setScene(scene);
        stage.show();
        
        Reversi reversi=new Reversi();
        
        reversi.mostrarTablero();
        
        
        
                
        
        reversi.colocarFicha( 2, 4, 'N');
        
        
        
        
        
        
        reversi.mostrarTablero();
                
    }

    public static void main(String[] args) {
        launch();
    }

}