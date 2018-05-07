/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Modele;

import java.util.*;

/**
 *
 * @author ameliefiems
 */
public class Sous_projet extends ProjetGeneral {
    List<ProjetGeneral> listePG=new ArrayList();
    public Sous_projet(String titre, String dateDebut, String dateFin,Entreprise ent){
        super(titre,dateDebut,dateFin,ent);
    }
    public Sous_projet(){
        
    }
    public Sous_projet(String titre){
        super(titre);
    }
    public void setListePG(List<ProjetGeneral> listePG) {
        this.listePG = listePG;
    }
    public void ajoutPG(ProjetGeneral pg){
        listePG.add(pg);
    }
    
}
