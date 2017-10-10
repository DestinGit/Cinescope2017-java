/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;

/**
 *
 * @author formation
 */
public class Pays implements Serializable{
    private int idPays;
    private String nomPays;
    private String masculin;
    private String feminin;
    private String neutre;
    
    // CONSTRUCTEURS
    public Pays() {
    }

    public Pays(int idPays, String nomPays, String masculin, String feminin, String neutre) {
        this.idPays = idPays;
        this.nomPays = nomPays;
        this.masculin = masculin;
        this.feminin = feminin;
        this.neutre = neutre;
    }

    public Pays(String nomPays, String masculin, String feminin, String neutre) {
        this.nomPays = nomPays;
        this.masculin = masculin;
        this.feminin = feminin;
        this.neutre = neutre;
    }
    
    // GETTERS ET SETTERS
    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    public String getMasculin() {
        return masculin;
    }

    public void setMasculin(String masculin) {
        this.masculin = masculin;
    }

    public String getFeminin() {
        return feminin;
    }

    public void setFeminin(String feminin) {
        this.feminin = feminin;
    }

    public String getNeutre() {
        return neutre;
    }

    public void setNeutre(String neutre) {
        this.neutre = neutre;
    }
    
    // AUTRES
    @Override
    public String toString() {
        return "Pays{" + "idPays=" + idPays + ", nomPays=" + nomPays + ", masculin=" + masculin + ", feminin=" + feminin + ", neutre=" + neutre + '}';
    }
    
}
