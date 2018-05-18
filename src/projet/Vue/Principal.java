/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Vue;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ameliefiems
 */
public class Principal extends Application {

    public static String screen1ID = "accueil";
    public static String screen1File = "Accueil.fxml";
    public static String screen2ID = "liste";
    public static String screen2File = "Liste.fxml";
    
    
    @Override
    public void start(Stage primaryStage) {
        
        ControleurEcran mainContainer = new ControleurEcran();
        mainContainer.loadScreen(Principal.screen1ID, Principal.screen1File);
        mainContainer.loadScreen(Principal.screen2ID, Principal.screen2File);
        
        mainContainer.setScreen(Principal.screen1ID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
