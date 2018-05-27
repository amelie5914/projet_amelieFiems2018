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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import projet.Modele.*;

/**
 * FXML Controller class
 *
 * @author ameliefiems
 */
public class CreerProjetDisController implements Initializable, ControlledEcran {

    ControleurEcran myController;
    @FXML
    TextField titre;
    @FXML
    TextField jhomme;
    @FXML
    private ListView<Discipline> disciplineListView;
    private ObservableList<Discipline> listDiscipline = FXCollections.observableArrayList();
    private List<Discipline> ld = new ArrayList();
    @FXML
    ListView<String> list = new ListView<String>();
    private String choix;
    Discipline d = new Discipline();

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
        Discipline dis = new Discipline("Aucun");
        if (Principal.pm.getDis() != null) {
            ld = Principal.pm.getDis();
            ld.forEach((discipline) -> {
                listDiscipline.add(discipline);
            });
        } else {
            listDiscipline.add(dis);
        }
        if (listDiscipline != null) {
            disciplineListView.setItems(listDiscipline);
        } else {
            System.out.println("prout");
        }
        disciplineListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                d = disciplineListView.getSelectionModel().getSelectedItem();

            }
        });
    }

    @Override
    public void setScreenParent(ControleurEcran screenParent) {
        myController = screenParent;
    }

    @FXML
    public void ajout() {
        if (choix.equals("Simple")) {
            ProjetSimple ps = new ProjetSimple();
            ProjetGeneral pg;
            ps = (ProjetSimple) Principal.pm.getProjet(ps, titre.getText());
            if (ps != null) {
                try {
                    int j = Integer.parseInt(jhomme.getText());
                    Temps t = new Temps(j, ps, d);
                    String message = Principal.pm.ajouter(t);
                    String msg = "\n" + message;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information ajout du discipline dans le projet");
                    alert.setHeaderText(null);
                    alert.setContentText(msg);
                    alert.showAndWait();
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("ERREUR");
                    alert.setHeaderText(null);
                    alert.setContentText("Nombre invalide");
                    alert.showAndWait();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERREUR");
                alert.setHeaderText(null);
                alert.setContentText("le projet n'existe pas!");
                alert.showAndWait();
            }

        } else {
            Sous_projet sp = new Sous_projet();
            ProjetGeneral pg;
            sp = (Sous_projet) Principal.pm.getProjet(sp, titre.getText());
            if (sp != null) {
                try {
                    int j = Integer.parseInt(jhomme.getText());
                    Temps t = new Temps(j, sp, d);
                    String message = Principal.pm.ajouter(t);

                    String msg = "\n" + message;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information ajout du discipline dans le projet");
                    alert.setHeaderText(null);
                    alert.setContentText(msg);
                    alert.showAndWait();
                } catch (NumberFormatException e) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("ERREUR");
                    alert.setHeaderText(null);
                    alert.setContentText("Nombre invalide");
                    alert.showAndWait();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERREUR");
                alert.setHeaderText(null);
                alert.setContentText("le projet n'existe pas!");
                alert.showAndWait();
            }
        }
        titre.setText("");
        jhomme.setText("");
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
