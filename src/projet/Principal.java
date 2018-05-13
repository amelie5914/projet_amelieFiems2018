/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.Scanner;
import projet.Controleur.ProjetControleur;
import projet.Modele.ProjetModele;
import projet.Modele.ProjetModeleJDBC;
import projet.Vue.ProjetVue;

/**
 *
 * @author ameliefiems
 */
public class Principal {
    private ProjetModele pm;
    private ProjetVue pv;
    private ProjetControleur pc;
    public Principal(int mode){
        
        pv=new ProjetVue();
        
        pm = new ProjetModele();
        switch (mode) {
            case 1:
                pm = new ProjetModele();
                break;
            case 2:
                pm = new ProjetModeleJDBC();
                break;
            default:
                System.out.println("mode incorrect");
                System.exit(1);
        }
        pm.personne();
        pc=new ProjetControleur(pv,pm);
        pc.gestion();
        System.out.println("fin");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("mode 1:SANS DB 2:AVEC DB ");
        int mode = sc.nextInt();
        Principal p = new Principal(mode);

    }
}
