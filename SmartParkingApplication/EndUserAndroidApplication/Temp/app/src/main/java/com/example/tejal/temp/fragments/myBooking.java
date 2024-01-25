package com.example.tejal.temp.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tejal.temp.Bookaslot;
import com.example.tejal.temp.Cancel;
import com.example.tejal.temp.R;

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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Tejal on 25-01-2016.
 */
public class myBooking extends Fragment implements View.OnClickListener{
    String myJSON;

    public static final String TAG_RESULTS = "result";
    public static final String TAG_ID = "pname";
    public static final String TAG_NAME = "status";
    public static final String TAG_ADD = "sessionid";
    String sessionid;
   // public static final String TAG_CAR = "carno";

    Button cancel;

    TextView loc, view1;

    JSONArray peoples = null;
    String username;

    ArrayList<HashMap<String, String>> slotList;

    ListView list;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.booking, container, false);
        Bundle bundle = getArguments();
         username = bundle.getString("USERNAME");
        cancel = (Button)rootView.findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
        Toast.makeText(getActivity(), username, Toast.LENGTH_LONG).show();
       // TextView tv = (TextView)rootView.findViewById(R.id.username);
      //  tv.setText(username);

        list = (ListView) rootView.findViewById(R.id.listview);
        slotList = new ArrayList<HashMap<String, String>>();

        mybooking(username);

        return rootView;

    }

    private void mybooking(final String username) {
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
                    HttpPost httpPost = new HttpPost("http://52.36.114.94/website6/viewbook.php");/*********************/
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
                if (result.equals(""))
                    Toast.makeText(getActivity(),"No Booking",Toast.LENGTH_LONG).show();
               else {
             //  Toast.makeText(getActivity(), result, Toast.LENGTH_LONG).show();

                }

                myJSON = result;

                showList();

            }
        }
        GetDataJSON g = new GetDataJSON();
        g.execute();


    }


    public void showList() {
        try {

            Toast.makeText(getActivity(), "showlist", Toast.LENGTH_LONG).show();
            JSONObject jsonObj = new JSONObject(myJSON);
            peoples = jsonObj.getJSONArray(TAG_RESULTS);
            for (int i = 0; i < peoples.length(); i++) {
                JSONObject c = peoples.getJSONObject(i);
                String pname = c.getString(TAG_ID);

                String status = c.getString(TAG_NAME);
                sessionid = c.getString(TAG_ADD);
                view1 = (TextView)getActivity().findViewById(R.id.view1);



                view1.setText("Location :"+pname + "\n Status :"+ status + "\n Session id :"+ sessionid);   /**********************************************************/
              /*  HashMap<String, String> persons = new HashMap<String, String>();
                persons.put(TAG_ID, pid);
                persons.put(TAG_NAME, pname);
                persons.put(TAG_ADD, available_slots);
                slotList.add(persons);*/


            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void onClick(View v)
    {
        String id = view1.getText().toString();

        switch (v.getId()) {
            case R.id.cancel:
                if (id.equals("")) {

                    Toast.makeText(getActivity(), "No Booking", Toast.LENGTH_LONG).show();


                } else {

                    Intent intent = new Intent(getActivity(), Cancel.class);
                    intent.putExtra("username", username);
                    intent.putExtra("sessionid", sessionid);
                    startActivity(intent);
                }
                break;

        }


    }


}
