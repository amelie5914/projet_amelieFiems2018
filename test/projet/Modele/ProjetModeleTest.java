

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Modele;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ameliefiems
 */
public class ProjetModeleTest {
    
    public ProjetModeleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ajouter method, of class ProjetModele.
     */
    @Test
    public void testAjouter() {
        System.out.println("ajouter");
        Object o = new Entreprise();
        ProjetModele instance = new ProjetModele();
        String expResult = "entreprise ajoutée";
        String result = instance.ajouter(o);
        assertEquals(expResult, result);
        instance.supprimer(o);
        Object p = new Projet();
        expResult = "projet ajouté";
        result = instance.ajouter(p);
        assertEquals(expResult, result);
        instance.supprimer(p);
    }

    /**
     * Test of modifierNomEntreprise method, of class ProjetModele.
     */
    @Test
    public void testModifierNomEntreprise() {
        System.out.println("modifierNomEntreprise");
        Entreprise e = new Entreprise ("Podorcet","09098765","Rue du paradis 98");
        String nom = "Apple";
        ProjetModele instance = new ProjetModele();
        String expResult="Apple";
        instance.modifierNomEntreprise(e, nom);
        String result=e.getNom();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of modifierTelEntreprise method, of class ProjetModele.
     */
    @Test
    public void testModifierTelEntreprise() {
        System.out.println("modifierTelEntreprise");
        Entreprise e = new Entreprise ("Podorcet","09098765","Rue du paradis 98");
        String tel = "067856432";
        ProjetModele instance = new ProjetModele();
        String expResult="067856432";
        instance.modifierTelEntreprise(e, tel);
        String result=e.getTel();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of modifierAdEntreprise method, of class ProjetModele.
     */
    @Test
    public void testModifierAdEntreprise() {
        System.out.println("modifierAdEntreprise");
        Entreprise e = new Entreprise ("Podorcet","09098765","Rue du paradis 98");
        String ad = "Rue du coq 87";
        ProjetModele instance = new ProjetModele();
        String expResult="Rue du coq 87";
        instance.modifierAdEntreprise(e, ad);
        String result=e.getAdresse();
        assertEquals(expResult, result);
    }

    /**
     * Test of modifierTitreProjet method, of class ProjetModele.
     */
    @Test
    public void testModifierTitreProjet() {
        System.out.println("modifierTitreProjet");
        Projet p = new Projet ("maquette pour l'A380", "09/12/17", "09/03/18");
        String titre = "A380";
        ProjetModele instance = new ProjetModele();
        String expResult="A380";
        instance.modifierTitreProjet(p, titre);
        String result=p.getTitre();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of modifierDateDebutProjet method, of class ProjetModele.
     */
    @Test
    public void testModifierDateDebutProjet() {
        System.out.println("modifierDateDebutProjet");
        Projet p = new Projet ("maquette pour l'A380", "09/12/17", "09/03/18");
        String date = "09/01/17";
        ProjetModele instance = new ProjetModele();
        String expResult="09/01/17";
        instance.modifierDateDebutProjet(p, date);
        String result=p.getDateDebut();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of modifierDateFinProjet method, of class ProjetModele.
     */
    @Test
    public void testModifierDateFinProjet() {
        System.out.println("modifierDateFinProjet");
        Projet p = new Projet ("maquette pour l'A380", "09/12/17", "09/03/18");
        String date = "09/05/17";
        ProjetModele instance = new ProjetModele();
        String expResult="09/05/17";
        instance.modifierDateFinProjet(p, date);
        String result=p.getDateFin();
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of get method, of class ProjetModele.
     */
    @Test
    public void testGet_String_Object() {
        System.out.println("get string");
        Entreprise e = new Entreprise ("Podorcet","09098765","Rue du paradis 98");
        ProjetModele instance = new ProjetModele();
        instance.ajouter(e);
        String mot = "Podorcet";
        Object expResult = e;
        Object result = instance.get(mot,"", e);
        assertEquals(expResult, result);
        
        
        Projet p = new Projet ("maquette pour l'A380", "09/12/17", "09/03/18");
        instance.ajouter(p);
        mot="maquette pour l'A380";
        expResult=p;
        result=instance.get(mot,"",p);
        assertEquals(expResult,result);
        instance.supprimer(p);
        instance.supprimer(e);
    }

    /**
     * Test of get method, of class ProjetModele.
     */
    @Test
    public void testGet_int_Object() {
        System.out.println("get int");
        Temps t=new Temps(30);
        int primary = 30;
        Object o = t;
        ProjetModele instance = new ProjetModele();
        instance.ajouter(t);
        Object expResult = t;
        Object result = instance.get(primary, o);
        assertEquals(expResult, result);
        instance.supprimer(o);
        
        Competence c=new Competence(20);
        primary=20;
        o=c;
        instance.ajouter(c);
        expResult=c;
        result=instance.get(primary, o);
        assertEquals(expResult,result);
        instance.supprimer(o);
    }

    /**
     * Test of supprimer method, of class ProjetModele.
     */
    @Test
    public void testSupprimer() {
        System.out.println("supprimer");
        Projet p = new Projet ("maquette pour l'A380", "09/12/17", "09/03/18");
        Object o = p;
        ProjetModele instance = new ProjetModele();
        instance.ajouter(p);
        instance.supprimer(p);
        Object result=instance.get("maquette pour l'A380","", p);
        assertNull(result);
    }

    /**
     * Test of getComp method, of class ProjetModele.
     */
    @Test
    public void testGetComp() {
        System.out.println("getComp");
        ProjetModele instance = new ProjetModele();
        Competence c=new Competence(10);
        Competence c2=new Competence(20);
        
        List<Competence> expResult = new ArrayList();
        expResult.add(c);expResult.add(c2);
        instance.ajouter(c);instance.ajouter(c2);
        List<Competence> result = instance.getComp();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDis method, of class ProjetModele.
     */
    @Test
    public void testGetDis() {
        System.out.println("getDis");
        ProjetModele instance = new ProjetModele();
        Discipline d=new Discipline("Java");
        Discipline d1=new Discipline("C");
        
        List<Discipline> expResult = new ArrayList();
        expResult.add(d);expResult.add(d1);
        instance.ajouter(d);instance.ajouter(d1);
        List<Discipline> result = instance.getDis();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntreprise method, of class ProjetModele.
     */
    @Test
    public void testGetEntreprise() {
        System.out.println("getEmp");
        ProjetModele instance = new ProjetModele();
        Entreprise e=new Entreprise("Asos");
        Entreprise e1=new Entreprise("Fabricom");
        
        List<Entreprise> expResult=new ArrayList();
        instance.ajouter(e);instance.ajouter(e1);
        expResult.add(e);expResult.add(e1);
        List<Entreprise> result = instance.getEntreprise();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMembre method, of class ProjetModele.
     */
    @Test
    public void testGetMembre() {
        System.out.println("getMembre");
        ProjetModele instance = new ProjetModele();
        Membre m=new Membre("Fiems","Amélie");
        Membre m1=new Membre("Tomsen","Alice");
        
        List<Membre> expResult = new ArrayList();
        expResult.add(m);expResult.add(m1);
        instance.ajouter(m);instance.ajouter(m1);
        List<Membre> result = instance.getMembre();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNiveau method, of class ProjetModele.
     */
    @Test
    public void testGetNiveau() {
        System.out.println("getNiveau");
        ProjetModele instance = new ProjetModele();
        Niveaux n=new Niveaux(50);
        Niveaux n1=new Niveaux(100);
        
        List<Niveaux> expResult = new ArrayList();
        expResult.add(n);expResult.add(n1);
        instance.ajouter(n);instance.ajouter(n1);
        List<Niveaux> result = instance.getNiveau();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getProjet method, of class ProjetModele.
     */
    @Test
    public void testGetProjet() {
        System.out.println("getProjet");
        ProjetModele instance = new ProjetModele();
        Projet p=new Projet("Site web");
        Projet p1=new Projet("Base de donnée des clients");
        
        List<Projet> expResult = new ArrayList();
        expResult.add(p);expResult.add(p1);
        instance.ajouter(p);instance.ajouter(p1);
        List<Projet> result = instance.getProjet();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getTemps method, of class ProjetModele.
     */
    @Test
    public void testGetTemps() {
        System.out.println("getTemps");
        ProjetModele instance = new ProjetModele();
        Temps t=new Temps(20);
        Temps t1=new Temps(30);
        
        List<Temps> expResult = new ArrayList();
        expResult.add(t);expResult.add(t1);
        instance.ajouter(t);instance.ajouter(t1);
        List<Temps> result = instance.getTemps();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getTrav method, of class ProjetModele.
     */
    @Test
    public void testGetTrav() {
        System.out.println("getTrav");
        ProjetModele instance = new ProjetModele();
        Travail t=new Travail("12/09/09");
        Travail t1=new Travail("12/06/16");
        
        List<Travail> expResult = new ArrayList();
        expResult.add(t);expResult.add(t1);
        instance.ajouter(t);instance.ajouter(t1);
        List<Travail> result = instance.getTrav();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of personne method, of class ProjetModele.
     */
    //@Test
    public void testPersonne() {
        System.out.println("personne");
        ProjetModele instance = new ProjetModele();
        instance.personne();
        fail("The test case is a prototype.");
    }
    @Test
    public void testModifCoutMax(){
        System.out.println("testModifCoutMax");
        Projet p = new Projet ("maquette pour l'A380", "09/12/17", "09/03/18");
        //test quand la fonction retourne true et je teste si setCoutMax a été exécuté correctement
        ProjetModele instance = new ProjetModele();
        double expResult=100;
        assertTrue(instance.modifCoutMax(p, 100));
        double result=p.getCoutMax();
        assertEquals(result,expResult,0.0);
        
        //test quand la fonction retourne false
        
        assertFalse(instance.modifCoutMax(p, -1));
        assertFalse(instance.modifCoutMax(p,10000001));
    }
    
}