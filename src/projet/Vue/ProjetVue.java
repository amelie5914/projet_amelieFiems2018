/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Vue;
import java.util.Scanner;
import projet.Modele.Entreprise;
import projet.Modele.Projet;
/**
 *
 * @author ameliefiems
 */
public class ProjetVue {
    private Scanner sc = new Scanner(System.in);
    public Entreprise saisieEntreprise(){
        String nom=sc.nextLine();
        String tel=sc.nextLine();
        String adresse=sc.nextLine();
        Entreprise e=new Entreprise(nom,tel,adresse);
        return e;
    }
}
