/*
 * DTO Département
 * CONSTRUCTEURS
4 constructeurs
un vide
un plein
un avec les colonnes obligatoires
un avec les colonnes obligatoires sans pk
* GETTERS ET SETTERS
Tous sauf si certains attributs sont en RO le dérivé ou frozen 
 */

package entities;

import java.io.Serializable;

/**
 *
 * @author formation
 */
public class Departement implements Serializable{
    /**
     * ATTRIBUTS
     */
    private int idDepartement;
    private String codeDepartement;
    private String nomDepartement;
    

    /**
     * CONSTRUCTEURS
     */
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
    
    /**
     * GETTTERS ET SETTERS
     * @return 
     */
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
    /**
     * AUTRES
     */

    @Override
    public String toString() {
        return "Departement{" + "idDepartement=" + idDepartement + ", codeDepartement=" + codeDepartement + ", nomDepartement=" + nomDepartement + '}';
    }

}
