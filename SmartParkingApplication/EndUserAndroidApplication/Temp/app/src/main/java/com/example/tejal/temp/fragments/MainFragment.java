package com.example.tejal.temp.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.tejal.temp.R;
import com.example.tejal.temp.SearchByLoc;
import com.example.tejal.temp.SearchByMap;

/**
 * Created by Tejal on 25-01-2016.
 */
public class MainFragment extends Fragment
{


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);


        Bundle bundle = getArguments();
        final String username = bundle.getString("USERNAME");
        // String username = getArguments().getString("username");

        Toast.makeText(getActivity(),username,Toast.LENGTH_LONG).show();
        //CODE TO START ANOTHER ACTIVITY FROM A FRAGMENT
        Button searchbyloc = (Button)rootView.findViewById(R.id.searchbyloc);
        searchbyloc.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), SearchByLoc.class);
                intent.putExtra("username",username);
                startActivity(intent);
            }
        });

        //CODE TO START NEW ACTIVITY FROM A FRAGMENT
        /*Button searchbymap = (Button)rootView.findViewById(R.id.searchbymap);
        searchbymap.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v){

                Intent intent = new Intent(getActivity(), SearchByMap.class);
                startActivity(intent);
            }
        });*/
        return rootView;
    }


}

