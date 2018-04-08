/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Vue;
import java.util.Collection;
import java.util.Scanner;
import projet.Modele.Entreprise;
import projet.Modele.Projet;
/**
 *
 * @author ameliefiems
 */
public class ProjetVue {
    private Scanner sc = new Scanner(System.in);
    public int menu(){
        System.out.println("1.Entreprise\n2.Projet");
        int choix=sc.nextInt();
        return choix;
    }
    public int menuEntreprise(){
        System.out.println("ENTREPRISE\n1. Ajouter une entreprise\n2. Recherche de entreprise\n4.Liste entreprise");
        int choix=sc.nextInt();
        return choix;
    }
    public int menuProjet(){
        System.out.println("PROJET\n1.Ajout d'un projet\n2.Recherche d'un projet\n 3.Modification du titre\n4.Suppresion du projet\n5.Liste ");
        int choix=sc.nextInt();
        return choix;
    }
    public Entreprise saisieEntreprise(){
        sc.nextLine();
        String nom=saisie("Entrez un nom d'entreprise");
        String tel=saisie("Entrez un numero de telephone");
        String adresse=saisie("Entrez une adresse");
        Entreprise e=new Entreprise(nom,tel,adresse);
       // System.out.println(e);
        return e;
    }
    
    public Projet saisieProjet(){
        String titre=saisie("Entrez le titre du projet");
        String dateDebut=saisie("Entrez la date de debut du projet");
        String dateFin=saisie("Entrez la date de fin du projet");
        Entreprise client=new Entreprise();
        client=saisieEntreprise();
        Projet p=new Projet(titre, dateDebut,dateFin,client);
        return p;
    }
    public String saisie(String msg){
        System.out.println(msg);
        
        String m=sc.nextLine();
        System.out.println(m);
        return m;
    }
    public void affListe(Collection liste){
        int i=1;
        for(Object o: liste){
            System.out.println((i++)+" "+o);
        }
    
    }
    
    
}
