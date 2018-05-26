/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Vue;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import projet.Modele.ProjetModele;
import projet.Modele.ProjetModeleJDBC;

/**
 *
 * @author ameliefiems
 */
public class Principal extends Application {
    public static ProjetModeleJDBC pm=new ProjetModeleJDBC();
    public static String screen1ID = "accueil";
    public static String screen1File = "Accueil.fxml";
    public static String screen2ID = "JDBC";
    public static String screen2File = "JDBC.fxml";
    public static String projetAjout="projetAjouter";
    public static String projetAjoutFile = "ProjetAjouter.fxml";
    public static String entrepriseAjout="entrepriseAjouter";
    public static String entrepriseAjoutFile = "EntrepriseAjouter.fxml";
    public static String modifierTitreProjet="modifierTitreProjet";
    public static String modifierTitreProjetFile = "ModifierTitreProjet.fxml";
    
    public static String listeEntreprise="listeEntreprise";
    public static String listeEntrepriseFile = "ListeEntreprise.fxml";
    public static String modifierAdresseEntreprise="modifierAdresseEntreprise";
    public static String modifierAdresseEntrepriseFile = "ModifierAdresseEntreprise.fxml";
    public static String modifierGSMEntreprise="modifierGSMEntreprise";
    public static String modifierGSMEntrepriseFile = "ModifierGSMEntreprise.fxml";
    public static String supprimerEntreprise="supprimerEntreprise";
    public static String supprimerEntrepriseFile = "SupprimerEntreprise.fxml";
    public static String modifierNomEntreprise="modifierNomEntreprise";
    public static String modifierNomEntrepriseFile = "ModifierNomEntreprise.fxml";
    
    public static String listeProjet="listeProjet";
    public static String listeProjetFile = "ListeProjet.fxml";
    public static String modifierDateDebutProjet="modifierDateDebutProjet";
    public static String modifierDateDebutProjetFile = "ModifierDateDebutProjet.fxml";
    public static String modifierDateFinProjet="modifierDateFinProjet";
    public static String modifierDateFinProjetFile = "ModifierDateFinProjet.fxml";
    public static String supprimerProjet="supprimerProjet";
    public static String supprimerProjetFile = "SupprimerProjet.fxml";
    public static String creerProjetMembre="creerProjetMembre";
    public static String creerProjetMembreFile = "CreerProjetMembre.fxml";
    public static String creerProjetDis="creerProjetDis";
    public static String creerProjetDisFile = "CreerProjetDis.fxml";
    
    public static String ajoutMembre="ajoutMembre";
    public static String ajoutMembreFile = "AjouterMembre.fxml";
    public static String modifierEmailMembre="modifierEmailMembre";
    public static String modifierEmailMembreFile = "ModifierEmailMembre.fxml";
    public static String modifierGSMMembre="modifierGSMMembre";
    public static String modifierGSMMembreFile = "ModifierGSMMembre.fxml";
    public static String supprimerMembre="supprimembre";
    public static String supprimerMembreFile = "SupprimerMembre.fxml";
    
    public static String ajoutDiscipline="ajoutDiscipline";
    public static String ajoutDisciplineFile = "AjoutDiscipline.fxml";
    public static String modifierNomDiscipline="modifierNomDiscipline";
    public static String modifierNomDisciplineFile = "ModifierNomDiscipline.fxml";
    public static String supprimerDiscipline="supprimerDiscipline";
    public static String supprimerDisciplineFile = "SupprimerDiscipline.fxml";
    
    public static String ajoutNiveaux="ajoutNiveaux";
    public static String ajoutNiveauxFile = "AjoutNiveaux.fxml";
    public static String modifierSignificationNiveaux="modifierSignificationNiveaux";
    public static String modifierSignificationNiveauxFile = "ModificationSignificationNiveaux.fxml";
    public static String supprimerNiveaux="supprimerNiveaux";
    public static String supprimerNiveauxFile = "SupprimerNiveaux.fxml";
    
    public static String listeMembre="listeMembre";
    public static String listeMembreFile = "ListeMembre.fxml";
    public static String listeDiscipline="listeDiscipline";
    public static String listeDisciplineFile = "ListeDiscipline.fxml";
    public static String listeNiveaux="listeNiveaux";
    public static String listeNiveauxFile = "ListeNiveaux.fxml";
    public static String listeMembreProjet="listeMembreProjet";
    public static String listeMembreProjetFile = "ListeMembreProjet.fxml";
    public static String listeDisciplineProjet="listeDisciplineProjet";
    public static String listeDisciplineProjetFile = "ListeDisciplineProjet.fxml";
    
