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
public class Produire implements Serializable{
    private int idPays;
    private int idFilm;
    private int rangProduction;
    
    // CONSTRUCTEURS

    public Produire() {
    }

    public Produire(int rangProduction) {
        this.rangProduction = rangProduction;
    }

    public Produire(int idPays, int idFilm, int rangProduction) {
        this.idPays = idPays;
        this.idFilm = idFilm;
        this.rangProduction = rangProduction;
    }
    
    // GETTERS AND SETTERS

    public int getIdPays() {
        return idPays;
    }

    public void setIdPays(int idPays) {
        this.idPays = idPays;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public int getRangProduction() {
        return rangProduction;
    }

    public void setRangProduction(int rangProduction) {
        this.rangProduction = rangProduction;
    }
    
    // AUTRES

    @Override
    public String toString() {
        return "Produire{" + "idPays=" + idPays + ", idFilm=" + idFilm + ", rangProduction=" + rangProduction + '}';
    }
}
