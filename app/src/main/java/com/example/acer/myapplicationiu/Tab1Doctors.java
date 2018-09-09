package com.example.acer.myapplicationiu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ListViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tab1Doctors extends Fragment {
    EditText editText;
    String [] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;
    Button button;
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_doctors, container, false);
        editText = (EditText)rootView.findViewById(R.id.doctorscity);
        listView = (ListView)rootView.findViewById(R.id.listaDoktorat);
        button = (Button)rootView.findViewById(R.id.finddoc);
        initList();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) listView.getItemAtPosition(position);
                editText.setText(item);

            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().equals(""))
                {
                    initList();
                }
                else
                {
                    searchItems(s.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String qyteti = editText.getText().toString();
                if (qyteti.equals("Peje"))
                {
                    startActivity(new Intent(getContext(), ListaDoktorave.class));
                    ((Activity) getActivity()).overridePendingTransition(0,0);

                }
            }
        });
        return rootView;
    }
    public void searchItems(String textToSearch)
    {
        for (String item: items)
        {
            if (!item.toLowerCase().contains(textToSearch.toLowerCase()))
            {
                listItems.remove(item);

            }

        }
        adapter.notifyDataSetChanged();
    }
    public void initList()
    {
        items = new String[]{"Prishtine","Peje", "Gjakove", "Gjilan", "Mitrovice", "Ferizaj", "Decan", "Istog", "Kamenice",
                "Kline", "Prizren", "Podujeve", "Vushtrri", "Suhareke", "Rahovec", "Drenas", "Lipjan", "Malisheve", "Viti",
                "Skenderaj", "Dragash", "Fushe Kosove", "Kacanik", "Shtime"};
        listItems = new ArrayList<>(Arrays.asList(items));
        adapter = new ArrayAdapter<String>(getContext(), R.layout.list_items,R.id.txtQytet, listItems);
        listView.setAdapter(adapter);
    }

    }

