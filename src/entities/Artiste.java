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
public class Artiste implements Serializable{
    private int idArtiste;
    private String nomArtiste;
    
    // CONSTRUCTEURS
    public Artiste() {
    }

    public Artiste(String nomArtiste) {
        this.nomArtiste = nomArtiste;
    }

    public Artiste(int idArtiste, String nomArtiste) {
        this.idArtiste = idArtiste;
        this.nomArtiste = nomArtiste;
    }
    
    // GETTERS AND SETTERS
    public int getIdArtiste() {
        return idArtiste;
    }

    public void setIdArtiste(int idArtiste) {
        this.idArtiste = idArtiste;
    }

    public String getNomArtiste() {
        return nomArtiste;
    }

    public void setNomArtiste(String nomArtiste) {
        this.nomArtiste = nomArtiste;
    }
    
    // AUTRES
    @Override
    public String toString() {
        return "Artiste{" + "idArtiste=" + idArtiste + ", nomArtiste=" + nomArtiste + '}';
    }
    
}
