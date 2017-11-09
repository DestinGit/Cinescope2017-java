/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

/**
 *
 * @author Administrateur
 */
public class Cinema {

    private int idCinema;
    private int idVille;
    private int idArrondissement;
    private String codeCinema;
    private String nomCinema;
    private String adresseCinema;
    private String telephoneCinema;
    private String tarifsCinema;
    private String diversCinema;
    private String reseauCinema;
    private int accesHandicapes;
    
    
    public Cinema() {
    }

    public Cinema(int idCinema, int idVille, int idArrondissement, String codeCinema, String nomCinema, String adresseCinema, String telephoneCinema, String tarifsCinema, String diversCinema, String reseauCinema, int accesHandicapes) {
        this.idCinema = idCinema;
        this.idVille = idVille;
        this.idArrondissement = idArrondissement;
        this.codeCinema = codeCinema;
        this.nomCinema = nomCinema;
        this.adresseCinema = adresseCinema;
        this.telephoneCinema = telephoneCinema;
        this.tarifsCinema = tarifsCinema;
        this.diversCinema = diversCinema;
        this.reseauCinema = reseauCinema;
        this.accesHandicapes = accesHandicapes;
    }

    public Cinema(int idCinema, int idVille, int idArrondissement, String codeCinema, String nomCinema, String adresseCinema, int accesHandicapes) {
        this.idCinema = idCinema;
        this.codeCinema = codeCinema;
        this.nomCinema = nomCinema;
    }

    public Cinema(int idVille, int idArrondissement, String codeCinema, String nomCinema, String adresseCinema, int accesHandicapes) {
        this.codeCinema = codeCinema;
        this.nomCinema = nomCinema;
    }

    public int getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(int idCinema) {
        this.idCinema = idCinema;
    }

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    public int getIdArrondissement() {
        return idArrondissement;
    }

    public void setIdArrondissement(int idArrondissement) {
        this.idArrondissement = idArrondissement;
    }

    public String getCodeCinema() {
        return codeCinema;
    }

    public void setCodeCinema(String codeCinema) {
        this.codeCinema = codeCinema;
    }

    public String getNomCinema() {
        return nomCinema;
    }

    public void setNomCinema(String nomCinema) {
        this.nomCinema = nomCinema;
    }

    public String getAdresseCinema() {
        return adresseCinema;
    }

    public void setAdresseCinema(String adresseCinema) {
        this.adresseCinema = adresseCinema;
    }

    public int getAccesHandicapes() {
        return accesHandicapes;
    }

    public void setAccesHandicapes(int accesHandicapes) {
        this.accesHandicapes = accesHandicapes;
    }

    @Override
    public String toString() {
        return "Cinema{" + "idCinema=" + idCinema + ", idVille=" + idVille + ", idArrondissement=" + idArrondissement + ", codeCinema=" + codeCinema + ", nomCinema=" + nomCinema + ", adresseCinema=" + adresseCinema + ", telephoneCinema=" + telephoneCinema + ", tarifsCinema=" + tarifsCinema + ", diversCinema=" + diversCinema + ", reseauCinema=" + reseauCinema + ", accesHandicapes=" + accesHandicapes + '}';
    }

    



    
    
    
    
}
