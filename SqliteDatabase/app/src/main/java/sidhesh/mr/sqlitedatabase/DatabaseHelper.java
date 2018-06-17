package sidhesh.mr.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

/**
 * Created by Felix-ITS on 22-02-2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;

    public static final String DATABASE_NAME = "register.db";
    public static final String TABLE_NAME = "register";
    public static final String COL_1 = "Id";
    public static final String COL_2 = "Name";
    public static final String COL_3 = "Mail";
    public static final String COL_4 = "Password";

    private static final String CREATE_TABLE_QUERY = "CREATE TABLE" + TABLE_NAME
            + "("
            + COL_1 + "INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + COL_2 + "TEXT ,"
            + COL_3 + "TEXT ,"
            + COL_4 + "TEXT "
            + ")";

    private String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_QUERY);

        onCreate(db);
    }

    public void addUser(Register register) {

        db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL_2, register.getName());
        cv.put(COL_3, register.getEmail());
        cv.put(COL_4, register.getPasswrd());

        long Id = db.insert(TABLE_NAME, null, cv);
        db.close();

    return Id;
}

    public List<Register> getUsers() {
        String[] users = {
                COL_1,
                COL_2,
                COL_3,
                COL_4
        };
        String sortOrder = COL_2 + " USERNAME";
        List<Register>userList= new ArrayList<Register>();
        db=this.getReadableDatabase();

        Cursor cursor= db.query(TABLE_NAME,
                users,
                null,
                null,
                null,
                null,
                sortOrder);

        if (cursor.moveToFirst()){
            do {
                Register register= new Register();
                register.setName(cursor.getString(cursor.getColumnIndex(COL_2)));
                register.setEmail(cursor.getString(cursor.getColumnIndex(COL_3)));
                register.setPasswrd(cursor.getString(cursor.getColumnIndex(COL_4)));

                userList.add(register);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return userList;
    }

}
