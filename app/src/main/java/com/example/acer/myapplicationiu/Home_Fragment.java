package com.example.acer.myapplicationiu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class Home_Fragment extends Fragment {
    GridView griddView;
    String[] values = {"Kontrollo simptomat",
            "Perkujto medikamentet",
            "Lista e medikamenteve",
            "Interaksionet",
            "Gjej doktor",
            "IMT"};

    int[] images = {R.drawable.symptomcheck,
            R.drawable.reminder,
            R.drawable.list,
            R.drawable.interac,
            R.drawable.finddoc,R.drawable.bmi };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        griddView = (GridView)getView().findViewById(R.id.gridVieew);
        GridAdapter gridAdapter = new GridAdapter(getContext(), values, images);
        griddView.setAdapter(gridAdapter);
        griddView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (values[position] == "Kontrollo simptomat")
                {
                    startActivity(new Intent(getContext(),CheckSyptomsActivity.class));
                }
                else if (values[position] == "Perkujto medikamentet")
                {
                    startActivity(new Intent(getActivity(),RememberDrugsActivity.class));
                }
                else if (values[position] == "Lista e medikamenteve")
                {
                    startActivity(new Intent(getContext(),ListaMedikamenteveActivity.class));
                }
                else if (values[position] == "Gjej doktor")
                {
                    startActivity(new Intent(getContext(),FindDoctorActivity.class));
                }
                else
                {
                    startActivity(new Intent(getContext(), Interactions.class));
                }
            }
        });


    }
}

