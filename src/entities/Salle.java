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
public class Salle implements Serializable{
    private int idSalle;
    private int idCinema;
    private int idFestival;
    private String nomSalle;
    private String descriptionSalle;
    
    // CONSTRUCTEURS

    public Salle() {
    }

    public Salle(int idSalle, int idCinema, int idFestival, String nomSalle, String descriptionSalle) {
        this.idSalle = idSalle;
        this.idCinema = idCinema;
        this.idFestival = idFestival;
        this.nomSalle = nomSalle;
        this.descriptionSalle = descriptionSalle;
    }

    public Salle(int idCinema, int idFestival, String nomSalle, String descriptionSalle) {
        this.idCinema = idCinema;
        this.idFestival = idFestival;
        this.nomSalle = nomSalle;
        this.descriptionSalle = descriptionSalle;
    }
    
    // GETTERS AND SETTERS

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public int getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(int idCinema) {
        this.idCinema = idCinema;
    }

    public int getIdFestival() {
        return idFestival;
    }

    public void setIdFestival(int idFestival) {
        this.idFestival = idFestival;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public String getDescriptionSalle() {
        return descriptionSalle;
    }

    public void setDescriptionSalle(String descriptionSalle) {
        this.descriptionSalle = descriptionSalle;
    }
    
    // AUTRES

    @Override
    public String toString() {
        return "Salle{" + "idSalle=" + idSalle + ", idCinema=" + idCinema + ", idFestival=" + idFestival + ", nomSalle=" + nomSalle + ", descriptionSalle=" + descriptionSalle + '}';
    }
    
}
