/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import projet.Controleur.ProjetControleur;
import projet.Modele.ProjetModele;
import projet.Vue.ProjetVue;

/**
 *
 * @author ameliefiems
 */
public class Principal {
    private ProjetModele pm;
    private ProjetVue pv;
    private ProjetControleur pc;
    public Principal(){
        pm=new ProjetModele();
        pm.personne();
        pv=new ProjetVue();
        pc=new ProjetControleur(pv,pm);
        pc.gestion();
        System.out.println("fin");
    }
    public static void main(String[] args){
        Principal p=new Principal();
    }
}
