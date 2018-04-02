/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_modele;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ameliefiems
 */
public class ProjetModele {
    private  List<Competence> comp = new ArrayList<>();
    private  List<Discipline> dis = new ArrayList<>();
    private  List<Entreprise> entreprise = new ArrayList<>();
    private  List<Membre> membre = new ArrayList<>();
    private  List<Niveaux> niveau = new ArrayList<>();
    private List<Projet> projet = new ArrayList<>();
    private List<Temps> temps= new ArrayList<>();
    private List<Travail> trav = new ArrayList<>();
    
    public ProjetModele(){
        
    }
    public void ajouterCompetence(Competence c){
     if(!comp.contains(c)&&c!=null){
         
         comp.add(c);
     }
    
    }
    
    public void ajouterDiscipline(Discipline d){
        if(!dis.contains(d)&&d!=null){
            dis.add(d);
        }
    }
    
    public void ajouterEntreprise(Entreprise e){
        if(!entreprise.contains(e)&&e!=null){
            entreprise.add(e);
        }
    }
    
    public void ajouterMembre(Membre m){
        if(!membre.contains(m)&&m!=null){
            membre.add(m);
        }
    }
    public void ajouterniveaux(Niveaux n){
        if(!niveau.contains(n)&&n!=null){
            niveau.add(n);
        }
    }
    public void ajouterProjet(Projet p){
        if(!projet.contains(p)&&p!=null){
            projet.add(p);
        }
    }
    public void ajouterTemps(Temps t){
        if(!temps.contains(t)&&t!=null){
            temps.add(t);
        }
    }
    public void ajouterTravail(Travail t){
        if(!trav.contains(t)&&t!=null){
            trav.add(t);
        }
    }
}
