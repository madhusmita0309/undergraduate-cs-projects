package com.example.tejal.operator.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.tejal.operator.Logreg;
import com.example.tejal.operator.R;

/**
 * Created by Tejal on 13-03-2016.
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

                Intent intent = new Intent(getActivity(),Logreg.class);

                Toast.makeText(getActivity(), "You have successfully logged out!", Toast.LENGTH_LONG).show();
                startActivity(intent);
            }
        });
        return rootView;

    }


}

