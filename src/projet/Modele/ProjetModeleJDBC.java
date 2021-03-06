/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Modele;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import my_connections.DBConnection;

/**
 *
 * @author ameliefiems
 */
public class ProjetModeleJDBC extends ProjetModele {

    Connection dbConnect;

    public ProjetModeleJDBC() {
        dbConnect = DBConnection.getConnection();
        if (dbConnect == null) {
            System.err.println("erreur de connexion => arrêt du pgm");
            System.exit(1);//Pour fermer un programme. quand un programme se ferme normalement alors c'est 0
        }
    }
   
    public void close() {
        try {
            dbConnect.close();
        } catch (Exception e) {
            System.err.println("erreur lors de la fermeture de la connexion " + e);
        }
    }

    @Override
    public String ajouter(Object o) {
        String query = "";
        String query1 = "";
        String message = "";
        String msg = "";
        int m = 0;
        if (o != null) {
            if (o instanceof Entreprise) {
                query = "insert into ENTREPRISE(NOMENT,TELENT,ADRESSE) values(?,?,?)";
                try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                    dbConnect.setAutoCommit(true);
                    pstm.setString(1, ((Entreprise) o).getNom());
                    pstm.setString(3, ((Entreprise) o).getAdresse());
                    pstm.setString(2, ((Entreprise) o).getTel());
                    int n = pstm.executeUpdate();
                    System.out.println("n vaut " + n);
                    if (n == 1) {
                        message = "ajout entreprise effectué";
                    } else {
                        message = "ajout entreprise non effectué";
                    }
                } catch (SQLException e) {
                    message = "erreur lors de l'ajout de l'entreprise " + e;
                } catch (Exception e) {
                    message = e.getMessage();
                }

            } else if (o instanceof Competence) {

                int membre = rechercheMembre((Competence) o);
                int niveau = rechercheNiveau((Competence) o);
                int dis = rechercheDiscipline((Competence) o);
                query = "insert into COMPETENCE(IDNIV,IDMEM,IDDIS) values(?,?,?) ";
                try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                    dbConnect.setAutoCommit(true);
                    pstm.setInt(1, niveau);
                    pstm.setInt(2, membre);
                    pstm.setInt(3, dis);
                    int n = pstm.executeUpdate();
                    if (n == 1) {
                        message = "ajout competence effectué";
                    } else {
                        message = "ajout competence non effectué";
                    }
                } catch (SQLException e) {
                    message = e.getMessage();

                } catch (Exception e) {
                    message = e.getMessage();
                }
            } else if (o instanceof Discipline) {
                query = "insert into DISCIPLINE (NOMDIS) values (?)";
                try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                    dbConnect.setAutoCommit(true);
                    pstm.setString(1, ((Discipline) o).getNomdiscipline());
                    int n = pstm.executeUpdate();
                    if (n == 1) {
                        message = "ajout discipline effectué";
                    } else {
                        message = "ajout discipline non effectué";
                    }
                } catch (SQLException e) {
                    message = e.getMessage();

                } catch (Exception e) {
                    message = e.getMessage();
                }
            } else if (o instanceof Membre) {
                query = "insert into MEMBRE(NOMMEM,PRENOMMEN,TELMEM,EMAIL) values (?,?,?,?) ";
                try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                    dbConnect.setAutoCommit(true);
                    pstm.setString(1, ((Membre) o).getNomMem());
                    pstm.setString(2, ((Membre) o).getPrenomMem());
                    pstm.setString(3, ((Membre) o).getGsmMem());
                    pstm.setString(4, ((Membre) o).getEmail());
                    int n = pstm.executeUpdate();
                    if (n == 1) {
                        message = "ajout membre effectué";
                    } else {
                        message = "ajout membre non effectué";
                    }
                } catch (SQLException e) {
                    message = e.getMessage();
                } catch (Exception e) {
                    message = e.getMessage();
                }

            } else if (o instanceof Niveaux) {
                query = "insert into NIVEAU(DEGRE,SIGNIFICATION) values (?,?)";
                try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                    dbConnect.setAutoCommit(true);
                    pstm.setString(2, ((Niveaux) o).getSignification());
                    pstm.setInt(1, ((Niveaux) o).getDegre());
                    int n = pstm.executeUpdate();
                    if (n == 1) {
                        message = "ajout niveau effectué";
                    } else {
                        message = "ajout niveau non effectué";
                    }
                    dbConnect.commit();
                } catch (SQLException e) {
                    message = e.getMessage();

                } catch (Exception e) {
                    message = e.getMessage();
                }
            } else if (o instanceof ProjetSimple || o instanceof Sous_projet) {
                
                ResultSet rs = null;
                int ident = 0;
                if (o instanceof ProjetSimple) {
                    
                    if (((ProjetSimple) o).getEnt() != null) {
                        query = "select ident from entreprise where noment=?";
                        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                            pstm.setString(1, ((ProjetSimple) o).getEnt().getNom());
                            rs = pstm.executeQuery();
                            if (rs.next()) {
                                ident = rs.getInt("IDENT");
                            }
                        } catch (SQLException e) {
                            message = e.getMessage();
                            System.out.println(message);
                        } catch (Exception e) {
                            message = e.getMessage();
                            System.out.println(message);
                        } finally {
                            try {
                                if (rs != null) {
                                    rs.close();
                                }
                            } catch (SQLException e) {
                                System.err.println("erreur de fermeture de resultset " + e);
                            }
                        }
                    }
                    query = "INSERT INTO PROJET(TITRE,DATEDEBUT,DATEFIN,IDCLI) values (?,?,?,?)";
                    try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                        dbConnect.setAutoCommit(true);
                        pstm.setString(1, ((ProjetSimple) o).getTitre());
                        
                        pstm.setString(2, ((ProjetSimple) o).getDateDebut());
                        pstm.setString(3, ((ProjetSimple) o).getDateFin());
                        pstm.setInt(4, ident);
                       
                        int n = pstm.executeUpdate();
                        if (n == 1) {
                            message = "ajout projet effectué "+n;
                        } else {
                            message = "ajout projet non effectué";
                        }
                    } catch (SQLException e) {
                        message = e.getMessage();
                        System.out.println(e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("Nombre invalide!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (o instanceof Sous_projet){
                    rs = null;
                    ident = 0;
                    System.out.println("Je suis dans ajout sous_projet");
                    if (((Sous_projet) o).getEnt() != null) {
                        query = "select ident from entreprise where noment=?";
                        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                            pstm.setString(1, ((Sous_projet) o).getEnt().getNom());
                            rs = pstm.executeQuery();
                            if (rs.next()) {
                                ident = rs.getInt("IDENT");
                            }
                        } catch (SQLException e) {
                            message = e.getMessage();
                            System.out.println(message);
                        } catch (Exception e) {
                            message = e.getMessage();
                            System.out.println(message);
                        } finally {
                            try {
                                if (rs != null) {
                                    rs.close();
                                }
                            } catch (SQLException e) {
                                System.err.println("erreur de fermeture de resultset " + e);
                            }
                        }
                    }
                    query = "INSERT INTO PROJET(TITRE,DATEDEBUT,DATEFIN,IDCLI) values (?,?,?,?)";
                    try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                        dbConnect.setAutoCommit(true);
                        pstm.setString(1, ((Sous_projet) o).getTitre());
                       
                       pstm.setString(3,((Sous_projet) o).getDateFin());
                        pstm.setString(2,((Sous_projet) o).getDateDebut());
                        pstm.setInt(4, ident);
                        int n = pstm.executeUpdate();
                        if (n == 1) {
                            message = "ajout projet effectué";
                        } else {
                            message = "ajout projet non effectué";
                        }
                    } catch (SQLException e) {
                        message = e.getMessage();
                    } catch (NumberFormatException e) {
                        System.out.println("Nombre invalide!");
                    } catch (Exception e) {
                        message = e.getMessage();
                    }
                }
            } else if (o instanceof Temps) {
                ResultSet rs = null;
                int idProj = 0;
                if (((Temps) o).getProj() != null) {
                    query = "select idproj from PROJET where TITRE=?";
                    try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                        pstm.setString(1, ((Temps) o).getProj().getTitre());
                        rs = pstm.executeQuery();
                        if (rs.next()) {
                            idProj = rs.getInt("IDPROJ");
                        }
                    } catch (SQLException e) {
                        message = e.getMessage();
                    } catch (Exception e) {
                        message = e.getMessage();
                    } finally {
                        try {
                            if (rs != null) {
                                rs.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de resultset " + e);
                        }
                    }
                }
                int iddis = 0;
                if (((Temps) o).getDis() != null) {
                    query = "select iddis from DISCIPLINE where NOMDIS=?";
                    try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                        pstm.setString(1, ((Temps) o).getDis().getNomdiscipline());
                        rs = pstm.executeQuery();
                        if (rs.next()) {
                            iddis = rs.getInt("IDDIS");
                        }
                    } catch (SQLException e) {
                        message = e.getMessage();
                    } catch (Exception e) {
                        message = e.getMessage();
                    } finally {
                        try {
                            if (rs != null) {
                                rs.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de resultset " + e);
                        }
                    }
                }
                query = "INSERT INTO TEMPS(JHOMME,IDPROJ,IDDIS) values (?,?,?)";
                try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                    dbConnect.setAutoCommit(true);
                    pstm.setInt(1, ((Temps) o).getjHomme());
                    pstm.setInt(2, idProj);
                    pstm.setInt(3, iddis);
                    int n = pstm.executeUpdate();
                    if (n == 1) {
                        message = "ajout projet effectué";
                    } else {
                        message = "ajout projet non effectué";
                    }
                } catch (SQLException e) {
                    message = e.getMessage();
                } catch (Exception e) {
                    message = e.getMessage();
                }
            } else if (o instanceof Travail) {
                int idProj = 0;
                ResultSet rs = null;
                if (((Travail) o).getProj() != null) {
                    query = "select idproj from PROJET where TITRE=?";
                    try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                        pstm.setString(1, ((Travail) o).getProj().getTitre());
                        rs = pstm.executeQuery();
                        if (rs.next()) {
                            idProj = rs.getInt("IDPROJ");
                        }
                    } catch (SQLException e) {
                        message = e.getMessage();
                    } catch (Exception e) {
                        message = e.getMessage();
                    } finally {
                        try {
                            if (rs != null) {
                                rs.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de resultset " + e);
                        }
                    }
                }
                int idMem = 0;
                if (((Travail) o).getMem() != null) {
                    query = "select idmem from membre where NOMMEM=? AND PRENOMMEN=?";
                    try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                        pstm.setString(1, ((Travail) o).getMem().getNomMem());
                        pstm.setString(2, ((Travail) o).getMem().getPrenomMem());
                        rs = pstm.executeQuery();
                        if (rs.next()) {
                            idMem = rs.getInt("IDMEM");
                        }
                    } catch (SQLException e) {
                        message = e.getMessage();
                    } catch (Exception e) {
                        message = e.getMessage();
                    } finally {
                        try {
                            if (rs != null) {
                                rs.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de resultset " + e);
                        }
                    }
                }

                query = "INSERT INTO travail(DATEENG,TAUX,IDPROJ,IDMEM ) values(?,?,?,?)";
                try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                    dbConnect.setAutoCommit(true);
                    pstm.setString(1, ((Travail) o).getDateEng());
                    pstm.setInt(2, ((Travail) o).getTaux());
                    pstm.setInt(3, idProj);
                    pstm.setInt(4, idMem);
                    int n = pstm.executeUpdate();
                    if (n == 1) {
                        message = "ajout projet effectué";
                    } else {
                        message = "ajout projet non effectué";
                    }
                } catch (SQLException e) {
                    message = e.getMessage();
                } catch (Exception e) {
                    message = e.getMessage();
                }
            }
        } else {
            message = null;
        }

        return message;
    }
