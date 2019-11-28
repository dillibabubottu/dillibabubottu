package com.example.contactsbook.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.contactsbook.model.ContactListBean;

import java.util.ArrayList;

public class ContactsDBManager {
    private  DatabaseHelper dbHelper;

    private  Context context;

    private static SQLiteDatabase database;

    public ContactsDBManager(Context c) {
        context = c;
    }

    public static ArrayList<ContactListBean> loadValuesfromDB() {
        ArrayList<ContactListBean> alContacts=new ArrayList<>();
        ContactListBean contactListBean;

        String selectQuery = "SELECT  * FROM " + DatabaseHelper.TABLE_NAME;
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do{
                contactListBean=new ContactListBean();

                contactListBean.setFirstName(cursor.getString(1));

                alContacts.add(contactListBean);

            }while (cursor.moveToNext());
        }

        return alContacts;
    }

    public ContactsDBManager open() throws SQLException {

        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.FIRSTNAME, DatabaseHelper.LASTNAME,DatabaseHelper.PROFILEPIC,DatabaseHelper.EMAIL,DatabaseHelper.PHONE };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String firstname, String  lastname,String profilepic,String email,String phone ) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.FIRSTNAME, firstname);
        contentValue.put(DatabaseHelper.LASTNAME, lastname);
        contentValue.put(DatabaseHelper.PROFILEPIC, profilepic);
        contentValue.put(DatabaseHelper.EMAIL, email);
        contentValue.put(DatabaseHelper.PHONE, phone);
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.FIRSTNAME, DatabaseHelper.LASTNAME,DatabaseHelper.PROFILEPIC,DatabaseHelper.EMAIL,DatabaseHelper.PHONE };
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, String firstname, String  lastname,String profilepic,String email,String phone) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.FIRSTNAME, firstname);
        contentValues.put(DatabaseHelper.LASTNAME, lastname);
        contentValues.put(DatabaseHelper.PROFILEPIC, profilepic);
        contentValues.put(DatabaseHelper.EMAIL, email);
        contentValues.put(DatabaseHelper.PHONE, phone);
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }






}
