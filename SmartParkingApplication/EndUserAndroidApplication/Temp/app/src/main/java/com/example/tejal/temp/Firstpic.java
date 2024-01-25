package com.example.tejal.temp;

/**
 * Created by Tejal on 04-02-2016.
 */
        import java.util.Timer;
        import java.util.TimerTask;
        import android.os.Bundle;
        import android.app.Activity;
        import android.content.Intent;


public class Firstpic extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstpic);

        if(getIntent().getBooleanExtra("exit", false)){
            finish();
        }
        else
        {
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                public void run() {
                    Intent i=new Intent(Firstpic.this,Logreg.class);
                    startActivity(i);
                    finish();
                }

            }, 2000);

        }

    }

}