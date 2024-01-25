package com.example.tejal.temp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
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
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Search extends ActionBarActivity implements View.OnClickListener{
    String myJSON;

    public static final String TAG_RESULTS = "result";
    public static final String TAG_ID = "pid";
    public static final String TAG_NAME = "pname";
    public static final String TAG_ADD = "available_slots";
    public static final String TAG_PRICE = "price";

    public EditText ID;
    public Button next;
    TextView loc;

    JSONArray peoples = null;

    ArrayList<HashMap<String, String>> slotList;

    ListView list;
    public String location,username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        location = getIntent().getStringExtra("location");
        username = getIntent().getStringExtra("username");
        TextView loc = (TextView) findViewById(R.id.loc);
        loc.setText(location);
        ID = (EditText)findViewById(R.id.id);

        next = (Button)findViewById(R.id.next);
        next.setOnClickListener(this);

        list = (ListView) findViewById(R.id.listview);
        slotList = new ArrayList<HashMap<String, String>>();
        getData(location);
    }


    public void showList() {
        try {

          //  Toast.makeText(getBaseContext(), "showlist", Toast.LENGTH_LONG).show();
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);
            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                String pid = c.getString(TAG_ID);
                String pname = c.getString(TAG_NAME);
                String available_slots = c.getString(TAG_ADD);


                String price = c.getString(TAG_PRICE);


                HashMap<String, String> persons = new HashMap<String, String>();
                persons.put(TAG_ID, pid);
                persons.put(TAG_NAME, pname);
                persons.put(TAG_ADD, available_slots);
                persons.put(TAG_PRICE, price);
                slotList.add(persons);


            }
            ListAdapter adapter = new SimpleAdapter(Search.this, slotList, R.layout.list_item, new String[]{TAG_ID, TAG_NAME, TAG_ADD, TAG_PRICE}, new int[]{R.id.id, R.id.name, R.id.address, R.id.price});
            list.setAdapter(adapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void getData(final String location) {/**/
        class GetDataJSON extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {

            /**/
                String loc = location;
            /**/

                InputStream is = null;
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("location", loc));

                String result = null;

                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpPost httpPost = new HttpPost("http://52.36.114.94/website6/search2.php");
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public void onClick(View v) {

        String id = ID.getText().toString();

        switch (v.getId()) {
            case R.id.next:
             if (id.equals("")) {

                    Toast.makeText(getBaseContext(), "Please enter location id", Toast.LENGTH_LONG).show();


                } else {

                    Intent intent = new Intent(Search.this,Bookaslot.class);
                    intent.putExtra("locationid", id);
                    intent.putExtra("username", username);
                    startActivity(intent);
               }
                break;

        }
    }
}

