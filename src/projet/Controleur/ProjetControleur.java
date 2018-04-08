/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Controleur;

import java.util.List;
import java.util.Scanner;
import projet.Modele.Entreprise;
import projet.Modele.Projet;
import projet.Modele.ProjetModele;
import projet.Vue.ProjetVue;

/**
 *
 * @author ameliefiems
 */
public class ProjetControleur {
    private ProjetVue pv;
    private ProjetModele pm;
    Scanner sc=new Scanner(System.in);
    public ProjetControleur(ProjetVue pv,ProjetModele pm){
        this.pv=pv;
        this.pm=pm;
    }

    public ProjetControleur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void gestion(){
        int choix,c;
        do{
            choix=pv.menu();
            switch(choix){
                case 1: 
                        do{
                           c=pv.menuEntreprise();
                           switch(c){
                                case 1: Entreprise e=new Entreprise();
                                        e=pv.saisieEntreprise();
                                        ajout(e);break;
                                case 2: Entreprise e1=new Entreprise();
                                Entreprise e2=new Entreprise();
                                         sc.nextLine();
                                        String m=pv.saisie("Entrez un nom d'entreprise");
                                       
                                        if(pm.get(m, e1)!=null){
                                            System.out.println(pm.get(m, e1));
                                        }
                                        break;
                                case 3: System.out.println(rechercheEntreprise());break;
                                case 4:listeEntreprise();break;
                            }
                        }
                        while(c!=5);
                        break;
                case 2: 
                    do{
                        c=pv.menuProjet();
                        switch(c){
                            case 1: Projet p=new Projet();
                                    p=pv.saisieProjet();
                                    ajout(p);break;
                        }
                    }while(c!=6);
                    break;
            }
            
        }
        while(choix!=5);
    }
    
    
    public void ajout(Object o){
        
        String m=pm.ajouter(o);
        if(m!=null){
            System.out.println(m);
        }
        else{
            System.out.println("Erreur, recommencez");
        }
    }
    public Entreprise rechercheEntreprise(){
        Entreprise e=new Entreprise();
        Scanner sc=new Scanner(System.in);
        sc.nextLine();
        System.out.println("Entrez un nom d'entreprise à rechercher");
        String nom=sc.nextLine();
        
        //String nom=pv.saisie("Entrez un nom d'entreprise à rechercher");  //Pas sur car ça va prendre de la place pour rien de creer tout un objet entreprise!!!
        return pm.getEnt(nom);
    }
    public Projet rechercheProjet(){
        String titre=pv.saisieProjet().getTitre();
        return pm.getProj(titre);
    }
    
    public void listeEntreprise(){
        List<Entreprise> le=pm.getEntreprise();
        pv.affListe(le);
    }
}
