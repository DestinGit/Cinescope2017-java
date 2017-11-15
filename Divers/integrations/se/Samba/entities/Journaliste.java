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
public class Journaliste {

    private int id_media;
    private int id_journaliste;
    private String nom_journaliste;
    private String nom_media;

    public Journaliste() {
    }

    public Journaliste(int id_journaliste) {
        this.id_journaliste = id_journaliste;
    }

    public Journaliste(int id_media, String nom_journaliste, int id_journaliste) {
        this.id_media = id_media;
        this.nom_journaliste = nom_journaliste;
        this.id_journaliste = id_journaliste;

    }

    public Journaliste(String nom_journaliste,int id_media) {
        this.nom_journaliste = nom_journaliste;
        this.id_media = id_media;
        
    }



    public Journaliste(String nom_journaliste, String nom_media) {
        this.nom_journaliste = nom_journaliste;
        this.nom_media = nom_media;
    }

    public Journaliste(int id_media, int id_journaliste, String nom_journaliste, String nom_media) {
        this.id_media = id_media;
        this.id_journaliste = id_journaliste;
        this.nom_journaliste = nom_journaliste;
        this.nom_media = nom_media;
    }

    public int getId_media() {
        return id_media;
    }

    public void setId_media(int id_media) {
        this.id_media = id_media;
    }

    public int getId_journaliste() {
        return id_journaliste;
    }

    public void setId_journaliste(int id_journaliste) {
        this.id_journaliste = id_journaliste;
    }

    public String getNom_journaliste() {
        return nom_journaliste;
    }

    public void setNom_journaliste(String nom_journaliste) {
        this.nom_journaliste = nom_journaliste;
    }

    public String getNom_media() {
        return nom_media;
    }

    public void setNom_media(String nom_media) {
        this.nom_media = nom_media;
    }

    @Override
    public String toString() {
        return "Journaliste{" + "id_media=" + id_media + ", id_journaliste=" + id_journaliste + ", nom_journaliste=" + nom_journaliste + ", nom_media=" + nom_media + '}';
    }

}
