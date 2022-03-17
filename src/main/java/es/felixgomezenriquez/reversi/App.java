package es.felixgomezenriquez.reversi;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
       
        
        int tamXPantalla = 640;
        int tamYPantalla = 480;
        
        BorderPane paneRoot = new BorderPane();
        var scene = new Scene(paneRoot, tamXPantalla, tamYPantalla);
        stage.setScene(scene);
        stage.show();
        paneRoot.setPadding(new Insets(10));
        CornerRadii cornerradii=new CornerRadii(15);
        paneRoot.setBackground(new Background(
            new BackgroundFill(Color.rgb(179,187,175), cornerradii, Insets.EMPTY)));
        
        
        Reversi reversi=new Reversi();
        
        
        Tablero tablero =new Tablero(reversi);
        
        
        PanelPuntos puntos=new PanelPuntos();
        PanelMensajes mensajes=new PanelMensajes();
        
                
        paneRoot.setCenter(tablero);
        
        //para quitar que te diga por rastreo tantas veces lo mismo hacer metodo comprobar
        //posicion escogida sin verbose y llamar a ese metodo en reversi.movposibles 
        //y en tablero.compruebacondiciones
        
        paneRoot.setLeft(puntos);
        
        paneRoot.setBottom(mensajes);
        
        
        
        

        
        
        
        
        
        
        
        
        
        
        
        
        
//        reversi.mostrarTablero();
//        
//        
//        
//                
//        
//        reversi.colocarFicha( 5, 4, 'N');
//        
//        
//        
//        
//        
//        
//        reversi.mostrarTablero();
                
    }

    public static void main(String[] args) {
        launch();
    }

}
