/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj_modele;

/**
 *
 * @author ameliefiems
 */
public class Competence {
    private int degre;
    public Discipline discipline;
    public Niveaux niveau;
    public Membre mem;

    public Competence(int degre, Discipline discipline, Niveaux niveau, Membre mem) {
        this.degre = degre;
        this.discipline = discipline;
        this.niveau = niveau;
        this.mem = mem;
    }
    

    
}
