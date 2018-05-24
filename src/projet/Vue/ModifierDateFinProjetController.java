/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Vue;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import projet.Modele.ProjetGeneral;
import projet.Modele.ProjetModele;
import projet.Modele.ProjetModeleJDBC;
import projet.Modele.ProjetSimple;
import projet.Modele.Sous_projet;

/**
 * FXML Controller class
 *
 * @author ameliefiems
 */
public class ModifierDateFinProjetController implements Initializable, ControlledEcran {

    ControleurEcran myController;
    //ProjetModeleJDBC pm;
    @FXML
    DatePicker dateFin;
    @FXML
    TextField titre;
    @FXML
    ListView<String> list=new ListView<String>();
    private String choix;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> items = FXCollections.observableArrayList(
                "Simple", "Composite");
        list.setItems(items);
        list.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                choix = list.getSelectionModel().getSelectedItem();
                System.out.println("choix=" + choix);
            }
        });
    }

    @FXML
    public void modifierDateFinProjet() {
        if (choix.equals("Simple")) {
            ProjetSimple ps = new ProjetSimple();
            ProjetGeneral pg;
            System.out.println("TITRE TROUVE" + Principal.pm.getProjet(ps, titre.getText()));
            String pattern = "dd-MM-yyyy";

            dateFin.setPromptText(pattern.toLowerCase());

            dateFin.setConverter(new StringConverter<LocalDate>() {
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

                @Override
                public String toString(LocalDate date) {
                    if (date != null) {
                        return dateFormatter.format(date);
                    } else {
                        return "";
                    }
                }

                @Override
                public LocalDate fromString(String string) {
                    if (string != null && !string.isEmpty()) {
                        return LocalDate.parse(string, dateFormatter);
                    } else {
                        return null;
                    }
                }
            });
            LocalDate date = dateFin.getValue();
            String d1 = inverseDate(date);

            ps = (ProjetSimple) Principal.pm.getProjet(ps, titre.getText());
            String message = Principal.pm.modifierDateFinProjet(ps, d1);

            String msg = "\n" + message;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information modification de la date de fin  du projet");
            alert.setHeaderText(null);
            alert.setContentText(msg);
            alert.showAndWait();
        } else {
            Sous_projet sp = new Sous_projet();
            ProjetGeneral pg;
            System.out.println("TITRE TROUVE" +Principal.pm.getProjet(sp, titre.getText()));
            String pattern = "dd-MM-yyyy";

            dateFin.setPromptText(pattern.toLowerCase());

            dateFin.setConverter(new StringConverter<LocalDate>() {
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

                @Override
                public String toString(LocalDate date) {
                    if (date != null) {
                        return dateFormatter.format(date);
                    } else {
                        return "";
                    }
                }

                @Override
                public LocalDate fromString(String string) {
                    if (string != null && !string.isEmpty()) {
                        return LocalDate.parse(string, dateFormatter);
                    } else {
                        return null;
                    }
                }
            });
            LocalDate date = dateFin.getValue();
            String d1 = inverseDate(date);

            sp = (Sous_projet) Principal.pm.getProjet(sp, titre.getText());
            String message = Principal.pm.modifierDateFinProjet(sp, d1);

            String msg = "\n" + message;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information modification de la date de fin du projet");
            alert.setHeaderText(null);
            alert.setContentText(msg);
            alert.showAndWait();
        }

    }

    public String inverseDate(LocalDate date) {
        String inverse;
        inverse = date.toString();
        String annee = inverse.substring(0, 4);
        String mois = inverse.substring(5, 7);
        String jour = inverse.substring(8, 10);
        inverse = jour + "-" + mois + "-" + annee;
        return inverse;

    }

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
