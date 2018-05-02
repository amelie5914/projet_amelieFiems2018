/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Controleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import projet.Modele.*;
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
        Discipline dis=new Discipline();
        List <Membre>listeMembreP=new ArrayList();
        List <Projet>listeProjetEntreprise=new ArrayList();
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
                                case 5:supprimerEntreprise();break;
                                case 6:m=pv.saisie("Entrez le titre d'une entreprise");
                                        listeProjetEntreprise=pm.listeProjetEntreprise(m);
                                        for(Projet proj:listeProjetEntreprise){
                                            System.out.println(proj);
                                        }break;
                                   
                            }
                        }
                        while(c!=7);
                        break;
                case 2: 
                    do{
                        c=pv.menuProjet();

                        switch(c){
                            case 1: 
                                    creerProjet();break;
                            case 2: p=rechercheProjet();
                                    System.out.println(p);break;
                            case 3: modifierProjet();break;
                            case 4:listeProjet();break;
                            //case 5:supprimerProjet();break;
                            case 6: m=pv.saisie("Entrez le titre d'un projet");
                                listeMembreP=pm.listeMembreProjet(m);
                                for(Membre mbre:listeMembreP){
                                    System.out.println(mbre);
                                }break;
                            case 7:p=rechercheProjet();
                            if(p!=null)
                                ajouterMembreTravail(p);
                        }
                    }while(c!=8);
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
                            case 5:supprimerMembre();break;
                        }
                    }
                    while(c!=6);
                    break;
                case 4:listeTravail(); break;
                case 5:do{
                    c=pv.menuDiscipline();
                    switch(c){
                        case 1: dis=pv.saisieDiscipline();
                                ajout(dis);break;
                        case 2: m=pv.saisie("Entrez le nom de la discipline");
                                if(pm.get(m,"",dis)!=null){
                                        System.out.println(pm.get(m, "", dis));
                                    }break;
                        case 3: modifierDiscipline();break;
                        case 4: listeDiscipline();break;
                        case 5:supprimerDiscipline();break;
                    }
                }
                while(c!=6);
            }
        }
        while(choix!=7);
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
        boolean v;
        m=pv.saisie("Entrez le nom de l'entreprise à supprimer");
        e=(Entreprise)pm.get(m,"", e);
        List<Projet>ProjetTmp=new ArrayList();
        for(Projet p:pm.getProjet()){
            if(!p.getEnt().equals(e)){
                ProjetTmp.add(p);
            }
        }
        pm.setProjet(ProjetTmp);
        pm.supprimer(e);
       
       
    }
    public void supprimerProjet(){
        String m;
        Projet proj=new Projet();
        boolean v;
        m=pv.saisie("Entrez le nom du projet à supprimer");
        proj=(Projet)pm.get(m,"", proj);
        List<Travail>travailTmp=new ArrayList();
        for(Travail t:pm.getTrav()){
            if(!t.getProj().equals(proj)){
                travailTmp.add(t);
            }
        }
        pm.setTrav(travailTmp);
        pm.supprimer(proj);
    }
    
    public Projet rechercheProjet(){
        
        String m;
        Projet p=new Projet();
        m=pv.saisie("Entrez un nom de projet");
        if(pm.get(m,"", p)!=null){
             p=(Projet)pm.get(m,"", p);
             return p;
        }
        else{
            return null;
        }
        
    }
    public void supprimerMembre(){
        String m1,m2;
        Membre membre=new Membre();
        boolean v;
        m1=pv.saisie("Entrez le nom du membre à supprimer");
        m2=pv.saisie("Entrez le prenom du membre à supprimer");
        membre=(Membre)pm.get(m1,m2, membre);
        List<Travail>travailTmp=new ArrayList();
        for(Travail t:pm.getTrav()){
            if(!t.getMem().equals(membre)){
                travailTmp.add(t);
            }
        }
        pm.setTrav(travailTmp);
        pm.supprimer(membre);
    }
    public void supprimerDiscipline(){
        String nom=pv.saisie("Entrez le nom de la discipline à supprimer");
        Discipline d=new Discipline();
        d=(Discipline)pm.get(nom,"", d);
        pm.supprimer(d);
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
        int n;
        String m1,m2;
        Membre membre=new Membre();
        do{
           n=pv.menuMembreModif();
           Object o=new Membre();
           switch(n){
           case 1: m1=pv.saisie("Entrez le nom du membre");
                    m2=pv.saisie("Entrez le prenom du membre");
                    if(pm.get(m1,m2, membre)!=null){
                        o=pm.get(m1,m2,membre);
                        pv.affMessage("Entrez le numero de gsm remplacé");
                        String s=pv.saisie();
                        m1=pm.modifierGSMMembre((Membre) o, s);
                        pv.affMessage(m1);
                    }
                    else pv.affMessage("Pas dans la table");
            break;
            case 2: 
                m1=pv.saisie("Entrez le nom du membre");
                    m2=pv.saisie("Entrez le prenom du membre");
                    if(pm.get(m1,m2, membre)!=null){
                        o=pm.get(m1,m2,membre);
                        pv.affMessage("Entrez le email remplacé");
                        String s=pv.saisie();
                        m1=pm.modifierEmailMembre((Membre) o, s);
                        pv.affMessage(m1);
                    }
                    else pv.affMessage("Pas dans la table");
            break;
            
        }
      }
      while(n!=4);
    }
    public void modifierDiscipline(){
        Discipline discipline=new Discipline();
        Object o=new Discipline();
        String nom=pv.saisie("Entrez le nom de la discipline");
        String nomRemp;
        if(pm.get(nom,"",discipline)!=null){
            o=pm.get(nom,"",discipline);
            nomRemp=pv.saisie("Entrez le nom de la discipline remplacé");
            pv.affMessage(pm.modifierNomDiscipline((Discipline)o, nomRemp));
        }
        else{
            pv.affMessage("Pas dans la table");
        }
        
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
      public void listeTravail(){
          List<Travail>lt=pm.getTrav();
          pv.affListe(lt);
      }
      public void listeDiscipline(){
          List <Discipline> ld=pm.getDis();
          pv.affListe(ld);
      }
     public void creerProjet(){
         int c;
         String m;
         String m1;
         String nomEnt;
         Membre mem=new Membre();
         Travail t=new Travail();
         Entreprise e=new Entreprise();
         Projet p=pv.saisieProjet();
         boolean v=false;
         if(pm.get(p.getEnt().getNom(),"", p.getEnt())==null){
            pm.ajouter(p.getEnt());
         }
         c=pv.menuCreerProjetEntreprise();
         switch(c){
             case 1: do{
                            e=pv.saisieEntreprise();
                        }
                        while(e==null);
                        if(pm.get(e.getNom(),"",e)==null){
                            ajout(e);
                         }
                        break;
             case 2: do{
                        nomEnt=pv.saisie("Entrez le nom de l'entreprise que vous recherchez");
                            e=(Entreprise)pm.get(nomEnt,"", e);
                        
                        }
                        while(pm.get(nomEnt,"", e)==null);
                        System.out.println(pm.get(nomEnt,"", e));
         }
         p.setEnt(e);
         pm.ajouter(p);
         do{
             c=pv.menuCreerProjetMembre();
             switch(c){
                 case 1:mem=pv.saisieMembre();
                        if(pm.get(mem.getNomMem(),mem.getPrenomMem(), mem)==null&&mem!=null){
                            ajout(mem);
                            t= pv.saisieTravail(p,mem);
                            ajout(t);
                            v=true;
                         }
                        else{
                            System.out.println("Il est déjà ajouter");
                        }
                        
                        break;
                 case 2: m=pv.saisie("Entrez un nom d'un membre");
                         m1=pv.saisie("Entrez le prénom du membre");
                         if(pm.get(m,m1,mem)!=null){
                                System.out.println(pm.get(m, m1, mem));
                                mem=(Membre)pm.get(m, m1, mem);
                                System.out.println("Après l'avoir récuperer:");
                                v=true;
                         }
                         if(mem!=null){
                                t= pv.saisieTravail(p,mem);
                                ajout(t);
                                v=true;
                          }
                         break;
             }
         }
         while(c!=3);
         if(v==false){
             pv.affMessage("Vous n'avez pas entré de membre.");
         }
     }
     public void ajouterMembreTravail(Projet p){
         Membre mem=pv.saisieMembre();
         Travail t=new Travail();
         ajout(mem);
         t=pv.saisieTravail(p,mem);
         ajout(t);
     }
}
