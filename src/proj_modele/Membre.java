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
public class Membre {
    private String nomMem;
    private String prenomMem;
    private String gsmMem;
    private String email;
    //a verifier
    public Set<Projet> projet;
    public Set<Discipline> compétence;

    public Membre(String nomMem, String prenomMem, String gsmMem, String email, Set<Projet> projet, Set<Discipline> compétence) {
        this.nomMem = nomMem;
        this.prenomMem = prenomMem;
        this.gsmMem = gsmMem;
        this.email = email;
        this.projet = projet;
        this.compétence = compétence;
    }
    

    public String getNomMem() {
        return nomMem;
    }

    public String getPrenomMem() {
        return prenomMem;
    }

    public String getGsmMem() {
        return gsmMem;
    }

    public String getEmail() {
        return email;
    }
    
}
