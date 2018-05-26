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
public class ProjetAjouterController implements Initializable, ControlledEcran {

    private ObservableList<Entreprise> listEntreprise = FXCollections.observableArrayList();
    private ObservableList<Membre> listMembre = FXCollections.observableArrayList();
    private ObservableList<Discipline> listDiscipline = FXCollections.observableArrayList();
    private ObservableList<Niveaux> listNiveau = FXCollections.observableArrayList();
    @FXML
    TextField titre;
    @FXML
    TextField taux;
    @FXML
    TextField jhomme;
    @FXML
    TextField degre;
    @FXML
    TextField signification;
    @FXML
    DatePicker datedebut;
    @FXML
    DatePicker datefin;
    @FXML
    DatePicker dateEng;
    @FXML
    private ListView<Entreprise> entrepriseListView;
    @FXML
    private ListView<Membre> membreListView;
    @FXML
    private ListView<Discipline> disciplineListView;
    @FXML
    private ListView<Niveaux> niveauListView;
    private List<Entreprise> l = new ArrayList();
    private List<Membre> lm = new ArrayList();
    private List<Discipline> ld = new ArrayList();
    private List<Niveaux> ln = new ArrayList();
    ControleurEcran myController;
    //ProjetModeleJDBC pm;
    Entreprise e = new Entreprise();
    Discipline d = new Discipline();
    Membre mem;
    Niveaux n = new Niveaux();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Entreprise ent = new Entreprise("Aucun");
        if (Principal.pm.getEntreprise() != null) {
            l = Principal.pm.getEntreprise();
            l.forEach((entreprise) -> {
                listEntreprise.add(entreprise);
            });
        } else {
            listEntreprise.add(ent);
        }
        entrepriseListView.setItems(listEntreprise);

        entrepriseListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                e = entrepriseListView.getSelectionModel().getSelectedItem();
                System.out.println("Entreprise" + e);
            }
        });

        if (Principal.pm.getMembre() != null) {
            lm = Principal.pm.getMembre();
            lm.forEach((memb) -> {
                listMembre.add(memb);
            });
        }
        membreListView.setItems(listMembre);

        membreListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                mem = membreListView.getSelectionModel().getSelectedItem();
                System.out.println("Membre" + mem);
            }
        });

        if (Principal.pm.getDis() != null) {
            ld = Principal.pm.getDis();
            ld.forEach((dis) -> {
                listDiscipline.add(dis);
            });
        }
        disciplineListView.setItems(listDiscipline);

        disciplineListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                d = disciplineListView.getSelectionModel().getSelectedItem();
                System.out.println("Dis" + d);
            }
        });

        if (Principal.pm.getNiveau() != null) {
            ln = Principal.pm.getNiveau();
            ln.forEach((niv) -> {
                listNiveau.add(niv);
            });
        }
        niveauListView.setItems(listNiveau);

        niveauListView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                n = niveauListView.getSelectionModel().getSelectedItem();
                System.out.println("Niveau" + n);
            }
        });
    }

    @FXML
    public void ajoutProjetSimple() {
        String message1="", message2="",message3="",message4="";
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
        String d1 = inverseDate(date);

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
        String d2 = inverseDate(date2);
        System.out.println("Selected date: " + d1);
        System.out.println("titre" + titre.getText());
        ProjetSimple ps = new ProjetSimple(titre.getText(), d1, d2, e);
        String message = ps + "\n" + Principal.pm.ajouter(ps);
        

        try {
            int j = Integer.parseInt(jhomme.getText());
            Temps t = new Temps(j, ps, d);
            message1 = Principal.pm.ajouter(t);

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERREUR");
            alert.setHeaderText(null);
            alert.setContentText("Nombre invalide");
            alert.showAndWait();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String pattern2 = "dd-MM-yyyy";

        dateEng.setPromptText(pattern.toLowerCase());

        dateEng.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern2);

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
        date = dateEng.getValue();
        d1 = inverseDate(date);
        try {
            int pourcentage = Integer.parseInt(taux.getText());
            int deg=Integer.parseInt(degre.getText());
            Travail t = new Travail(d1, pourcentage, ps, mem);
            n=new Niveaux(deg,signification.getText());
            message2 = Principal.pm.ajouter(t);
            message3= Principal.pm.ajouter(n);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERREUR");
            alert.setHeaderText(null);
            alert.setContentText("Nombre invalide");
            alert.showAndWait();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Competence c=new Competence(d, n, mem);
        message4=Principal.pm.ajouter(c);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information ajout projet");
        alert.setHeaderText(null);
        alert.setContentText(message+"\n"+message1+"\n"+message2+"\n"+message3+"\n"+message4);
        alert.showAndWait();
    }

    @FXML
    public void ajoutSousProjet() {
        String pattern = "dd-MM-yyyy";
        String message="",message1="",message2="",message3="",message4="";
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
        String d1 = inverseDate(date);

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
        String d2 = inverseDate(date2);
        if (titre.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Titre incorrect");
            alert.setContentText("Vous devez remplir ce champs!");
            alert.showAndWait();
        } else {
            Sous_projet sp = new Sous_projet(titre.getText(), d1, d2, e);
            message = sp + "\n" + Principal.pm.ajouter(sp);
            try {
            int j = Integer.parseInt(jhomme.getText());
            Temps t = new Temps(j, sp, d);
            message1 = Principal.pm.ajouter(t);

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERREUR");
            alert.setHeaderText(null);
            alert.setContentText("Nombre invalide");
            alert.showAndWait();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String pattern2 = "dd-MM-yyyy";

        dateEng.setPromptText(pattern.toLowerCase());

        dateEng.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern2);

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
        date = dateEng.getValue();
        d1 = inverseDate(date);


        try {
            int pourcentage = Integer.parseInt(taux.getText());
            int deg=Integer.parseInt(degre.getText());
            Travail t = new Travail(d1, pourcentage, sp, mem);
            n=new Niveaux(deg,signification.getText());
            message2 = Principal.pm.ajouter(t);
            message3= Principal.pm.ajouter(n);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERREUR");
            alert.setHeaderText(null);
            alert.setContentText("Nombre invalide");
            alert.showAndWait();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Competence c=new Competence(d, n, mem);
        message4=Principal.pm.ajouter(c);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information ajout projet");
        alert.setHeaderText(null);
        alert.setContentText(message+"\n"+message1+"\n"+message2+"\n"+message3+"\n"+message4);
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
