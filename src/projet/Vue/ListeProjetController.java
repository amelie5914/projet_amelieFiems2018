/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Vue;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import projet.Modele.*;

/**
 * FXML Controller class
 *
 * @author ameliefiems
 */
public class ListeProjetController implements Initializable, ControlledEcran {
     //private ProjetModeleJDBC pm;
    ControleurEcran myController;
     private ObservableList<ProjetGeneral> projetData = FXCollections.observableArrayList();
    private List<ProjetGeneral> l = new ArrayList();
     @FXML
    private TableView<ProjetGeneral> personTable;
    @FXML
    private TableColumn<ProjetGeneral, String> titreColumn;

    @FXML
    private TableColumn<ProjetGeneral, String> dateDebutLabel;
    @FXML
    private TableColumn<ProjetGeneral, String> dateFinLabel;
    @FXML
    private TableColumn<ProjetGeneral, String> entrepriseLabel;
    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        l = Principal.pm.getProjet();
        l.forEach((projet) -> {
            projetData.add(projet);
        });
        titreColumn.setCellValueFactory(cellData -> cellData.getValue().getpTitre());
        dateDebutLabel.setCellValueFactory(cellData -> cellData.getValue().getpDateDebut());
        dateFinLabel.setCellValueFactory(cellData -> cellData.getValue().getpDateFin());
        
        //entrepriseLabel.setCellValueFactory(cellData -> cellData.getValue().getpEnt());
        /*entrepriseLabel.setCellValueFactory(cellData -> {
            return cellData.getValue();
        });*/
        

        personTable.setItems(projetData);
    }
    

    /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
   
     @Override
    public void setScreenParent(ControleurEcran screenParent) {
        myController = screenParent;
    }
    /*@Override
    public void setModele(ProjetModeleJDBC modele) {
        this.pm=modele;
    }*/

    @FXML
    private void goToScreen2(ActionEvent event) {
        myController.setScreen(Principal.screen2ID);
    }

    @FXML
    private void goToScreenProjetAjout(ActionEvent event) {
        myController.setScreen(Principal.projetAjoutFile);
    }

    @FXML
    private void goToScreenEntrepriseAjout(ActionEvent event) {
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
    @FXML
    private void goToScreenEntrepriseNom(ActionEvent event) {
        myController.setScreen(Principal.modifierNomEntrepriseFile);
    }
    @FXML
    private void goToScreenEntrepriseAdresse(ActionEvent event) {
        myController.setScreen(Principal.modifierAdresseEntrepriseFile);
    }
    @FXML
    private void goToScreenEntrepriseTel(ActionEvent event) {
        myController.setScreen(Principal.modifierGSMEntrepriseFile);
    }
    @FXML
    private void goToScreenSupprimerEntreprise(ActionEvent event) {
        myController.setScreen(Principal.supprimerEntrepriseFile);
    }
    @FXML
    private void goToScreenEntrepriseListe(ActionEvent event) {
        myController.setScreen(Principal.listeEntrepriseFile);
    }
    @FXML
    private void goToScreenCreerProjetMembre(ActionEvent event) {
        myController.setScreen(Principal.creerProjetMembreFile);
    }
    
}
