/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Modele;

import java.util.ArrayList;

import java.util.*;

/**
 *
 * @author ameliefiems
 */
public class ProjetModele {
    private  List<Competence> comp = new ArrayList<>();
    private  List<Discipline> dis = new ArrayList<>();
    private  List<Entreprise> entreprise ;
    private  List<Membre> membre = new ArrayList<>();
    private  List<Niveaux> niveau = new ArrayList<>();
    private List<Projet> projet;
    private List<Temps> temps= new ArrayList<>();
    private List<Travail> trav = new ArrayList<>();
    
    public ProjetModele(){
        //Pour tester mes classes
        entreprise=new ArrayList<>(Arrays.asList(new Entreprise("Fabricom","09898","rue pacqueret"),
                                                    new Entreprise("Condorcet","098098","Rue piv"),
                                                    new Entreprise ("Hopital","0999","Roiu")));
        projet=new ArrayList<>(Arrays.asList(new Projet("Projet Web", "1 juin 2018","4 juillet 2018", entreprise.get(1)),
                                                new Projet("Projet java","2 janvier","17 fevrier",entreprise.get(0)),
                                                new Projet("SGBD","14 juillet","21 juillet",entreprise.get(0))));
        
    }
    public String ajouter(Object o){
        String message=null;
        List l = null;
        if(o!=null){
            if(o instanceof Entreprise&&!entreprise.contains(o)){
                    l=entreprise;
                   message= "entreprise ajoutée";
                   
            }
            else if(o instanceof Competence&&!comp.contains(o)){
                l=comp;
                message="competence ajouté";
            }
            else if(o instanceof Discipline&&!dis.contains(o)){
                l=dis;
                message="discipline ajouté";
            }
            else if(o instanceof Membre&&!membre.contains(o)){
                l=membre;
                message="membre ajouté";
            }
            else if(o instanceof Niveaux&&!niveau.contains(o)){
                l=niveau;
                message="niveau ajouté";
            }
            else if(o instanceof Projet&&!projet.contains(o)){
                l=projet;
                message="projet ajouté";
            }
            else if(o instanceof Temps&&!temps.contains(o)){
                l=temps;
                message="Temps ajouté";
            }
            else if(o instanceof Travail&&!trav.contains(o)){
                l=trav;
                message="Travail ajouté";
            }
            
        }
        else{
            message= null;
        }
        l.add(o);
        return message;
    
    }
    
    public Entreprise getEnt(String nomEntreprise){
        Entreprise ent=new Entreprise(nomEntreprise);
        int p=entreprise.indexOf(ent);
        if(p>=0){
            return entreprise.get(p);
        }
        else{
            return null;
        }
    }
    /*public Entreprise getEnt(String nomEntreprise){
        Entreprise ent=new Entreprise(nomEntreprise);
        int p=entreprise.indexOf(ent);
        if(p>=0){
            return entreprise.get(p);
        }
        else{
            return null;
        }
    }*/
    public String modifierNomEntreprise(Entreprise e,String nom){
        
        e.setNom(nom);
        return "modification du nom effectué";
    }
    public String modifierTelEntreprise(Entreprise e,String tel){
        
        e.setTelEnt(tel);
        return "modification du numero de telephone effectué";
    }
    public String modifierAdEntreprise(Entreprise e,String a){
        e.setAdresse(a);
        return "modification d'adresse effectué";
    }
    
    public String modifierTitreProjet(Projet p, String titre){
        p.setTitre(titre);
        return "modification de titre effectué";
    }
    
    public String modifierDateDebutProjet(Projet p,String date){
        p.setDateDebut(date);
        return "modification de date du début du projet effectué";
    }
    public String modifierDateFinProjet(Projet p,String date){
        p.setDateFin(date);
        return "modification de date du début du projet effectué";
    }      
    
    public Object get(String mot,Object o)
    {
        if(mot!=null){
            if(o instanceof Entreprise){
                    Entreprise ent=new Entreprise(mot);
                    int p=entreprise.indexOf(ent);
                    
                    if(p>=0){
                        return entreprise.get(p);
                        
                    }
                    else{
                        return null;
                    }
            }
            else if(o instanceof Projet){
                Projet p=new Projet(mot);
                    int c=projet.indexOf(p);
                    if(c>=0){
                        return projet.get(c);
                    }
                    else{
                        return null;
                    }
            }
            else if(o instanceof Travail){
                Travail t=new Travail(mot);
                    int c=trav.indexOf(t);
                    if(c>=0){
                        return trav.get(c);
                    }
                    else{
                        return null;
                    }
            }
            else if(o instanceof Membre){
                Membre m=new Membre(mot);
                    int c=membre.indexOf(m);
                    if(c>=0){
                        return membre.get(c);
                    }
                    else{
                        return null;
                    }
            }
            else if(o instanceof Discipline){
                Discipline d=new Discipline(mot);
                    int c=dis.indexOf(d);
                    if(c>=0){
                        return dis.get(c);
                    }
                    else{
                        return null;
                    }
            }
            
        }
        return null;
       
    }
    
     public Object get(int primary,Object o)
    {
            if(o instanceof Competence){
                    Competence competence=new Competence(primary);
                    int p=comp.indexOf(competence);
                    if(p>=0){
                        return comp.get(p);
                    }
                    else{
                        return null;
                    }
            }
            else if(o instanceof Niveaux){
                Niveaux p=new Niveaux(primary);
                    int c=niveau.indexOf(p);
                    if(c>=0){
                        return niveau.get(c);
                    }
                    else{
                        return null;
                    }
            }
            else if(o instanceof Temps){
                Temps t=new Temps(primary);
                    int c=temps.indexOf(t);
                    if(c>=0){
                        return temps.get(c);
                    }
                    else{
                        return null;
                    }
            }
            
            return null;
    }
    public void supprimer(Object o){
        if(o!=null){
            if(o instanceof Entreprise){
                entreprise.remove(o);
            }
            else if(o instanceof Projet){
                projet.remove(o);
            }
            else if(o instanceof Travail){
                trav.remove(o);
            }
            else if(o instanceof Membre){
                membre.remove(o);
            }
            else if(o instanceof Discipline){
                dis.remove(o);
            }
            else if(o instanceof Competence){
                comp.remove(o);
            }
            else if(o instanceof Niveaux){
                niveau.remove(o);
            }
            else if(o instanceof Temps){
                temps.remove(o);
            }
        }
        else{
            System.out.println("pas de suppression");
        }
    }    
       
    
    public List<Competence> getComp() {
        return comp;
    }

    public List<Discipline> getDis() {
        return dis;
    }

    public List<Entreprise> getEntreprise() {
        return entreprise;
    }

    public List<Membre> getMembre() {
        return membre;
    }

    public List<Niveaux> getNiveau() {
        return niveau;
    }

    public List<Projet> getProjet() {
        return projet;
    }

    public List<Temps> getTemps() {
        return temps;
    }

    public List<Travail> getTrav() {
        return trav;
    }
    
    
   
    
    

    
    
}
