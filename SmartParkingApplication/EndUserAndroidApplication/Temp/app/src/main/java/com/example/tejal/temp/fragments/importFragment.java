package com.example.tejal.temp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tejal.temp.R;

import java.io.FileReader;

/**
 * Created by Tejal on 25-01-2016.
 */
public class importFragment extends Fragment {

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_import, container, false);
        return rootView;



    }
}
