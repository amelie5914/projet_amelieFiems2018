/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_modele;

import java.util.Set;

/**
 *
 * @author ameliefiems
 */
public class Projet {
    private String titre;
    private String client;
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

    public String getTitre() {
        return titre;
    }

    public String getClient() {
        return client;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }
    
}