package pe.gob.minem.deam.db;

import android.provider.BaseColumns;

/**
 * Created by ronaldvelasquez on 10/12/16.
 */

public class DenunciaContract {
    private  DenunciaContract() {
    }

    public static class DenunciaEntry implements BaseColumns {
        public static final String TABLE_NAME = "denuncia";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_TITLE = "titulo";
        public static final String COLUMN_NAME_DESCRIPTION = "descripcion";

    }
}
