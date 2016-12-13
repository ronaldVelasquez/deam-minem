package pe.gob.minem.deam.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ronaldvelasquez on 10/12/16.
 */

/*
* CREATE TABLE contacts (
 contact_id integer PRIMARY KEY,
 first_name text NOT NULL,
 last_name text NOT NULL,
 email text NOT NULL UNIQUE,
 phone text NOT NULL UNIQUE
);*/

public class DenunciasHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "DENUNCIAS";

    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_DENUNCIA =
            "CREATE TABLE " + DenunciaContract.DenunciaEntry.TABLE_NAME + " (" +
                    DenunciaContract.DenunciaEntry._ID + INT_TYPE + " PRIMARY KEY, " +
                    DenunciaContract.DenunciaEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    DenunciaContract.DenunciaEntry.COLUMN_NAME_DESCRIPTION + TEXT_TYPE + " )";
    private static final String SQL_CREATE_PERSON = "";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DenunciaContract.DenunciaEntry.TABLE_NAME;

    public DenunciasHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_DENUNCIA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

}