/**
 * recherche d'un membre en fonction de sa competence entrée en paramètre
 * @param c competence donnée pour la recherche
 * @return un entier qui est l'id du membre
 */
    public int rechercheMembre(Competence c) {
        String query = "";
        String message = "";
        int m = 0;
        ResultSet rs = null;
        query = "select idMem from Membre where NOMMEM=? and PRENOMMEN=?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, c.getMem().getNomMem());
            pstm.setString(2, c.getMem().getPrenomMem());
            rs = pstm.executeQuery();
            if (rs.next()) {
                m = rs.getInt("IDMEM");
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche de membre " + e);
        } catch (Exception e) {
            message = e.getMessage();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("erreur de fermeture de resultset " + e);
            }
        }
        return m;
    }
/**
 * Recherche d'un niveau en fonction de sa competence entrée en paramètre
 * @param c competence donnée pour la recherche
 * @return  un entier qui est l'id du niveau
 */
    public int rechercheNiveau(Competence c) {
        int m = 0;
        String query = "select idniv from niveau where degre=? ";
        ResultSet rs = null;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, c.getNiveau().getDegre());
            rs = pstm.executeQuery();
            if (rs.next()) {
                m = rs.getInt("IDNIV");
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche de niveau " + e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("erreur de fermeture de resultset " + e);
            }
        }
        return m;
    }
