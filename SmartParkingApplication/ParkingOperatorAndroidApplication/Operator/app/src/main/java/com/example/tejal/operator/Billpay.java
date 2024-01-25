package com.example.tejal.operator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Tejal on 13-03-2016.
 */
public class Billpay  extends AppCompatActivity implements View.OnClickListener {


    private static Button yes;
    private static Button no;
    String response=null;
TextView tv;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.billpay);
        response=getIntent().getStringExtra("s");
        Toast.makeText(getBaseContext(),response,Toast.LENGTH_LONG).show();
        tv=(TextView)findViewById(R.id.textViewresult);
        tv.setText(response);
        yes = (Button) findViewById(R.id.yes);
        yes.setOnClickListener(this);
        no = (Button) findViewById(R.id.no);
        no.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.yes: {
                //Toast.makeText(getBaseContext(), response, Toast.LENGTH_LONG).show();
                //Toast.makeText(getBaseContext(), "Transaction completed!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Billpay.this, MainActivity.class));
                finish();

                break;
            }

            case R.id.no: {
                //Toast.makeText(getBaseContext(), response, Toast.LENGTH_LONG).show();
                // Toast.makeText(getBaseContext(), "Bill payment not done!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(Billpay.this, MainActivity.class));
                finish();
                break;
            }

        }

    }
}
