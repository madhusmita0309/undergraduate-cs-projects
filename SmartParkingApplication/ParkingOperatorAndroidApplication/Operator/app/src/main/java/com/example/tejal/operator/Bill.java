package com.example.tejal.operator;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tejal on 13-03-2016.
 */public class Bill extends AppCompatActivity implements View.OnClickListener {

    EditText sid,carno;
    String sidstrng,carnostrng;
    private static Button bill;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bill);
        bill=(Button)findViewById(R.id.bill);
       bill.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        sid = (EditText) findViewById(R.id.sessionid);
        carno = (EditText) findViewById(R.id.carno);
        sidstrng = sid.getText().toString();
        carnostrng = carno.getText().toString();
        switch(v.getId()) {
            case R.id.bill:
                if(sidstrng.equals("")||carnostrng.equals(""))
                {

                    Toast.makeText(getBaseContext(), "Please enter Session id!!!", Toast.LENGTH_LONG).show();


                }
                else if(carnostrng.matches("[A-Z]"+"[A-Z]"+"[0-9]"+"[0-9]"+"[A-Z]"+"[A-Z]"+"[0-9]"+"[0-9]"+"[0-9]"+"[0-9]")){
                    billfn(sidstrng, carnostrng);

                }
                else
                {
                    Toast.makeText(getBaseContext(), "Please Enter Valid Car Number!", Toast.LENGTH_LONG).show();
                }
                break;


        }
    }
    private void billfn(final String sidstrng, String carnostrng) {

        class LoginAsync extends AsyncTask<String, Void, String> {

            private Dialog loadingDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loadingDialog = ProgressDialog.show(Bill.this, "Please wait", "Loading...");
            }

            @Override
            protected String doInBackground(String... params) {
                String sidstr = params[0];

                String carnostr = params[1];
                InputStream is = null;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("sessionid", sidstr));
                nameValuePairs.add(new BasicNameValuePair("carno", carnostr));

                String result = null;

                try{
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(
                            "http://52.36.114.94/website6/bill.php");
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();

                    is = entity.getContent();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null)
                    {
                        sb.append(line + "\n");
                    }
                    result = sb.toString();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

            @Override
            protected void onPostExecute(String result){
                String s = result.trim();
                loadingDialog.dismiss();
                // tv=(TextView)findViewById(R.id.textView5);
                //tv.setText(s);
                //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(Bill.this, Billpay.class);
                intent.putExtra("s",s);
                finish();
                startActivity(intent);
                /*if(s.equalsIgnoreCase("")){
                    Intent intent = new Intent(Logreg.this, MainActivity.class);
                    intent.putExtra(USER_NAME, username);
                    finish();
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Invalid User Name or Password", Toast.LENGTH_LONG).show();
                }*/
            }
        }

        LoginAsync la = new LoginAsync();
        la.execute(sidstrng,carnostrng);

    }
}

