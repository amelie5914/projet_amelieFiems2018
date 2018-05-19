/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Vue;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import projet.Modele.*;

/**
 * FXML Controller class
 *
 * @author ameliefiems
 */
public class ProjetAjouterController implements Initializable, ControlledEcran {

    ControleurEcran myController;
    @FXML
    private ListView<Entreprise> entrepriseListView;
    private List<Entreprise> l = new ArrayList();

    @FXML
    TextField titre;
    @FXML
    DatePicker datedebut;
    @FXML
    DatePicker datefin;
    private ObservableList<Entreprise> listEntreprise = FXCollections.observableArrayList();
    private Entreprise e;
    LocalDate date1 = null, date2 = null;
    ProjetModele pm = new ProjetModele();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        pm.personne();
        l = pm.getEntreprise();
        l.forEach((entreprise) -> {
            listEntreprise.add(entreprise);
        });
        entrepriseListView.setItems(listEntreprise);

        entrepriseListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                e = entrepriseListView.getSelectionModel().getSelectedItem();
                System.out.println("Entreprise" + e);
            }
        });
    }

    @Override
    public void setScreenParent(ControleurEcran screenParent) {
        myController = screenParent;
    }

    @FXML
    public void ajourProjetSimple() {

        String pattern = "dd-MM-yyyy";

        datedebut.setPromptText(pattern.toLowerCase());

        datedebut.setConverter(new StringConverter<LocalDate>() {
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
        LocalDate date = datedebut.getValue();
        String d1=inverseDate(date);
        
        String pattern1 = "dd-MM-yyyy";

        datedebut.setPromptText(pattern1.toLowerCase());

        datedebut.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern1);

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
        LocalDate date2 = datefin.getValue();
        String d2=inverseDate(date2);
        System.out.println("Selected date: " + d1);
        System.out.println("titre" + titre.getText());
        ProjetSimple ps = new ProjetSimple(titre.getText(), d1,d2, e);
        String message=ps+"\n"+pm.ajouter(ps);
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information ajout projet");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    public void ajourSousProjet() {

        
        String pattern = "dd-MM-yyyy";

        datedebut.setPromptText(pattern.toLowerCase());

        datedebut.setConverter(new StringConverter<LocalDate>() {
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
        LocalDate date = datedebut.getValue();
        String d1=inverseDate(date);
        
        String pattern1 = "dd-MM-yyyy";

        datedebut.setPromptText(pattern1.toLowerCase());

        datedebut.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern1);

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
        LocalDate date2 = datefin.getValue();
        String d2=inverseDate(date2);
        if (titre.getText().equals("")) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Titre incorrect");
            alert.setContentText("Vous devez remplir ce champs!");
            alert.showAndWait();
        } 
        else{
            Sous_projet sp = new Sous_projet(titre.getText(), d1,d2, e);
            String message=sp+"\n"+pm.ajouter(sp);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information ajout projet");
            alert.setHeaderText(null);
            alert.setContentText(message);
            alert.showAndWait();
            titre.setText("");
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
    
}
