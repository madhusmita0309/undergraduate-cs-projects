package com.example.tejal.temp;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tejal on 13-03-2016.
 */
public class Booknow  extends AppCompatActivity implements View.OnClickListener{


    private static Button booknow;
    public String userid, username, locationid, carno, hrs, mins;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booknow);
        userid = getIntent().getStringExtra("userid");
        username = getIntent().getStringExtra("username");
        locationid = getIntent().getStringExtra("locationid");
        carno = getIntent().getStringExtra("carno");
        hrs = getIntent().getStringExtra("hrs");
        mins = getIntent().getStringExtra("mins");

        TextView details = (TextView)findViewById(R.id.details);
        details.setText("User id :"+userid+"\nUsername :"+ username+"\nLocation id :"+locationid+"\nCar no :"+carno+"\nDuration :"+hrs+":"+mins);
        booknow=(Button)findViewById(R.id.booknow);
        booknow.setOnClickListener(this);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.booknow: {
                /*Toast.makeText(getBaseContext(), "Slot booked successfully", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Booknow.this, MainActivity.class));
                finish();*/
                booking(userid,locationid, carno, hrs, mins);

            }
            break;
        }
    }

    private void booking(String userid, String locationid, String carno, String hrs, String mins) {

        class BookAsync extends AsyncTask<String, Void, String> {

            private Dialog loadingDialog;

            @Override
             protected void onPreExecute() {
                super.onPreExecute();
                loadingDialog = ProgressDialog.show(Booknow.this, "Please wait", "Loading...");
            }

            @Override
            protected String doInBackground(String... params) {
                String userid = params[0];
                String locationid = params[1];
                String carno = params[2];
                String hrs = params[3];
                String mins = params[4];


                InputStream is = null;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("userid", userid));
                nameValuePairs.add(new BasicNameValuePair("locationid", locationid));
                nameValuePairs.add(new BasicNameValuePair("carno", carno));
                nameValuePairs.add(new BasicNameValuePair("hrs", hrs));

                nameValuePairs.add(new BasicNameValuePair("mins", mins));
                String result = null;

                try{
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost(
                            "http://52.36.114.94/website6/book.php");
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
                if(s.equalsIgnoreCase("0")){
                    Toast.makeText(getApplicationContext(), "Booking UNSUCCESSFUL", Toast.LENGTH_LONG).show();


                }else if (s.equalsIgnoreCase("noslots"))
                    Toast.makeText(getApplicationContext(), "No slots available", Toast.LENGTH_LONG).show();

                else if(s.equalsIgnoreCase("invalid"))
                    Toast.makeText(getApplicationContext(), "reservation already made", Toast.LENGTH_LONG).show();


                else {
                    String sessionid = s;
                    Toast.makeText(getApplicationContext(), "Booking SUCCESSFUL", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(Booknow.this, Last.class);
                    intent.putExtra("sessionid", sessionid);


                   finish();
                    startActivity(intent);
                }
            }
        }

        BookAsync la = new BookAsync();
        la.execute(userid, locationid, carno, hrs, mins);

    }
}

