package com.example.tejal.temp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tejal on 13-03-2016.
 */
public class Bookaslot  extends AppCompatActivity implements View.OnClickListener{


    private static Button bookaslot;
    String id, username;

    String myJSON;

    public static final String TAG_RESULTS = "result";
    public static final String TAG_ID = "userid";
    public static final String TAG_NAME = "contactno";
    public static final String TAG_ADD = "dlicense";
    public static final String TAG_CAR = "carno";

    TextView loc;

    JSONArray peoples = null;


    ArrayList<HashMap<String, String>> slotList;
    ListView list;

    public String user_id, car_no, duration, locationid;
    public TextView carno;
    public TextView conno;
    public TextView email;
    public TextView licence;
    public TextView userid;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookaslot);
        id = getIntent().getStringExtra("locationid");
        username =  getIntent().getStringExtra("username");
        TextView username1 = (TextView)findViewById(R.id.username);
        username1.setText("Username: "+ username);
        TextView lid = (TextView)findViewById(R.id.id);
        lid.setText("Location id :"+ id);
        bookaslot=(Button)findViewById(R.id.bookaslot);
        bookaslot.setOnClickListener(this);

        list = (ListView)findViewById(R.id.listview);
        slotList = new ArrayList<HashMap<String, String>>();

        profileinfo(username);



    }



    public void profileinfo(final String username) {/**/
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {

            /**/
                String uname = username;
            /**/

                InputStream is = null;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("username", uname));

                String result = null;

                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://52.36.114.94/website6/myprofile.php");/*********************/
                    httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = httpClient.execute(httpPost);

                    HttpEntity entity = response.getEntity();

                    is = entity.getContent();

                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
                    StringBuilder sb = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null) {
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
            protected void onPostExecute(String result) {
                Log.d("tejal", result);
               // Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();

                myJSON = result;
                showList();

            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();
    }

    public void showList() {
        try {

            Toast.makeText(getBaseContext(), "showlist", Toast.LENGTH_LONG).show();
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);
            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                user_id = c.getString(TAG_ID);
                // Toast.makeText(getActivity(), pid, Toast.LENGTH_LONG).show();

                String contactno = c.getString(TAG_NAME);
                String dlicense = c.getString(TAG_ADD);
                car_no = c.getString(TAG_CAR); /******************************************************/
                // Toast.makeText(getActivity(),pid , Toast.LENGTH_LONG).show();

               /* carno = (TextView)findViewById(R.id.carno);
                conno = (TextView)findViewById(R.id.conno);
                email = (TextView)findViewById(R.id.email);
                licence = (TextView)findViewById(R.id.licence);
*/
                TextView userid = (TextView)findViewById(R.id.userid);
                TextView carno = (TextView)findViewById(R.id.carno);
                userid.setText("User id: "+ user_id);
                carno.setText("Car no:" + car_no);

               /* carno.setText(pid);
                conno.setText(pname);
                email.setText(available_slots);
                licence.setText(car_no);
*/
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
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
        EditText hrs1 = (EditText)findViewById(R.id.hrs);
        String hrs =hrs1.getText().toString();
        int hrsn = Integer.parseInt(hrs1.getText().toString());



        EditText mins1 = (EditText)findViewById(R.id.mins);
        String mins =mins1.getText().toString();
        int minsn = Integer.parseInt(mins1.getText().toString());


        switch(v.getId()) {
            case R.id.bookaslot:
                    if (hrs.equals("")|| mins.equals(""))
                   Toast.makeText(getBaseContext(), "Please enter a valid duration!", Toast.LENGTH_LONG).show();

                    else if(hrsn>2 ||  minsn>60)
                    {
                    Toast.makeText(getBaseContext()," Duration cannot be more than 2 hrs 59 minutes", Toast.LENGTH_LONG).show();
                    }


                    else {
                        Intent intent = new Intent(Bookaslot.this,Booknow.class);
                        intent.putExtra("hrs", hrs);
                        intent.putExtra("mins",mins);

                        intent.putExtra("userid", user_id);
                        intent.putExtra("locationid", id);
                        intent.putExtra("carno", car_no);
                        intent.putExtra("username", username);

                        startActivity(intent);
                        finish();


                        break;
                    }


        }
    }
}

