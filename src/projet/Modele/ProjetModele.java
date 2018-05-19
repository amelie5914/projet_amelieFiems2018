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

    private List<Competence> comp = new ArrayList<>();
    private List<Discipline> dis = new ArrayList<>();
    private List<Entreprise> entreprise = new ArrayList<>();
    private List<Membre> membre = new ArrayList<>();
    private List<Niveaux> niveau = new ArrayList<>();
    private List<ProjetGeneral> projet = new ArrayList<>();
    private List<Temps> temps = new ArrayList<>();
    private List<Travail> trav = new ArrayList<>();

    /**
     * Constructeur par défaut
     */
    public ProjetModele() {

    }

    /**
     * Méthode permettant l'ajout d'un objet à une des listes qui se trouve en
     * atribut.
     *
     * @param o objet à ajouter
     * @return une chaine de caractère qui décrit l'état de l'ajout
     */
    public String ajouter(Object o) {
        String message = "";
        List l = null;
        if (o != null) {
            if (o instanceof Entreprise ) {
                if (!entreprise.contains(o)) {
                    l = entreprise;
                    message = "entreprise ajouté";
                } else {
                    message = "entreprise déjà ajouté";
                }
            } else if (o instanceof Competence) {
                if (!comp.contains(o)) {
                    l = comp;
                    message = "competence ajouté";
                } else {
                    message = "competence déjà ajouté";
                }
            } else if (o instanceof Discipline) {
                if (!dis.contains(o)) {
                    l = dis;
                    message = "discipline ajouté";
                } else {
                    message = "discipline déjà mise";
                }
            } else if (o instanceof Membre) {
                if (!membre.contains(o)) {
                    l = membre;
                    message = "membre ajouté";
                } else {
                    message = "membre déjà enregistré";
                }
            } else if (o instanceof Niveaux) {
                if (!niveau.contains(o)) {
                    l = niveau;
                    message = "niveau ajouté";
                } else {
                    message = "niveau déjà enregistré";
                }
            } else if (o instanceof ProjetSimple || o instanceof Sous_projet) {
                if (!projet.contains(o)) {
                    l = projet;
                    message = "projet ajouté";
                } else {
                    message = "projet déjà enregistré";
                }
            } else if (o instanceof Temps) {
                if (!temps.contains(o)) {
                    l = temps;
                    message = "Temps ajouté";
                } else {
                    message = "Temps déjà ajouté";
                }
            } else if (o instanceof Travail) {
                if (!trav.contains(o)) {
                    l = trav;
                    message = "Travail ajouté";
                } else {
                    message = "travail déjà enregistré";
                }
            }

        } else {
            message = null;
        }
        l.add(o);
        return message;

    }

    /**
     * Méthode permettant de changer le nom de l'entreprise du client.
     *
     * @param e entreprise dont on désire changer le nom.
     * @param nom le nouveau nom.
     * @return chaine de caractère qui décrit l'état de la modification.
     */
    public String modifierNomEntreprise(Entreprise e, String nom) {

        e.setNom(nom);
        return "modification du nom effectué";
    }

    /**
     * Méthode permettant de changer le numero de telephone de l'entreprise du
     * client.
     *
     * @param e entreprise dont on désire changer le numéro de téléphone.
     * @param tel le nouveau numéro de téléphone
     * @return chaine de caractère qui décrit l'état de la modification
     */
    public String modifierTelEntreprise(Entreprise e, String tel) {

        e.setTelEnt(tel);
        return "modification du numero de telephone effectué";
    }

    /**
     * Méthode permettant de changer l'adresse de l'entreprise du client.
     *
     * @param e entreprise dont on désire changer l'adresse.
     * @param a nouvelle adresse.
     * @return chaine de caractère qui décrit l'état de la modification.
     */
    public String modifierAdEntreprise(Entreprise e, String a) {
        e.setAdresse(a);
        return "modification d'adresse effectué";
    }

    /**
     * Méthode permettant de changer le nom d'un projet
     *
     * @param p projet dont on désire changer le nom
     * @param titre nouveau nom
     * @return chaine de caractère qui décrit l'état de la modification
     */
    public String modifierTitreProjet(ProjetGeneral p, String titre) {
        p.setTitre(titre);
        return "modification de titre effectué";
    }

    /**
     * Méthode permettant de changer la date du début d'un projet
     *
     * @param p projet dont on désire changer la date de début.
     * @param date nouvelle date de début
     * @return chaine de caractère qui décrit l'état de la modification
     */
    public String modifierDateDebutProjet(ProjetGeneral p, String date) {
        p.setDateDebut(date);
        return "modification de date du début du projet effectué";
    }

    /**
     * Méthode permettant de changer la date de fin d'un projet
     *
     * @param p projet dont on désire changer la date de fin
     * @param date nouvelle date de fin
     * @return chaine de caractère qui décrit l'état de la modification
     */
    public String modifierDateFinProjet(ProjetGeneral p, String date) {
        p.setDateFin(date);
        return "modification de date du début du projet effectué";
    }

    public String modifierGSMMembre(Membre m, String gsmMem) {

        m.setGsmMem(gsmMem);
        return "modification du numero de gsm du membre effectué";
    }

    public String modifierEmailMembre(Membre m, String email) {

        m.setEmail(email);
        return "modification de l'email du membre effectué";
    }

    public String modifierNomDiscipline(Discipline d, String nom) {
        d.setNomdiscipline(nom);
        return "Modification du nom de la discipline effectué";

    }

    public String modifierDescriptionNiveaux(Niveaux niv, String description) {
        niv.setSignification(description);
        return "Modification de la description effectué";
    }

    /**
     * Fonction permettant de rechercher un objet dans une des listes par
     * rapport à une chaine de caractère.
     *
     * @param mot l'attribut "principal" qui est de type String d'une des
     * classes à rechercher.
     * @param o permet de savoir quelle liste doit on utiliser
     * @return objet trouvé ou null si la méthode ne le trouve pas
     */
    public Object get(String mot, String mot2, Object o) {

        if (mot != null) {
            if (o instanceof Entreprise) {
                Entreprise ent = new Entreprise(mot);
                int p = entreprise.indexOf(ent);
                if (p >= 0) {
                    return entreprise.get(p);
                } else {
                    return null;
                }
            } else if (o instanceof Membre) {
                Membre.MembreBuilder membreBuild = new Membre.MembreBuilder();
                membreBuild.setNomMem(mot).setPrenomMem(mot2);
                try {
                    Membre m = membreBuild.build();
                    System.out.println(m);

                    int c = membre.indexOf(m);
                    if (c >= 0) {

                        System.out.println("Creation ok pour membre!!");
                        return membre.get(c);
                    } else {
                        return null;
                    }
                } catch (Exception e) {
                    System.out.println("Erreur de création" + e);
                }
            } else if (o instanceof Discipline) {
                Discipline d = new Discipline(mot);
                int c = dis.indexOf(d);
                if (c >= 0) {
                    return dis.get(c);
                } else {
                    return null;
                }
            }

        }
        return null;

    }

    public ProjetGeneral getProjet(ProjetGeneral p, String m) {

        if (p instanceof ProjetSimple) {
            p = new ProjetSimple(m);
        } else {
            p = new Sous_projet(m);
        }
        int c = projet.indexOf(p);
        if (c >= 0) {
            return projet.get(c);
        } else {
            return null;
        }
    }

    public Travail getTrav(Membre m) {
        Travail t = new Travail(m);
        int c = trav.indexOf(t);
        if (c >= 0) {
            return trav.get(c);
        } else {
            return null;
        }

    }

    /**
     * Surcharge de la méthode get. Méthode de recherche par rapport à un
     * numéro.
     *
     * @param primary l'attribut "principal" qui est de type int d'une des
     * classes à rechercher.
     * @param o permet de savoir quelle liste doit on utiliser
     * @return objet trouvé ou null si la méthode ne le trouve pas
     */
    public Object get(int primary, Object o) {
        //A verifier!!!!!!!!
        if (o instanceof Competence) {
            Competence competence = new Competence(primary);
            int p = comp.indexOf(competence);
            if (p >= 0) {
                return comp.get(p);
            } else {
                return null;
            }
        } else if (o instanceof Niveaux) {
            Niveaux p = new Niveaux(primary);
            int c = niveau.indexOf(p);
            if (c >= 0) {
                return niveau.get(c);
            } else {
                return null;
            }
        } else if (o instanceof Temps) {
            Temps t = new Temps(primary);
            int c = temps.indexOf(t);
            if (c >= 0) {
                return temps.get(c);
            } else {
                return null;
            }
        }

        return null;
    }

    /**
     * Méthode pour supprimer un objet d'une liste
     *
     * @param o objet à supprimer
     */
    public boolean supprimer(Object o) {
        boolean verite = true;
        if (o != null) {
            if (o instanceof Entreprise) {
                verite = entreprise.remove(o);
            } else if (o instanceof ProjetSimple || o instanceof Sous_projet) {
                verite = projet.remove(o);
            } else if (o instanceof Travail) {
                verite = trav.remove(o);
            } else if (o instanceof Membre) {
                verite = membre.remove(o);
            } else if (o instanceof Discipline) {
                verite = dis.remove(o);
            } else if (o instanceof Competence) {
                verite = comp.remove(o);
            } else if (o instanceof Niveaux) {
                verite = niveau.remove(o);
            } else if (o instanceof Temps) {
                verite = temps.remove(o);
            }
        } else {
            System.out.println("pas de suppression");
        }
        return verite;
    }

    public int journeeHommeTotalProjet(ProjetGeneral p) {
        int journeeHommeTotalProjet = 0;
        if (p == null) {
            return 0;
        }
        if (!temps.isEmpty()) {
            journeeHommeTotalProjet = temps.stream().filter((t) -> (t.getProj().equals(p))).map((t) -> t.getjHomme()).reduce(journeeHommeTotalProjet, Integer::sum);
        }
        return journeeHommeTotalProjet;
    }

    public List<Membre> listeMembreProjet(String m, ProjetGeneral p) {
        List<Membre> listeMembre = new ArrayList<>();
        ProjetGeneral pg;
        pg = getProjet(p, m);
        if (pg == null) {
            System.out.println("Ce projet n'existe pas");
            return null;
        }
        if (!membre.isEmpty()) {
            System.out.println("Je ne suis pas vide");
            trav.stream().filter((tra) -> (tra.getProj().equals(p))).forEachOrdered((tra) -> {
                listeMembre.add(tra.getMem());
            });
        } else {
            System.out.println("Je ne suis vide");
        }

        if (listeMembre.isEmpty()) {
            System.out.println("Il y a aucun membre");
            return null;
        }
        return listeMembre;

    }

    public List<Discipline> listeDisciplineProjet(String m, ProjetGeneral p) {
        List<Discipline> listeDis = new ArrayList<>();
        Discipline d = new Discipline();
        ProjetGeneral pg = getProjet(p, m);
        if (pg == null) {
            System.out.println("Ce projet n'existe pas");
            System.out.println(p);
            return null;
        }
        if (!dis.isEmpty()) {
            System.out.println("Je ne suis pas vide");
            temps.stream().filter((t) -> (t.getProj().equals(p))).filter((t) -> (get(t.getDis().getNomdiscipline(), "", d) != null)).forEachOrdered((t) -> {
                listeDis.add(t.getDis());
            }); //Pour éviter qu'il recopie deux fois la meme discipline dans la liste discipline
        } else {
            System.out.println("Je ne suis  vide");
        }

        if (listeDis.isEmpty()) {
            System.out.println("Il y a aucune discipline");
            return null;
        }
        return listeDis;

    }

    public List<ProjetGeneral> listeProjetEntreprise(String nomEnt) {
        List<ProjetGeneral> listeProj = new ArrayList<>();
        Entreprise e = new Entreprise(nomEnt);
        Object o = new Entreprise();
        o = get(nomEnt, "", e);
        if (nomEnt == null) {
            return listeProj;
        }
        if (!o.equals(e)) {
            return null;
        }
        if (!projet.isEmpty()) {

            projet.stream().filter((p) -> (p.getEnt().equals(e))).forEachOrdered((p) -> {
                listeProj.add(p);
            });
        } else {
            System.out.println("Je ne suis pas vide");
        }
        if (listeProj.isEmpty()) {
            System.out.println("Il n'y a aucun projet");
            return null;
        }
        return listeProj;
    }

    public String ajoutSousProjet(Sous_projet sp, ProjetGeneral pg) {
        sp.ajoutPG(pg);
        return "ajout des projets ";
    }

    /**
     * getter de liste competences
     *
     * @return la liste de competences
     */
    public List<Competence> getComp() {
        return comp;
    }

    /**
     * getter de la liste de disciplines
     *
     * @return la liste de disciplines
     */
    public List<Discipline> getDis() {
        return dis;
    }

    /**
     * getter de la liste d'entreprises
     *
     * @return la liste d'entreprises
     */
    public List<Entreprise> getEntreprise() {
        return entreprise;
    }

    /**
     * getter de la liste de membres
     *
     * @return la liste de membres
     */
    public List<Membre> getMembre() {
        return membre;
    }

    /**
     * getter de la liste de niveaux
     *
     * @return la liste de niveaux
     */
    public List<Niveaux> getNiveau() {
        return niveau;
    }

    /**
     * getter de la liste de projets
     *
     * @return la liste de projets
     */
    public List<ProjetGeneral> getProjet() {
        return projet;
    }

    /**
     * getter de la liste des temps
     *
     * @return la liste des temps
     */
    public List<Temps> getTemps() {
        return temps;
    }

    /**
     * getter de la liste des travaux
     *
     * @return liste des travaux
     */

    public List<Travail> getTrav() {
        return trav;
    }

    public void setProjet(List<ProjetGeneral> projet) {
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

    public void personne() {
        //Pour tester mes classes
        entreprise = new ArrayList<>(Arrays.asList(new Entreprise("Fabricom", "09898", "rue pacqueret"),
                new Entreprise("Condorcet", "098098", "Rue piv"),
                new Entreprise("Hopital", "0999", "Roiu")));
        /*projet=new ArrayList<>(Arrays.asList(new Projet("Projet Web", "1 juin 2018","4 juillet 2018"),
                                                new Projet("Projet java","2 janvier","17 fevrier"),
                                                new Projet("SGBD","14 juillet","21 juillet")));*/

        String nom = "Fiems";
        String prenom = "Amélie";
        String gsm = "0477880599";
        String email = "rue du nord";

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

    public boolean modifCoutMax(ProjetGeneral p, double coutMax) {
        if (coutMax < 0 || coutMax > 1000000) {
            return false;
        }
        p.setCoutMax(coutMax);
        return true;
    }

}
