/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Vue;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author ameliefiems
 */
public class ListeController implements Initializable, ControlledEcran {
    ControleurEcran myController;
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
       myController.setScreen(Principal.screen2ID);
    }
    @FXML
    private void goToScreenProjetAjout(ActionEvent event){
       myController.setScreen(Principal.projetAjoutFile);
    }
    @FXML
    private void goToScreenEntrepriseAjout(ActionEvent event){
       myController.setScreen(Principal.entrepriseAjoutFile);
    }
    
    @FXML
    private void goToScreenProjetListe(ActionEvent event) {
        myController.setScreen(Principal.listeProjetFile);
    }
    @FXML
    private void goToScreenTitreProjet(ActionEvent event) {
        myController.setScreen(Principal.modifierTitreProjetFile);
    }
    @FXML
    private void goToScreenDateDebutProjet(ActionEvent event) {
        myController.setScreen(Principal.modifierDateDebutProjetFile);
    }
    @FXML
    private void goToScreenDateFinProjet(ActionEvent event) {
        myController.setScreen(Principal.modifierDateFinProjetFile);
    }
    @FXML
    private void goToScreenSupprimerProjet(ActionEvent event) {
        myController.setScreen(Principal.supprimerProjetFile);
    }
}
