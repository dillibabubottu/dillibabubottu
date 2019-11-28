package com.example.contactsbook;



import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsbook.adapter.ContactListAdapter;
import com.example.contactsbook.addcontact.AddContacts;
import com.example.contactsbook.common.Constants;
import com.example.contactsbook.db.ContactsDBManager;
import com.example.contactsbook.db.DatabaseHelper;
import com.example.contactsbook.model.ContactListBean;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ContactsDBManager dbManager;
    private  DatabaseHelper dbHelper;

    RecyclerView rv_Contact_List;

    ArrayList<ContactListBean>alContactList;
    ArrayList<ContactListBean>dbContactList;
    ContactListAdapter contactListAdapter;

    private SimpleCursorAdapter adapter;
    final String[] from = new String[] { DatabaseHelper._ID,
            DatabaseHelper.FIRSTNAME, DatabaseHelper.LASTNAME,DatabaseHelper.PROFILEPIC,DatabaseHelper.EMAIL,DatabaseHelper.PHONE };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_Contact_List=(RecyclerView)findViewById(R.id.rv_contact_list);


        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.floating_action_button);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            Intent addcontactIntent=new Intent(MainActivity.this, AddContacts.class);
            startActivity(addcontactIntent);
            }
        });
        intilizeObjects();




    }

    private void intilizeObjects() {
     //   dbManager = new ContactsDBManager(this);
        dbHelper=new DatabaseHelper(this);
                //dbManager.open();

        alContactList=Constants.getContacts();

        if(alContactList.size()>0){

            dbHelper.insertvalues(alContactList);
           /* for (int i = 0; i <alContactList.size() ; i++) {
                String firstname=alContactList.get(i).getFirstName();
                String lastname=alContactList.get(i).getLastName();
                String profilepic=alContactList.get(i).getProfilePic();
                String email=alContactList.get(i).getEmail();
                String phone=alContactList.get(i).getPhoneNumber();


            }*/
        }

//        dbManager.close();

        dbContactList=dbHelper.loadValuesfromDB();

        contactListAdapter=new ContactListAdapter(MainActivity.this,MainActivity.this,dbContactList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        rv_Contact_List.setLayoutManager(mLayoutManager);
        rv_Contact_List.setItemAnimator(new DefaultItemAnimator());
        rv_Contact_List.setAdapter(contactListAdapter);







    }



}