/**
 * Recherche d'une discipline en fonction de sa competence entrée en paramètre
 * @param c competence donnée oour la recherche
 * @return  un entier qui est l'id de la discipline
 */
    public int rechercheDiscipline(Competence c) {
        String query = "";
        String query1 = "";
        String message = "";
        int m = 0;
        query = "select iddis from discipline where nomdis=? ";
        ResultSet rs = null;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, c.getDiscipline().getNomdiscipline());
            rs = pstm.executeQuery();
            if (rs.next()) {
                m = rs.getInt("IDDIS");
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche de discipline " + e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("erreur de fermeture de resultset " + e);
            }
        }
        return m;
    }

    @Override
    public List<ProjetGeneral> getProjet() {
        String query = "";
        int id, idCli, idProjCompo;
        String t;
        ProjetGeneral p;
        List<ProjetGeneral> lp = new ArrayList();
        query = "select idproj,idcli,titre,datedebut,datefin,nvl(id_proj_composite,0) IDPROJCOMPO from projet";
        try (Statement stmt = dbConnect.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                id = rs.getInt("IDPROJ");
                t = rs.getString("TITRE");
                LocalDate dd = rs.getDate("DATEDEBUT").toLocalDate();
                LocalDate df = rs.getDate("DATEFIN").toLocalDate();
                idCli = rs.getInt("IDCLI");
                idProjCompo = rs.getInt("IDPROJCOMPO");
                if (idProjCompo != 0) {
                    p = new Sous_projet(t, dd.toString(), df.toString(), getEnt(idCli));
                } else {
                    p = new ProjetSimple(t, dd.toString(), df.toString(), getEnt(idCli));
                }
                lp.add(p);
            }

        } catch (SQLException e) {
            System.err.println("erreur de recherche de projet " + e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lp;
    }
/**
 * Recherche d'une entreprise à l'aide de son id
 * @param id de l'entreprise recherché
 * @return un objet entreprise trouvé ou retourne null si il le trouve pas
 */
    public Entreprise getEnt(int id) {
        String query = "";
        String message = "";
        int m = 0;
        query = "select nomEnt,telEnt,adresse from entreprise where idEnt=? ";
        ResultSet rs = null;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String nom = rs.getString("NOMENT");
                String tel = rs.getString("TELENT");
                String ad = rs.getString("ADRESSE");
                Entreprise ent = new Entreprise(nom, tel, ad);
                return ent;
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche de entreprise " + e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("erreur de fermeture de resultset " + e);
            }

        }
        return null;
    }

    @Override
    public String modifierNomEntreprise(Entreprise e, String nom) {
        String query = "UPDATE ENTREPRISE SET NOMENT = ? where NOMENT= ?";
        String msg = "";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            dbConnect.setAutoCommit(true);
            pstm.setString(1, nom);
            pstm.setString(2, e.getNom());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement du nom effectué";
            } else {
                msg = "changement du nom non effectué";
            }
        } catch (SQLException ex) {
            msg = "erreur lors du changement de nom " + ex;
        } catch (Exception ex) {
            msg = ex.getMessage();
        }
        return msg;
    }

    @Override
    public String modifierTelEntreprise(Entreprise e, String tel) {
        String query = "UPDATE ENTREPRISE SET TELENT = ? where NOMENT= ?";
        String msg = "";
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            dbConnect.setAutoCommit(true);
            pstm.setString(1, tel);
            pstm.setString(2, e.getNom());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement du numero effectué";
            } else {
                msg = "changement du numero non effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement du numero " + ex;
        } catch (Exception ex) {
            msg = ex.getMessage();
        }
        return msg;
    }

    @Override
    public String modifierAdEntreprise(Entreprise e, String a) {
        String query = "UPDATE ENTREPRISE SET ADRESSE = ? where NOMENT= ?";
        String msg;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            dbConnect.setAutoCommit(true);
            pstm.setString(1, a);
            pstm.setString(2, e.getNom());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement de l'adresse effectué";
            } else {
                msg = "changement de l'adresse non effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement de l'adresse " + ex;
        }
        return msg;
    }

    @Override
    public String modifierTitreProjet(ProjetGeneral p, String titre) {
        String query = "UPDATE PROJET SET TITRE = ? where TITRE= ?";
        String msg;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            dbConnect.setAutoCommit(true);
            pstm.setString(1, titre);
            pstm.setString(2, p.getTitre());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement du titre effectué";
            } else {
                msg = "changement du titre non effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement du titre " + ex;
        }
        return msg;
    }

    @Override
    public String modifierDateDebutProjet(ProjetGeneral p, String date) {
        String query = "UPDATE PROJET SET DATEDEBUT = ? where TITRE= ?";
        String msg;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            dbConnect.setAutoCommit(true);
            pstm.setString(1, date);
            pstm.setString(2, p.getTitre());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement de la date de debut effectué";
            } else {
                msg = "changement de la date de debut non effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement de la date de debut " + ex;
        }
        return msg;
    }

    @Override
    public String modifierDateFinProjet(ProjetGeneral p, String date) {
        String query = "UPDATE PROJET SET DATEFIN = ? where TITRE= ?";
        String msg;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            dbConnect.setAutoCommit(true);
            pstm.setString(1, date);
            pstm.setString(2, p.getTitre());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement de la date de debut effectué";
            } else {
                msg = "changement de la date de debut non effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement de la date de debut " + ex;
        }
        return msg;
    }

    @Override
    public String modifierGSMMembre(Membre m, String gsmMem) {
        String query = "UPDATE MEMBRE SET TELMEM = ? where NOMMEM= ? AND PRENOMMEN=?";
        String msg;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            dbConnect.setAutoCommit(true);
            pstm.setString(1, gsmMem);
            pstm.setString(2, m.getNomMem());
            pstm.setString(3, m.getPrenomMem());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement du numero effectué";
            } else {
                msg = "changement du numero non effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement de la date de debut " + ex;
        }
        return msg;
    }

    @Override
    public String modifierEmailMembre(Membre m, String email) {
        String query = "UPDATE MEMBRE SET EMAIL = ? where NOMMEM= ? AND PRENOMMEN=?";
        String msg;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            dbConnect.setAutoCommit(true);
            pstm.setString(1, email);
            pstm.setString(2, m.getNomMem());
            pstm.setString(3, m.getPrenomMem());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement du email effectué";
            } else {
                msg = "changement du email non effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement du email " + ex;
        }
        return msg;
    }

    @Override
    public String modifierNomDiscipline(Discipline d, String nom) {
        String query = "UPDATE DISCIPLINE SET NOMDIS = ? where NOMDIS= ? ";
        String msg;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            dbConnect.setAutoCommit(true);
            pstm.setString(1, nom);
            pstm.setString(2, d.getNomdiscipline());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement du nom effectué";
            } else {
                msg = "changement du nom non effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement du nom " + ex;
        }
        return msg;

    }

    @Override
    public String modifierDescriptionNiveaux(Niveaux niv, String description) {
        String query = "UPDATE NIVEAU SET SIGNIFICATION = ? where DEGRE= ? ";
        String msg;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            dbConnect.setAutoCommit(true);
            pstm.setString(1, description);
            pstm.setInt(2, niv.getDegre());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement de la description effectué";
            } else {
                msg = "changement de la description non effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement de la description " + ex;
        }
        return msg;
    }

    @Override
    public Object get(String mot, String mot2, Object o) {
        if (mot != null) {
            if (o instanceof Entreprise) {
                String query = "";
                String message = "";
                int m = 0;
                query = "select NOMENT,TELENT,ADRESSE from ENTREPRISE where NOMENT=?";
                ResultSet rs = null;
                try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                    pstm.setString(1, mot);
                    rs = pstm.executeQuery();
                    if (rs.next()) {
                        String n = rs.getString("NOMENT");
                        String tel = rs.getString("TELENT");
                        String ad = rs.getString("ADRESSE");
                        Entreprise e = new Entreprise(n, tel, ad);
                        return e;
                    } else {
                        return null;
                    }
                } catch (SQLException e) {
                    System.err.println("erreur de recherche de get entreprise " + e);
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                    } catch (SQLException e) {
                        System.err.println("erreur de fermeture de resultset " + e);
                    }
                }
            } else if (o instanceof Membre) {
                String query;
                String message = "";
                System.out.println("Je suis bien dans membre");
                query = "select NOMMEM,PRENOMMEN,TELMEM,EMAIL from MEMBRE where NOMMEM=? AND PRENOMMEN=?";
                ResultSet rs = null;
                try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                    pstm.setString(1, mot);
                    pstm.setString(2, mot2);
                    rs = pstm.executeQuery();
                    if (rs.next()) {
                        String n = rs.getString("NOMMEM");
                        String p = rs.getString("PRENOMMEN");
                        String tel = rs.getString("TELMEM");
                        String email = rs.getString("EMAIL");
                        Membre.MembreBuilder membreBuild = new Membre.MembreBuilder();
                        membreBuild.setNomMem(n).setPrenomMem(p).setGsm(tel).setEmail(email);
                        Membre m = membreBuild.build();
                        return m;
                    } else {
                        return null;
                    }
                } catch (SQLException e) {
                    System.err.println("erreur de recherche de get membre " + e);
                } catch (Exception e) {
                    System.out.println("Erreur de création" + e);
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                    } catch (SQLException e) {
                        System.err.println("erreur de fermeture de resultset " + e);
                    }
                }
            } else if (o instanceof Discipline) {
                String query = "";
                query = "select NOMDIS from DISCIPLINE where NOMDIS=?";
                ResultSet rs = null;
                try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                    pstm.setString(1, mot);
                    rs = pstm.executeQuery();
                    if (rs.next()) {
                        String n = rs.getString("NOMDIS");
                        Discipline d = new Discipline(n);
                        return d;
                    } else {
                        return null;
                    }
                } catch (SQLException e) {
                    System.err.println("erreur de recherche de get discipline " + e);
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                    } catch (SQLException e) {
                        System.err.println("erreur de fermeture de resultset " + e);
                    }
                }
            }
            
        }
        return null;

    }
