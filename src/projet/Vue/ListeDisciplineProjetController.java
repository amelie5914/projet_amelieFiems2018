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
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import projet.Modele.*;

/**
 * FXML Controller class
 *
 * @author ameliefiems
 */
public class ListeDisciplineProjetController implements Initializable, ControlledEcran {

    ControleurEcran myController;
    private ObservableList<Discipline> membreData = FXCollections.observableArrayList();
    private List<Discipline> l = new ArrayList();
    @FXML
    private TableView<Discipline> personTable;
    @FXML
    private TableColumn<Discipline, String> nomColumn;

    @FXML
    private TextField titre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void rech() {
        ProjetGeneral pg = null;
        membreData.clear();
        l = Principal.pm.listeDisciplineProjet(titre.getText(), pg);
        if(l!=null){
        l.forEach((m) -> {
            membreData.add(m);
        });
        nomColumn.setCellValueFactory(cellData -> cellData.getValue().getpNom());

        personTable.setItems(membreData);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information sur le projet");
            alert.setHeaderText(null);
            alert.setContentText("existe pas");
            alert.showAndWait();
        }
        titre.setText("");
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

    @FXML
    private void goToScreenCreerProjetDis(ActionEvent event) {
        myController.setScreen(Principal.creerProjetDisFile);
    }

    @FXML
    private void goToScreenMembreAjout(ActionEvent event) {
        myController.setScreen(Principal.ajoutMembreFile);
    }

    @FXML
    private void goToScreenEmailMembre(ActionEvent event) {
        myController.setScreen(Principal.modifierEmailMembreFile);
    }

    @FXML
    private void goToScreenGSMMembre(ActionEvent event) {
        myController.setScreen(Principal.modifierGSMMembreFile);
    }

    @FXML
    private void goToScreenSupprimerMembre(ActionEvent event) {
        myController.setScreen(Principal.supprimerMembreFile);
    }

    @FXML
    private void goToScreenDisciplineAjout(ActionEvent event) {
        myController.setScreen(Principal.ajoutDisciplineFile);
    }

    @FXML
    private void goToScreenNomDiscipline(ActionEvent event) {
        myController.setScreen(Principal.modifierNomDisciplineFile);
    }

    @FXML
    private void goToScreenSupprimerDiscipline(ActionEvent event) {
        myController.setScreen(Principal.supprimerDisciplineFile);
    }

    @FXML
    private void goToScreenNiveauxAjout(ActionEvent event) {
        myController.setScreen(Principal.ajoutNiveauxFile);
    }

    @FXML
    private void goToScreenSignificationNiveaux(ActionEvent event) {
        myController.setScreen(Principal.modifierSignificationNiveauxFile);
    }

    @FXML
    private void goToScreenSupprimerNiveaux(ActionEvent event) {
        myController.setScreen(Principal.supprimerNiveauxFile);
    }

    @FXML
    private void goToScreenMembreListe(ActionEvent event) {
        myController.setScreen(Principal.listeMembreFile);
    }

    @FXML
    private void goToScreenDisciplineListe(ActionEvent event) {
        myController.setScreen(Principal.listeDisciplineFile);
    }

    @FXML
    private void goToScreenNiveauxListe(ActionEvent event) {
        myController.setScreen(Principal.listeNiveauxFile);
    }

    @FXML
    private void goToScreenMembreProjetListe(ActionEvent event) {
        myController.setScreen(Principal.listeMembreProjetFile);
    }

    @FXML
    private void goToScreenDisciplineProjetListe(ActionEvent event) {
        myController.setScreen(Principal.listeDisciplineProjetFile);
    }

    @FXML
    private void goToScreenSous_projetListe(ActionEvent event) {
        myController.setScreen(Principal.listeSousProjetFile);
    }

    @FXML
    private void goToScreenDisciplineProjetSupprimer(ActionEvent event) {
        myController.setScreen(Principal.supprimerDisciplineProjetFile);
    }

    @FXML
    private void goToScreenMembreProjetSupprimer(ActionEvent event) {
        myController.setScreen(Principal.supprimerMembreProjetFile);
    }

    @FXML
    private void goToScreenSousProjetAjout(ActionEvent event) {
        myController.setScreen(Principal.ajoutSousProjetFile);
    }

}
