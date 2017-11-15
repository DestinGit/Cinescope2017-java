package qe.fr.cinescopemobile2017;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;
import org.json.*;

/**
 *
 */
public class Importation extends AppCompatActivity implements View.OnClickListener {

    private Button buttonImportDepartements;
    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.importation);

        initInterface();
        initEvents();
    }/// onCreate

    private void initInterface() {

        buttonImportDepartements = (Button) findViewById(R.id.buttonImportDepartements);
        textViewMessage = (TextView) findViewById(R.id.textViewMessage);
    }/// initInterface

    private void initEvents() {

        buttonImportDepartements.setOnClickListener(this);
    }/// initEvents


    @Override
    public void onClick(View v) {

        if (v == buttonImportDepartements) {

            textViewMessage.setText(" ");
            String ip = "http://172.26.10.151";
            String port = "8084";
            String chemin = "Cinescope2017Web";
            String ressource = "DepartementSelectAll";

            Log.i("Test département", ressource);
            new TacheASynchroneExterneString(new MyCallBack(textViewMessage, this)).execute(ip, port, chemin, ressource);
        }

    }/// onClick


    //==================================MyCallBack==============================================//

    /**
     *
     */
    private static class MyCallBack implements MyCallBackInterface {

        private TextView textViewMessage;
        private Context contexte;
        private int liAffecte;

        public MyCallBack(TextView textViewMessage, Context contexte) {
            this.textViewMessage = textViewMessage;
            this.contexte = contexte;
        }

        @Override
        public void onTaskFinished(String result) {
            Log.i("Ceci est:", " un test");
            textViewMessage.setText(result);
            StringBuilder lsbMessage = new StringBuilder();
            GestionnaireDepartementSQLite gds;
            SQLiteDatabase bd;
            ContentValues hmValeurs;

            // Connexion
            // --- GestionnaireOuvertureSQLite(Contexte, Fabrique de curseur);
            gds = new GestionnaireDepartementSQLite(contexte, null);
            bd = gds.getWritableDatabase();

            /*
             * Insertion des données du JSONArray dans la table departement
             */
            try {
                JSONArray JSONResults = new JSONArray(result);
                JSONObject departement = new JSONObject();
                for (int i = 0; i < JSONResults.length(); i++) {
                    departement = JSONResults.getJSONObject(i);
                    hmValeurs = new ContentValues();
                    hmValeurs.put("ID_DEPARTEMENT", departement.get("ID_DEPARTEMENT").toString());
                    hmValeurs.put("CODE_DEPARTEMENT", departement.get("CODE_DEPARTEMENT").toString());
                    hmValeurs.put("NOM_DEPARTEMENT", departement.get("NOM_DEPARTEMENT").toString());
                    long llNum = bd.insert("departement", null, hmValeurs);
                    liAffecte = (int) llNum;
                }
                lsbMessage.append(Integer.toString(liAffecte) + " enregistrement(s) inséré(s) dans la table.");
                lsbMessage.append("\n\n\n");

                /*
                 * Visualisation des données insérées dans la table
                 */
                lsbMessage.append("Liste des départements :");
                lsbMessage.append("\n");
                String[] cols = {"ID_DEPARTEMENT", "CODE_DEPARTEMENT", "NOM_DEPARTEMENT"};
                Cursor curseur = bd.query("departement", cols, null, null, null, null, null);
                while (curseur.moveToNext()) {
                    lsbMessage.append(curseur.getInt(0));
                    lsbMessage.append(" - ");
                    lsbMessage.append(curseur.getString(1));
                    lsbMessage.append(" - ");
                    lsbMessage.append(curseur.getString(2));
                    lsbMessage.append(";");
                    lsbMessage.append("\n");
                }
                curseur.close();

            } catch (JSONException e) {
                e.getMessage();
            }catch (Exception e) {
                lsbMessage.append("Aïe, aïe, aïe ! ");
                lsbMessage.append(e.getMessage());
                lsbMessage.append("\n");
            }

            // Deconnexion
            gds.close();
            lsbMessage.append("\n\n\n");
            lsbMessage.append("Vous êtes déconnecté(e) !");
            lsbMessage.append("\n");
            bd = null;

            /*
             * Affichage des données dans le textView
             */
            textViewMessage.setText(lsbMessage.toString());
        }
    }

    //==================================ItemMenu==============================================//

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return MenuItemChoix.menuItemChoix(this, item.getItemId());
    } // onOptionsItemSelected

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }/// onCreateOptionsMenu

}/// class Importation
