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
import projet.Modele.Membre;
import projet.Modele.ProjetGeneral;
import projet.Modele.ProjetSimple;
import projet.Modele.Sous_projet;
import projet.Modele.Travail;

/**
 * FXML Controller class
 *
 * @author ameliefiems
 */
public class CreerProjetMembreController implements Initializable,ControlledEcran {
    ControleurEcran myController;
    @FXML
    TextField titre;
    @FXML
    DatePicker dateEng;
    @FXML
    TextField pourcentage;
    @FXML
    private ListView<Membre> membreListView;
    private ObservableList<Membre> listMembre = FXCollections.observableArrayList();
    private List<Membre> lm = new ArrayList();
   @FXML
    ListView<String> list=new ListView<String>();
    private String choix;

    Membre mem;
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
        try {
            Membre.MembreBuilder membreBuild = new Membre.MembreBuilder();
            membreBuild.setNomMem("bla").setPrenomMem("bla");
            mem = membreBuild.build();
        } catch (Exception ex) {
            System.out.println("Pas creation");
        }
        if (Principal.pm.getMembre() != null) {
            lm = Principal.pm.getMembre();
            lm.forEach((membre) -> {
                listMembre.add(membre);
            });
            membreListView.setItems(listMembre);
            membreListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                if (newSelection != null) {
                    mem = membreListView.getSelectionModel().getSelectedItem();
                }
            });
        }
        else{
            System.out.println("pas de membre");
        }
    } 
    @Override
    public void setScreenParent(ControleurEcran screenParent) {
        myController = screenParent;
    }
    @FXML
    public void ajout(){
        if (choix.equals("Simple")) {
            ProjetSimple ps = new ProjetSimple();
            ProjetGeneral pg;
            System.out.println("TITRE TROUVE" + Principal.pm.getProjet(ps, titre.getText()));
            String pattern = "dd-MM-yyyy";

            dateEng.setPromptText(pattern.toLowerCase());

            dateEng.setConverter(new StringConverter<LocalDate>() {
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
            LocalDate date = dateEng.getValue();
            String d1 = inverseDate(date);

            ps = (ProjetSimple) Principal.pm.getProjet(ps, titre.getText());
            
        try {
            int taux=Integer.parseInt(pourcentage.getText());
            Travail t=new Travail(d1, taux,ps,mem);
            
            String message = Principal.pm.ajouter(t);
            
            String msg = "\n" + message;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information ajout du membre dans le projet");
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
            Sous_projet sp = new Sous_projet();
            ProjetGeneral pg;
            System.out.println("TITRE TROUVE" +Principal.pm.getProjet(sp, titre.getText()));
            String pattern = "dd-MM-yyyy";

            dateEng.setPromptText(pattern.toLowerCase());

            dateEng.setConverter(new StringConverter<LocalDate>() {
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
            LocalDate date = dateEng.getValue();
            String d1 = inverseDate(date);

            sp = (Sous_projet) Principal.pm.getProjet(sp, titre.getText());
            try {
            int taux=Integer.parseInt(pourcentage.getText());
            Travail t=new Travail(d1, taux,sp,mem);
            
            String message = Principal.pm.ajouter(t);
            
            String msg = "\n" + message;
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information ajout du membre dans le projet");
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
        }
    }

    /*@Override
    public void setModele(ProjetModeleJDBC modele) {
        this.pm=modele;
    }*/
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
}
