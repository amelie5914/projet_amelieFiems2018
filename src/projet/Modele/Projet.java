/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Modele;

import java.util.Set;

/**
 *
 * @author ameliefiems
 */
public class Projet {
    private String titre;
    
    private String dateDebut;
    private String dateFin;
   //a verifier!!!
    private Entreprise ent;
    /*public Set<Temps> temps;
    public Set<Discipline> discipline;
    public Set<Membre> membre;
    */
    public Projet(){
        this.dateDebut="";
        this.dateFin="";
        this.ent=null;
        this.titre="";
    }
    public Projet(String titre){
        this.titre=titre;
        dateDebut="";
        dateFin="";
        ent=null;
    }
    public Projet(String titre, String dateDebut, String dateFin, Entreprise ent) {
        this.titre = titre;
        
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.ent = ent;
    }
    

    public String getTitre() {
        return titre;
    }

    public Entreprise getEnt() {
        return ent;
    }

    

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public void setEnt(Entreprise ent) {
        this.ent = ent;
    }
    
    
}
