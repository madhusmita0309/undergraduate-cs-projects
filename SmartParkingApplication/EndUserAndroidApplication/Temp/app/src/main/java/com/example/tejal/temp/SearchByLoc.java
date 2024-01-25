package com.example.tejal.temp;

/**
 * Created by Tejal on 14-02-2016.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;


public class SearchByLoc extends AppCompatActivity implements View.OnClickListener {
    String[] locations;
    String location, username;
    private static Button view;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchbyloc);
        view = (Button) findViewById(R.id.view);
        view.setOnClickListener(this);
        username = getIntent().getStringExtra("username");
        locations = getResources().getStringArray(R.array.locations);
        Spinner s1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, locations);

        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//int index = arg0.getSelectedItemPosition();
                Toast.makeText(getBaseContext(), locations[arg2] + " : Opted as your location",
                        Toast.LENGTH_SHORT).show();
                location = locations[arg2];


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

                Toast.makeText(getBaseContext(), "Select your location",
                        Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.view:

            {
                // Toast.makeText(getBaseContext(),"cgngj",Toast.LENGTH_LONG).show();
                //startActivity(new Intent(SearchByLoc.this, Bookaslot.class));
                //  startActivity(new Intent(SearchByLoc.this, Search.class));
                Intent intent = new Intent(SearchByLoc.this, Search.class);
                intent.putExtra("location", location);
                intent.putExtra("username",username);
                startActivity(intent);


                //finish();

                break;

            }
        }
    }

}
