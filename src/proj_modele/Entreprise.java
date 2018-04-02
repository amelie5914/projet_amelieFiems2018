/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_modele;

/**
 *
 * @author ameliefiems
 */
public class Entreprise {
    private String nomEmt;
    private String telEmt;
    private String adresse;
    
    public Entreprise(){
        
    }
    public String getNom(){
        return nomEmt;
    }
    public String getTel(){
        return telEmt;
    }

    public String getAdresse() {
        return adresse;
    }

    public Entreprise(String nomEmt, String telEmt, String adresse) {
        this.nomEmt = nomEmt;
        this.telEmt = telEmt;
        this.adresse = adresse;
    }

    

 
}
