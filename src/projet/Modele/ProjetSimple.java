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
public class ProjetSimple extends ProjetGeneral{
    public ProjetSimple(String titre, String dateDebut, String dateFin,Entreprise ent){
        super(titre,dateDebut,dateFin,ent);
        
    }
   public ProjetSimple(String titre){
       super(titre);
   }
   public ProjetSimple(){
    
}
}
