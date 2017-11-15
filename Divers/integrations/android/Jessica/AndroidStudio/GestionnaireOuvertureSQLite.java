package jl.fr.cinescope2017;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/*
 * Classe Helper pour la gestion de l'ouverture de la BD
 * La connexion a la BD en somme ou la creation et connexion si elle n'existe pas
 * Methodes : constructeur, onCreate, onUpgrade
 */

// -------------------------------------
public class GestionnaireOuvertureSQLite extends SQLiteOpenHelper {
    private static final int DB_VERSION = 4;
    private static final String DB_NAME = "cinescope.db";

    private static final String DROP_TABLE_ARRONDISSEMENT = "DROP TABLE IF EXISTS arrondissement";
    private static final String CREATE_TABLE_ARRONDISSEMENT = "CREATE TABLE IF NOT EXISTS arrondissement(ID_ARRONDISSEMENT INTEGER PRIMARY KEY AUTOINCREMENT, CODE_ARRONDISSEMENT VARCHAR(5) NOT NULL UNIQUE, NOM_ARRONDISSEMENT VARCHAR(50) NOT NULL UNIQUE)";

    // --- Constructeur
    // -------------------------------
    public GestionnaireOuvertureSQLite(Context contexte, CursorFactory fabrique) {
        // --- Cree la BD si elle n'existe pas
        // --- et de ce fait execute le code de onCreate()
        // --- Se connecte si elle existe
        super(contexte, DB_NAME, fabrique, DB_VERSION);
    } /// GestionnaireOuvertureSQLite()

    @Override
    // -----------------
    public void onCreate(SQLiteDatabase abd) {
        // --- Creation de la table arrondissement
        abd.execSQL(CREATE_TABLE_ARRONDISSEMENT);

    } /// onCreate()

    @Override
    // ------------------
    public void onUpgrade(SQLiteDatabase abd, int ancienneVersion, int nouvelleVersion) {
        // --- Suppression de la table puis appel a la creation des tables
        abd.execSQL(DROP_TABLE_ARRONDISSEMENT);
        onCreate(abd);
    } /// onUpgrade()

} /// class GestionnaireOuvertureSQLite
