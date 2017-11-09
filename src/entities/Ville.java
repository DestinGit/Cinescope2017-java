/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author Administrateur
 */
public class Ville {
    
    private int idVille;
    private int idDepartement;
    private String cp;
    private String nomVille;

    public Ville() {
    }

    public Ville(int idVille, int idDepartement, String cp, String nomVille) {
        this.idVille = idVille;
        this.idDepartement = idDepartement;
        this.cp = cp;
        this.nomVille = nomVille;
    }

    public Ville(int idDepartement, String cp, String nomVille) {
        this.idDepartement = idDepartement;
        this.cp = cp;
        this.nomVille = nomVille;
    }

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    public int getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    @Override
    public String toString() {
        return "Ville{" + "idVille=" + idVille + ", idDepartement=" + idDepartement + ", cp=" + cp + ", nomVille=" + nomVille + '}';
    }
    
    

    
    
    
    
}
