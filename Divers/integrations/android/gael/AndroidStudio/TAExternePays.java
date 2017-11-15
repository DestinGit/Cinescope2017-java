package pb.fr.cinescope2017;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by pascal
 */
public class TAExterneSQLite extends AsyncTask<String, Integer, String> {

    private TextView textViewMessage;
    private Context contexte;

    public TAExterneSQLite(Context contexte, TextView textViewMessage) {
        super();
        this.textViewMessage = textViewMessage;
        this.contexte = contexte;
    } /// Constructeur

    // ----------------------------
    protected String doInBackground(String... asParametres) {
        // String... parametre : nombre variable d'arguments
        // Se deplace dans un thread d'arriere-plan
        StringBuilder lsbResultat = new StringBuilder();
        String lsURL = "";
        URL urlConnection = null;
        HttpURLConnection httpConnection = null;
        boolean lbErreur = false;

        try {
            // Probleme avec les espaces
            // Donc URL_encode ...
            //lsURL = "http://" + Globale.getIp() + "/gc/bo/php/dao/HabiliteInsert.php";
            lsURL = "http://172.26.10.63:8084/Cinescope2017Web/SQLite";

            // Instanciation de HttpURLConnection avec l'objet url
            urlConnection = new URL(lsURL);
            httpConnection = (HttpURLConnection) urlConnection.openConnection();

            // Connexion
            httpConnection.connect();
            // Lecture du flux de la REPONSE
            InputStream inputStream = httpConnection.getInputStream();
            // Comme l'on recoit un flux Text ASCII
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));


            String lsLigne = "";
            while ((lsLigne = br.readLine()) != null) {
                if (!lsLigne.trim().equals("")) {
                    lsbResultat.append(lsLigne);
                    lsbResultat.append("\n");
                }
            }
            br.close();
            inputStream.close();

        } catch (UnsupportedEncodingException e) {
            lsbResultat.append(e.getMessage());
            lbErreur = true;

        } catch (IOException e) {
            lsbResultat.append(e.getMessage());
            lbErreur = true;
        } finally {
            // Deconnexion
            httpConnection.disconnect();
        }

        if (lbErreur) {
            lsbResultat.setLength(0);
            lsbResultat.append("Erreur réseau");
        }

        // Renvoie la valeur a onPostExecute
        return lsbResultat.toString();
    } /// doInBackground

    @Override
    // -------------------------
    protected void onPostExecute(String asResultat) {

        textViewMessage.setText(asResultat.toString());
        getSQLITE(this.contexte, asResultat);
        insertPays(asResultat);

    } /// onPostExecute

    /**
     *
     * @param con
     * @param resultat
     */
    public void getSQLITE(Context con, String resultat) {


        StringBuilder lsbMessage = new StringBuilder();
        GestionnaireOuvertureSQLite gos;
        SQLiteDatabase bd;

        try {
            // Connexion
            // --- GestionnaireOuvertureSQLite(Contexte, Fabrique de curseur);
            gos = new GestionnaireOuvertureSQLite(con, null, resultat);
            bd = gos.getWritableDatabase();

            // Deconnexion
            gos.close();
            lsbMessage.append("Vous êtes déconnecté(e) !");
            lsbMessage.append("\n");
            bd = null;

        } catch (Exception e) {
            lsbMessage.append("Aïe, aïe, aïe ! ");
            lsbMessage.append(e.getMessage());
            lsbMessage.append("\n");
        }


    }
        public static void insertPays(String asResultat) {

            ContentValues hmValeurs;
            JSONArray tableauJSON;

            String lsChemin = "/data/data/pb.fr.cinescope2017/databases/cinescope2017.db";
            SQLiteDatabase bd = SQLiteDatabase.openDatabase(lsChemin, null, SQLiteDatabase.OPEN_READWRITE);

            try {

                long llAffectes = bd.delete("pays", null, null);
                Log.e("liAffectes sup", Long.toString(llAffectes));
                bd.beginTransaction();

                Log.i("dans OPEN_READWRITE :", asResultat.toString());
                tableauJSON = new JSONArray(asResultat);
                JSONObject objetJSON;

                for (int i = 0; i < tableauJSON.length(); i++) {
                    objetJSON = (JSONObject) tableauJSON.get(i);
                    hmValeurs = new ContentValues();

                    hmValeurs.put("id_pays", Integer.parseInt(objetJSON.get("ID_PAYS").toString()));
                    hmValeurs.put("nom_pays", objetJSON.get("NOM_PAYS").toString());
                    hmValeurs.put("Masculin", objetJSON.get("MASCULIN").toString());
                    hmValeurs.put("Feminin", objetJSON.get("FEMININ").toString());
                    hmValeurs.put("Neutre", objetJSON.get("NEUTRE").toString());

                    // --- Insertion
                     bd.insert("pays", null, hmValeurs);

                }

                bd.setTransactionSuccessful();
                bd.endTransaction();
                bd.close();

            } catch (Exception e) {
                Log.i("erreur", e.getMessage());

            }

        } /// insertPays


} /// class
