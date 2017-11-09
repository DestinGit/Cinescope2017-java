package entities;

/**
 *
 * @author 
 */
public class Arrondissement {

    private int idArrondissement;
    private String codeArrondissement;
    private String nomArrondissement;

    //************ CONSTRUCTEUR ********\\
    // Constructeur Vide
    /**
     *
     */
    public Arrondissement() {
    }

    // Constructeur MoitiÃ© Plein
    /**
     *
     * @param codeArrondissement
     * @param nomArrondissement
     */
    public Arrondissement(String codeArrondissement, String nomArrondissement) {
        this.codeArrondissement = codeArrondissement;
        this.nomArrondissement = nomArrondissement;
    }

    // Constructeur Plein
    /**
     *
     * @param idArrondissement
     * @param codeArrondissement
     * @param nomArrondissement
     */
    public Arrondissement(int idArrondissement, String codeArrondissement, String nomArrondissement) {
        this.idArrondissement = idArrondissement;
        this.codeArrondissement = codeArrondissement;
        this.nomArrondissement = nomArrondissement;
    }
    //******** Fin CONSTRUCTEUR ********\\

    //******** GETTERS and SETTERS ********\\
    /**
     *
     * @return
     */
    public int getIdArrondissement() {
        return idArrondissement;
    }

    /**
     *
     * @param idArrondissement
     */
    public void setIdArrondissement(int idArrondissement) {
        this.idArrondissement = idArrondissement;
    }

    /**
     *
     * @return
     */
    public String getCodeArrondissement() {
        return codeArrondissement;
    }

    /**
     *
     * @param codeArrondissement
     */
    public void setCodeArrondissement(String codeArrondissement) {
        this.codeArrondissement = codeArrondissement;
    }

    /**
     *
     * @return
     */
    public String getNomArrondissement() {
        return nomArrondissement;
    }

    /**
     *
     * @param nomArrondissement
     */
    public void setNomArrondissement(String nomArrondissement) {
        this.nomArrondissement = nomArrondissement;
    }
    //******** Fin GETTERS and SETTERS ********\\

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Arrondissement{" + "idArrondissement=" + idArrondissement + ", codeArrondissement=" + codeArrondissement + ", nomArrondissement=" + nomArrondissement + '}';
    }

}

