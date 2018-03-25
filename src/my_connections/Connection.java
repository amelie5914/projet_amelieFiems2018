/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_connections;

import java.sql.DriverManager;
import java.util.PropertyResourceBundle;

/**
 *
 * @author ameliefiems
 */
public class Connection {
    




     private static java.sql.Connection dbConnect = null;

  private Connection(){}   
     
     
     
     public static java.sql.Connection getConnection() {
        if (dbConnect!=null)return dbConnect;
        PropertyResourceBundle properties = 
                (PropertyResourceBundle) PropertyResourceBundle.getBundle("resources.application");
            //nom du fichier properties à utiliser
        String serverName = properties.getString("connection.server");
        String dbName = properties.getString("connection.database");
        String username = properties.getString("connection.login");
        String password = properties.getString("connection.password");
        String dbPort = properties.getString("connection.port");
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@//" + serverName + ":" + dbPort + "/" + dbName;
            dbConnect = DriverManager.getConnection(url, username, password);
            return dbConnect;

        } catch (Exception e) {
            System.err.println("erreur de connexion " + e);
            e.printStackTrace();
            return null;
        }
    }
    
    public static void closeConnection(){
       
        try{
            
            dbConnect.close();
           
        }
        catch(Exception e){
            System.out.println("erreur de fermeture de connexion "+e);
                    
        }
         dbConnect=null;
     }

}
