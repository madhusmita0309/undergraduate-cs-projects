package com.example.madhusmita.wordscramble;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity2Activity extends ActionBarActivity {

    public static final String score1="score1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }
      private EditText edit;
    private TextView text1,answer;
    public static int i=0;
    public static int correct=0;
    public static int wrong=0;

    final String words[]={"adroit","altruist","astute","candor","blithe","brevity","congenial","dainty","enigma","fidelity","inert",
            "infatuation","levity","lumos","mistify","officious","patronus","pensive","pious","rustic","seduce","sloth","zeal","vex",
            "taciturn"};
    final String Scramble[]={"oitadr","trsuitla","uetsat","rocnda","thlibe","ryvbeit","ccoanigne","naidty","ingaem","ylitedif",
            "tirne","fautinatoin","vielty","solum","itsmiyf","fiofciuos","ortapusn","isnepev","oiups","tiscur","ucdees","tohsl","rutnicat","exv","aelz"};


    public void startg(View v)
    {
        Button button1=(Button)v;

        text1 = (TextView) findViewById(R.id.txt1);
        answer = (TextView) findViewById(R.id.ans);
        edit=(EditText)findViewById(R.id.edi);

        text1.setText(Scramble[0]);
        i=1;

    }
    public void game(View v){


        Button button=(Button)v;
        text1 = (TextView) findViewById(R.id.txt1);
        answer = (TextView) findViewById(R.id.ans);
        edit=(EditText)findViewById(R.id.edi);


        if(i<=25) {

            if((edit.getText().toString()).equals(words[i-1]))
            {
                correct++;
                answer.setText("CORRECT");

            }
            else {
                wrong++;
                answer.setText("WRONG");

            }
            if(i<25)
            {text1.setText(Scramble[i]);}
        }
         i++;

        if(!(i<=25)) {

            Intent getStats=new Intent(MainActivity2Activity.this,MainActivity22Activity.class);
            getStats.putExtra("Score",correct);
            startActivity(getStats);
        }
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
}
