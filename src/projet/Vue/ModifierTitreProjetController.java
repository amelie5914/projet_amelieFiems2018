/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Vue;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import projet.Modele.ProjetGeneral;
import projet.Modele.ProjetModele;
import projet.Modele.ProjetSimple;
import projet.Modele.Sous_projet;

/**
 * FXML Controller class
 *
 * @author ameliefiems
 */
public class ModifierTitreProjetController implements Initializable, ControlledEcran {

    ControleurEcran myController;
    @FXML
    TextField titre;
    @FXML
    TextField nvxTitre;
    private String choix;
    @FXML
    ListView<String> list = new ListView<String>();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> items = FXCollections.observableArrayList(
                "Simple", "Composite");
        list.setItems(items);
        list.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                choix = list.getSelectionModel().getSelectedItem();
                System.out.println("choix="+choix);
            }
        });
    }

    @FXML
    public void modifierTitreProjet() {
        if (choix.equals("Simple")) {
            ProjetSimple ps = new ProjetSimple();
            ProjetGeneral pg;
            System.out.println("TITRE TROUVE"+ Principal.pm.getProjet(ps,titre.getText()));
            ps = (ProjetSimple) Principal.pm.getProjet(ps, titre.getText());
            String message = Principal.pm.modifierTitreProjet(ps, nvxTitre.getText());
            String msg = "\n" + message;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information modification du titre du projet");
            alert.setHeaderText(null);
            alert.setContentText(msg);
            alert.showAndWait();
        } else {
            Sous_projet sp = new Sous_projet();
            ProjetGeneral pg;
            
            sp = (Sous_projet) Principal.pm.getProjet(sp, titre.getText());
            String message = Principal.pm.modifierTitreProjet(sp, nvxTitre.getText());
            String msg = "\n" + message;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information modification du titre du projet");
            alert.setHeaderText(null);
            alert.setContentText(msg);
            alert.showAndWait();
        }

    }

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
    private void goToScreenTitreProjet(ActionEvent event) {
        myController.setScreen(Principal.modifierTitreProjetFile);
    }

    @FXML
    private void goToScreenProjetListe(ActionEvent event) {
        myController.setScreen(Principal.listeProjetFile);
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
