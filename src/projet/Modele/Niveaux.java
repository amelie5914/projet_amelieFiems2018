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
public class Niveaux {
    private int degre;
    private String signification;
    public Niveaux(){
        
    }
    public Niveaux(int degre, String signification) {
        this.degre = degre;
        this.signification = signification;
    }
   public Niveaux(int degre){
       this.degre=degre;
   }
    
}