/**
 * Recherche d'un projet 
 * @param p le type du projet
 * @param m le titre du projet recherché
 * @return le projet recherché
 */
    public ProjetGeneral getProjet(ProjetGeneral p, String m) {
        String query = "";
        int id, idCli, idProjCompo;
        String t;
        Statement stmt = null;
        ProjetGeneral pg;
        query = "select idproj,idcli,titre,datedebut,datefin,nvl(id_proj_composite,0) idProjCompo from projet where titre=?";
        ResultSet rs = null;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, m);
            rs = pstm.executeQuery();
            if (rs.next()) {
                id = rs.getInt("IDPROJ");
                t = rs.getString("TITRE");
                LocalDate dd = rs.getDate("DATEDEBUT").toLocalDate();
                LocalDate df = rs.getDate("DATEFIN").toLocalDate();
                idCli = rs.getInt("IDCLI");
                idProjCompo = rs.getInt("IDPROJCOMPO");
                if (p instanceof Sous_projet) {
                    pg = new Sous_projet(t, dd.toString(), df.toString(), getEnt(idCli));
                } else {
                    pg = new ProjetSimple(t, dd.toString(), df.toString(), getEnt(idCli));
                }
                return pg;
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.err.println("erreur de recherche de getProjet " + e);
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("erreur de fermeture de resultset " + e);
            }
        }
    }
/**
 * Recherche d'un projet
 * @param idproj l'id du projet recherché
 * @return un objet de type ProjetGeneral trouvé
 */
    public ProjetGeneral getProjet(int idproj) {
        String query = "";
        String message = "";
        int id, idCli, idProjCompo;
        String t;
        ProjetGeneral p;
        query = "select idcli,titre,datedebut,datefin,nvl(id_proj_composite,0) idProjCompo from projet where idProj=?";
        ResultSet rs = null;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, idproj);
            rs = pstm.executeQuery();
            while (rs.next()) {
                id = rs.getInt("IDCLI");
                t = rs.getString("TITRE");
                LocalDate dd = rs.getDate("DATEDEBUT").toLocalDate();
                LocalDate df = rs.getDate("DATEFIN").toLocalDate();
                idCli = rs.getInt("IDCLI");
                idProjCompo = rs.getInt("idProjCompo");
                if (idProjCompo != 0) {
                    p = new Sous_projet(t, dd.toString(), df.toString(), getEnt(idCli));
                } else {
                    p = new ProjetSimple(t, dd.toString(), df.toString(), getEnt(idCli));
                }
                return p;
            }

        } catch (SQLException e) {
            System.err.println("erreur de recherche de getProjet avec id en paramètre " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("erreur de fermeture de resultset " + e);
            }
        }
        return null;
    }
/**
 * Recherche d'un objet de type travail
 * @param m objet Membre qui fait parti de l'objet travail recherché
 * @param p objet Projet qui fait parti de l'objet travail recherché
 * @return objet Travail trouvé
 */
    public Travail getTrav(Membre m,ProjetGeneral p) {
        String query = "";
        
        String message = "";
        query = "select T.DATEENG DATEENG,NVL(T.IDPROJ,0) IDPROJ,T.TAUX TAUX,m.IDMEM IDMEM, m.NOMMEM NOMMEM,m.PRENOMMEN PRENOMMEN,m.TELMEM TELMEM,m.EMAIL EMAIL from Projet p join TRAVAIL T on T.idproj=p.idproj join Membre m on m.idmem=T.idmem where m.NOMMEM=? AND m.PRENOMMEN=? and p.titre=?";
        Travail t = new Travail();
        ResultSet rs = null;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, m.getNomMem());
            pstm.setString(2, m.getPrenomMem());
            pstm.setString(3, p.getTitre());
            rs = pstm.executeQuery();
            if (rs.next()) {
                int taux = rs.getInt("TAUX");
                LocalDate de = rs.getDate("DATEENG").toLocalDate();
                System.out.println(de);
                t = new Travail(de.toString(), taux, p, m);
                return t;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche d'acheteur " + e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("erreur de fermeture de resultset " + e);
            }
        }
        return t;
    }
    /**
 * Recherche d'un objet de type temps
 * @param d objet Discipline qui fait parti de l'objet temps recherché
 * @param p objet Projet qui fait parti de l'objet temps recherché
 * @return objet Temps trouvé
 */
public Temps getTemps(Discipline d,ProjetGeneral p) {
        String query = "";
        
        String message = "";
        query = "select T.JHOMME JHOMME from Projet p join TEMPS T on T.idproj=p.idproj join Discipline d on d.iddis=T.iddis where d.NOMDIS=? and p.titre=?";
        Temps t = new Temps();
        ResultSet rs = null;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, d.getNomdiscipline());
            pstm.setString(2, p.getTitre());
            rs = pstm.executeQuery();
            if (rs.next()) {
                int jhomme = rs.getInt("JHOMME");
                t = new Temps(jhomme, p, d);
                return t;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche d'acheteur " + e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("erreur de fermeture de resultset " + e);
            }
        }
        return t;
    }
