package com.example.contactsbook.common;

import com.example.contactsbook.model.ContactListBean;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Constants {

    public static String JsonString = "[\n" +
            "  {\n" +
            "  \"id\": 1,\n" +
            "  \"first_name\": \"Amitabh\",\n" +
            "  \"last_name\": \"Bachchan\",\n" +
            "  \"profile_pic\": \"https://firebasestorage.googleapis.com/v0/b/api-demo-f6647.appspot.com/o/thumbnails%2Fab.jpg?alt=media&token=60f4183d-6ec0-4f76-9ae3-c584b4e58c9b\",\n" +
            "  \"favorite\": false,\n" +
            "  \"email\": \"ab@gmail.com\",\n" +
            "  \"phone_number\": \"+919980123123\",\n" +
            "  \"created_at\": \"2016-05-29T10:10:10.995Z\",\n" +
            "  \"updated_at\": \"2016-05-29T10:10:10.995Z\"\n" +
            "},\n" +
            "  {\n" +
            "  \"id\": 2,\n" +
            "  \"first_name\": \"Shahrukh\",\n" +
            "  \"last_name\": \"Khan\",\n" +
            "  \"profile_pic\": \"https://firebasestorage.googleapis.com/v0/b/api-demo-f6647.appspot.com/o/thumbnails%2Fsrk.jpg?alt=media&token=5b837761-f4a1-4216-9c86-5f71936fffc5\",\n" +
            "  \"favorite\": false,\n" +
            "  \"email\": \"srk@gmail.com\",\n" +
            "  \"phone_number\": \"+919980123412\",\n" +
            "  \"created_at\": \"2016-05-29T10:10:10.995Z\",\n" +
            "  \"updated_at\": \"2016-05-29T10:10:10.995Z\"\n" +
            "  },\n" +
            "  {\n" +
            "  \"id\": 3,\n" +
            "  \"first_name\": \"Aishwarya\",\n" +
            "  \"last_name\": \"Rai\",\n" +
            "  \"profile_pic\": \"https://firebasestorage.googleapis.com/v0/b/api-demo-f6647.appspot.com/o/thumbnails%2Fa_rai.jpg?alt=media&token=b10772d4-2d5d-446a-9e00-060cb79a80de\",\n" +
            "  \"favorite\": false,\n" +
            "  \"email\": \"a_rai@gmail.com\",\n" +
            "  \"phone_number\": \"+919980123124\",\n" +
            "  \"created_at\": \"2016-05-29T10:10:10.995Z\",\n" +
            "  \"updated_at\": \"2016-05-29T10:10:10.995Z\"\n" +
            "  },\n" +
            "  {\n" +
            "  \"id\": 4,\n" +
            "  \"first_name\": \"Shreya\",\n" +
            "  \"last_name\": \"Ghoshal\",\n" +
            "  \"profile_pic\": \"https://firebasestorage.googleapis.com/v0/b/api-demo-f6647.appspot.com/o/thumbnails%2Fsg.jpeg?alt=media&token=27a62bc8-0e69-4e79-9541-17d10c6fd374\",\n" +
            "  \"favorite\": false,\n" +
            "  \"email\": \"s_ghoshal@gmail.com\",\n" +
            "  \"phone_number\": \"+919980123125\",\n" +
            "  \"created_at\": \"2016-05-29T10:10:10.995Z\",\n" +
            "  \"updated_at\": \"2016-05-29T10:10:10.995Z\"\n" +
            "  },\n" +
            "  {\n" +
            "  \"id\": 5,\n" +
            "  \"first_name\": \"Arjun\",\n" +
            "  \"last_name\": \"Rampal\",\n" +
            "  \"profile_pic\": \"https://firebasestorage.googleapis.com/v0/b/api-demo-f6647.appspot.com/o/thumbnails%2Far.jpg?alt=media&token=f678a062-db31-4922-b5b7-8027cbbe7eeb\",\n" +
            "  \"favorite\": false,\n" +
            "  \"email\": \"arjun@gmail.com\",\n" +
            "  \"phone_number\": \"+919980123126\",\n" +
            "  \"created_at\": \"2016-05-29T10:10:10.995Z\",\n" +
            "  \"updated_at\": \"2016-05-29T10:10:10.995Z\"\n" +
            "  },\n" +
            "  {\n" +
            "  \"id\": 6,\n" +
            "  \"first_name\": \"Deepika\",\n" +
            "  \"last_name\": \"Padukone\",\n" +
            "  \"profile_pic\": \"https://firebasestorage.googleapis.com/v0/b/api-demo-f6647.appspot.com/o/thumbnails%2Fdp.jpg?alt=media&token=09c873fb-8bbb-42f5-bad4-c404b2d28100\",\n" +
            "  \"favorite\": false,\n" +
            "  \"email\": \"deepika@gmail.com\",\n" +
            "  \"phone_number\": \"+919980123127\",\n" +
            "  \"created_at\": \"2016-05-29T10:10:10.995Z\",\n" +
            "  \"updated_at\": \"2016-05-29T10:10:10.995Z\"\n" +
            "  },\n" +
            "  {\n" +
            "  \"id\": 7,\n" +
            "  \"first_name\": \"Ranveer\",\n" +
            "  \"last_name\": \"Singh\",\n" +
            "  \"profile_pic\": \"https://firebasestorage.googleapis.com/v0/b/api-demo-f6647.appspot.com/o/thumbnails%2Frv.png?alt=media&token=924cbef5-23e9-4265-aa6b-d99257005506\",\n" +
            "  \"favorite\": false,\n" +
            "  \"email\": \"r_singh@gmail.com\",\n" +
            "  \"phone_number\": \"+919980123128\",\n" +
            "  \"created_at\": \"2016-05-29T10:10:10.995Z\",\n" +
            "  \"updated_at\": \"2016-05-29T10:10:10.995Z\"\n" +
            "  },\n" +
            "  {\n" +
            "  \"id\": 8,\n" +
            "  \"first_name\": \"Ranbir\",\n" +
            "  \"last_name\": \"Kapoor\",\n" +
            "  \"profile_pic\": \"https://firebasestorage.googleapis.com/v0/b/api-demo-f6647.appspot.com/o/thumbnails%2Frk.jpg?alt=media&token=a72d112f-62ef-47b2-987a-d3f923800c46\",\n" +
            "  \"favorite\": false,\n" +
            "  \"email\": \"rk@gmail.com\",\n" +
            "  \"phone_number\": \"+919980123129\",\n" +
            "  \"created_at\": \"2016-05-29T10:10:10.995Z\",\n" +
            "  \"updated_at\": \"2016-05-29T10:10:10.995Z\"\n" +
            "  },\n" +
            "  {\n" +
            "  \"id\": 9,\n" +
            "  \"first_name\": \"Sunny\",\n" +
            "  \"last_name\": \"Doel\",\n" +
            "  \"profile_pic\": \"https://firebasestorage.googleapis.com/v0/b/api-demo-f6647.appspot.com/o/thumbnails%2Fsd.jpg?alt=media&token=06f35ff9-41dc-44b6-91fc-2657e4b7a787\",\n" +
            "  \"favorite\": false,\n" +
            "  \"email\": \"sunny@gmail.com\",\n" +
            "  \"phone_number\": \"+919980123100\",\n" +
            "  \"created_at\": \"2016-05-29T10:10:10.995Z\",\n" +
            "  \"updated_at\": \"2016-05-29T10:10:10.995Z\"\n" +
            "  },\n" +
            "  {\n" +
            "  \"id\": 10,\n" +
            "  \"first_name\": \"Hrithik\",\n" +
            "  \"last_name\": \"Roshan\",\n" +
            "  \"profile_pic\": \"https://firebasestorage.googleapis.com/v0/b/api-demo-f6647.appspot.com/o/thumbnails%2Fhr.jpg?alt=media&token=dad86ea8-13b9-4cf7-a968-50595c250d68\",\n" +
            "  \"favorite\": false,\n" +
            "  \"email\": \"roshans@gmail.com\",\n" +
            "  \"phone_number\": \"+919980123101\",\n" +
            "  \"created_at\": \"2016-05-29T10:10:10.995Z\",\n" +
            "  \"updated_at\": \"2016-05-29T10:10:10.995Z\"\n" +
            "  }\n" +
            "]";

    public static ArrayList<ContactListBean> getContacts() {

        ArrayList<ContactListBean> contactList = new ArrayList<>();
        ContactListBean contactListBean;
        try {
            JSONArray contactsArray = new JSONArray(Constants.JsonString);
            for (int i = 0; i < contactsArray.length(); i++) {
                JSONObject contactsObj = contactsArray.getJSONObject(i);
                contactListBean = new ContactListBean();
                contactListBean.setId(contactsObj.getString("id"));
                contactListBean.setFirstName(contactsObj.getString("first_name"));
                contactListBean.setLastName(contactsObj.getString("last_name"));
                contactListBean.setProfilePic(contactsObj.getString("profile_pic"));
                contactListBean.setEmail(contactsObj.getString("email"));
                contactListBean.setPhoneNumber(contactsObj.getString("phone_number"));
                contactList.add(contactListBean);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contactList;
    }
}
