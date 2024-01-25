package com.example.tejal.temp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import org.w3c.dom.Text;

/**
 * Created by Tejal on 14-04-2016.
 */
public class Last extends AppCompatActivity implements View.OnClickListener{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last);
        String sessionid = getIntent().getStringExtra("sessionid");
        Button back = (Button)findViewById(R.id.back);

        back.setOnClickListener(this);
        TextView si = (TextView)findViewById(R.id.sessionid);
        si.setText("Session id for current booking is "+ sessionid);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.back: {



                startActivity(new Intent(Last.this, MainActivity.class));
                finish();


            }
            break;
        }
    }
}
