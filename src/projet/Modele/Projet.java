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
        
    }
    public Projet(String titre){
        titre=titre;
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

    

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }
    
}
