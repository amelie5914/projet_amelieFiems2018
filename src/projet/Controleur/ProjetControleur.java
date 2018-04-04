/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Controleur;

import projet.Modele.Entreprise;
import projet.Modele.ProjetModele;
import projet.Vue.ProjetVue;

/**
 *
 * @author ameliefiems
 */
public class ProjetControleur {
    private ProjetVue pv;
    private ProjetModele pm;
    public ProjetControleur(){
        
    }
    public void gestion(){
        
    }
    
    public void ajoutEntreprise(){
        Entreprise e=pv.saisieEntreprise();
        String m=pm.ajouterEntreprise(e);
        if(m!=null){
            System.out.println(m);
        }
        else{
            System.out.println("Erreur, recommencez");
        }
    }
}
