/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author allth
 */
public class FilmRecherche {
    
    private String titreFilm;
    private String annee;
    private String couleur;
    private String genre;
    private String genreGrammatical;

    public FilmRecherche() {
    }

    public FilmRecherche(String titreFilm, String annee, String couleur, String genre, String genreGrammatical) {
        this.titreFilm = titreFilm;
        this.annee = annee;
        this.couleur = couleur;
        this.genre = genre;
        this.genreGrammatical = genreGrammatical;
    }

    public String getTitreFilm() {
        return titreFilm;
    }

    public void setTitreFilm(String titreFilm) {
        this.titreFilm = titreFilm;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenreGrammatical() {
        return genreGrammatical;
    }

    public void setGenreGrammatical(String genreGrammatical) {
        this.genreGrammatical = genreGrammatical;
    }

    @Override
    public String toString() {
        return "FilmRecherche{" + "titreFilm=" + titreFilm + ", annee=" + annee + ", couleur=" + couleur + ", genre=" + genre + ", genreGrammatical=" + genreGrammatical + '}';
    }
    
    
    
    
}
