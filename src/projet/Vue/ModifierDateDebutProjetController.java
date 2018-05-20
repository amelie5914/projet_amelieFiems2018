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
import projet.Modele.ProjetSimple;
import projet.Modele.Sous_projet;

/**
 * FXML Controller class
 *
 * @author ameliefiems
 */
public class ModifierDateDebutProjetController implements Initializable, ControlledEcran {

    ControleurEcran myController;
    @FXML
    DatePicker dateDebut;
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
    public void modifierDateDebutProjet() {
        if (choix.equals("Simple")) {
            ProjetSimple ps = new ProjetSimple();
            ProjetGeneral pg;
            System.out.println("TITRE TROUVE" + Principal.pm.getProjet(ps, titre.getText()));
            String pattern = "dd-MM-yyyy";

            dateDebut.setPromptText(pattern.toLowerCase());

            dateDebut.setConverter(new StringConverter<LocalDate>() {
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
            LocalDate date = dateDebut.getValue();
            String d1 = inverseDate(date);

            ps = (ProjetSimple) Principal.pm.getProjet(ps, titre.getText());
            String message = Principal.pm.modifierDateDebutProjet(ps, d1);

            String msg = "\n" + message;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information modification du titre du projet");
            alert.setHeaderText(null);
            alert.setContentText(msg);
            alert.showAndWait();
        } else {
            Sous_projet sp = new Sous_projet();
            ProjetGeneral pg;
            System.out.println("TITRE TROUVE" + Principal.pm.getProjet(sp, titre.getText()));
            String pattern = "dd-MM-yyyy";

            dateDebut.setPromptText(pattern.toLowerCase());

            dateDebut.setConverter(new StringConverter<LocalDate>() {
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
            LocalDate date = dateDebut.getValue();
            String d1 = inverseDate(date);

            sp = (Sous_projet) Principal.pm.getProjet(sp, titre.getText());
            String message = Principal.pm.modifierDateDebutProjet(sp, d1);

            String msg = "\n" + message;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information modification du titre du projet");
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
