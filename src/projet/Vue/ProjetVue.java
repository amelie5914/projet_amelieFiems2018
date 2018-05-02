/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Vue;
import java.util.Collection;
import java.util.Scanner;
import projet.Modele.Discipline;
import projet.Modele.Entreprise;
import projet.Modele.Membre;
import projet.Modele.Projet;
import projet.Modele.Travail;
/**
 *
 * @author ameliefiems
 */
public class ProjetVue {
    private Scanner sc = new Scanner(System.in);
    public int menu(){
        System.out.println("1.Entreprise\n2.Projet\n3.Membre\n4.Travail\n5.Disciplines\n6.Temps");
        int choix=sc.nextInt();
          sc.skip("\n");
        return choix;
    }
    public int menuEntreprise(){
        System.out.println("ENTREPRISE\n1. Ajouter une entreprise\n2. Recherche de entreprise\n3.Modification entreprise\n4.Liste entreprise\n5.Suppresion entreprise\n6.liste ");
        int choix=sc.nextInt();
          sc.skip("\n");
        return choix;
    }
    public int menuProjet(){
        System.out.println("PROJET\n1.Ajout d'un projet\n2.Recherche d'un projet\n 3.Modification du titre\n4.Liste du projet\n5.Suppresion entreprise \n6.Liste de tous les membres d'un projet\n7. Ajouter un membre à un projet");
        int choix=sc.nextInt();
          sc.skip("\n");
        
        return choix;
    }
    public int menuEntrepriseModif(){
        System.out.println("MODIFICATION\n1.Nom\n2.Adresse\n3.Telephone");
        int choix=sc.nextInt();  
        sc.skip("\n");
        return choix;
    }
    public int menuProjetModif(){
        System.out.println("MODIFICATION\n1.Titre\n2. La date du debut\n3. La date de fin");
        int choix=sc.nextInt();
          sc.skip("\n");
        return choix;
    }
    public int menuMembre(){
        System.out.println("MEMBRE\n1. AJouter un membre\n2. Recherche d'un membre\n3.Modification de membre\nn4.Liste des membres \n5.Suppression membre");
        int choix=sc.nextInt();
          sc.skip("\n");
        
        return choix;
    }
    public int menuDiscipline(){
        System.out.println("DISCIPLINE\n1. AJouter une discipline\n2. Recherche d'une discipline\n3.Modification d'une discipline\nn4.Liste des différentes disciplines \n5.Suppression discipline");
        int choix=sc.nextInt();
          sc.skip("\n");
        
        return choix;
    }
    public int menuMembreModif(){
        System.out.println("MODIFICATION\n1.GSM\n2.email");
        int choix=sc.nextInt();  
        sc.skip("\n");
        return choix;
    }
    public int menuCreerProjetMembre(){
        System.out.println("Creation Projet\n1.Creer un nouveau membre\n2.Rechercher un nouveau membre");
        int choix=sc.nextInt();
          sc.skip("\n");
        return choix;
    }
    public int menuCreerProjetEntreprise(){
        System.out.println("Creation Projet\n1.Creer une nouvelle entreprise\n2.Rechercher une nouvelle entreprise");
        int choix=sc.nextInt();
          sc.skip("\n");
        return choix;
    }
    public Entreprise saisieEntreprise(){
        
        String nom=saisie("Entrez un nom d'entreprise");
        String tel=saisie("Entrez un numero de telephone");
        String adresse=saisie("Entrez une adresse");
        Entreprise e=new Entreprise(nom,tel,adresse);
        System.out.println(e);
        return e;
    }
    public Membre saisieMembre(){
        
        String nom=saisie("Entrez le nom du membre");
        String prenom=saisie("Entrez son prénom");
        String gsm=saisie("Entrez le numero de telephone");
        String email=saisie("Entrez son email");
        Membre m=new Membre(nom,prenom,gsm,email);
        return m;
    }
    public Projet saisieProjet(){
        sc.nextLine();
        String titre=saisie("Entrez le titre du projet");
        String dateDebut=saisie("Entrez la date de debut du projet");
        String dateFin=saisie("Entrez la date de fin du projet");
        Entreprise client=new Entreprise();
        
        
        Projet p=new Projet(titre, dateDebut,dateFin,client);
        return p;
    }
    public Travail saisieTravail(Projet p,Membre m){
        
        String date=saisie("Entrez la date d'engagement dans le projet du membre");
        int taux=saisieInt("Entrez le pourcentage du temps qu'il y consacre");
        Travail t=new Travail(date,taux,p,m);
        return t;
    }
    public Discipline saisieDiscipline(){
        sc.nextLine();
        String nom=saisie("Entrez le nom de la discipline");
        Discipline d=new Discipline(nom);
        return d;
    }
    public String saisie(String msg){
        System.out.println(msg);
        String m=sc.nextLine();
          sc.skip("\n");
        //System.out.println(m);
        return m;
    }
    public String saisie(){
       // sc.nextLine();
        String m=sc.nextLine();
          sc.skip("\n");
        //System.out.println(m);
        return m;
    }
    
    public int saisieInt(String m){
        System.out.println(m);
        int i=sc.nextInt();
          sc.skip("\n");
        return i;
        
    }
    public void affListe(Collection liste){
        int i=1;
        for(Object o: liste){
            System.out.println((i++)+" "+o);
        }
    }
    public void affMessage(String m){
        System.out.println(m);
    }
    
    
}
