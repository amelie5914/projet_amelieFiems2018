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
        
        mainContainer.loadScreen(Principal.listeEntrepriseFile, Principal.listeEntrepriseFile);
        mainContainer.loadScreen(Principal.modifierAdresseEntrepriseFile, Principal.modifierAdresseEntrepriseFile);
        mainContainer.loadScreen(Principal.modifierGSMEntrepriseFile, Principal.modifierGSMEntrepriseFile);
        mainContainer.loadScreen(Principal.supprimerEntrepriseFile, Principal.supprimerEntrepriseFile);
        mainContainer.loadScreen(Principal.modifierNomEntrepriseFile, Principal.modifierNomEntrepriseFile);
        
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