     public static String listeSousProjet="listeSousProjet";
    public static String listeSousProjetFile = "ListeSousProjet.fxml";
     public static String supprimerDisciplineProjet="supprimerDisciplineProjet";
    public static String supprimerDisciplineProjetFile = "SupprimerDisciplineProjet.fxml";
    public static String supprimerMembreProjet="supprimerMembreProjet";
    public static String supprimerMembreProjetFile = "SupprimerMembreProjet.fxml";
    
    @Override
    public void start(Stage primaryStage) {
        
        ControleurEcran mainContainer = new ControleurEcran();
        mainContainer.loadScreen(Principal.screen1ID, Principal.screen1File);
        mainContainer.loadScreen(Principal.screen2ID, Principal.screen2File);
        mainContainer.loadScreen(Principal.projetAjoutFile, Principal.projetAjoutFile);
        mainContainer.loadScreen(Principal.entrepriseAjoutFile, Principal.entrepriseAjoutFile);
        mainContainer.loadScreen(Principal.modifierDateDebutProjetFile, Principal.modifierDateDebutProjetFile);
        mainContainer.loadScreen(Principal.modifierDateFinProjetFile, Principal.modifierDateFinProjetFile);
        mainContainer.loadScreen(Principal.modifierTitreProjetFile, Principal.modifierTitreProjetFile);
        mainContainer.loadScreen(Principal.supprimerProjetFile, Principal.supprimerProjetFile);
        mainContainer.loadScreen(Principal.creerProjetMembreFile, Principal.creerProjetMembreFile);
        mainContainer.loadScreen(Principal.creerProjetDisFile, Principal.creerProjetDisFile);

        mainContainer.loadScreen(Principal.listeEntrepriseFile, Principal.listeEntrepriseFile);
        mainContainer.loadScreen(Principal.modifierAdresseEntrepriseFile, Principal.modifierAdresseEntrepriseFile);
        mainContainer.loadScreen(Principal.modifierGSMEntrepriseFile, Principal.modifierGSMEntrepriseFile);
        mainContainer.loadScreen(Principal.supprimerEntrepriseFile, Principal.supprimerEntrepriseFile);
        mainContainer.loadScreen(Principal.modifierNomEntrepriseFile, Principal.modifierNomEntrepriseFile);
        
        mainContainer.loadScreen(Principal.ajoutMembreFile, Principal.ajoutMembreFile);
        mainContainer.loadScreen(Principal.modifierEmailMembreFile, Principal.modifierEmailMembreFile);
        mainContainer.loadScreen(Principal.modifierGSMMembreFile, Principal.modifierGSMMembreFile);
        mainContainer.loadScreen(Principal.supprimerMembreFile, Principal.supprimerMembreFile);
        
        mainContainer.loadScreen(Principal.ajoutDisciplineFile, Principal.ajoutDisciplineFile);
        mainContainer.loadScreen(Principal.modifierNomDisciplineFile, Principal.modifierNomDisciplineFile);
        mainContainer.loadScreen(Principal.supprimerDisciplineFile, Principal.supprimerDisciplineFile);
       
        mainContainer.loadScreen(Principal.ajoutNiveauxFile, Principal.ajoutNiveauxFile);
        mainContainer.loadScreen(Principal.modifierSignificationNiveauxFile, Principal.modifierSignificationNiveauxFile);
        mainContainer.loadScreen(Principal.supprimerNiveauxFile, Principal.supprimerNiveauxFile);
        
        mainContainer.loadScreen(Principal.listeMembreFile, Principal.listeMembreFile);
        mainContainer.loadScreen(Principal.listeDisciplineFile, Principal.listeDisciplineFile);
        mainContainer.loadScreen(Principal.listeNiveauxFile, Principal.listeNiveauxFile);
        
        mainContainer.loadScreen(Principal.listeMembreProjetFile, Principal.listeMembreProjetFile);
        mainContainer.loadScreen(Principal.listeDisciplineProjetFile, Principal.listeDisciplineProjetFile);
        mainContainer.loadScreen(Principal.listeSousProjetFile, Principal.listeSousProjetFile);
        mainContainer.loadScreen(Principal.supprimerDisciplineProjetFile, Principal.supprimerDisciplineProjetFile);
        mainContainer.loadScreen(Principal.supprimerMembreProjetFile, Principal.supprimerMembreProjetFile);
        
        mainContainer.loadScreen(Principal.listeProjetFile, Principal.listeProjetFile);
        mainContainer.setScreen(Principal.screen1ID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Principal p=new Principal();
        launch(args);
    }
}
