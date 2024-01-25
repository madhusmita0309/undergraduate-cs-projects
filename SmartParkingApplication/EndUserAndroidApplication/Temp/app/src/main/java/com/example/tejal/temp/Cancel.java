package com.example.tejal.temp;

import android.app.Dialog;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.tejal.temp.fragments.myBooking;
import com.example.tejal.temp.fragments.tac;

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
 * Created by Tejal on 16-04-2016.
 */
public class Cancel extends AppCompatActivity {

    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();


    EditText USER_NAME, USER_PASS;

    String sessionid,username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cancel);
        username = getIntent().getStringExtra("username");
        sessionid = getIntent().getStringExtra("sessionid");
        Toast.makeText(getApplicationContext(), sessionid,Toast.LENGTH_LONG).show();
       cancel(sessionid);




    }

    private void cancel(String sessionid) {
        class CancelAsync extends AsyncTask<String, Void, String> {


           // private Dialog loadingDialog;


         /*   protected void onPreExecute() {
                Toast.makeText(getBaseContext(),"cancel",Toast.LENGTH_LONG).show();
                super.onPreExecute();
              // loadingDialog = ProgressDialog.show(Cancel.this, "Please wait", "Cancelling...");
            }

           */
            @Override
            protected String doInBackground(String... params) {
                String sid = params[0];
              //  String pass = params[1];

                InputStream is = null;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("sessionid", sid));
                //nameValuePairs.add(new BasicNameValuePair("password", pass));
                String result = null;

                try{
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://52.36.114.94/website6/cancel.php");  /************************************/
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
                Toast.makeText(getBaseContext(), "onpostexecute", Toast.LENGTH_LONG).show();
                Log.d("tejal", result);
                Toast.makeText(getBaseContext(),result,Toast.LENGTH_LONG).show();
               String s = result.trim();
              //  loadingDialog.dismiss();
                if(s.equalsIgnoreCase("success")){
                    Intent intent = new Intent(Cancel.this, MainActivity.class);
                    intent.putExtra("username", username);
                    Toast.makeText(getApplicationContext(),"Booking cancelled",Toast.LENGTH_LONG).show();

                    startActivity(intent);
                    finish();
                }else {

                    Toast.makeText(getApplicationContext(), "Booking not cancelled", Toast.LENGTH_LONG).show();

                    FragmentManager fn = getFragmentManager();
                    fn.beginTransaction().replace(R.id.content_frame, new myBooking()).commit();
                    finish();


                }
            }
        }

        CancelAsync la = new CancelAsync();
        la.execute(sessionid);

    }



}



