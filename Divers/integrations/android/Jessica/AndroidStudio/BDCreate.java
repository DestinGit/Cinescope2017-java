package jl.fr.cinescope2017;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class BDCreate extends Activity implements View.OnClickListener {

    private Button buttonBDCreate;
    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bd_create);

        buttonBDCreate = (Button) findViewById(R.id.buttonBDCreate);
        buttonBDCreate.setOnClickListener(this);

        textViewMessage = (TextView) findViewById(R.id.textViewMessage);
    }

    @Override
    public void onClick(View v) {

        String lsURL = "http://172.26.10.8:8084/Cinescope2017Web/";
        String lsRessource = "Arrondissement";
        new TAExterneArrondissement(new MyCallBack(this,textViewMessage)).execute(lsURL, lsRessource);

    } /// onClick

    private static class MyCallBack implements MyCallBackInterface {

        private TextView textViewContenu;
        private Context contexte;

        public MyCallBack(Context contexte, TextView textViewMessage) {
            this.textViewContenu = textViewMessage;
            this.contexte = contexte;
        }

        @Override
        public void onTaskFinished(String result) {

            StringBuilder lsbMessage = new StringBuilder();
            GestionnaireOuvertureSQLite gos;
            SQLiteDatabase bd;
            ContentValues hmValeurs;

            try {
                // Connexion
                // --- GestionnaireOuvertureSQLite(Contexte, Fabrique de curseur);
                gos = new GestionnaireOuvertureSQLite(contexte, null);
                bd = gos.getWritableDatabase();

                lsbMessage.append("Connexion réussie");
                lsbMessage.append("\n");

                // Suppression du contenu de la table
                // SQLiteDatabase.delete(String table, String whereClause, String[] whereArgs)
                bd.delete("arrondissement", null, null);

                // Creation de la table
                // cf GOS

                // Insertion dans la table
                // cf GOS + ce qui suit
                JSONArray tableauJSON = null;
                tableauJSON = new JSONArray(result);
                JSONObject objetJSON;
                long llNum = 0;

                for (int i = 0; i < tableauJSON.length(); i++) {
                    objetJSON = tableauJSON.getJSONObject(i);
                    hmValeurs = new ContentValues();
                    hmValeurs.put("ID_ARRONDISSEMENT", objetJSON.getString("id").toString());
                    hmValeurs.put("CODE_ARRONDISSEMENT",objetJSON.getString("code").toString() );
                    hmValeurs.put("NOM_ARRONDISSEMENT", objetJSON.getString("nom").toString());
                    llNum = bd.insert("arrondissement", null, hmValeurs);
                }

                lsbMessage.append("Enregistrements ajoutés");
                lsbMessage.append("\n");

                // Deconnexion
                gos.close();
                lsbMessage.append("Vous êtes déconnecté !");
                lsbMessage.append("\n");
                bd = null;

            } catch (Exception e) {
                lsbMessage.append("Aïe, aïe, aïe ! ");
                lsbMessage.append(e.getMessage());
                lsbMessage.append("\n");
            }

            textViewContenu.setText(lsbMessage);
        }
    }


} //// classe
