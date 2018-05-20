/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Modele;

import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author ameliefiems
 */
public class Membre {
    private String nomMem;
    private String prenomMem;
    private String gsmMem;
    private String email;
    
    private Membre(MembreBuilder mb){
        this.nomMem=mb.nomMem;
        this.prenomMem=mb.prenomMem;
        this.gsmMem=mb.gsmMem;
        this.email=mb.email;
    }
    public String getNomMem() {
        return nomMem;
    }

    public String getPrenomMem() {
        return prenomMem;
    }

    public String getGsmMem() {
        return gsmMem;
    }

    public String getEmail() {
        return email;
    }
    public SimpleStringProperty getpNom(){
        return new SimpleStringProperty(nomMem);
    }
    public SimpleStringProperty getpPrenomMem(){
        return new SimpleStringProperty(prenomMem);
    }
    public SimpleStringProperty getpGsm(){
        return new SimpleStringProperty(gsmMem);
    }
    public SimpleStringProperty getpEmail(){
        return new SimpleStringProperty(email);
    }
    @Override
    public String toString() {
        return "Membre{" + "nomMem=" + nomMem + ", prenomMem=" + prenomMem + ", gsmMem=" + gsmMem + ", email=" + email +'}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nomMem);
        hash = 67 * hash + Objects.hashCode(this.prenomMem);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Membre other = (Membre) obj;
        if (!Objects.equals(this.nomMem, other.nomMem)) {
            return false;
        }
        if (!Objects.equals(this.prenomMem, other.prenomMem)) {
            return false;
        }
        return true;
    }

    

    public void setGsmMem(String gsmMem) {
        this.gsmMem = gsmMem;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public static class MembreBuilder{
        private String nomMem;
        private String prenomMem;
        private String gsmMem;
        private String email;
        public MembreBuilder(){
            
        }
        public MembreBuilder setNomMem(String nomMem){
            this.nomMem=nomMem;
            return this;
        }
        public MembreBuilder setPrenomMem(String prenomMem){
            this.prenomMem=prenomMem;
            return this;
        }
        
        public MembreBuilder setGsm(String gsm){
            this.gsmMem=gsm;
            return this;
        }
        public MembreBuilder setEmail(String email){
            this.email=email;
            return this;
        }
        public Membre build() throws Exception{
            if(nomMem==null|| prenomMem==null){
                throw new Exception("Nom et prénom manquants");
            }
            if(nomMem.trim().equals("")|| prenomMem.trim().equals("")){
                throw new Exception("Nom et prénom manquants");
            }
            return new Membre(this);
                //trim ça retire les blancs
        }
    }
    /*public Membre(String nomMem, String prenomMem, String gsmMem, String email) {
        this.nomMem = nomMem;
        this.prenomMem = prenomMem;
        this.gsmMem = gsmMem;
        this.email = email;
       
    }
    
    public Membre(String nomMem,String prenomMem){
        this.nomMem=nomMem;
        this.prenomMem = prenomMem;
        this.gsmMem = ""; 
        this.email = "";
       
    }
    */
    
}
