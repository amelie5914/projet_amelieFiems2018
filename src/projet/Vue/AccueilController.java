/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Vue;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projet.Modele.ProjetModele;
import projet.Modele.ProjetModeleJDBC;

/**
 * FXML Controller class
 *
 * @author ameliefiems
 */
public class AccueilController implements Initializable, ControlledEcran{

    ControleurEcran myController;
    //ProjetModeleJDBC pm;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @Override
    public void setScreenParent(ControleurEcran screenParent){
        myController = screenParent;
    }

    @FXML
    private void goToScreen2(ActionEvent event){
        //tPrincipal.pm=new ProjetModeleJDBC();
        
       //myController.setModele(pm);
       myController.setScreen(Principal.screen2ID);
       
    }
    /**
     * Initializes the controller class.
     */
      
    
}
