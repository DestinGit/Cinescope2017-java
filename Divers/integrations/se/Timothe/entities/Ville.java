/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author formation
 */
public class Ville {

   

    private int IDVille;
    private int IDDepartement;
    private String CP;
    private String NomVille;
    
     public Ville() {
    }

    public Ville(int IDDepartement, String CP, String NomVille) {
        this.IDDepartement = IDDepartement;
        this.CP = CP;
        this.NomVille = NomVille;
    }

    public Ville(int IDVille, int IDDepartement, String CP, String NomVille) {
        this.IDVille = IDVille;
        this.IDDepartement = IDDepartement;
        this.CP = CP;
        this.NomVille = NomVille;
    }

    public void setIDVille(int IDVille) {
        this.IDVille = IDVille;
    }

    public void setIDDepartement(int IDDepartement) {
        this.IDDepartement = IDDepartement;
    }

    public void setCP(String CP) {
        this.CP = CP;
    }

    public void setNomVille(String NomVille) {
        this.NomVille = NomVille;
    }

    public int getIDVille() {
        return IDVille;
    }

    public int getIDDepartement() {
        return IDDepartement;
    }

    public String getCP() {
        return CP;
    }

    public String getNomVille() {
        return NomVille;
    }

    @Override
    public String toString() {
        return "Ville{" + "IDVille=" + IDVille + ", IDDepartement=" + IDDepartement + ", CP=" + CP + ", NomVille=" + NomVille + '}';
    }
    
}
