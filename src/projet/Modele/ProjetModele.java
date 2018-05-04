/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Modele;

import java.util.ArrayList;

import java.util.*;

/**
 *
 * @author ameliefiems
 */
public class ProjetModele {
    private  List<Competence> comp = new ArrayList<>();
    private  List<Discipline> dis = new ArrayList<>();
    private  List<Entreprise> entreprise =new ArrayList<>();
    private  List<Membre> membre = new ArrayList<>();
    private  List<Niveaux> niveau = new ArrayList<>();
    private List<Projet> projet=new ArrayList<>();
    private List<Temps> temps= new ArrayList<>();
    private List<Travail> trav = new ArrayList<>();
    /** 
     * Constructeur par défaut
     */
    public ProjetModele(){
        
    }
    /** 
     * Méthode permettant l'ajout d'un objet à une des listes qui se trouve en atribut.
     * @param o objet à ajouter
     * @return une chaine de caractère qui décrit l'état de l'ajout
     */
    public String ajouter(Object o){
        String message="";
        List l = null;
        if(o!=null){
            if(o instanceof Entreprise&&!entreprise.contains(o)){
                    l=entreprise;
                   message= "entreprise ajoutée";
            }
            else if(o instanceof Competence){
                if(!comp.contains(o)){
                    l=comp;
                    message="competence ajouté";
                }
                else{
                    message="competence déjà ajouté";
                }
            }
            else if(o instanceof Discipline){
                if(!dis.contains(o)){
                    l=dis;
                    message="discipline ajouté";
                }
                else{
                    message="discipline déjà mise";
                }
            }
            else if(o instanceof Membre){
                if(!membre.contains(o)){
                    l=membre;
                    message="membre ajouté";
                }
                else{
                    message="membre déjà enregistré";
                }
            }
            else if(o instanceof Niveaux){
                if(!niveau.contains(o)){
                    l=niveau;
                    message="niveau ajouté";
                }
                else{
                    message="niveau déjà enregistré";
                }
            }
            else if(o instanceof Projet){
                if(!projet.contains(o)){
                    l=projet;
                    message="projet ajouté";
                }
                else{
                    message="projet déjà enregistré";
                }
            }
            else if(o instanceof Temps){
                if(!temps.contains(o)){
                    l=temps;
                    message="Temps ajouté";
                }
                else{
                    message="Temps déjà ajouté";
                }
            }
            else if(o instanceof Travail){
                if(!trav.contains(o)){
                    l=trav;
                    message="Travail ajouté";
                }
                else{
                    message="travail déjà enregistré";
                }
            }
            
        }
        else{
            message= null;
        }
        l.add(o);
        return message;
    
    }
    /**
     * Méthode permettant de changer le nom de l'entreprise du client.
     * @param e entreprise dont on désire changer le nom.
     * @param nom le nouveau nom.
     * @return chaine de caractère qui décrit l'état de la modification.
     */
    public String modifierNomEntreprise(Entreprise e,String nom){
        
        e.setNom(nom);
        return "modification du nom effectué";
    }
    /**
     * Méthode permettant de changer le numero de telephone de l'entreprise du client.
     * @param e entreprise dont on désire changer le numéro de téléphone.
     * @param tel le nouveau numéro de téléphone 
     * @return chaine de caractère qui décrit l'état de la modification
     */
    public String modifierTelEntreprise(Entreprise e,String tel){
        
        e.setTelEnt(tel);
        return "modification du numero de telephone effectué";
    }
    /**
     * Méthode permettant de changer l'adresse de l'entreprise du client.
     * @param e entreprise dont on désire changer l'adresse.
     * @param a nouvelle adresse.
     * @return chaine de caractère qui décrit l'état de la modification.
     */
    public String modifierAdEntreprise(Entreprise e,String a){
        e.setAdresse(a);
        return "modification d'adresse effectué";
    }
    /**
     * Méthode permettant de changer le nom d'un projet
     * @param p projet dont on désire changer le nom
     * @param titre nouveau nom
     * @return chaine de caractère qui décrit l'état de la modification
     */
    public String modifierTitreProjet(Projet p, String titre){
        p.setTitre(titre);
        return "modification de titre effectué";
    }
    /**
     * Méthode permettant de changer la date du début d'un projet
     * @param p projet dont on désire changer la date de début.
     * @param date nouvelle date de début
     * @return chaine de caractère qui décrit l'état de la modification
     */
    public String modifierDateDebutProjet(Projet p,String date){
        p.setDateDebut(date);
        return "modification de date du début du projet effectué";
    }
    /**
     * Méthode permettant de changer la date de fin d'un projet
     * @param p projet dont on désire changer la date de fin
     * @param date nouvelle date de fin
     * @return chaine de caractère qui décrit l'état de la modification
     */
    public String modifierDateFinProjet(Projet p,String date){
        p.setDateFin(date);
        return "modification de date du début du projet effectué";
    }     
    public String modifierGSMMembre(Membre m,String gsmMem){
        
        m.setGsmMem(gsmMem);
        return "modification du numero de gsm du membre effectué";
    }
    public String modifierEmailMembre(Membre m,String email){
        
        m.setEmail(email);
        return "modification de l'email du membre effectué";
    }
    public String modifierNomDiscipline(Discipline d,String nom){
        d.setNomdiscipline(nom);
        return "Modification du nom de la discipline effectué";
    
    }
    public String modifierDescriptionNiveaux(Niveaux niv,String description){
        niv.setSignification(description);
        return "Modification de la description effectué";
    }
    /**
     * Fonction permettant de rechercher un objet dans une des listes par rapport à une chaine de caractère.
     * @param mot l'attribut "principal" qui est de type String d'une des classes à rechercher.
     * @param o permet de savoir quelle liste doit on utiliser
     * @return objet trouvé ou null si la méthode ne le trouve pas
     */
    public Object get(String mot,String mot2,Object o)
    {
        
        if(mot!=null){
            if(o instanceof Entreprise){
                    Entreprise ent=new Entreprise(mot);
                    int p=entreprise.indexOf(ent);
                    if(p>=0){
                        return entreprise.get(p);
                    }
                    else{
                        return null;
                    }
            }
            else if(o instanceof Projet){
                Projet p=new Projet(mot);
                    int c=projet.indexOf(p);
                    if(c>=0){
                        return projet.get(c);
                    }
                    else{
                        return null;
                    }
            }
            
            else if(o instanceof Membre){
                Membre m=null;
                Membre.MembreBuilder membreBuild=new Membre.MembreBuilder();
                membreBuild.setNomMem(mot).setPrenomMem(mot2);
                try{
                    m=membreBuild.build();
                    System.out.println(m);
                }
                catch(Exception e){
                    System.out.println("Erreur de création"+e);
                }
                    int c=membre.indexOf(m);
                    if(c>=0){
                        return membre.get(c);
                    }
                    else{
                        return null;
                    }
            }
            else if(o instanceof Discipline){
                Discipline d=new Discipline(mot);
                    int c=dis.indexOf(d);
                    if(c>=0){
                        return dis.get(c);
                    }
                    else{
                        return null;
                    }
            }
            
        }
        return null;
       
    }
    public Travail getTrav(Membre m){
        Travail t=new Travail(m);
        int c=trav.indexOf(t);
        if(c>=0){
            return trav.get(c);
        }
        else{
            return null;
        }
            
    }
    /**
     * Surcharge de la méthode get. Méthode de recherche par rapport à un numéro.
     * @param primary l'attribut "principal" qui est de type int d'une des classes à rechercher.
     * @param o permet de savoir quelle liste doit on utiliser
     * @return objet trouvé ou null si la méthode ne le trouve pas
     */
     public Object get(int primary,Object o)
    {
            //A verifier!!!!!!!!
            if(o instanceof Competence){
                    Competence competence=new Competence(primary);
                    int p=comp.indexOf(competence);
                    if(p>=0){
                        return comp.get(p);
                    }
                    else{
                        return null;
                    }
            }
            else if(o instanceof Niveaux){
                Niveaux p=new Niveaux(primary);
                    int c=niveau.indexOf(p);
                    if(c>=0){
                        return niveau.get(c);
                    }
                    else{
                        return null;
                    }
            }
            else if(o instanceof Temps){
                Temps t=new Temps(primary);
                    int c=temps.indexOf(t);
                    if(c>=0){
                        return temps.get(c);
                    }
                    else{
                        return null;
                    }
            }
            
            return null;
    }
     /**
      * Méthode pour supprimer un objet d'une liste
      * @param o objet à supprimer 
      */
    public boolean supprimer(Object o){
        boolean verite=true;
        if(o!=null){
            if(o instanceof Entreprise){
                verite=entreprise.remove(o);
            }
            else if(o instanceof Projet){
                verite=projet.remove(o);
            }
            else if(o instanceof Travail){
                verite=trav.remove(o);
            }
            else if(o instanceof Membre){
                verite=membre.remove(o);
            }
            else if(o instanceof Discipline){
                verite=dis.remove(o);
            }
            else if(o instanceof Competence){
                verite=comp.remove(o);
            }
            else if(o instanceof Niveaux){
                verite=niveau.remove(o);
            }
            else if(o instanceof Temps){
                verite=temps.remove(o);
            }
        }
        else{
            System.out.println("pas de suppression");
        }
        return verite;
    }    
    public List<Membre> listeMembreProjet(String m){
        List <Membre> listeMembre=new ArrayList<>();
        Projet p=new Projet(m);
        Object o=new Projet();
        o=get(m,"",p);
        if(!o.equals(p)){
            System.out.println("Ce projet n'existe pas");
            System.out.println(o);
            System.out.println(p);
            return null;
        }
            if(!membre.isEmpty()){
                System.out.println("Je ne suis pas vide");
                for(Travail tra:trav){
                        if(tra.getProj().equals(p)){
                            listeMembre.add(tra.getMem());
                        }
                }
            }
            else{
                System.out.println("Je ne suis  vide");
            }
        
        if(listeMembre.isEmpty()){ System.out.println("Il y a aucun membre");return null;
        }
        return listeMembre;
       
    }
    public List<Discipline> listeDisciplineProjet(String m){
        List <Discipline> listeDis=new ArrayList<>();
        Projet p=new Projet(m);
        Object o=new Projet();
        o=get(m,"",p);
        if(!o.equals(p)){
            System.out.println("Ce projet n'existe pas");
            System.out.println(o);
            System.out.println(p);
            return null;
        }
            if(!dis.isEmpty()){
                System.out.println("Je ne suis pas vide");
                for(Temps t:temps){
                        if(t.getProj().equals(p)){
                            listeDis.add(t.getDis());
                        }
                }
            }
            else{
                System.out.println("Je ne suis  vide");
            }
        
        if(listeDis.isEmpty()){ System.out.println("Il y a aucune discipline");return null;
        }
        return listeDis;
       
    }
    public List<Projet> listeProjetEntreprise(String nomEnt){
        List<Projet>listeProj=new ArrayList<>();
        Entreprise e=new Entreprise(nomEnt);
        Object o=new Entreprise();
        o=get(nomEnt,"",e);
        if(nomEnt==null)return listeProj;
        if(!o.equals(e)){
            return null;
        }
        if(!projet.isEmpty()) {
        
            for(Projet p:projet){
                   if(p.getEnt().equals(e)){
                       listeProj.add(p);
                   }
            }
        }
        else{
            System.out.println("Je ne suis pas vide");
        }
        if(listeProj.isEmpty()){
            System.out.println("Il n'y a aucun projet"); 
            return null;
        }
        return listeProj;
    }
    /**
     * getter de liste competences
     * @return la liste de competences
     */
    public List<Competence> getComp() {
        return comp;
    }
    /**
     * getter de la liste de disciplines
     * @return la liste de disciplines
     */
    public List<Discipline> getDis() {
        return dis;
    }
    /**
     * getter de la liste d'entreprises
     * @return la liste d'entreprises
     */
    public List<Entreprise> getEntreprise() {
        return entreprise;
    }
    /**
     * getter de la liste de membres
     * @return la liste de membres
     */
    public List<Membre> getMembre() {
        return membre;
    }
    /**
     * getter de la liste de niveaux
     * @return la liste de niveaux
     */
    public List<Niveaux> getNiveau() {
        return niveau;
    }
    /**
     * getter de la liste de projets
     * @return la liste de projets
     */
    public List<Projet> getProjet() {
        return projet;
    }
    /**
     * getter de la liste des temps
     * @return la liste des temps
     */
    public List<Temps> getTemps() {
        return temps;
    }
    /**
     * getter de la liste des travaux
     * @return liste des travaux
     */

