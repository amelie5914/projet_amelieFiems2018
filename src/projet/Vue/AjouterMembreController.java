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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import projet.Modele.*;

/**
 * FXML Controller class
 *
 * @author ameliefiems
 */
public class AjouterMembreController implements Initializable,ControlledEcran {
    @FXML
    TextField nom;
    @FXML
    TextField prenom;
    @FXML
    TextField gsm;
    @FXML
    TextField email;
    ControleurEcran myController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
     @FXML
    public void ajout() {
        Membre membre=null;
        if (!gsm.getText().matches("^[0-9]{10}$")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Le numero de téléphone n'est pas dans le bon format...");
            alert.setContentText("Format: Il faut mettre que 10 chiffres");
            alert.showAndWait();
        } else if (!email.getText().matches("^[A-Za-z0-9]+\\.[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,3}$")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("L'email est pas dnas le bon format");
            alert.setContentText("Format: nom.prenom@nav.be  (ou .com)");
            alert.showAndWait();
        } else if (prenom.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Vous n'avez pas entré de prenom");
            alert.setContentText("Obligatoire de remplir ce champs!");
            alert.showAndWait();
        }else if (nom.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Vous n'avez pas entré de nom");
            alert.setContentText("Obligatoire de remplir ce champs!");
            alert.showAndWait();
        } else {
            Membre.MembreBuilder membreBuild = new Membre.MembreBuilder();
        membreBuild.setNomMem(nom.getText()).setPrenomMem(prenom.getText()).setGsm(gsm.getText()).setEmail(email.getText());
        try {
            membre = membreBuild.build();

        } catch (Exception e) {
            System.out.println("Erreur de création" + e);
        }
            String message = membre + "\n" + Principal.pm.ajouter(membre);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information ajout membre");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
            nom.setText("");
            prenom.setText("");
            gsm.setText("");
            email.setText("");
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
