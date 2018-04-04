/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Modele;

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
    public String ajouter(Object o,List<Object> tamp){
        String message=null;
        
        if(!tamp.contains(o)&&o!=null){
            if(o instanceof Entreprise){
                    o=new Entreprise();
                    Entreprise e=(Entreprise)o;
                   entreprise.add(e); 
                   message= "entreprise ajoutée";
            }
            else if(o instanceof Competence){
                o=new Competence();
                Competence c=(Competence)o;
                comp.add(c);
                message="competence ajouté";
            }
            else if(o instanceof Discipline){
                o=new Discipline();
                Discipline d=(Discipline)o;
                dis.add(d);
                message="discipline ajouté";
            }
            else if(o instanceof Membre){
                o=new Membre();
                Membre m=(Membre)o;
                membre.add(m);
                message="membre ajouté";
            }
            else if(o instanceof Niveaux){
                o=new Niveaux();
                Niveaux n=(Niveaux)o;
                niveau.add(n);
                message="niveau ajouté";
            }
            else if(o instanceof Projet){
                o=new Projet();
                Projet p=(Projet)o;
                projet.add(p);
                message="projet ajouté";
            }
            else if(o instanceof Temps){
                o=new Temps();
                Temps t=(Temps)o;
                temps.add(t);
                message="Temps ajouté";
            }
            else if(o instanceof Travail){
                o=new Travail();
                Travail tr=(Travail)o;
                trav.add(tr);
                message="Travail ajouté";
            }
            
        }
        else{
            message= null;
        }
        return message;
    
    }
    public String ajouterProjet(Projet p){
        if(!projet.contains(p)&&p!=null){
            projet.add(p);
            return "Projet ajouté";
        }
        return null;
    }
    public String ajouterEntreprise(Entreprise e){
        if(!entreprise.contains(e)&&e!=null){
            entreprise.add(e);
            return "Entreprise ajouté";
        }
        return null;
    }
    
    
   /* public void ajouterDiscipline(Discipline d){
        if(!dis.contains(d)&&d!=null){
            dis.add(d);
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
    
    public void ajouterTemps(Temps t){
        if(!temps.contains(t)&&t!=null){
            temps.add(t);
        }
    }
    public void ajouterTravail(Travail t){
        if(!trav.contains(t)&&t!=null){
            trav.add(t);
        }
    }*/

    public void setEntreprise(List<Entreprise> entreprise) {
        this.entreprise = entreprise;
    }
    
    
}