    public List<Travail> getTrav() {
        return trav;
    }

    public void setProjet(List<Projet> projet) {
        this.projet = projet;
    }

    public void setTrav(List<Travail> trav) {
        this.trav = trav;
    }

    public void setTemps(List<Temps> temps) {
        this.temps = temps;
    }

    public void setComp(List<Competence> comp) {
        this.comp = comp;
    }
    
    public void personne(){
        //Pour tester mes classes
        entreprise=new ArrayList<>(Arrays.asList(new Entreprise("Fabricom","09898","rue pacqueret"),
                                                    new Entreprise("Condorcet","098098","Rue piv"),
                                                    new Entreprise ("Hopital","0999","Roiu")));
        /*projet=new ArrayList<>(Arrays.asList(new Projet("Projet Web", "1 juin 2018","4 juillet 2018"),
                                                new Projet("Projet java","2 janvier","17 fevrier"),
                                                new Projet("SGBD","14 juillet","21 juillet")));*/
        
        String nom = "Fiems";
        String prenom="Amélie";
        String gsm="0477880599";
        String email="rue du nord";
        

        Membre.MembreBuilder mb = new Membre.MembreBuilder();
        mb.setNomMem(nom).
                setPrenomMem(prenom).
                setGsm(gsm).
                setEmail(email);
                
        try {
            Membre m = mb.build();
        } catch (Exception e) {
            System.out.println("erreur de création " + e);
        }
    }
    public boolean modifCoutMax(Projet p, double coutMax){
        if(coutMax<0|| coutMax>1000000) return false;
        p.setCoutMax(coutMax);
        return true;
    }
    
}
