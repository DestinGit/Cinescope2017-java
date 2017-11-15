/**
 * DTO Dptm
 */
package entities;

/**
 *
 * @author formation
 */
public class Departement {
    //--- attributs
    private int idDepartement;
    private String codeDepartement;
    private String nomDepartement;
    
    
    /*
    constructeurs
    */
    
    public Departement(int idDepartement, String codeDepartement, String nomDepartement) {
        this.idDepartement = idDepartement;
        this.codeDepartement = codeDepartement;
        this.nomDepartement = nomDepartement;
    }

    public Departement(String codeDepartement, String nomDepartement) {
        this.codeDepartement = codeDepartement;
        this.nomDepartement = nomDepartement;
    }

   public Departement() {
    }
    
    

    /*
    GET AND SETTERS
     */
    public String getNomDepartement() {
        return nomDepartement;
    }
     public int getIdDepartement() {
        return idDepartement;
    }

    public String getCodeDepartement() {
        return codeDepartement;
    }

    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        this.codeDepartement = codeDepartement;
    }

    public void setNomDepartement(String nomDepartement) {
        this.nomDepartement = nomDepartement;
    }

    /*
    AUTRE
     */

    @Override
    public String toString() {
        return "Departement{" + "idDepartement=" + idDepartement + ", codeDepartement=" + codeDepartement + ", nomDepartement=" + nomDepartement + '}';
    }
    
    public Object[] tableauDepartement (Departement d){
       Object[] out = new Object[3] ; 
       
       out[0] =  d.getIdDepartement();
       out[1] = d.getCodeDepartement();
       out[2] = d.getNomDepartement();
       
       return out;
    }
    
}/// class

