/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Vue;
import java.util.Collection;
import java.util.Scanner;
import projet.Modele.*;

/**
 *
 * @author ameliefiems
 */
public class ProjetVue {
    private Scanner sc = new Scanner(System.in);
    public int menu(){
        System.out.println("1.Entreprise\n2.Projet\n3.Membre\n4.Travail\n5.Disciplines\n6.Temps\n7.Compétence\n8.Niveaux");
        int choix=0;
        try{
            choix=sc.nextInt();
            sc.skip("\n");
        }
        catch(NumberFormatException e){
            System.out.println("Nombre invalide!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return choix;
    }
    public int menuEntreprise(){
        System.out.println("ENTREPRISE\n1. Ajouter une entreprise\n2. Recherche de entreprise\n3.Modification entreprise\n4.Liste entreprise\n5.Suppresion entreprise\n6.liste des projet d'une entreprise ");
        int choix=0;
        try{
            choix=sc.nextInt();
            sc.skip("\n");
        }
        catch(NumberFormatException e){
            System.out.println("Nombre invalide!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return choix;
    }
    public int menuProjet(){
        System.out.println("PROJET\n1.Ajout d'un projet\n2.Recherche d'un projet\n 3.Modification du titre\n4.Liste du projet\n5.Suppresion projet \n6.Liste de tous les membres d'un projet\n7. Ajouter un membre à un projet\n8. AJouter une discipline à un projet\n9 Liste de toutes les discplines d'un projet");
        int choix=0;
        try{
            choix=sc.nextInt();
            sc.skip("\n");
        }
        catch(NumberFormatException e){
            System.out.println("Nombre invalide!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return choix;
    }
    public int menuEntrepriseModif(){
        System.out.println("MODIFICATION\n1.Nom\n2.Adresse\n3.Telephone");
        int choix=0;
        try{
            choix=sc.nextInt();  
            sc.skip("\n");
        }
        catch(NumberFormatException e){
            System.out.println("Nombre invalide!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return choix;
    }
    public int menuProjetModif(){
        System.out.println("MODIFICATION\n1.Titre\n2. La date du debut\n3. La date de fin");
        int choix=0;
        try{
            choix=sc.nextInt();  
            sc.skip("\n");
        }
        catch(NumberFormatException e){
            System.out.println("Nombre invalide!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return choix;
    }
    public int menuMembre(){
        System.out.println("MEMBRE\n1. AJouter un membre\n2. Recherche d'un membre\n3.Modification de membre\nn4.Liste des membres \n5.Suppression membre");
        int choix=0;
        try{
            choix=sc.nextInt();  
            sc.skip("\n");
        }
        catch(NumberFormatException e){
            System.out.println("Nombre invalide!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return choix;
    }
    public int menuDiscipline(){
        System.out.println("DISCIPLINE\n1. AJouter une discipline\n2. Recherche d'une discipline\n3.Modification d'une discipline\nn4.Liste des différentes disciplines \n5.Suppression discipline");
        int choix=0;
        try{
            choix=sc.nextInt();  
            sc.skip("\n");
        }
        catch(NumberFormatException e){
            System.out.println("Nombre invalide!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return choix;
    }
    public int menuNiveaux(){
        System.out.println("NIVEAUX\n1. AJouter un niveau\n2. Recherche d'un niveau\n3.Modification d'un niveau\nn4.Liste des différents niveau \n5.Suppression niveau");
        int choix=sc.nextInt();
          sc.skip("\n");
        
        return choix;
    }
    public int menuMembreModif(){
        System.out.println("MODIFICATION\n1.GSM\n2.email");
        int choix=0;
        try{
            choix=sc.nextInt();  
            sc.skip("\n");
        }
        catch(NumberFormatException e){
            System.out.println("Nombre invalide!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return choix;
    }
    public int menuCreerProjetMembre(){
        System.out.println("Creation Projet\n1.Creer un nouveau membre\n2.Rechercher un nouveau membre");
        int choix=0;
        try{
            choix=sc.nextInt();  
            sc.skip("\n");
        }
        catch(NumberFormatException e){
            System.out.println("Nombre invalide!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return choix;
    }
    public int menuCreerProjetDiscipline(){
        System.out.println("Creation Projet\n1.Creer une nouvelle discipline\n2.Rechercher une nouvelle discipline");
        int choix=0;
        try{
            choix=sc.nextInt();  
            sc.skip("\n");
        }
        catch(NumberFormatException e){
            System.out.println("Nombre invalide!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return choix;
    }
    public int menuCreerProjetEntreprise(){
        System.out.println("Creation Projet\n1.Creer une nouvelle entreprise\n2.Rechercher une nouvelle entreprise");
        int choix=0;
        try{
            choix=sc.nextInt();  
            sc.skip("\n");
        }
        catch(NumberFormatException e){
            System.out.println("Nombre invalide!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return choix;
    }
    public Entreprise saisieEntreprise(){
        String tel;
        String nom=saisie("Entrez un nom d'entreprise");
        do{
            tel=saisie("Entrez un numero de telephone");
        }
        while(!tel.matches("^[0-9]{12}$"));
        String adresse;
        do{
            adresse=saisie("Entrez une adresse");
        }
        while(adresse.matches("^[[:alnum:]]{1,70}$"));
        Entreprise e=new Entreprise(nom,tel,adresse);
        System.out.println(e);
        return e;
    }
    public Membre saisieMembre(){
        Membre membre=null;
        String nom;
        String email;
        String gsm;
        String prenom;
        do{
            nom=saisie("Entrez le nom du membre");
        }while(nom.equals("")); 
        do{
            prenom=saisie("Entrez son prénom");
        }
        while(prenom.equals(""));
        do{
            gsm=saisie("Entrez un numero de telephone");
        }
        while(!gsm.matches("^[0-9]{12}$"));
        do{
            email=saisie("Entrez son email");
        }
        while(!email.matches("^[A-Za-z0-9]+\\.[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z]{2,3}$"));
        
        //Membre m=new Membre(nom,prenom,gsm,email);
        Membre.MembreBuilder membreBuild=new Membre.MembreBuilder();
        membreBuild.setNomMem(nom).setPrenomMem(prenom).setGsm(gsm).setEmail(email);
        try{
            membre=membreBuild.build();
            
        }
        catch(Exception e){
            System.out.println("Erreur de création"+e);
        }
        return membre;
    }
    public ProjetGeneral saisieProjet(int choix){
        sc.nextLine();
        String dateDebut,dateFin,titre;
        do{
            titre=saisie("Entrez le titre du projet");
        }while(titre.equals(""));
        do{
            dateDebut=saisie("Entrez la date de debut du projet");
        }
        while(!dateDebut.matches("^[0-9]{2}-[0-9]{2}-[0-9]{4}$"));
        
        do{
            dateFin=saisie("Entrez la date de fin du projet");
        }
        while(!dateFin.matches("^[0-9]{2}-[0-9]{2}-[0-9]{4}$"));
        Entreprise client=new Entreprise();
        ProjetGeneral p;
        if(choix==1){
            p=new ProjetSimple(titre,dateDebut,dateFin,client);
        }
        else{
            p=new Sous_projet(titre,dateDebut,dateFin,client);
        }
        return p;
    }
    public Travail saisieTravail(ProjetGeneral p,Membre m){
        String date;
        int taux=0;
        do{
            date=saisie("Entrez la date d'engagement dans le projet du membre");
        }
        while(!date.matches("^[0-9]{2}-[0-9]{2}-[0-9]{4}$"));
        try{
            taux=saisieInt("Entrez le pourcentage du temps qu'il y consacre");
        }
        catch(NumberFormatException e){
            System.out.println("Nombre invalide!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Travail t=new Travail(date,taux,p,m);
        return t;
    }
    public Discipline saisieDiscipline(){
        sc.nextLine();
        String nom;
        do{
            nom=saisie("Entrez le nom de la discipline");
        }
        while(nom.equals(""));
        Discipline d=new Discipline(nom);
        return d;
    }
    public Temps saisieTemps(ProjetGeneral proj,Discipline dis){
        int jhomme=0;
        try{
            jhomme=saisieInt("Entrez l'investissement en temps (jour/homme) ");
        }
        catch(NumberFormatException e){
            System.out.println("Nombre invalide!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Temps t=new Temps(jhomme,proj,dis);
        return t;
    }
    public Niveaux saisieNiveaux(){
        int degre=0;
        try{
            degre=saisieInt("Entrez le degré de compétence (1 :peu compétent,2 :moyennement compétent,3 :très compétent) ");
        
        }catch(NumberFormatException e){
            System.out.println("Nombre invalide!");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String signification;
        do{
            signification=saisie("Entrez la signification de ce degré");
        }
        while(signification.equals(""));
        Niveaux n=new Niveaux(degre,signification);
        return n;
    }
    public String saisie(String msg){
        System.out.println(msg);
        String m=sc.nextLine();
          sc.skip("\n");
        //System.out.println(m);
        return m;
    }
    public String saisie(){
       // sc.nextLine();
        String m=sc.nextLine();
          sc.skip("\n");
        //System.out.println(m);
        return m;
    }
    
    public int saisieInt(String m){
        System.out.println(m);
        int i=sc.nextInt();
          sc.skip("\n");
        return i;
        
    }
    public void affListe(Collection liste){
        int i=1;
        System.out.println("test dans aaffliste");
        if(liste!=null){
        for(Object o: liste){
            System.out.println((i++)+" "+o);
        }
        }
        else{
            System.out.println("Elle est vide");
        }
    }
    public void affMessage(String m){
        System.out.println(m);
    }
    
    
}
