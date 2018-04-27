/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import projet.Modele.Entreprise;
import projet.Modele.Membre;
import projet.Modele.Projet;
import projet.Modele.ProjetModele;
import projet.Modele.Travail;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void gestion(){
        int choix,c,n;
        String m,m1;
        Entreprise e=new Entreprise();
        Projet p=new Projet();
        Membre membre=new Membre();
        List <Membre>listeMembreP=new ArrayList();
        do{
            choix=pv.menu();
            switch(choix){
                case 1: 
                        do{
                           c=pv.menuEntreprise();
                           switch(c){
                                case 1:e=pv.saisieEntreprise();
                                        ajout(e);break;
                                case 2: m=pv.saisie("Entrez un nom d'entreprise");
                                        if(pm.get(m,"", e)!=null){
                                            System.out.println(pm.get(m,"", e));
                                        }
                                        break;
                                case 3: modifierEntreprise();break;
                                case 4:listeEntreprise();break;
                                case 5:supprimerEntreprise();
                            }
                        }
                        while(c!=6);
                        break;
                case 2: 
                    do{
                        c=pv.menuProjet();
                        switch(c){
                            case 1: 
                                    creerProjet();break;
                            case 2: m=pv.saisie("Entrez un nom de projet");
                                       if(pm.get(m,"", p)!=null){
                                            System.out.println(pm.get(m,"", p));
                                        }
                                        break;
                            case 3: modifierProjet();break;
                            case 4:listeProjet();break;
                            case 5:supprimerProjet();break;
                            case 6: m=pv.saisie("Entrez le titre d'un projet");
                                listeMembreP=pm.listeMembreProjet(m);
                                for(Membre mbre:listeMembreP){
                                    System.out.println(mbre);
                                }
                        }
                    }while(c!=7);
                    break;
                case 3:
                    do{
                        c=pv.menuMembre();
                        switch(c){
                            case 1: membre=pv.saisieMembre();
                                    ajout(membre);break;
                            case 2: m=pv.saisie("Entrez un nom d'un membre");
                                    m1=pv.saisie("Entrez le prénom du membre");
                                    if(pm.get(m,m1,membre)!=null){
                                        System.out.println(pm.get(m, m1, membre));
                                    }break;
                            case 3:modifierMembre();break;
                            case 4:listeMembre();break;
                            case 5:break;
                        }
                    }
                    while(c!=6);
            }
        }
        while(choix!=3);
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
    public void supprimerEntreprise(){
        String m;
        Entreprise e=new Entreprise();
        m=pv.saisie("Entrez le nom de l'entreprise à supprimer");
        pm.supprimer((Entreprise)pm.get(m,"", e));
    }
    public void supprimerProjet(){
        String m;
        Projet p=new Projet();
        m=pv.saisie("Entrez le nom du projet à supprimer");
        pm.supprimer((Projet)pm.get(m,"", p));
    }
    public void modifierEntreprise(){
        int n;
        String m;
        Entreprise e=new Entreprise();
        do{
           n=pv.menuEntrepriseModif();
           Object o=new Entreprise();
           switch(n){
           case 1: m=pv.saisie("Entrez le nom de l'entreprise");
                    if(pm.get(m,"", e)!=null){
                        o=pm.get(m,"",e);
                        pv.affMessage("Entrez le nom de l'entreprise à remplacer");
                        String s=pv.saisie();
                       m=pm.modifierNomEntreprise((Entreprise)o, s);
                        pv.affMessage(m);
                    }
                    else pv.affMessage("Pas dans la table");
            break;
            case 2: 
                m=pv.saisie("Entrez le nom de l'entreprise");
                if(pm.get(m,"", e)!=null){
                    o=pm.get(m,"",e);
                    System.out.println("Entrez l'adresse à remplacer");
                    String s=pv.saisie();
                    m=pm.modifierAdEntreprise((Entreprise)o, s);
                    pv.affMessage(m);
                }
                else pv.affMessage("Pas dans la table");
            break;
            case 3: 
                m=pv.saisie("Entrez le nom de l'entreprise");
                if(pm.get(m,"" ,e)!=null){
                    o=pm.get(m,"",e);
                    System.out.println("Entrez le telephone de l'entreprise à remplacer");
                    String s=pv.saisie();
                    m=pm.modifierTelEntreprise((Entreprise)o, s);
                    pv.affMessage(m);
                }
                else pv.affMessage("Pas dans la table");
                break;
        }
      }
      while(n!=4);
    }
    public void modifierProjet(){
         int n;
        String m;
        Projet p=new Projet();
        do{
           n=pv.menuProjetModif();
           Object o=new Projet();
           switch(n){
           case 1: m=pv.saisie("Entrez le nom du projet");
                    if(pm.get(m,"", p)!=null){
                        o=pm.get(m,"",p);
                        pv.affMessage("Entrez le nom du projet modifié");
                        String s=pv.saisie();
                       m=pm.modifierTitreProjet((Projet)o, s);
                        pv.affMessage(m);
                    }
                    else pv.affMessage("Pas dans la table");
            break;
            case 2: 
                m=pv.saisie("Entrez le nom du projet");
                if(pm.get(m,"", p)!=null){
                    o=pm.get(m,"",p);
                    System.out.println("Entrez la date du debut remplacé");
                    String s=pv.saisie();
                    m=pm.modifierDateDebutProjet((Projet)o, s);
                    pv.affMessage(m);
                }
                else pv.affMessage("Pas dans la table");
            break;
            case 3: 
                m=pv.saisie("Entrez le nom du projet");
                if(pm.get(m,"", p)!=null){
                    o=pm.get(m,"",p);
                    System.out.println("Entrez la date de fin remplacé");
                    String s=pv.saisie();
                    m=pm.modifierDateFinProjet((Projet)o, s);
                    pv.affMessage(m);
                }
                else pv.affMessage("Pas dans la table");
                break;
        }
      }
      while(n!=4);
    }
    public void modifierMembre(){
        
    }
    public void listeEntreprise(){
        List<Entreprise> le=pm.getEntreprise();
        pv.affListe(le);
    }
     public void listeProjet(){
        List<Projet> lp=pm.getProjet();
        pv.affListe(lp);
    }
      public void listeMembre(){
        List<Membre> lm=pm.getMembre();
        pv.affListe(lm);
    }
     public void creerProjet(){
         int c;
         String m;
         String m1;
         Membre mem=new Membre();
         Travail t=new Travail();
         Projet p=pv.saisieProjet();
         pm.ajouter(p);
         do{
             c=pv.menuCreerProjet();
             switch(c){
                 case 1:mem=pv.saisieMembre();
                        ajout(mem);
                        
                        break;
                 case 2: m=pv.saisie("Entrez un nom d'un membre");
                         m1=pv.saisie("Entrez le prénom du membre");
                         if(pm.get(m,m1,mem)!=null){
                                System.out.println(pm.get(m, m1, mem));
                                mem=(Membre)pm.get(m1, m1, mem);
                                System.out.println("Après l'avoir récuperer:");
                         }break;
             }
             
         }
         while(c!=3);
         if(mem!=null){
                t= pv.saisieTravail(p,mem);
                ajout(t);
             }
     }
}
