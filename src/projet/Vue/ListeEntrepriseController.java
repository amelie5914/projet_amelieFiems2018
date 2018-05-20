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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import projet.Modele.Entreprise;
import projet.Modele.ProjetGeneral;
import projet.Modele.ProjetModeleJDBC;

/**
 * FXML Controller class
 *
 * @author ameliefiems
 */
public class ListeEntrepriseController implements Initializable, ControlledEcran {
    
    ControleurEcran myController;
     private ObservableList<Entreprise> entrepriseData = FXCollections.observableArrayList();
    private List<Entreprise> l = new ArrayList();
     @FXML
    private TableView<Entreprise> personTable;
    @FXML
    private TableColumn<Entreprise, String> nomColumn;

    @FXML
    private TableColumn<Entreprise, String> adresseColumn;
    @FXML
    private TableColumn<Entreprise, String> telColumn;
    /**
     * Initializes the controller class.
     */
    ProjetModeleJDBC pm=new ProjetModeleJDBC();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        l = pm.getEntreprise();
        l.forEach((entreprise) -> {
            entrepriseData.add(entreprise);
        });
        nomColumn.setCellValueFactory(cellData -> cellData.getValue().getpNom());
        adresseColumn.setCellValueFactory(cellData -> cellData.getValue().getpAdresse());
        telColumn.setCellValueFactory(cellData -> cellData.getValue().getpTelEnt());
        
        personTable.setItems(entrepriseData);
    }
    

    /**
     * Returns the data as an observable list of Persons. 
     * @return
     */
   
     @Override
    public void setScreenParent(ControleurEcran screenParent) {
        myController = screenParent;
    }

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
    
}
