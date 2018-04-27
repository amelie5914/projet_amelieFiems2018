/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.Modele;

import java.util.Objects;
import java.util.Set;

/**
 *
 * @author ameliefiems
 */
public class Membre {
    private String nomMem;
    private String prenomMem;
    private String gsmMem;
    private String email;
    
    public Membre(){
        nomMem="";
        prenomMem="";
        gsmMem="";
        email="";
    }
    public Membre(String nomMem, String prenomMem, String gsmMem, String email) {
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

    @Override
    public String toString() {
        return "Membre{" + "nomMem=" + nomMem + ", prenomMem=" + prenomMem + ", gsmMem=" + gsmMem + ", email=" + email +'}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.nomMem);
        hash = 67 * hash + Objects.hashCode(this.prenomMem);
        hash = 67 * hash + Objects.hashCode(this.gsmMem);
        hash = 67 * hash + Objects.hashCode(this.email);
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

    
    
}
