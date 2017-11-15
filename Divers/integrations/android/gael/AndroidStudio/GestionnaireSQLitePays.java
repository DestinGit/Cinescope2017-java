package pb.fr.cinescope2017;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/*
 * Classe Helper pour la gestion de l'ouverture de la BD
 * La connexion a la BD en somme ou la creation et connexion si elle n'existe pas
 * Methodes : constructeur, onCreate, onUpgrade
 */

// -------------------------------------
public class GestionnaireOuvertureSQLite extends SQLiteOpenHelper {
    private static final int DB_VERSION = 7;
    private static final String DB_NAME = "cinescope2017.db";
    private String donnees;

    private static final String DROP_TABLE_PAYS = "DROP TABLE IF EXISTS pays";
//    private static final String CREATE_TABLE_PAYS = "CREATE TABLE IF NOT EXISTS pays(id_pays INTEGER PRIMARY KEY AUTOINCREMENT, nom_pays VARCHAR(50) NOT NULL UNIQUE," +
//            " Masculin VARCHAR(50) NOT NULL UNIQUE, Feminin VARCHAR(50) NOT NULL UNIQUE, Neutre VARCHAR(50) NOT NULL UNIQUE)";
    //private static final String CREATE_TABLE_PAYS = "CREATE TABLE IF NOT EXISTS pays (id_pays INTEGER PRIMARY KEY AUTOINCREMENT, nom_pays VARCHAR(50))";
    private static final String CREATE_TABLE_PAYS = "CREATE TABLE IF NOT EXISTS pays(id_pays INTEGER PRIMARY KEY , nom_pays VARCHAR(50) ," +
          " Masculin VARCHAR(50) , Feminin VARCHAR(50), Neutre VARCHAR(50))";

    // --- Constructeur
    // -------------------------------
    public GestionnaireOuvertureSQLite(Context contexte, CursorFactory fabrique, String donnees) {
        // --- Cree la BD si elle n'existe pas
        // --- et de ce fait execute le code de onCreate()
        // --- Se connecte si elle existe
        super(contexte, DB_NAME, fabrique, DB_VERSION);

        this.donnees = donnees;
        Log.i("donnes dans GOSQLITE", donnees.toString());
    } /// GestionnaireOuvertureSQLite()

    @Override
    // -----------------
    public void onCreate(SQLiteDatabase abd) {
        // --- Creation de la table pays

        Log.i("OnCeate","on est dedans");
        abd.execSQL(CREATE_TABLE_PAYS);

        /*
         * Pour les tests
         */

    } /// onCreate()

    @Override
    // ------------------
    public void onUpgrade(SQLiteDatabase abd, int ancienneVersion, int nouvelleVersion) {
        // --- Suppression de la table puis appel a la creation des tables
        abd.execSQL(DROP_TABLE_PAYS);
        onCreate(abd);
    } /// onUpgrade()

} /// class GestionnaireOuvertureSQLite