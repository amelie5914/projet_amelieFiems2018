/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Modele;

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
    public Entreprise(String nomEmt, String telEmt, String adresse) {
        this.nomEmt = nomEmt;
        this.telEmt = telEmt;
        this.adresse = adresse;
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

    

    

 
}
