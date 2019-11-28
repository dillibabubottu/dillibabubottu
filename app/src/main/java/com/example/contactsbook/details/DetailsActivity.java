package com.example.contactsbook.details;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.contactsbook.R;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {
String strPicUrl="";
String firstName="";
String lastName="";
String phoneNumber="";
String email="";
ImageView iv_Profile;
TextView tv_name,tv_phone,tv_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle bundle = getIntent().getExtras();

        if(bundle.getString("url")!= null){
            strPicUrl=bundle.getString("url");
        }  if(bundle.getString("first_name")!= null){
            firstName=bundle.getString("first_name");
            lastName=bundle.getString("last_name");

        }  if(bundle.getString("phone")!= null) {
            phoneNumber = bundle.getString("phone");
        } if(bundle.getString("email")!= null) {
            email = bundle.getString("email");
        }
        iv_Profile=(ImageView)findViewById(R.id.iv_profilePic);
        tv_name=(TextView) findViewById(R.id.tv_name);
        tv_phone=(TextView) findViewById(R.id.tv_phone);
        tv_email=(TextView) findViewById(R.id.tv_email);

        tv_name.setText(firstName+" "+lastName);
        tv_phone.setText(phoneNumber);
        tv_email.setText(email);




      //  loadProfilePic();

    }

    private void loadProfilePic() {
        Glide.with(this)
                .load(strPicUrl)
                .into(iv_Profile);
    }
}
