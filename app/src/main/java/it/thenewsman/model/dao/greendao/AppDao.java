package it.thenewsman.model.dao.greendao;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import it.thenewsman.model.user.DaoMaster;
import it.thenewsman.model.user.DaoSession;

public class AppDao extends Application {
    /** A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher. */
    public static final boolean ENCRYPTED = true;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "the-newsman-db-encrypted" : "the-newsman-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}