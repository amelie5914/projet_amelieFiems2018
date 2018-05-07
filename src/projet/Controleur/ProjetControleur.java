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
        boolean v;
        String m,m1;
        Entreprise e=new Entreprise();
        ProjetGeneral pg;
        Membre membre=null
                ;
        Discipline dis=new Discipline();
        Niveaux niv=new Niveaux();
        List <Membre>listeMembreP=new ArrayList();
        List <Discipline>listeDisProjet=new ArrayList();
        List <ProjetGeneral>listeProjetEntreprise=new ArrayList();
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
                                        for(ProjetGeneral proj:listeProjetEntreprise){
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
                            case 2: pg=rechercheProjet();
                                    System.out.println(pg);break;
                            case 3: modifierProjet();break;
                            case 4:listeProjet();break;
                            case 5:supprimerProjet();break;
                            case 6: m=pv.saisie("Entrez le titre d'un projet");
                            pg=null;
                                do{
                                    choix=pv.saisieInt("Est ce un simple ou un composite?\n1.Simple\n2.Composite");
                                    switch(choix){
                                        case 1:pg=new ProjetSimple();break;
                                        case 2:pg=new Sous_projet();break;
                                }
                            }while(choix!=1&&choix!=2);
                                listeMembreP=pm.listeMembreProjet(m,pg);
                                for(Membre mbre:listeMembreP){
                                    System.out.println(mbre);
                                }break;
                            case 7:pg=rechercheProjet();
                                    if(pg!=null)
                                        do{
                                            v=creerProjetMembre(pg);
                                        }
                                        while(v==false);
                                    break;
                            case 8:pg=rechercheProjet();
                                if(pg!=null){
                                    do{
                                        v=creerProjetDiscipline(pg);
                                    }
                                    while(v==false);
                                }
                                break;
                               
                            case 9:m=pv.saisie("Entrez le titre d'un projet");
                             pg=null;
                            do{
                                choix=pv.saisieInt("Est ce un simple ou un composite?\n1.Simple\n2.Composite");
                                switch(choix){
                                    case 1:pg=new ProjetSimple();break;
                                    case 2:pg=new Sous_projet();break;
                                }
                            }while(choix!=1&&choix!=2);
                                listeDisProjet=pm.listeDisciplineProjet(m,pg);
                                for(Discipline d:listeDisProjet){
                                    System.out.println(d);
                                }break;
                        }
                    }while(c!=10);
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
                        case 2: 
                             m=pv.saisie("Entrez le nom de la discipline");
                            dis=rechercheDiscipline(m);
                                System.out.println(dis);break;
                        case 3: modifierDiscipline();break;
                        case 4: listeDiscipline();break;
                        case 5:supprimerDiscipline();break;
                    }
                }
                while(c!=6); break;
                case 6:listeTemps(); break;
                case 7:listeCompetence();break;
                case 8:do{
                    c=pv.menuNiveaux();
                    switch(c){
                        case 1:niv=pv.saisieNiveaux(); 
                                ajout(niv);
                                break;
                        case 2:niv=rechercheNiveaux();
                                System.out.println(niv);
                                break;
                        case 3: modifierNiveaux();break;
                        case 4:listeNiveaux(); break;
                        case 5:supprimerNiveaux();break;
                    }
                }
                while(c!=6);
            }
        }
        while(choix!=9);
    }
    public void ajout(Object o){
        String m=pm.ajouter(o);
        System.out.println(m);
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
        List<ProjetGeneral>ProjetTmp=new ArrayList();
        for(ProjetGeneral p:pm.getProjet()){
            if(!p.getEnt().equals(e)){
                ProjetTmp.add(p);
            }
        }
        pm.setProjet(ProjetTmp);
        pm.supprimer(e);
       
       
    }
    public void supprimerProjet(){
        String m;
        int choix;
        ProjetGeneral p=null;
        boolean v;
        m=pv.saisie("Entrez le nom du projet à supprimer");
        do{
            choix=pv.saisieInt("Est ce un simple ou un composite?\n1.Simple\n2.Composite");
             switch(choix){
                 case 1:p=new ProjetSimple();break;
                  case 2:p=new Sous_projet();break;
              }
        }while(choix!=1&&choix!=2);
        p=pm.getProjet(p, m);
        List<Travail>travailTmp=new ArrayList();
        for(Travail t:pm.getTrav()){
            if(!t.getProj().equals(p)){
                travailTmp.add(t);
            }
        }
        pm.setTrav(travailTmp);
        
        List<Temps>tempsTmp=new ArrayList();
        for(Temps t:pm.getTemps()){
            if(!t.getProj().equals(p)){
                tempsTmp.add(t);
            }
        }
        pm.setTemps(tempsTmp);
        pm.supprimer(p);
    }
    
    public ProjetGeneral rechercheProjet(){
        int choix;
        String m;
        ProjetGeneral p=null;
        m=pv.saisie("Entrez un nom de projet");
        do{
            choix=pv.saisieInt("Est ce un simple ou un composite?\n1.Simple\n2.Composite");
             switch(choix){
                 case 1:p=new ProjetSimple();break;
                  case 2:p=new Sous_projet();break;
              }
        }while(choix!=1&&choix!=2);
        if(pm.getProjet(p, m)!=null){
             p=pm.getProjet(p, m);
             return p;
        }
        else{
            return null;
        }
        
    }
    public void supprimerMembre(){
        String m1,m2;
        Membre membre=null;
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
        List<Temps>tempsTmp=new ArrayList();
        for(Temps t:pm.getTemps()){
            if(!t.getDis().equals(d)){
                tempsTmp.add(t);
            }
        }
        pm.setTemps(tempsTmp);
        pm.supprimer(d);
    }
    public void supprimerNiveaux(){
        String m1,m2;
        Niveaux niv=new Niveaux();
        boolean v;
        int degre=pv.saisieInt("Entrez le degré à supprimer");
        niv=(Niveaux)pm.get(degre, niv);
        List<Competence>compTmp=new ArrayList();
        for(Competence c:pm.getComp()){
            if(!c.getNiveau().equals(niv)){
                compTmp.add(c);
            }
        }
        pm.setComp(compTmp);
        pm.supprimer(niv);
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
        int choix;
        ProjetGeneral p=null;
        do{
           n=pv.menuProjetModif();
            do{
                        choix=pv.saisieInt("Est ce un simple ou un composite?\n1.Simple\n2.Composite");
                        switch(choix){
                            case 1:p=new ProjetSimple();break;
                            case 2:p=new Sous_projet();break;
                        }
           }while(choix!=1&&choix!=2);
           switch(n){
           case 1: m=pv.saisie("Entrez le nom du projet");
                   
                    if(pm.getProjet(p, m)!=null){
                        p=pm.getProjet(p, m);
                        pv.affMessage("Entrez le nom du projet modifié");
                        String s=pv.saisie();
                       m=pm.modifierTitreProjet(p, s);
                        pv.affMessage(m);
                    }
                    else pv.affMessage("Pas dans la table");
            break;
            case 2: 
                m=pv.saisie("Entrez le nom du projet");
                if(pm.get(m,"", p)!=null){
                    p=pm.getProjet(p, m);
                    System.out.println("Entrez la date du debut remplacé");
                    String s=pv.saisie();
                    m=pm.modifierDateDebutProjet(p, s);
                    pv.affMessage(m);
                }
                else pv.affMessage("Pas dans la table");
            break;
            case 3: 
                m=pv.saisie("Entrez le nom du projet");
                if(pm.get(m,"", p)!=null){
                    p=pm.getProjet(p, m);
                    System.out.println("Entrez la date de fin remplacé");
                    String s=pv.saisie();
                    m=pm.modifierDateFinProjet(p, s);
                    pv.affMessage(m);
                }
                else pv.affMessage("Pas dans la table");
                break;
        }
      }
      while(n!=4);
    }
    public void modifierMembre() {
        int n;
        String m1,m2;
        Membre.MembreBuilder membreBuild=new Membre.MembreBuilder();
        membreBuild.setNomMem("f").setPrenomMem("p");
        try {
            
           Membre membre=membreBuild.build();
            do{
           n=pv.menuMembreModif();
           
           switch(n){
           case 1:
               m1=pv.saisie("Entrez le nom du membre");
                    m2=pv.saisie("Entrez le prenom du membre");
                    membre=(Membre)pm.get(m1,m2, membre);
                    if(pm.get(m1,m2, membre)!=null){
                        membre=(Membre)pm.get(m1,m2,membre);
                        pv.affMessage("Entrez le numero de gsm remplacé");
                        String s=pv.saisie();
                        m1=pm.modifierGSMMembre(membre, s);
                        pv.affMessage(m1);
                    }
                    else pv.affMessage("Pas dans la table");
            break;
            case 2: 
                m1=pv.saisie("Entrez le nom du membre");
                    m2=pv.saisie("Entrez le prenom du membre");
                    if(pm.get(m1,m2, membre)!=null){
                        membre=(Membre)pm.get(m1,m2,membre);
                        pv.affMessage("Entrez le email remplacé");
                        String s=pv.saisie();
                        m1=pm.modifierEmailMembre((Membre) membre, s);
                        pv.affMessage(m1);
                    }
                    else pv.affMessage("Pas dans la table");
            break;
            
        }
      }
      while(n!=3);
        } catch (Exception e) {
            System.out.println("erreur de création " + e);
        }

        
    }
    public void modifierDiscipline(){
        Discipline discipline=new Discipline();
        Object o=new Discipline();
        String nom=pv.saisie("Entrez le nom de la discipline");
        String nomRemp;
        if(pm.get(nom,"",discipline)!=null){
            o=pm.get(nom,"",discipline);
            nomRemp=pv.saisie("Entrez le nom de la discipline remplacé");
            String m=pm.modifierNomDiscipline((Discipline)o, nomRemp);
            pv.affMessage(m);
        }
        else{
            pv.affMessage("Pas dans la table");
        }
        
    }
    
    public void modifierNiveaux(){
        int degre=pv.saisieInt("Entre le degré de compétence dont vous voulez changer la signification");
        Niveaux niv=new Niveaux(degre);
        String m;
        if(pm.get(degre, niv)!=null){
            
            String description=pv.saisie("Entrez la nouvelle description");
            m=pm.modifierDescriptionNiveaux(niv,description);
            pv.affMessage(m);
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
        List<ProjetGeneral> lp=pm.getProjet();
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
      public void listeTemps(){
          List<Temps> lt=pm.getTemps();
          pv.affListe(lt);
      }
      public void listeCompetence(){
          List<Competence> lc=pm.getComp();
          pv.affListe(lc);
      }
      public void listeNiveaux(){
          List<Niveaux>ln=pm.getNiveau();
          pv.affListe(ln);
      }
     public void creerProjet(){
         int c=0;
         String m;
         String m1;
         String nomEnt;
         int choix=0;
         ProjetGeneral p;
         Travail t=new Travail();
         Entreprise e=new Entreprise();
         do{
            choix=pv.saisieInt("Est ce un projet simple ou un groupe de projet? \n1.Simple\n2.Groupe");
            p=pv.saisieProjet(choix);
            if(choix==1){

            }
            else if(choix==2){
                Sous_projet sp=new Sous_projet();
                p=(Sous_projet)p;
                do{
                    if(!pm.getProjet().isEmpty()){
                        listeProjet();
                        c=pv.saisieInt("Entrez les sous-projets: ");
                        sp.ajoutPG(pm.getProjet().get(c));
                    }
                    else{
                        pv.affMessage("Il n' y a aucun autre projet.Donc recommencez en tant que projet simple");
                        p=pv.saisieProjet(1);
                    }
                }
                while(c<=pm.getProjet().size()&&!pm.getProjet().isEmpty());
            }
            }
         while(choix!=1&&choix!=2);
         Discipline dis=new Discipline();
         Temps temps=new Temps();
         boolean v=false;
         /*if(pm.get(p.getEnt().getNom(),"", p.getEnt())==null){
            pm.ajouter(p.getEnt());
         }*/
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
         v=creerProjetDiscipline(p);
         if(v==false){
             pv.affMessage("Vous n'avez pas entré de discipline.");
         }
         v=creerProjetMembre(p);
         if(v==false){
             pv.affMessage("Vous n'avez pas entré de membre.");
         }
         
         
         
     }
     public boolean creerProjetMembre(ProjetGeneral p){
         int c;
         Membre mem=null;
         Travail t;
         String m,m1;
         boolean v=false;
         do{
             c=pv.menuCreerProjetMembre();
             switch(c){
                 case 1:ajouterMembre(p);
                        v=true;
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
         System.out.println(v);
         return v;
     }
     
     public boolean creerProjetDiscipline(ProjetGeneral p){
         int c;
         Discipline dis=new Discipline();
         Temps temps=new Temps();
         String m;
         boolean v=false;
         do{
             c=pv.menuCreerProjetDiscipline();
             switch(c){
                 case 1:dis=pv.saisieDiscipline();
                        if(pm.get(dis.getNomdiscipline(),"", dis)==null&&dis!=null){
                            ajout(dis);
                            temps= pv.saisieTemps(p,dis);
                            ajout(temps);
                            v=true;
                         }
                        else{
                            System.out.println("Il est déjà ajouté");
                        }
                        
                        break;
                 case 2: m=pv.saisie("Entrez une discipline");
                         if(pm.get(m,"",dis)!=null){
                                System.out.println(pm.get(m, "", dis));
                                dis=(Discipline)pm.get(m, "", dis);
                                v=true;
                         }
                         if(dis!=null){
                                temps= pv.saisieTemps(p,dis);
                                ajout(temps);
                                v=true;
                          }
                         break;
             }
         }
         while(c!=3);
         return v;
     }
     public void ajouterMembre(ProjetGeneral projet){
         Membre membre;
         Travail travail=new Travail();
         Niveaux niveau=new Niveaux();
         Discipline dis=new Discipline();
         int c=0;
         List <Discipline> listeDis=pm.listeDisciplineProjet(projet.getTitre(),projet);
         
         membre=pv.saisieMembre();
         
         if(pm.get(membre.getNomMem(),membre.getPrenomMem(), membre)==null&&membre!=null){
             ajout(membre);
             travail= pv.saisieTravail(projet,membre);
             ajout(travail);
             if(listeDis!=null){
                do{
                   pv.affListe(listeDis);
                   c=pv.saisieInt("Entrez le numéro de la discipline pour le membre");
                   if(c<listeDis.size()){
                       dis=listeDis.get(c);
                       niveau=pv.saisieNiveaux();
                       ajout(niveau);
                       Competence comp=new Competence( dis,niveau, membre);
                       ajout(comp);
                   }

                }
                while(c!=listeDis.size());
             }
             else{
                 System.out.println("Il y a aucune discipline enregistré");
             }
         }
            else{
                System.out.println("Il est déjà ajouté");
            }
     }
     public Discipline rechercheDiscipline(String d){
         
         Discipline dis=new Discipline();
         if(pm.get(d,"",dis)!=null){
             dis=(Discipline)pm.get(d,"",dis);
        }
        return dis;
     }
     public Niveaux rechercheNiveaux(){
         int n;
         Niveaux niv=new Niveaux();
         n=pv.saisieInt("Entrez le degré de compétence");
         if(pm.get(n, niv)!=null){
             niv=(Niveaux)pm.get(n, niv);
         }
         return niv;
     }
}
