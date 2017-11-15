package daos;

/**
 *
 * @author Timot
 */
import entities.Ville;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VilleDAO implements IDAO<Ville> {

    private final Connection icnx;

    /**
     *
     * @param icnx
     */
    public VilleDAO(Connection icnx) {
        this.icnx = icnx;
    }

    /**
     *
     * @param objet
     * @return
     */
    @Override
    public int insert(Ville objet) {
        int liAffecte;
        try {

            String lrSQL = "CALL villeInsert(?,?,?)";
            PreparedStatement lpst = icnx.prepareStatement(lrSQL);
            lpst.setInt(1, objet.getIDDepartement());
            lpst.setString(2, objet.getCP());
            lpst.setString(3, objet.getNomVille());

            liAffecte = lpst.executeUpdate();

            //icnx.commit();
            lpst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            liAffecte = -1;
        }

        return liAffecte;
    }// inserte

    @Override
    public List<Ville> selectAll() {
        ArrayList<Ville> lVille = new ArrayList<>();

        Ville v;
        ResultSet lrs;
        try {

            String lrSQL = "CALL villeSelectAll()";
            PreparedStatement lpst = icnx.prepareStatement(lrSQL);
            lrs = lpst.executeQuery();
            while (lrs.next()) {
                v = new Ville();
                v.setIDVille(lrs.getInt("ID_ville"));
                v.setIDDepartement(lrs.getInt("ID_departement"));
                v.setCP(lrs.getString("CP"));
                v.setNomVille(lrs.getString("NOM_ville"));

                lVille.add(v);
            }

            lrs.close();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return lVille;
    }

    @Override
    public Ville selectOne(int id) {
        Ville v = new Ville();
        ResultSet lrs;
        try {

            String lrSQL = "CALL villeSelectOne(?)";
            PreparedStatement lpst = icnx.prepareStatement(lrSQL);
            lpst.setInt(1, id);
            lrs = lpst.executeQuery();
            if (lrs.next()) {
                v.setIDVille(lrs.getInt("ID_ville"));
                v.setIDDepartement(lrs.getInt("ID_departement"));
                v.setCP(lrs.getString("CP"));
                v.setNomVille(lrs.getString("NOM_ville"));
            } else {
                v.setIDVille(lrs.getInt(0));
                v.setIDDepartement(lrs.getInt(0));
                v.setCP(lrs.getString("inconnue"));
                v.setNomVille(lrs.getString("inconnue"));
            }

            lrs.close();
            lpst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return v;
    }

    @Override
    public int delete(Ville v) {
        int liAffecte = 0;

        try {
            String lrSQL = "CALL villeDelete(?)";
            PreparedStatement lpst = icnx.prepareStatement(lrSQL);
            lpst.setInt(1, v.getIDVille());

            System.out.println(lpst);
            liAffecte = lpst.executeUpdate();
            //icnx.commit();
            lpst.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return liAffecte;
    }

    @Override
    public int update(Ville v) {
        int out = 0;

        try {
            String lrSQL = "CALL villeUpdate(?,?,?,?)";
            PreparedStatement lpst = icnx.prepareStatement(lrSQL);
            lpst.setInt(1, v.getIDDepartement());
            lpst.setString(2, v.getCP());
            lpst.setString(3, v.getNomVille());
            lpst.setInt(4, v.getIDVille());

            out = lpst.executeUpdate();

           // icnx.commit();
            lpst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

        return out;
    }

}