/**
 * Recherche d'une discipline
 * @param idDis l'id de la discipline recherché
 * @return un objet Discipline trouvé
 */
    public Discipline getDis(int idDis) {
        String message = "";
        String query = "select NOMDIS from DISCIPLINE where IDDIS=?";
        ResultSet rs = null;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, idDis);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String nom = rs.getString("NOMDIS");
                Discipline d = new Discipline(nom);
                return d;
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche de dis " + e);
            return null;
        } catch (Exception e) {
            System.out.println("Erreur de création" + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("erreur de fermeture de resultset " + e);
            }
        }
        return null;
    }
/**
 * Recherche d'un membre
 * @param idMem l'id du membre recherché
 * @return un objet Membre trouvé
 */
    public Membre getMembre(int idMem) {
        String query = "";
        String message = "";
        query = "select NOMMEM,PRENOMMEN,TELMEM,EMAIL from MEMBRE where IDMEM=?";
        ResultSet rs = null;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, idMem);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String n = rs.getString("NOMMEM");
                String p = rs.getString("PRENOMMEN");
                String tel = rs.getString("TELMEM");
                String email = rs.getString("EMAIL");
                Membre.MembreBuilder membreBuild = new Membre.MembreBuilder();
                membreBuild.setNomMem(n).setPrenomMem(p).setGsm(tel).setEmail(email);
                Membre m = membreBuild.build();
                return m;
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche d'acheteur " + e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("erreur de fermeture de resultset " + e);
            }
        }
        return null;
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

        if (o instanceof Competence) {
            String query = "";
            String message = "";
            query = "select c.idcomp IDCOMP,c.idniv IDNIV,c.idmem IDMEM,c.iddis IDDIS,n.degre DEGRE,n.signification SIGNIFICATION from competence c join Niveau n on where n.degre=?";
            ResultSet rs = null;
            try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                pstm.setInt(1, primary);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    int degre = rs.getInt("DEGRE");
                    String signification = rs.getString("SIGNIFICATION");
                    Niveaux n = new Niveaux(degre, signification);
                    Membre m = getMembre(rs.getInt("IDMEM"));
                    Discipline d = getDis(rs.getInt("IDDIS"));
                    Competence c = new Competence(d, n, m);
                    return c;
                }
            } catch (SQLException e) {
                System.err.println("erreur de recherche d'acheteur " + e);

            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    System.err.println("erreur de fermeture de resultset " + e);
                }
            }

        } else if (o instanceof Niveaux) {
            String query = "";
            String message = "";
            query = "select  DEGRE,SIGNIFICATION from NIVEAU where degre=?";
            ResultSet rs = null;
            try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                pstm.setInt(1, primary);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    int degre = rs.getInt("DEGRE");
                    String signification = rs.getString("SIGNIFICATION");
                    Niveaux n = new Niveaux(degre, signification);
                    return n;
                } else {
                    return null;
                }
            } catch (SQLException e) {
                System.err.println("erreur de recherche d'acheteur " + e);
                return 0;
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    System.err.println("erreur de fermeture de resultset " + e);
                }

            }
        } else if (o instanceof Temps) {
            String query = "";
            String message = "";
            query = "select  JHOMME,IDPROJ,IDDIS from TEMPS where JHOMME=?";
            ResultSet rs = null;
            try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
                pstm.setInt(1, primary);
                rs = pstm.executeQuery();
                if (rs.next()) {
                    int jHomme = rs.getInt("JHOMME");
                    ProjetGeneral p = getProjet(rs.getInt("IDPROJ"));
                    Discipline d = getDis(rs.getInt("IDDIS"));
                    Temps t = new Temps(jHomme, p, d);
                    return t;
                }
            } catch (SQLException e) {
                System.err.println("erreur de recherche d'acheteur " + e);
                return 0;
            } finally {
                try {
                    if (rs != null) {
                        rs.close();
                    }
                } catch (SQLException e) {
                    System.err.println("erreur de fermeture de resultset " + e);
                }
            }
        }
        return null;
    }

    @Override
    public boolean supprimer(Object o) {
        boolean verite = true;
        if (o != null) {
            if (o instanceof Entreprise) {
                String query = "";
                String message = "";
                query = "select IDENT from ENTREPRISE where NOMENT=?";
                String query1 = "DELETE FROM projet WHERE idCli=?";
                String query2 = "DELETE FROM entreprise WHERE idEnt = ?";

                ResultSet rs = null;
                try (PreparedStatement pstm = dbConnect.prepareStatement(query); PreparedStatement pstm1 = dbConnect.prepareStatement(query1); PreparedStatement pstm2 = dbConnect.prepareStatement(query2)) {
                    dbConnect.setAutoCommit(true);
                    pstm.setString(1, ((Entreprise) o).getNom());
                    rs = pstm.executeQuery();
                    if (rs.next()) {
                        int ident = rs.getInt("IDENT");
                        pstm1.setInt(1, ident);
                        int nl = pstm1.executeUpdate();
                        System.out.println(nl + " lignes effacees Dans la table projet"); //suppression de l'emprunt
                        pstm2.setInt(1, ident);
                        nl = pstm2.executeUpdate();
                        System.out.println(nl + " lignes effacees Dans la table entreprise");
                        verite = true;
                    }
                } catch (SQLException e) {
                    System.out.println("erreur SQL =" + e);
                } catch (Exception e) {
                    System.out.println("erreur =" + e);
                }
            } else if (o instanceof ProjetSimple || o instanceof Sous_projet) {
                String query = "";
                String message = "";
                query = "select IDPROJ from PROJET where TITRE=?";
                String query1 = "DELETE FROM TRAVAIL WHERE idProj=?";
                String query2 = "DELETE FROM temps WHERE idProj = ?";
                String query3 = "DELETE FROM projet WHERE idProj = ?";
                ResultSet rs = null;
                try (PreparedStatement pstm = dbConnect.prepareStatement(query); PreparedStatement pstm1 = dbConnect.prepareStatement(query1); PreparedStatement pstm2 = dbConnect.prepareStatement(query2); PreparedStatement pstm3 = dbConnect.prepareStatement(query3)) {
                    dbConnect.setAutoCommit(true);
                    pstm.setString(1, ((ProjetGeneral) o).getTitre());
                    rs = pstm.executeQuery();
                    if (rs.next()) {
                        int idproj = rs.getInt("IDPROJ");
                        pstm1.setInt(1, idproj);
                        int nl = pstm1.executeUpdate();
                        System.out.println(nl + " lignes effacees Dans la table travail"); //suppression de l'emprunt
                        pstm2.setInt(1, idproj);
                        nl = pstm2.executeUpdate();
                        System.out.println(nl + " lignes effacees Dans la table temps");
                        pstm3.setInt(1, idproj);
                        nl = pstm3.executeUpdate();
                        System.out.println(nl + " lignes effacees Dans la table projet");
                        verite = true;
                    }
                } catch (SQLException e) {
                    System.out.println("erreur SQL =" + e);
                } catch (Exception e) {
                    System.out.println("erreur =" + e);
                }
            } else if (o instanceof Travail) {
                String query = "";
                String message = "";
                query = "select T.IDTRAV IDTRAV,M.IDMEM,P.IDPROJ from Membre M join TRAVAIL T on T.IDMEM=M.IDMEM join PROJET P on P.IDPROJ=T.IDPROJ where M.NOMMEM=? AND M.PRENOMMEN=? AND P.TITRE=?";
                String query1 = "DELETE FROM TRAVAIL WHERE idTrav=?";
                ResultSet rs = null;
                try (PreparedStatement pstm = dbConnect.prepareStatement(query); PreparedStatement pstm1 = dbConnect.prepareStatement(query1)) {
                    dbConnect.setAutoCommit(true);
                    Travail trav= getTrav(((Travail) o).getMem() ,((Travail) o).getProj());
                    System.out.println(trav.getDateEng());
                    pstm.setString(1, ((Travail) o).getMem().getNomMem());
                    pstm.setString(2, ((Travail) o).getMem().getPrenomMem());
                    pstm.setString(3,((Travail) o).getProj().getTitre());
                    rs = pstm.executeQuery();
                    if (rs.next()) {
                        int idTrav = rs.getInt("IDTRAV");
                        pstm1.setInt(1, idTrav);
                        int nl = pstm1.executeUpdate();
                        System.out.println(nl + " lignes effacees Dans la table travail"); //suppression de l'emprunt
                        verite = true;
                    }
                } catch (SQLException e) {
                    System.out.println("erreur SQL =" + e);
                } catch (Exception e) {
                    System.out.println("erreur =" + e);
                }
                
                
            } else if (o instanceof Membre) {
                String query = "";
                String message = "";
                query = "select IDMEM from MEMBRE where NOMMEM=? AND PRENOMMEN=?";
                String query1 = "DELETE FROM TRAVAIL WHERE IDMEM=?";
                String query2 = "DELETE FROM competence WHERE idmem = ?";
                String query3 = "DELETE FROM membre WHERE idmem = ?";
                ResultSet rs = null;
                try (PreparedStatement pstm = dbConnect.prepareStatement(query); PreparedStatement pstm1 = dbConnect.prepareStatement(query1); PreparedStatement pstm2 = dbConnect.prepareStatement(query2); PreparedStatement pstm3 = dbConnect.prepareStatement(query3)) {
                    dbConnect.setAutoCommit(true);
                    pstm.setString(1, ((Membre) o).getNomMem());
                    pstm.setString(2, ((Membre) o).getPrenomMem());
                    rs = pstm.executeQuery();
                    if (rs.next()) {
                        int idMem = rs.getInt("IDMEM");
                        pstm1.setInt(1, idMem);
                        int nl = pstm1.executeUpdate();
                        System.out.println(nl + " lignes effacees Dans la table travail"); //suppression de l'emprunt
                        pstm2.setInt(1, idMem);
                        nl = pstm2.executeUpdate();
                        System.out.println(nl + " lignes effacees Dans la table competence");
                        pstm3.setInt(1, idMem);
                        nl = pstm3.executeUpdate();
                        System.out.println(nl + " lignes effacees Dans la table membre");
                        verite = true;
                    }
                } catch (SQLException e) {
                    System.out.println("erreur SQL =" + e);
                } catch (Exception e) {
                    System.out.println("erreur =" + e);
                }
            } else if (o instanceof Discipline) {
                String query = "";
                String message = "";
                query = "select IDDIS from DISCIPLINE where nomdis=? ";
                String query1 = "DELETE FROM COMPETENCE WHERE IDDIS=?";
                String query2 = "DELETE FROM TEMPS WHERE IDDIS = ?";
                String query3 = "DELETE FROM DISCIPLINE WHERE IDDIS = ?";
                ResultSet rs = null;
                try (PreparedStatement pstm = dbConnect.prepareStatement(query); PreparedStatement pstm1 = dbConnect.prepareStatement(query1); PreparedStatement pstm2 = dbConnect.prepareStatement(query2); PreparedStatement pstm3 = dbConnect.prepareStatement(query3)) {
                    dbConnect.setAutoCommit(true);
                    pstm.setString(1, ((Discipline) o).getNomdiscipline());
                    rs = pstm.executeQuery();
                    if (rs.next()) {
                        int idDis = rs.getInt("IDDIS");
                        pstm1.setInt(1, idDis);
                        int nl = pstm1.executeUpdate();
                        System.out.println(nl + " lignes effacees Dans la table competence"); //suppression de l'emprunt
                        pstm2.setInt(1, idDis);
                        nl = pstm2.executeUpdate();
                        System.out.println(nl + " lignes effacees Dans la table temps");
                        pstm3.setInt(1, idDis);
                        nl = pstm3.executeUpdate();
                        System.out.println(nl + " lignes effacees Dans la table discipline");
                        verite = true;
                    }
                } catch (SQLException e) {
                    System.out.println("erreur SQL =" + e);
                } catch (Exception e) {
                    System.out.println("erreur =" + e);
                }
            } else if (o instanceof Competence) {
                String query = "";
                String message = "";
                query = "select c.IDCOMP IDCOMP from COMPETENCE c join Niveau n on n.idniv=c.idniv where n.degre=? ";
                String query1 = "DELETE FROM COMPETENCE WHERE IDCOMP=?";
                ResultSet rs = null;
                try (PreparedStatement pstm = dbConnect.prepareStatement(query); PreparedStatement pstm1 = dbConnect.prepareStatement(query1)) {
                    dbConnect.setAutoCommit(true);
                    pstm.setInt(1, ((Competence) o).getNiveau().getDegre());
                    rs = pstm.executeQuery();
                    if (rs.next()) {
                        int idComp = rs.getInt("IDCOMP");
                        pstm1.setInt(1, idComp);
                        int nl = pstm1.executeUpdate();
                        System.out.println(nl + " lignes effacees Dans la table competence"); //suppression de l'emprunt
                        verite = true;
                    }
                } catch (SQLException e) {
                    System.out.println("erreur SQL =" + e);
                } catch (Exception e) {
                    System.out.println("erreur =" + e);
                }
            } else if (o instanceof Niveaux) {
                String query = "";
                String message = "";
                query = "select IDNIV from NIVEAU where DEGRE=? ";
                String query1 = "DELETE FROM COMPETENCE WHERE IDNIV=?";
                String query2 = "DELETE FROM NIVEAU WHERE IDNIV = ?";
                ResultSet rs = null;
                try (PreparedStatement pstm = dbConnect.prepareStatement(query); PreparedStatement pstm1 = dbConnect.prepareStatement(query1); PreparedStatement pstm2 = dbConnect.prepareStatement(query2)) {
                    dbConnect.setAutoCommit(true);
                    pstm.setInt(1, ((Niveaux) o).getDegre());
                    rs = pstm.executeQuery();
                    if (rs.next()) {
                        int idNiv = rs.getInt("IDNIV");
                        pstm1.setInt(1, idNiv);
                        int nl = pstm1.executeUpdate();
                        System.out.println(nl + " lignes effacees Dans la table competence"); //suppression de l'emprunt
                        pstm2.setInt(1, idNiv);
                        nl = pstm2.executeUpdate();
                        System.out.println(nl + " lignes effacees Dans la table niveau");
                        verite = true;
                    }
                } catch (SQLException e) {
                    System.out.println("erreur SQL =" + e);
                } catch (Exception e) {
                    System.out.println("erreur =" + e);
                }
            } else if (o instanceof Temps) {
                String query = "";
                String message = "";
                query = "select IDTEMPS from TEMPS where JHOMME=? ";
                String query1 = "DELETE FROM TEMPS WHERE IDTEMPS=?";
                ResultSet rs = null;
                try (PreparedStatement pstm = dbConnect.prepareStatement(query); PreparedStatement pstm1 = dbConnect.prepareStatement(query1)) {
                    dbConnect.setAutoCommit(true);
                    Temps temps=getTemps(((Temps) o).getDis(),((Temps) o).getProj());
                    pstm.setInt(1, temps.getjHomme());
                    rs = pstm.executeQuery();
                    if (rs.next()) {
                        int idTemps = rs.getInt("IDTEMPS");
                        pstm1.setInt(1, idTemps);
                        int nl = pstm1.executeUpdate();
                        System.out.println(nl + " lignes effacees Dans la table temps"); //suppression de l'emprunt
                        verite = true;
                    }
                } catch (SQLException e) {
                    System.out.println("erreur SQL =" + e);
                } catch (Exception e) {
                    System.out.println("erreur =" + e);
                }
            }
        } else {
            System.out.println("pas de suppression");
        }
        return verite;
    }

    @Override
    public int journeeHommeTotalProjet(ProjetGeneral p) {
        int journeeHommeTotalProjet = 0;
        //!!!!!!!!!!!!!!!!!!!!!
        //Il faut mettre une colonne dans sgbd
        return journeeHommeTotalProjet;
    }

    @Override
    public List<Membre> listeMembreProjet(String m, ProjetGeneral p) {
        String query = "";
        String message = "";
        int id, idCli, idProjCompo;
        String n, prenom, tel, email;
        List<Membre> lm = new ArrayList();
        query = "select p.titre TITRE,m.idMem IDMEM,m.nomMem NOMMEM,m.PRENOMMEN PRENOMMEN,m.telMem TELMEM,m.email EMAIL from projet p join travail"
                + " t on t.idproj=p.idproj join membre m on m.idmem=t.idmem where p.titre=?";
        ResultSet rs = null;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            dbConnect.setAutoCommit(true);
            pstm.setString(1, m);
            rs = pstm.executeQuery();
            if (!rs.next()) {
                System.out.println("pas de membre dans son projet");
            } else {
                do {
                    id = rs.getInt("IDMEM");
                    n = rs.getString("NOMMEM");
                    prenom = rs.getString("PRENOMMEN");
                    tel = rs.getString("TELMEM");
                    email = rs.getString("EMAIL");
                    Membre.MembreBuilder membreBuild = new Membre.MembreBuilder();
                    membreBuild.setNomMem(n).setPrenomMem(prenom).setGsm(tel).setEmail(email);
                    Membre mem = membreBuild.build();
                    lm.add(mem);
                } while (rs.next());
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche d'acheteur " + e);
        } catch (Exception e) {
            System.out.println("Probleme de creation du membre");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("erreur de fermeture de resultset " + e);
            }
        }
        return lm;
    }

    @Override
    public List<Discipline> listeDisciplineProjet(String m, ProjetGeneral p) {
        List<Discipline> listeDis = null;
        Discipline d;
        String query = "";
        int id;
        String n, jhomme, titre;
        query = "select p.titre TITRE,d.iddis IDDIS,t.jhomme JHOMME,d.nomdis NOM from projet p "
                + "join temps t on t.idproj=p.idproj "
                + "join discipline d on t.iddis=d.iddis "
                + "where p.titre=?";
        ResultSet rs = null;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            dbConnect.setAutoCommit(true);
            listeDis = new ArrayList<>();
            pstm.setString(1, m);
            rs = pstm.executeQuery();
            while (rs.next()) {
            
                    id = rs.getInt("IDDIS");
                    n = rs.getString("NOM");
                    jhomme = rs.getString("JHOMME");
                    titre = rs.getString("TITRE");
                    d = new Discipline(n);
                    listeDis.add(d);
                
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche d'acheteur " + e);
        } catch (Exception e) {
            System.out.println("Probleme de creation du membre");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("erreur de fermeture de resultset " + e);
            }
        }
        return listeDis;
    }

    @Override
    public List<ProjetGeneral> listeProjetEntreprise(String nomEnt) {
        ProjetGeneral p;
        List<ProjetGeneral> listeProj = new ArrayList<>();
        ProjetGeneral pg;
        String query = "";
        int id, idCli, idProjCompo;
        String n, jhomme, titre;
        query = "select p.titre TITRE,p.idcli, IDCLI,p.dateDebut DATEDEBUT,p.dateFin DATEFIN,p.id_proj_composite IDPROJCOMPO from Projet p join Entreprise e on e.idEnt=p.idcli where e.noment=?";
        ResultSet rs = null;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            dbConnect.setAutoCommit(true);
            pstm.setString(1, nomEnt);
            rs = pstm.executeQuery();
            if (!rs.next()) {
                System.out.println("pas de projet pour cette entreprise");
            } else {
                do {
                    titre = rs.getString("TITRE");
                    LocalDate dd = rs.getDate("DATEDEBUT").toLocalDate();
                    LocalDate df = rs.getDate("DATEFIN").toLocalDate();
                    idCli = rs.getInt("IDCLI");
                    idProjCompo = rs.getInt("IDPROJCOMPO");
                    if (idProjCompo != 0) {
                        p = new Sous_projet(titre, dd.toString(), df.toString(), getEnt(idCli));
                    } else {
                        p = new ProjetSimple(titre, dd.toString(), df.toString(), getEnt(idCli));
                    }
                    listeProj.add(p);
                } while (rs.next());
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche d'acheteur " + e);
        } catch (Exception e) {
            System.out.println("Probleme de creation du membre");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("erreur de fermeture de resultset " + e);
            }
        }
        return listeProj;
    }

    @Override
    public String ajoutSousProjet(Sous_projet sp, ProjetGeneral pg) {
        String query = "";
        String msg = "";
        int id = 0, idCli, idProjCompo;
        String t;
        ProjetGeneral p;
        query = "select idproj from projet where titre=?";
        ResultSet rs = null;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, sp.getTitre());
            rs = pstm.executeQuery();
            if (rs.next()) {
                id = rs.getInt("IDPROJ");
                msg="le sous projet existe";
            } else {
                msg = "Le sous projet n'existe pas";
                return null;
            }

        } catch (SQLException e) {
            System.err.println("erreur de recherche de projet " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("erreur de fermeture de resultset " + e);
            }
        }
        query = "UPDATE PROJET SET id_proj_composite = ? where TITRE= ?";
        System.out.println("titre du sous_projet"+ pg.getTitre());
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            dbConnect.setAutoCommit(true);

            pstm.setInt(1, id);
            pstm.setString(2, pg.getTitre());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement du projet effectué";
            } else {
                msg = "changement du projet non effectué";
            }

        } catch (SQLException ex) {
            msg = ex.getMessage();
            System.out.println(msg);
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return msg;
    }
