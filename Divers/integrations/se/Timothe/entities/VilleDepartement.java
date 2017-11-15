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
public class VilleDepartement extends Ville  {

   
    private String NomDepartement;

    public VilleDepartement() {
    }

    public VilleDepartement(String NomDepartement) {
        this.NomDepartement = NomDepartement;
    }

    public VilleDepartement(String NomDepartement, int IDDepartement, String CP, String NomVille) {
        super(IDDepartement, CP, NomVille);
        this.NomDepartement = NomDepartement;
    }

    public VilleDepartement(String NomDepartement, int IDVille, int IDDepartement, String CP, String NomVille) {
        super(IDVille, IDDepartement, CP, NomVille);
        this.NomDepartement = NomDepartement;
    }
     public String getNomDepartement() {
        return NomDepartement;
    }

    public void setNomDepartement(String NomDepartement) {
        this.NomDepartement = NomDepartement;
    }
   
     public Object[] tableauVD (VilleDepartement vd){
       Object[] out = new Object[5] ; 
       out[0] = "";
       out[1] =  vd.getIDVille();
       out[2] = vd.getCP();
       out[3] = vd.getNomVille();
       out[4] = vd.getNomDepartement();
       
       return out;
    }
     
}
