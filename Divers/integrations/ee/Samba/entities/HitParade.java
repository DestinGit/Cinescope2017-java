/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.c2017.entities;

/**
 *
 * @author formation
 */
public class HitParade {
    private String lnom;
    private double lentreeSe;
    private double lsemaines;
    private double lentreeTT;

    public HitParade() {
    }

    public HitParade(String lnom) {
        this.lnom = lnom;
    }

    public HitParade(String lnom, double lentreeSe, double lsemaines, double lentreeTT) {
        this.lnom = lnom;
        this.lentreeSe = lentreeSe;
        this.lsemaines = lsemaines;
        this.lentreeTT = lentreeTT;
    }

    public String getLnom() {
        return lnom;
    }

    public double getLentreeSe() {
        return lentreeSe;
    }

    public double getLsemaines() {
        return lsemaines;
    }

    public double getLentreeTT() {
        return lentreeTT;
    }

    public void setLnom(String lnom) {
        this.lnom = lnom;
    }

    public void setLentreeSe(double lentreeSe) {
        this.lentreeSe = lentreeSe;
    }

    public void setLsemaines(double lsemaines) {
        this.lsemaines = lsemaines;
    }

    public void setLentreeTT(double lentreeTT) {
        this.lentreeTT = lentreeTT;
    }

    @Override
    public String toString() {
        return "HitParade{" + "lnom=" + lnom + ", lentreeSe=" + lentreeSe + ", lsemaines=" + lsemaines + ", lentreeTT=" + lentreeTT + '}';
    }
    
    
}
