package com.example.acer.myapplicationiu;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

import java.util.ArrayList;
import java.util.Arrays;

public class Tab2Hospitals extends Fragment {
    EditText editText;
    String [] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    ListView listView;
    Button button;
    TextView textView;
    Bundle bundle;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_hospitals, container, false);
        editText = (EditText)rootView.findViewById(R.id.hospitalcity);
        listView = (ListView)rootView.findViewById(R.id.listaQyteti);
        button = (Button)rootView.findViewById(R.id.findHosp);
        initList();
        bundle = new Bundle();
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
                    Intent intent = new Intent(getContext(), AktivitetiHosp.class);
                    bundle.putString("qyteti", "Peje");
                    intent.putExtras(bundle);
                    startActivity(intent);

                }
                else if (qyteti.equals("Prishtine"))
                {
                    Intent intent = new Intent(getContext(), AktivitetiHosp.class);
                    bundle.putString("qyteti", "Prishtine");
                    intent.putExtras(bundle);
                    startActivity(intent);
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
