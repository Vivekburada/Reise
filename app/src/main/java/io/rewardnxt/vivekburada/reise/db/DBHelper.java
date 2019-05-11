package io.rewardnxt.vivekburada.reise.db;


import java.util.ArrayList;
import java.util.HashMap;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "usermodel";
    public static final String CONTACTS_TABLE_NAME = "USERS";
    public static final String CONTACTS_COLUMN_EMAIL = "email";

    private HashMap hp;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(
                "create table USERS " +
                        "(email  text  primary key, password text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS USERS");
        onCreate(db);
    }

    public boolean insertUsers (String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        db.insert("USERS", null, contentValues);
        return true;
    }

    public Cursor getData(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from USERS where email= email ", null );
        return res;


    }

    public boolean login(String email, String password)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor resultSet = db.rawQuery("Select * from USERS where email = email and password = password",null);
        resultSet.moveToFirst();
        if(resultSet.isNull(0))
            return false;
        else
            return true;



    }


    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, CONTACTS_TABLE_NAME);
        return numRows;
    }

    public boolean updateUsers ( String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        db.update("USERS", contentValues, "email = ? ", new String[] { email } );
        return true;
    }



    public ArrayList<String> getAllUsers() {
        ArrayList<String> array_list = new ArrayList<String>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from Users", null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_EMAIL)));
            res.moveToNext();
        }
        return array_list;
    }
}