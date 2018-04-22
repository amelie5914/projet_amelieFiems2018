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
public class Membre {
    private String nomMem;
    private String prenomMem;
    private String gsmMem;
    private String email;
    
    public Membre(){
        
    }
    public Membre(String nomMem, String prenomMem, String gsmMem, String email) {
        this.nomMem = nomMem;
        this.prenomMem = prenomMem;
        this.gsmMem = gsmMem;
        this.email = email;
       
    }
    
    public Membre(String nomMem){
        this.nomMem=nomMem;
        this.prenomMem = "";
        this.gsmMem = "";
        this.email = "";
       
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

    @Override
    public String toString() {
        return "Membre{" + "nomMem=" + nomMem + ", prenomMem=" + prenomMem + ", gsmMem=" + gsmMem + ", email=" + email +'}';
    }

    
    
}
