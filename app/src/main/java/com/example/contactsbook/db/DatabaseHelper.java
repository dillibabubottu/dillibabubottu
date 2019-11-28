package com.example.contactsbook.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.contactsbook.model.ContactListBean;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Information
    static final String DB_NAME = "CONTACTS.DB";

    // database version
    static final int DB_VERSION = 1;
    // Table Name
    public static final String TABLE_NAME = "CONTACTSLIST";

    // Table columns
    public static final String _ID = "_id";
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String PROFILEPIC = "profilepic";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";


    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + FIRSTNAME + " TEXT NOT NULL, " + LASTNAME + " TEXT, "+PROFILEPIC+" TEXT, "+
        EMAIL+" TEXT, "+PHONE+" TEXT);";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }


    public void insertvalues(ArrayList<ContactListBean>alContactList) {
        SQLiteDatabase db = this.getWritableDatabase();
      //  ContactListBean contactListBean=new ContactListBean();
        for (int i = 0; i < alContactList.size(); i++) {

            ContentValues contentValue = new ContentValues();
            contentValue.put(DatabaseHelper._ID, alContactList.get(i).getId());
            contentValue.put(DatabaseHelper.FIRSTNAME, alContactList.get(i).getFirstName());
            contentValue.put(DatabaseHelper.LASTNAME, alContactList.get(i).getLastName());
            contentValue.put(DatabaseHelper.PROFILEPIC, alContactList.get(i).getProfilePic());
            contentValue.put(DatabaseHelper.EMAIL, alContactList.get(i).getEmail());
            contentValue.put(DatabaseHelper.PHONE, alContactList.get(i).getPhoneNumber());
            db.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
        }
        db.close();
    }

    public ArrayList<ContactListBean> loadValuesfromDB() {
ContactListBean contactListBean;
        ArrayList<ContactListBean> alContactList=new ArrayList<>();
//        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        String selectQuery = "SELECT  * FROM " + TABLE_NAME+" order by FIRSTNAME asc";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                contactListBean=new ContactListBean();
                contactListBean.setFirstName(cursor.getString(1));
                contactListBean.setLastName(cursor.getString(2));
                contactListBean.setProfilePic(cursor.getString(3));
                contactListBean.setEmail(cursor.getString(4));
                contactListBean.setPhoneNumber(cursor.getString(5));

               alContactList.add(contactListBean);
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();



        return alContactList;
    }

    public void insertContact(String firstName, String lastName, String email, String phone) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.FIRSTNAME, firstName);
        contentValue.put(DatabaseHelper.LASTNAME, lastName);
        contentValue.put(DatabaseHelper.PROFILEPIC, "");
        contentValue.put(DatabaseHelper.EMAIL, email);
        contentValue.put(DatabaseHelper.PHONE, phone);
        db.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
        db.close();
    }
}
