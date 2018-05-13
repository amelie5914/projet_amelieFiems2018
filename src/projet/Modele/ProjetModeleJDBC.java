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
public class ProjetModeleJDBC extends ProjetModele{
    Connection dbConnect;
    String nom="";
    String prenom="";
            
    public ProjetModeleJDBC(){
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
     public String ajouter(Object o){
        String query="";
        String query1="";
        String message="";
        String msg="";
        int m=0;
        PreparedStatement pstm = null;

        if(o!=null){
            if(o instanceof Entreprise){
                    query="insert into ENTREPRISE(NOMENT,TELENT,ADRESSE) values(?,?,?)";
                    
                   try{
                   pstm = dbConnect.prepareStatement(query);
                   pstm.setString(1,((Entreprise)o).getNom());
                       System.out.println(((Entreprise) o).getNom());
                   pstm.setString(3,((Entreprise) o).getAdresse());
                   pstm.setString(2,((Entreprise) o).getTel());
                   int n = pstm.executeUpdate();
                       System.out.println("n vaut "+n);
                        if (n == 1) {
                            message = "ajout projet effectué";
                        } else {
                            message = "ajout projet non effectué";
                        }
                   }
                   catch (SQLException e) {
                        message = "erreur lors de l'ajout de la voiture " + e;

                    } finally {

                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            message = "erreur de fermeture de preparedstatement " + e;
                        }
                    }

            }
            else if(o instanceof Competence){
                    
                    int membre=rechercheMembre((Competence)o);
                    int niveau=rechercheNiveau((Competence)o);
                    int dis=rechercheDiscipline((Competence) o);
                    query="insert into COMPETENCE(IDNIV,IDMEM,IDDIS) values(?,?,?) ";
                    try{
                   pstm = dbConnect.prepareStatement(query);
                   pstm.setInt(1,niveau);
                   pstm.setInt(2,membre);
                   pstm.setInt(3,dis);
                   int n = pstm.executeUpdate();
                        if (n == 1) {
                            message = "ajout projet effectué";
                        } else {
                            message = "ajout projet non effectué";
                        }
                            dbConnect.commit();
                   }
                   catch (SQLException e) {
                        msg = "erreur lors de l'ajout de la voiture " + e;

                    } finally {

                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            msg = "erreur de fermeture de preparedstatement " + e;
                        }
                    }
                    
            }
            else if(o instanceof Discipline){
                    query="insert into DISCIPLINE (NOMDIS) values (?)";
                    try{
                   pstm = dbConnect.prepareStatement(query);
                   pstm.setString(1,((Discipline) o).getNomdiscipline());
                   int n = pstm.executeUpdate();
                        if (n == 1) {
                            message = "ajout projet effectué";
                        } else {
                            message = "ajout projet non effectué";
                        }
                            dbConnect.commit();
                   }
                   catch (SQLException e) {
                        msg = "erreur lors de l'ajout de la voiture " + e;

                    } finally {

                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            msg = "erreur de fermeture de preparedstatement " + e;
                        }
                    }
            }
            else if(o instanceof Membre){
                    query="insert into MEMBRE(NOMMEM,PRENOMMEM,TELMEM,EMAIL) values (?,?,?,?) ";
                    try{
                   pstm = dbConnect.prepareStatement(query);
                   pstm.setString(1,((Membre) o).getNomMem());
                   pstm.setString(2,((Membre) o).getPrenomMem());
                   pstm.setString(3,((Membre) o).getGsmMem());
                   pstm.setString(4,((Membre) o).getEmail());
                   int n = pstm.executeUpdate();
                        if (n == 1) {
                            message = "ajout projet effectué";
                        } else {
                            message = "ajout projet non effectué";
                        }
                            dbConnect.commit();
                   }
                   catch (SQLException e) {
                        msg = "erreur lors de l'ajout de la voiture " + e;

                    } finally {

                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            msg = "erreur de fermeture de preparedstatement " + e;
                        }
                    }
                
            }
            else if(o instanceof Niveaux){
                    query="insert into NIVEAU(DEGRE,SIGNIFICATION) values (?,?)";
                    try{
                   pstm = dbConnect.prepareStatement(query);
                   pstm.setString(2,((Niveaux) o).getSignification());
                   pstm.setInt(1,((Niveaux) o).getDegre());
                   int n = pstm.executeUpdate();
                        if (n == 1) {
                            message = "ajout projet effectué";
                        } else {
                            message = "ajout projet non effectué";
                        }
                            dbConnect.commit();
                   }
                   catch (SQLException e) {
                        msg = "erreur lors de l'ajout de la voiture " + e;

                    } finally {

                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            msg = "erreur de fermeture de preparedstatement " + e;
                        }
                    }
               
            }
            else if(o instanceof ProjetSimple ||o instanceof Sous_projet){
                if(o instanceof ProjetSimple){
                    query="INSERT INTO PROJET(TITRE,DATEDEBUT,DATEFIN) values (?,?,?)";
                    try{
                        pstm=dbConnect.prepareStatement(query);
                        pstm.setString(1,((ProjetSimple) o).getTitre());
                        int jour=Integer.parseInt(((ProjetSimple) o).getDateDebut().substring(0,1));
                        int mois=Integer.parseInt(((ProjetSimple) o).getDateDebut().substring(3,4));
                        int annee=Integer.parseInt(((ProjetSimple) o).getDateDebut().substring(6,9));
                        LocalDate dd=LocalDate.of(annee, mois, jour);
                        pstm.setDate(2,java.sql.Date.valueOf(dd));
                        jour=Integer.parseInt(((ProjetSimple) o).getDateFin().substring(0,1));
                        mois=Integer.parseInt(((ProjetSimple) o).getDateFin().substring(3,4));
                        annee=Integer.parseInt(((ProjetSimple) o).getDateFin().substring(6,9));
                        dd=LocalDate.of(annee, mois, jour);
                        pstm.setDate(3,java.sql.Date.valueOf(dd));
                        
                        int n = pstm.executeUpdate();
                        if (n == 1) {
                            message = "ajout projet effectué";
                        } else {
                            message = "ajout projet non effectué";
                        }
                    }
                    catch (SQLException e) {
                        message = "erreur lors de l'ajout de la voiture " + e;
                    } finally {
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            message = "erreur de fermeture de preparedstatement " + e;
                        }
                    }
                }
                else{
                    
                    
                    query="INSERT INTO PROJET(TITRE,DATEDEBUT,DATEFIN) values (?,?,?)";
                    try{
                        pstm=dbConnect.prepareStatement(query);
                        pstm.setString(1,((ProjetSimple) o).getTitre());
                        int jour=Integer.parseInt(((ProjetSimple) o).getDateDebut().substring(0,2));
                        int mois=Integer.parseInt(((ProjetSimple) o).getDateDebut().substring(4,6));
                        int annee=Integer.parseInt(((ProjetSimple) o).getDateDebut().substring(8,12));
                        LocalDate dd=LocalDate.of(annee, mois, jour);
                        pstm.setDate(2,java.sql.Date.valueOf(dd));
                        jour=Integer.parseInt(((ProjetSimple) o).getDateFin().substring(0,2));
                        mois=Integer.parseInt(((ProjetSimple) o).getDateFin().substring(4,6));
                        annee=Integer.parseInt(((ProjetSimple) o).getDateFin().substring(8,12));
                        dd=LocalDate.of(annee, mois, jour);
                        pstm.setDate(3,java.sql.Date.valueOf(dd));
                        int n = pstm.executeUpdate();
                        if (n == 1) {
                            message = "ajout projet effectué";
                        } else {
                            message = "ajout projet non effectué";
                        }
                            dbConnect.commit();
                    }
                    catch (SQLException e) {
                        msg = "erreur lors de l'ajout de la voiture " + e;
                    } finally {
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            msg = "erreur de fermeture de preparedstatement " + e;
                        }
                    }
                }
            }
            else if(o instanceof Temps){
                    query="INSERT INTO TEMPS(JHOMME) values (?)";
                    try{
                   pstm = dbConnect.prepareStatement(query);
                   pstm.setInt(1,((Temps) o).getjHomme());
                   int n = pstm.executeUpdate();
                        if (n == 1) {
                            message = "ajout projet effectué";
                        } else {
                            message = "ajout projet non effectué";
                        }
                            dbConnect.commit();
                   }
                   catch (SQLException e) {
                        msg = "erreur lors de l'ajout de la voiture " + e;

                    } finally {

                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            msg = "erreur de fermeture de preparedstatement " + e;
                        }
                    }
                
            }
            else if(o instanceof Travail){
                    query="INSERT INTO travail(DATEENG,TAUX ) values(?,?)";
                    try{
                   pstm = dbConnect.prepareStatement(query);
                   pstm.setString(1,((Travail) o).getDateEng());
                   pstm.setInt(2,((Travail) o).getTaux());
                   int n = pstm.executeUpdate();
                        if (n == 1) {
                            message = "ajout projet effectué";
                        } else {
                            message = "ajout projet non effectué";
                        }
                            dbConnect.commit();
                   }
                   catch (SQLException e) {
                        msg = "erreur lors de l'ajout de la voiture " + e;

                    } finally {

                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            msg = "erreur de fermeture de preparedstatement " + e;
                        }
                    }
            }
            
        }
        else{
            message= null;
        }
        
        return message;
     }
     
     public int rechercheMembre(Competence c){
         String query="";
        String query1="";
        String message="";
        int m=0;
        PreparedStatement pstm = null;
         query="select idMem from Membre where NOMMEM=? and PRENOMMEM=?";
                    
                    ResultSet rs = null;
                    try {
                        pstm = dbConnect.prepareStatement(query);
                        pstm.setString(1, c.getMem().getNomMem());
                        pstm.setString(2,c.getMem().getPrenomMem());
                        rs = pstm.executeQuery();
                        if (rs.next()) {
                             m = rs.getInt("IDMEM");
                             return m;
                        } else {
                            return 0;
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
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de preparedstatement " + e);
                        }
                    }
                    
     }
     
     public int rechercheNiveau(Competence c){
         String query="";
        String query1="";
        String message="";
        int m=0;
        PreparedStatement pstm = null;
         query="select idniv from niveau where degre=? ";
                    
                    ResultSet rs = null;
                    try {
                        pstm = dbConnect.prepareStatement(query);
                        pstm.setInt(1, c.getNiveau().getDegre());
                        rs = pstm.executeQuery();
                        if (rs.next()) {
                             m = rs.getInt("IDNIV");
                             return m;
                        } else {
                            return 0;
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
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de preparedstatement " + e);
                        }
                    }
                    
     }
     public int rechercheDiscipline(Competence c){
         String query="";
        String query1="";
        String message="";
        int m=0;
        PreparedStatement pstm = null;
         query="select iddis from discipline where nomdis=? ";
                    
                    ResultSet rs = null;
                    try {
                        pstm = dbConnect.prepareStatement(query);
                        pstm.setString(1, c.getDiscipline().getNomdiscipline());
                        rs = pstm.executeQuery();
                        if (rs.next()) {
                             m = rs.getInt("IDDIS");
                             return m;
                        } else {
                            return 0;
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
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de preparedstatement " + e);
                        }
                    }
                    
     }
     @Override
     public List<ProjetGeneral> getProjet(){
          String query="";
        String message="";
        int id,idCli,idProjCompo;
        String t;
        ProjetGeneral p;
        List <ProjetGeneral> lp=new ArrayList();
        Statement stmt = null;
        PreparedStatement pstm = null;
         query="select idproj,idcli,titre,datedebut,datefin,nvl(id_proj_composite,0) idProjCompo from projet";
                    
                    ResultSet rs = null;
                    try {
                        stmt = dbConnect.createStatement();
                        rs = stmt.executeQuery(query);
                        while (rs.next()) {
                             id= rs.getInt("IDPROJ");
                             t=rs.getString("TITRE");
                             LocalDate dd=rs.getDate("DATEDEBUT").toLocalDate();
                             LocalDate df=rs.getDate("DATEFIN").toLocalDate();
                             idCli=rs.getInt("IDCLI");
                             idProjCompo=rs.getInt("IDPROJCOMPO");
                             
                             if(idProjCompo!=0){
                                p=new Sous_projet(t, dd.toString(),df.toString(),getEnt(idCli));
                             }
                             else{
                                 p=new ProjetSimple(t, dd.toString(),df.toString(),getEnt(idCli));
                             }
                             lp.add(p);
                        } 
                        
                    } catch (SQLException e) {
                        System.err.println("erreur de recherche d'acheteur " + e);
                        return null;
                    } finally {
                        try {
                            if (rs != null) {
                                rs.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de resultset " + e);
                        }
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de preparedstatement " + e);
                        }
                    }
                  return lp;  
     }
     
     public Entreprise getEnt(int id){
         String query="";
        String message="";
        int m=0;
        PreparedStatement pstm = null;
         query="select nomEnt,telEnt,adresse from entreprise where idEnt=? ";
                    ResultSet rs = null;
                    try {
                        pstm = dbConnect.prepareStatement(query);
                        pstm.setInt(1, id);
                        rs = pstm.executeQuery();
                        if (rs.next()) {
                             String nom = rs.getString("NOMENT");
                             String tel=rs.getString("TELENT");
                             String ad=rs.getString("ADRESSE");
                             Entreprise e=new Entreprise(nom,tel,ad);
                             return e;
                        } 
                          
                    } catch (SQLException e) {
                        System.err.println("erreur de recherche d'acheteur " + e);
                        return null;
                    } finally {
                        try {
                            if (rs != null) {
                                rs.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de resultset " + e);
                        }
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de preparedstatement " + e);
                        }
                    }
                    return null;
     }
     
     @Override
     public String modifierNomEntreprise(Entreprise e,String nom){
        String query = "UPDATE ENTREPRISE SET NOMENT = ? where NOMENT= ?";
        PreparedStatement pstm = null;
        String msg;
        try {
            pstm = dbConnect.prepareStatement(query);
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
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                msg = "erreur de fermeture de preparedstatement " + ex;
            }
        }
        return msg;
    }
     @Override
     public String modifierTelEntreprise(Entreprise e,String tel){
        
        String query = "UPDATE ENTREPRISE SET TELENT = ? where NOMENT= ?";
        PreparedStatement pstm = null;
        String msg;
        try {
            pstm = dbConnect.prepareStatement(query);
            pstm.setString(1, tel);
            pstm.setString(2, e.getNom());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement du numero effectué";
            } else {
                msg = "changement du numero effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement du numero " + ex;
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                msg = "erreur de fermeture de preparedstatement " + ex;
            }
        }
        return msg;
    }
     @Override
     public String modifierAdEntreprise(Entreprise e,String a){
        
        String query = "UPDATE ENTREPRISE SET ADRESSE = ? where NOMENT= ?";
        PreparedStatement pstm = null;
        String msg;
        try {
            pstm = dbConnect.prepareStatement(query);
            pstm.setString(1, a);
            pstm.setString(2, e.getNom());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement de l'adresse effectué";
            } else {
                msg = "changement de l'adresse effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement de l'adresse " + ex;
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                msg = "erreur de fermeture de preparedstatement " + ex;
            }
        }
        return msg;
    }
     @Override
     public String modifierTitreProjet(ProjetGeneral p, String titre){
         String query = "UPDATE PROJET SET TITRE = ? where TITRE= ?";
        PreparedStatement pstm = null;
        String msg;
        try {
            pstm = dbConnect.prepareStatement(query);
            pstm.setString(1, titre);
            pstm.setString(2, p.getTitre());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement du titre effectué";
            } else {
                msg = "changement du titre effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement du titre " + ex;
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                msg = "erreur de fermeture de preparedstatement " + ex;
            }
        }
        return msg;
    }
     @Override
     public String modifierDateDebutProjet(ProjetGeneral p,String date){
       String query = "UPDATE PROJET SET DATEDEBUT = ? where TITRE= ?";
        PreparedStatement pstm = null;
        String msg;
        try {
            pstm = dbConnect.prepareStatement(query);
            pstm.setString(1, date);
            pstm.setString(2, p.getTitre());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement de la date de debut effectué";
            } else {
                msg = "changement de la date de debut effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement de la date de debut " + ex;
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                msg = "erreur de fermeture de preparedstatement " + ex;
            }
        }
        return msg;
    }
    @Override
    public String modifierDateFinProjet(ProjetGeneral p,String date){
        String query = "UPDATE PROJET SET DATEFIN = ? where TITRE= ?";
        PreparedStatement pstm = null;
        String msg;
        try {
            pstm = dbConnect.prepareStatement(query);
            pstm.setString(1, date);
            pstm.setString(2, p.getTitre());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement de la date de debut effectué";
            } else {
                msg = "changement de la date de debut effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement de la date de debut " + ex;
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                msg = "erreur de fermeture de preparedstatement " + ex;
            }
        }
        return msg;
    }     
    @Override
    public String modifierGSMMembre(Membre m,String gsmMem){
        String query = "UPDATE MEMBRE SET TELMEM = ? where NOMMEM= ? AND PRENOMMEM=?";
        PreparedStatement pstm = null;
        String msg;
        try {
            pstm = dbConnect.prepareStatement(query);
            pstm.setString(1, gsmMem);
            pstm.setString(2, m.getNomMem());
            pstm.setString(3, m.getPrenomMem());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement du numero effectué";
            } else {
                msg = "changement du numero effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement de la date de debut " + ex;
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                msg = "erreur de fermeture de preparedstatement " + ex;
            }
        }
        return msg;
    }
    @Override
    public String modifierEmailMembre(Membre m,String email){
        
                String query = "UPDATE MEMBRE SET EMAIL = ? where NOMMEM= ? AND PRENOMMEM=?";
        PreparedStatement pstm = null;
        String msg;
        try {
            pstm = dbConnect.prepareStatement(query);
            pstm.setString(1, email);
            pstm.setString(2, m.getNomMem());
            pstm.setString(3, m.getPrenomMem());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement du email effectué";
            } else {
                msg = "changement du email effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement du email " + ex;
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                msg = "erreur de fermeture de preparedstatement " + ex;
            }
        }
        return msg;
    }
    @Override
    public String modifierNomDiscipline(Discipline d,String nom){
        String query = "UPDATE DISCIPLINE SET NOMDIS = ? where NOMDIS= ? ";
        PreparedStatement pstm = null;
        String msg;
        try {
            pstm = dbConnect.prepareStatement(query);
            pstm.setString(1, nom);
            pstm.setString(2, d.getNomdiscipline());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement du nom effectué";
            } else {
                msg = "changement du nom effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement du nom " + ex;
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                msg = "erreur de fermeture de preparedstatement " + ex;
            }
        }
        return msg;
    
    }
    @Override
    public String modifierDescriptionNiveaux(Niveaux niv,String description){
        
        String query = "UPDATE NIVEAU SET SIGNIFICATION = ? where DEGRE= ? ";
        PreparedStatement pstm = null;
        String msg;
        try {
            pstm = dbConnect.prepareStatement(query);
            pstm.setString(1, description);
            pstm.setInt(2, niv.getDegre());
            int n = pstm.executeUpdate();
            if (n == 1) {
                msg = "changement de la description effectué";
            } else {
                msg = "changement de la description effectué";
            }

        } catch (SQLException ex) {
            msg = "erreur lors du changement de la description " + ex;
        } finally {

            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException ex) {
                msg = "erreur de fermeture de preparedstatement " + ex;
            }
        }
        return msg;
    }
    @Override
    public Object get(String mot,String mot2,Object o)
    {
        if(mot!=null){
            if(o instanceof Entreprise){
                String query="";
                String message="";
                int m=0;
                PreparedStatement pstm = null;
                 query="select NOMENT,TELENT,ADRESSE from ENTREPRISE where NOMENT=?";
                    
                    ResultSet rs = null;
                    try {
                        pstm = dbConnect.prepareStatement(query);
                        pstm.setString(1, mot);
                        rs = pstm.executeQuery();
                        if (rs.next()) {
                             String n = rs.getString("NOMENT");
                             String tel=rs.getString("TELENT");
                             String ad=rs.getString("ADRESSE");
                             Entreprise e=new Entreprise(n,tel,ad);
                             return e;
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
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de preparedstatement " + e);
                        }
                    }
                  
            }
            
            else if(o instanceof Membre){
                
                String query="";
                String message="";
                PreparedStatement pstm = null;
                 query="select NOMMEM,PRENOMMEM,TELMEM,EMAIL from MEMBRE where NOMMEM=? AND PRENOMMEM=?";
                    
                    ResultSet rs = null;
                    try {
                        pstm = dbConnect.prepareStatement(query);
                        pstm.setString(1, mot);
                        pstm.setString(2, mot2);
                        rs = pstm.executeQuery();
                        if (rs.next()) {
                             String n = rs.getString("NOMMEM");
                             String p = rs.getString("PRENOMMEM");
                             String tel=rs.getString("TELMEM");
                             String email=rs.getString("EMAIL");
                             
                            Membre.MembreBuilder membreBuild=new Membre.MembreBuilder();
                            membreBuild.setNomMem(n).setPrenomMem(p).setGsm(tel).setEmail(email);
                             Membre m=membreBuild.build();
                             return m;
                        } else {
                            return null;
                        }
                    } catch (SQLException e) {
                        System.err.println("erreur de recherche d'acheteur " + e);
                        return 0;
                    }
                    
                    catch(Exception e){
                        System.out.println("Erreur de création"+e);}
                    finally {
                        try {
                            if (rs != null) {
                                rs.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de resultset " + e);
                        }
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de preparedstatement " + e);
                        }
                    }
                
            }
            else if(o instanceof Discipline){
                String query="";
                String message="";
                PreparedStatement pstm = null;
                query="select NOMDIS from DISCIPLINE where NOMDIS=?";
                ResultSet rs = null;
                    try {
                        pstm = dbConnect.prepareStatement(query);
                        pstm.setString(1, mot);
                        rs = pstm.executeQuery();
                        if (rs.next()) {
                             String n = rs.getString("NOMDIS");
                            Discipline d=new Discipline(n);
                             return d;
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
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de preparedstatement " + e);
                        }
                    }
            }
            
        }
        return null;
       
    }
    public ProjetGeneral getProjet(ProjetGeneral p,String m){
        String query="";
        String message="";
        int id,idCli,idProjCompo;
        String t;
        Statement stmt = null;
        PreparedStatement pstm = null;
         query="select idproj,idcli,titre,datedebut,datefin,nvl(id_proj_composite,0) idProjCompo from projet where titre=?";
          
                    ResultSet rs = null;
                    try {
                        pstm = dbConnect.prepareStatement(query);
                        pstm.setString(1, m);
                        rs = pstm.executeQuery();
                        while (rs.next()) {
                             id= rs.getInt("IDPROJ");
                             t=rs.getString("TITRE");
                             LocalDate dd=rs.getDate("DATEDEBUT").toLocalDate();
                             LocalDate df=rs.getDate("DATEFIN").toLocalDate();
                             idCli=rs.getInt("IDCLI");
                             idProjCompo=rs.getInt("IDPROJCOMPO");
                             
                             if(p instanceof Sous_projet){
                                p=new Sous_projet(t, dd.toString(),df.toString(),getEnt(idCli));
                             }
                             else{
                                 p=new ProjetSimple(t, dd.toString(),df.toString(),getEnt(idCli));
                             }
                             return p;
                        } 
                        
                    } catch (SQLException e) {
                        System.err.println("erreur de recherche d'acheteur " + e);
                        return null;
                    } finally {
                        try {
                            if (rs != null) {
                                rs.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de resultset " + e);
                        }
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de preparedstatement " + e);
                        }
                    }
                    return null;
    }
    public ProjetGeneral getProjet(int idproj){
        String query="";
        String message="";
        int id,idCli,idProjCompo;
        String t;
        ProjetGeneral p;
        PreparedStatement pstm = null;
        query="select idcli,titre,datedebut,datefin,nvl(id_proj_composite,0) idProjCompo from projet where idProj=?";
        ResultSet rs = null;
        try {
            pstm = dbConnect.prepareStatement(query);
            pstm.setInt(1, idproj);
            rs = pstm.executeQuery();
            while (rs.next()) {
                id= rs.getInt("IDPROJ");
                t=rs.getString("TITRE");
                LocalDate dd=rs.getDate("DATEDEBUT").toLocalDate();
                LocalDate df=rs.getDate("DATEFIN").toLocalDate();
                idCli=rs.getInt("IDCLI");
                idProjCompo=rs.getInt("IDPROJCOMPO");
                if(idProjCompo!=0){
                    p=new Sous_projet(t, dd.toString(),df.toString(),getEnt(idCli));
                }
                else{
                    p=new ProjetSimple(t, dd.toString(),df.toString(),getEnt(idCli));
                }
                return p;
            } 
                        
                    } catch (SQLException e) {
                        System.err.println("erreur de recherche d'acheteur " + e);
                        return null;
                    } finally {
                        try {
                            if (rs != null) {
                                rs.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de resultset " + e);
                        }
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de preparedstatement " + e);
                        }
                    }
                    return null;
    }
    public Travail getTrav(Membre m){
        String query="";
        ProjetGeneral p;
                String message="";
                PreparedStatement pstm = null;
                 query="select T.DATEENG DATEENG,NVL(T.IDPROJ,0) IDPROJ,T.TAUX TAUX,m.IDMEM IDMEM, m.NOMMEM NOMMEM,m.PRENOMMEM PRENOMMEM,m.TELMEM TELMEM,m.EMAIL EMAIL from TRAVAIL T join Membre m on m.idmem=T.idmem where m.NOMMEM=? AND m.PRENOMMEM=?";
                    Travail t=new Travail();
                    ResultSet rs = null;
                    try {
                        pstm = dbConnect.prepareStatement(query);
                        pstm.setString(1, m.getNomMem());
                        pstm.setString(2, m.getPrenomMem());
                        rs = pstm.executeQuery();
                        if (rs.next()) {
                             int taux = rs.getInt("TAUX");
                             int idProj= rs.getInt("IDPROJ");
                             if(idProj!=0){
                                 p=getProjet(idProj);
                             }
                             else{
                                 p=null;
                             }
                             String tel=rs.getString("TELMEM");
                             String email=rs.getString("EMAIL");
                             LocalDate de=rs.getDate("DATEENG").toLocalDate();
                             t=new Travail(de.toString(),taux,p,m);
                            return t;
                        } else {
                            return null;
                        }
                    } catch (SQLException e) {
                        System.err.println("erreur de recherche d'acheteur " + e);
                        return null;
                    }
                    
                    catch(Exception e){
                        System.out.println("Erreur de création"+e);}
                    finally {
                        try {
                            if (rs != null) {
                                rs.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de resultset " + e);
                        }
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de preparedstatement " + e);
                        }
                    }
            return t;
    }
    public Discipline getDis(int idDis){
        String query="";
                String message="";
                PreparedStatement pstm = null;
                 query="select NOMDIS from DISCIPLINE where IDDIS=?";
                    
                    ResultSet rs = null;
                    try {
                        pstm = dbConnect.prepareStatement(query);
                        pstm.setInt(1, idDis);
                        rs = pstm.executeQuery();
                        if (rs.next()) {
                             String nom = rs.getString("NOMDIS");
                             Discipline d=new Discipline(nom);
                             return d;
                        } else {
                            return null;
                        }
                    } catch (SQLException e) {
                        System.err.println("erreur de recherche d'acheteur " + e);
                        return null;
                    }
                    
                    catch(Exception e){
                        System.out.println("Erreur de création"+e);}
                    finally {
                        try {
                            if (rs != null) {
                                rs.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de resultset " + e);
                        }
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de preparedstatement " + e);
                        }
                    }
                    return null;
    }
    public Membre getMembre(int idMem){
        String query="";
        String message="";
        PreparedStatement pstm = null;
        query="select NOMMEM,PRENOMMEM,TELMEM,EMAIL from MEMBRE where IDMEM=?";
        ResultSet rs = null;
        try {
            pstm = dbConnect.prepareStatement(query);
            pstm.setInt(1, idMem);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String n = rs.getString("NOMMEM");
                String p = rs.getString("PRENOMMEM");
                String tel=rs.getString("TELMEM");
                String email=rs.getString("EMAIL");
                Membre.MembreBuilder membreBuild=new Membre.MembreBuilder();
                            membreBuild.setNomMem(n).setPrenomMem(p).setGsm(tel).setEmail(email);
                             Membre m=membreBuild.build();
                             return m;
                        } else {
                            return null;
                        }
                    } catch (SQLException e) {
                        System.err.println("erreur de recherche d'acheteur " + e);
                        return null;
                    }
                    
                    catch(Exception e){
                        System.out.println("Erreur de création"+e);}
                    finally {
                        try {
                            if (rs != null) {
                                rs.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de resultset " + e);
                        }
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de preparedstatement " + e);
                        }
                    }
        return null;
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
            String query="";
            String message="";
            PreparedStatement pstm = null;
            query="select c.idcomp IDCOMP,c.idniv IDNIV,c.idmem IDMEM,c.iddis IDDIS,n.degre DEGRE,n.signification SIGNIFICATION from competence c join Niveau n on where n.degre=?";
                ResultSet rs = null;
                    try {
                        pstm = dbConnect.prepareStatement(query);
                        pstm.setInt(1, primary);
                        rs = pstm.executeQuery();
                        if (rs.next()) {
                             int degre = rs.getInt("DEGRE");
                             String signification=rs.getString("SIGNIFICATION");
                             Niveaux n=new Niveaux(degre,signification);
                             Membre m=getMembre(rs.getInt("IDMEM"));
                             Discipline d=getDis(rs.getInt("IDDIS"));
                             Competence c=new Competence(d,n,m);
                             return c;
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
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de preparedstatement " + e);
                        }
                    }
            
            }
            else if(o instanceof Niveaux){
                String query="";
            String message="";
            PreparedStatement pstm = null;
            query="select  DEGRE,SIGNIFICATION from NIVEAU where degre=?";
                ResultSet rs = null;
                    try {
                        pstm = dbConnect.prepareStatement(query);
                        pstm.setInt(1, primary);
                        rs = pstm.executeQuery();
                        if (rs.next()) {
                             int degre = rs.getInt("DEGRE");
                             String signification=rs.getString("SIGNIFICATION");
                             Niveaux n=new Niveaux(degre,signification);
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
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de preparedstatement " + e);
                        }
                    }
            }
            else if(o instanceof Temps){
                String query="";
            String message="";
            PreparedStatement pstm = null;
            query="select  JHOMME,IDPROJ,IDDIS from TEMPS where JHOMME=?";
                ResultSet rs = null;
                    try {
                        pstm = dbConnect.prepareStatement(query);
                        pstm.setInt(1, primary);
                        rs = pstm.executeQuery();
                        if (rs.next()) {
                             int jHomme = rs.getInt("JHOMME");
                             ProjetGeneral p=getProjet(rs.getInt("IDPROJ"));
                             Discipline d=getDis(rs.getInt("IDDIS"));
                             Temps t=new Temps(jHomme,p,d);
                             return t;
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
                        try {
                            if (pstm != null) {
                                pstm.close();
                            }
                        } catch (SQLException e) {
                            System.err.println("erreur de fermeture de preparedstatement " + e);
                        }
                    }
            }
            
            return null;
    }
}