/**
 * Recherche d'un objet Niveau
 * @param idNiv l'id du niveau recherché
 * @return un objet de type Niveau trouvé
 */
    public Niveaux getNiv(int idNiv) {
        String query = "";
        String message = "";
        int m = 0;
        query = "select idniv,degre,signification from niveau where idniv=? ";
        ResultSet rs = null;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, idNiv);
            rs = pstm.executeQuery();
            if (rs.next()) {
                int degre = rs.getInt("DEGRE");
                String signification = rs.getString("SIGNIFICATION");
                Niveaux n = new Niveaux(degre, signification);
                return n;
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche d'acheteur " + e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("erreur de fermeture de resultset " + e);
            }
        }
        return null;
    }

    @Override
    public List<Competence> getComp() {
        String query = "";
        int id, idniv, idMem, idDis;
        List<Competence> lc = new ArrayList();
        query = "select idcomp,idniv,idmem,iddis from Competence";
        try (Statement stmt = dbConnect.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (!rs.next()) {
                System.out.println("Pas de competence");
            } else {
                do {
                    id = rs.getInt("IDCOMP");
                    idniv = rs.getInt("IDNIV");
                    idMem = rs.getInt("IDMEM");
                    idDis = rs.getInt("IDDIS");
                    Niveaux n = getNiv(idniv);
                    Membre m = getMembre(idMem);
                    Discipline d = getDis(idDis);
                    Competence c = new Competence(d, n, m);
                    lc.add(c);
                } while (rs.next());
            }

        } catch (SQLException e) {
            System.err.println("erreur de recherche d'acheteur " + e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lc;
    }
    @Override
    public List<Discipline> getDis() {
        String query = "";
        int iddis;
        String nom;
        List<Discipline> lc = new ArrayList();
        query = "select iddis,nomdis from Discipline";
        try (Statement stmt = dbConnect.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                iddis = rs.getInt("IDDIS");
                nom = rs.getString("NOMDIS");
                Discipline d = new Discipline(nom);
                lc.add(d);
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche d'acheteur " + e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lc;
    }

    @Override
    public List<Entreprise> getEntreprise() {
        String query = "";
        int idEnt;
        String nom, tel, adresse;
        List<Entreprise> lc = new ArrayList();
        query = "select IDENT,NOMENT,TELENT,ADRESSE from ENTREPRISE";
        try (Statement stmt = dbConnect.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                idEnt = rs.getInt("IDENT");
                nom = rs.getString("NOMENT");
                tel = rs.getString("TELENT");
                adresse = rs.getString("ADRESSE");
                Entreprise e = new Entreprise(nom, tel, adresse);
                lc.add(e);
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche d'acheteur " + e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lc;
    }

    @Override
    public List<Membre> getMembre() {
        String query = "";
        String nom, tel;
        List<Membre> lm = new ArrayList();
        query = "select NOMMEM,PRENOMMEN,TELMEM,EMAIL from MEMBRE";
        try (Statement stmt = dbConnect.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String n = rs.getString("NOMMEM");
                String p = rs.getString("PRENOMMEN");
                tel = rs.getString("TELMEM");
                String email = rs.getString("EMAIL");
                Membre.MembreBuilder membreBuild = new Membre.MembreBuilder();
                membreBuild.setNomMem(n).setPrenomMem(p).setGsm(tel).setEmail(email);
                Membre m = membreBuild.build();
                lm.add(m);
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche d'acheteur " + e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return lm;
    }

    @Override
    public List<Niveaux> getNiveau() {
        String query = "";
        int idNiv, degre;
        String signification;
        List<Niveaux> ln = new ArrayList();
        query = "select IDNIV,DEGRE,SIGNIFICATION from NIVEAU";
        try (Statement stmt = dbConnect.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                idNiv = rs.getInt("IDNIV");
                degre = rs.getInt("DEGRE");
                signification = rs.getString("SIGNIFICATION");
                Niveaux n = new Niveaux(degre, signification);
                ln.add(n);
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche d'acheteur " + e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ln;
    }

    @Override
    public List<Temps> getTemps() {
        String query = "";
        int idTemps, jhomme, idProj, idDis;
        List<Temps> ln = new ArrayList();
        query = "select IDTEMPS,JHOMME,IDPROJ,IDDIS from TEMPS";
        try (Statement stmt = dbConnect.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                idTemps = rs.getInt("IDTEMPS");
                jhomme = rs.getInt("JHOMME");
                idProj = rs.getInt("IDPROJ");
                idDis = rs.getInt("IDDIS");
                ProjetGeneral p = getProjet(idProj);
                Discipline d = getDis(idDis);
                Temps temps = new Temps(jhomme, p, d);
                ln.add(temps);
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche de temps " + e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ln;
    }

    @Override
    public List<Travail> getTrav() {
        String query = "";
        int idTemps, jhomme, idProj, idTrav, idMem, taux;
        List<Travail> ln = new ArrayList();
        query = "select IDTRAV,IDPROJ,IDMEM,DATEENG,TAUX from TRAVAIL";
        try (Statement stmt = dbConnect.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                idTrav = rs.getInt("IDTRAV");
                idMem = rs.getInt("IDMEM");
                idProj = rs.getInt("IDPROJ");
                taux = rs.getInt("TAUX");
                LocalDate de = rs.getDate("DATEENG").toLocalDate();
                ProjetGeneral p = getProjet(idProj);
                Membre m = getMembre(idMem);
                Travail trav = new Travail(de.toString(), taux, p, m);
                ln.add(trav);
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche de travail " + e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ln;
    }
    /**
     * Liste de tous les sous projets
     * @param sp projet dont on veut les sous projet
     * @return list de tous les sous projet du projet
     */
    public List<ProjetGeneral> listeSousProjet(Sous_projet sp) {
        List<ProjetGeneral> listpg=new ArrayList();
        String query = "";
        String msg = "";
        int id = 0;
        String t;
        query = "select idproj from projet where titre=?";
        ResultSet rs = null;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setString(1, sp.getTitre());
            rs = pstm.executeQuery();
            if (rs.next()) {
                id = rs.getInt("IDPROJ");
                msg="le sous projet existe";
            } else {
                msg = "Le sous projet n'existe pas";
                return null;
            }

        } catch (SQLException e) {
            System.err.println("erreur de recherche de projet " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("erreur de fermeture de resultset " + e);
            }
        }
        query = "select titre ,idcli,datedebut,datefin from projet where id_proj_composite= ?";
        rs = null;
        try (PreparedStatement pstm = dbConnect.prepareStatement(query)) {
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String titre = rs.getString("TITRE");
                String dateDebut = rs.getString("DATEDEBUT");
                String dateFin = rs.getString("DATEFIN");
                ProjetSimple p = new ProjetSimple(titre, dateDebut,dateFin);
                listpg.add(p);
            }
        } catch (SQLException e) {
            System.err.println("erreur de recherche d'acheteur " + e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("erreur de fermeture de resultset " + e);
            }
        }
         
        return listpg;
    }
}
