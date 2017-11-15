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
public class Media {

    private int id_media;
    private String nom_media;

    public Media() {
    }

    public Media(String nom_media) {
        this.nom_media = nom_media;
    }

    public Media(int id_media, String nom_media) {
        this.id_media = id_media;
        this.nom_media = nom_media;
    }

    public int getId_media() {
        return id_media;
    }

    public void setId_media(int id_media) {
        this.id_media = id_media;
    }

    public String getNom_media() {
        return nom_media;
    }

    public void setNom_media(String nom_media) {
        this.nom_media = nom_media;
    }

    @Override
    public String toString() {
        return "Media{" + "id_media=" + id_media + ", nom_media=" + nom_media + '}';
    }
    
    
}
