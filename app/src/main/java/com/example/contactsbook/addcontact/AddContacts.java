package com.example.contactsbook.addcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.contactsbook.MainActivity;
import com.example.contactsbook.R;
import com.example.contactsbook.db.DatabaseHelper;

public class AddContacts extends AppCompatActivity {

    EditText et_firstname,et_lastname,et_phone,et_email;
    Button btn_save;

    String FirstName="";
    String LastName="";
    String Email="";
    String Phone="";

    private DatabaseHelper dbHelper;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);
        et_firstname=(EditText)findViewById(R.id.et_firstname);
        et_lastname=(EditText)findViewById(R.id.et_lastname);
        et_phone=(EditText)findViewById(R.id.et_phone);
        et_email=(EditText)findViewById(R.id.et_email);
        btn_save=(Button)findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveConatct();
            }
        });

    }

    private void saveConatct() {
        FirstName=et_firstname.getText().toString();
         LastName=et_lastname.getText().toString();
         Email=et_email.getText().toString();
        Phone=et_phone.getText().toString();
        dbHelper=new DatabaseHelper(this);


     if(isvalidate()){
         dbHelper.insertContact(FirstName,LastName,Email,Phone);

         Toast.makeText(AddContacts.this,"Contact created Successfully",Toast.LENGTH_LONG).show();

         Intent refresh = new Intent(this, MainActivity.class);
         startActivity(refresh);
         this.finish();
     }





       /* if(FirstName.isEmpty()&&LastName.isEmpty()&&Phone.isEmpty()){
            Toast.makeText(AddContacts.this,"Please Enter FirstName or LastName or Phone number",Toast.LENGTH_LONG).show();
        }else{

        }*/
    }

    private boolean isvalidate() {

        if(FirstName.equalsIgnoreCase("")){
            Toast.makeText(AddContacts.this,"Please enter first name",Toast.LENGTH_LONG).show();
            return false;
        }
        if(LastName.equalsIgnoreCase("")){
            Toast.makeText(AddContacts.this,"Please enter last name",Toast.LENGTH_LONG).show();
            return false;
        }
        if(Phone.equalsIgnoreCase("")){
            Toast.makeText(AddContacts.this,"Please enter phone number ",Toast.LENGTH_LONG).show();
            return false;
        }
        if(Email.equalsIgnoreCase("")){
            Toast.makeText(AddContacts.this,"Please enter phone number ",Toast.LENGTH_LONG).show();
            return false;
        }
        if (!Email.matches(emailPattern))
        {
            Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
