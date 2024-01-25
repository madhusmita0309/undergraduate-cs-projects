package com.example.tejal.temp.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tejal.temp.Logreg;
import com.example.tejal.temp.MainActivity;
import com.example.tejal.temp.R;
import com.example.tejal.temp.Reg;
import com.example.tejal.temp.SearchByLoc;

/**
 * Created by Tejal on 25-01-2016.
 */
public class logout extends Fragment {


    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.logout, container, false);

        Button logout = (Button)rootView.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){

                Intent intent = new Intent(getActivity(), Logreg.class);

                Toast.makeText(getActivity(), "You have successfully logged out!", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
        return rootView;

    }


}
