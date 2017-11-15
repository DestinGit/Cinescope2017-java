/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author rayanakel
 */
public class Rubrique {
    private int idRubrique;
    private String codeRubrique;
    private String intituleRubrique;

    
    public Rubrique(int idRubrique, String codeRubrique, String intituleRubrique) {
        this.idRubrique = idRubrique;
        this.codeRubrique = codeRubrique;
        this.intituleRubrique = intituleRubrique;
    }

    public Rubrique(String codeRubrique, String intituleRubrique) {
        this.codeRubrique = codeRubrique;
        this.intituleRubrique = intituleRubrique;
    }

    public Rubrique() {
    }

    public int getIdRubrique() {
        return idRubrique;
    }

    public void setIdRubrique(int idRubrique) {
        this.idRubrique = idRubrique;
    }

    public String getCodeRubrique() {
        return codeRubrique;
    }

    public void setCodeRubrique(String codeRubrique) {
        this.codeRubrique = codeRubrique;
    }

    public String getIntituleRubrique() {
        return intituleRubrique;
    }

    public void setIntituleRubrique(String intituleRubrique) {
        this.intituleRubrique = intituleRubrique;
    }

    @Override
    public String toString() {
        return "Rubrique{" + "idRubrique=" + idRubrique + ", codeRubrique=" + codeRubrique + ", intituleRubrique=" + intituleRubrique + '}';
    }
    
    
}
