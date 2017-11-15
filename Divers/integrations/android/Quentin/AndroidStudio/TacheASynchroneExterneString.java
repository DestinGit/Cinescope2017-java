package qe.fr.cinescopemobile2017;


import android.os.AsyncTask;

import java.io.*;
import java.net.*;

public class TacheASynchroneExterneString extends AsyncTask<String, Integer, String> {

    private MyCallBackInterface myCallBack;

    public TacheASynchroneExterneString(MyCallBackInterface myCallBack) {
        this.myCallBack = myCallBack;
    }

    @Override
    protected String doInBackground(String... asParametres) {
        StringBuilder lsbContenu = new StringBuilder();

        /*
         * Déclaration d'une String pour la connection
         */
        String lsURL = asParametres[0] + ":" + asParametres[1] + "/" + asParametres[2] + "/" + asParametres[3];
        /*
         * Déclaration d'un Objet URL ainsi qu'un Objet HttpURLConnection
         */
        URL url = null;
        HttpURLConnection httpConnection = null;

        try {

            /*
             * Création d'un objet URL à partir d'une String
             */
            url = new URL(lsURL);

            /*
             * Instanciation d'un objet HttpURLConnection à partir de l'Objet URL
             */
            httpConnection = (HttpURLConnection) url.openConnection();

            /*
             * Connexion
             */
            httpConnection.connect();

            /*
             * Execution de la requete parametree Lecture du flux de la REPONSE
             */
            InputStream inputStream = httpConnection.getInputStream();

            /*
             * Comme l'on recoit un flux
             */
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String lsLigne = "";
            while ((lsLigne = br.readLine()) != null) {
                lsbContenu.append(lsLigne);
            }
            br.close();
            inputStream.close();

        } catch (IOException e) {
            lsbContenu.append(e.getMessage());
        } finally {
            // Deconnexion
            httpConnection.disconnect();
        }

        return lsbContenu.toString();

    }/// doInBackground


    @Override
    protected void onPostExecute(String result) {

        myCallBack.onTaskFinished(result);

    }/// onPostExecute

}/// class TacheASynchroneExterneString
