package com.example.tejal.temp;

/**
 * Created by Tejal on 07-02-2016.
 */

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Reg extends ActionBarActivity {

    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

    EditText USER_NAME, USER_PASS, CON_PASS, CAR_NO, CONTACT_NO, LIC_NO;
    String User_name, User_pass, Con_pass, Car_no, Contact_no,lic_no;
    Button REG;
    int code;
    InputStream is = null;
    String result = null;
    String line=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg);
        REG = (Button) findViewById(R.id.button);
        REG.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String result = null;
                InputStream is = null;
                USER_NAME = (EditText) findViewById(R.id.name);
                USER_PASS = (EditText) findViewById(R.id.password);
                CON_PASS = (EditText) findViewById(R.id.confirm);
                CAR_NO = (EditText) findViewById(R.id.carno);
                CONTACT_NO = (EditText) findViewById(R.id.conno);
                LIC_NO = (EditText) findViewById(R.id.licenceno);

                User_name = USER_NAME.getText().toString();
                User_pass = USER_PASS.getText().toString();
                Con_pass = CON_PASS.getText().toString();
                Car_no = CAR_NO.getText().toString();
                Contact_no = CONTACT_NO.getText().toString();
                lic_no = LIC_NO.getText().toString();


                if (User_name.equalsIgnoreCase("") || User_pass.equals("") || Con_pass.equals("") || Car_no.equals("") || Contact_no.equals("") || lic_no.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter all fields", Toast.LENGTH_LONG).show();
                }
                else
                if(((Car_no.matches("[A-Z]"+"[A-Z]"+"[0-9]"+"[0-9]"+"[A-Z]"+"[A-Z]"+"[0-9]"+"[0-9]"+"[0-9]"+"[0-9]"))&&Car_no.length()==10)
                        &&lic_no.length()==16 &&
                        lic_no.matches("[A-Z]"+"[A-Z]"+"-"+"[0-9]"+"[0-9]"+"[0-9]"+"[0-9]"+"[0-9]"+"[0-9]"+"[0-9]"+"[0-9]"+"[0-9]"+"[0-9]"+"[0-9]"+"[0-9]"+"[0-9]")
                        && Contact_no.length()==10)





                {
                    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();


                    nameValuePairs.add(new BasicNameValuePair("name", User_name));
                    nameValuePairs.add(new BasicNameValuePair("password", User_pass));
                    nameValuePairs.add(new BasicNameValuePair("carno", Car_no));
                    nameValuePairs.add(new BasicNameValuePair("contactno", Contact_no));
                    nameValuePairs.add(new BasicNameValuePair("licno", lic_no));

                    StrictMode.setThreadPolicy(policy);


                    //http post
                    try {
                        HttpClient httpclient = new DefaultHttpClient();
                        HttpPost httppost = new HttpPost("http://52.36.114.94/website6/insert.php");
                        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                        HttpResponse response = httpclient.execute(httppost);
                        HttpEntity entity = response.getEntity();
                        is = entity.getContent();

                        Log.e("log_tag", "connection success ");
                        Toast.makeText(getApplicationContext(), "pass", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        Log.e("log_tag", "Error in http connection " + e.toString());
                        Toast.makeText(getApplicationContext(), "Connection fail", Toast.LENGTH_SHORT).show();

                    }
                    //convert response to string
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
                        StringBuilder sb = new StringBuilder();
                        String line = null;
                        while ((line = reader.readLine()) != null) {
                            sb.append(line + "\n");
                            Intent i = new Intent(getBaseContext(), Logreg.class);
                            startActivity(i);
                            finish();
                        }
                        is.close();

                        result = sb.toString();
                    } catch (Exception e) {
                        Log.e("log_tag", "Error converting result " + e.toString());
                    }


                    try {

                        JSONObject json_data = new JSONObject(result);

                        CharSequence w = (CharSequence) json_data.get("re");

                        Toast.makeText(getApplicationContext(), w, Toast.LENGTH_SHORT).show();


                    } catch (JSONException e) {
                        Log.e("log_tag", "Error parsing data " + e.toString());
                        // Toast.makeText(getApplicationContext(), "JsonArray fail", Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Enter valid data",Toast.LENGTH_LONG).show();
                }
            }

        });

    }


}