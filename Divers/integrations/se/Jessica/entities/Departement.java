/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Jessica
 */
public class Departement {
    
    // Attributs
    
    private int idDepartement;
    private String codeDepartement;
    private String nomDepartement;
    
    // Constructeurs
    // 1. un vide
    // 2. un plein
    // 3. un avec les colonnes obligatoires
    // 4. un avec les colonnes obligatoires sans la PK
    
    public Departement() {
    }
    
    public Departement(int idDepartement, String codeDepartement, String nomDepartement) {
        this.idDepartement = idDepartement;
        this.codeDepartement = codeDepartement;
        this.nomDepartement = nomDepartement;
    }

    public Departement(String codeDepartement, String nomDepartement) {
        this.codeDepartement = codeDepartement;
        this.nomDepartement = nomDepartement;
    }
    
    // Get et Setters
    
    public int getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public String getNomDepartement() {
        return nomDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }
    
    // Autres
    
    @Override
    public String toString() {
        return "Departement{" + "idDepartement=" + idDepartement + ", codeDepartement=" + codeDepartement + ", nomDepartement=" + nomDepartement + '}';
    }
        
}
