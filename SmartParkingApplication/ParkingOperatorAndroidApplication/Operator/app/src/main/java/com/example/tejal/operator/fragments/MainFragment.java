package com.example.tejal.operator.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.Button;

import com.example.tejal.operator.Authenticate;
import com.example.tejal.operator.Bill;
import com.example.tejal.operator.R;

/**
 * Created by Tejal on 13-03-2016.
 */
public class MainFragment extends Fragment {
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button authenticate = (Button)rootView.findViewById(R.id.authenticate);
       authenticate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), Authenticate.class);
                startActivity(intent);
            }
        });

        //CODE TO START NEW ACTIVITY FROM A FRAGMENT
        Button bill = (Button)rootView.findViewById(R.id.bill);
       bill.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), Bill.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
}
