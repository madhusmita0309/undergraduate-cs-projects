package com.example.tejal.temp.fragments;

import android.app.Dialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.TagLostException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

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
 * Created by Tejal on 25-01-2016.
 */
public class myprofile extends Fragment {

    @Nullable

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

    public TextView carno;
    public TextView conno;
    public TextView email;
    public TextView licence;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.my_profile, container, false);
       Bundle bundle = getArguments();
        String username = bundle.getString("USERNAME");
       // String username = getArguments().getString("username");



        Toast.makeText(getActivity(),username,Toast.LENGTH_LONG).show();
        TextView tv = (TextView)rootView.findViewById(R.id.username);
        tv.setText(username);

        list = (ListView) rootView.findViewById(R.id.listview);
        slotList = new ArrayList<HashMap<String, String>>();

        profileinfo(username);
        return rootView;


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
                Toast.makeText(getActivity(), result, Toast.LENGTH_LONG).show();

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
                String pid = c.getString(TAG_ID);
               // Toast.makeText(getActivity(), pid, Toast.LENGTH_LONG).show();

                String pname = c.getString(TAG_NAME);
                String available_slots = c.getString(TAG_ADD);
                String car_no = c.getString(TAG_CAR); /******************************************************/
               // Toast.makeText(getActivity(),pid , Toast.LENGTH_LONG).show();

                carno = (TextView)getActivity().findViewById(R.id.carno);
                conno = (TextView)getActivity().findViewById(R.id.conno);
                email = (TextView)getActivity().findViewById(R.id.email);
                licence = (TextView)getActivity().findViewById(R.id.licence);


                carno.setText("User id : "+pid);
                conno.setText("Contact no : "+pname);
                email.setText("Licence no : "+available_slots);
                licence.setText("Car no : "+car_no);

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

}
