package qe.fr.cinescopemobile2017;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GestionnaireDepartementSQLite extends SQLiteOpenHelper {
    private static final int DB_VERSION = 5;
    private static final String DB_NAME = "cinescope2017.db";

    private static final String DROP_TABLE_DEPARTEMENT = "DROP TABLE IF EXISTS departement";
    private static final String CREATE_TABLE_DEPARTEMENT = "CREATE TABLE IF NOT EXISTS departement(ID_DEPARTEMENT INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "CODE_DEPARTEMENT VARCHAR(3) NOT NULL UNIQUE, NOM_DEPARTEMENT VARCHAR(50) NOT NULL UNIQUE)";

    // -------------------------------
    public GestionnaireDepartementSQLite(Context contexte, SQLiteDatabase.CursorFactory fabrique) {
        /*
         * Cree la BD si elle n'existe pas et du coup execute le code de onCreate()
         * Se connecte si elle existe
         */
        super(contexte, DB_NAME, fabrique, DB_VERSION);
    } /// GestionnaireOuvertureSQLite()

    @Override
    // -----------------
    public void onCreate(SQLiteDatabase abd) {
        /*
         * Creation de la table departement
         */
        abd.execSQL(CREATE_TABLE_DEPARTEMENT);

        /*
         * Remplissage de la table pour les tests
         */
        //abd.execSQL("INSERT INTO departement(ID_DEPARTEMENT, CODE_DEPARTEMENT, NOM_DEPARTEMENT) VALUES()");

    } /// onCreate()

    @Override
    // ------------------
    public void onUpgrade(SQLiteDatabase abd, int ancienneVersion, int nouvelleVersion) {
        /*
         * Suppression de la table puis appel a la creation des tables
         */
        abd.execSQL(DROP_TABLE_DEPARTEMENT);
        onCreate(abd);

    } /// onUpgrade()

} /// class GestionnaireOuvertureSQLite
