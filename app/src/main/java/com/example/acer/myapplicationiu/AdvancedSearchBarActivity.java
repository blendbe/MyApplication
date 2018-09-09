package com.example.acer.myapplicationiu;

import android.content.ContentQueryMap;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.hootsuite.nachos.NachoTextView;
import com.hootsuite.nachos.terminator.ChipTerminatorHandler;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.pchmn.materialchips.ChipView;
import com.pchmn.materialchips.ChipsInput;
import com.pchmn.materialchips.model.ChipInterface;
import com.robertlevonyan.views.chip.Chip;
import com.robertlevonyan.views.chip.OnCloseClickListener;

import org.w3c.dom.Text;

import java.time.temporal.ChronoUnit;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvancedSearchBarActivity extends AppCompatActivity {
    ProgressBar progressBar;
    ListView lstView;
    ChipView chipsii;
    Chip chips;
    Bundle bundle;
    Button btna;
    ArrayList<Integer> arrayList;
    DatabaseCheck db;
    ArrayAdapter adapter;
    ArrayList<Model1> ItemModelList;
    ArrayList<DiseasesModel> diseasesModels = new ArrayList<DiseasesModel>();
    EditText search;
    LinearLayout rl;
    int po;
    TextView simpt;
    CAdapter1 adapter12;
    TextView shto;
    private ArrayList<String> liste;
    String[] lstSource = {
                    "Ethe",
                    "Ngerq ne stomak",
                    "Fryrje stomaku",
                    "Kokedhimbje",
                    "Plogeshti",
                    "Teshtime",
                    "Vjellje",
                    "Gjakderdhje",
                    "Anemi",
                    "Hemorragji",
                    "Temperature",
                    "Kollitje",
                    "Dhimbje gjoksi",
                    "Anoreksi", "Enjtje", "Skuqje e muskujve", "Pagjumesi", "Humbje e interesit", "Dhimbje veshi", "Dhimbje fyti",
                    "Dhimbje muskujsh", "Konfuzion", "Duar te ftohta"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_search_bar);
        ItemModelList = new ArrayList<>();
        simpt = (TextView)findViewById(R.id.simptoma);
        rl = (LinearLayout)findViewById(R.id.linear1);
        liste = new ArrayList<String>();
        db = new DatabaseCheck(this);
        bundle = new Bundle();
        arrayList = new ArrayList<>();
        Toolbar toolbar1 = (Toolbar)findViewById(R.id.toolbar);
        lstView = (ListView)findViewById(R.id.lstView);
        adapter12 = new CAdapter1(getDiseases(), this);
        lstView.setAdapter(adapter12);
        search = (EditText)findViewById(R.id.eKerkoo);
        if (search.getText().toString().equals(""))
        {

        }
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter12.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        final TextView tv3 = (TextView)findViewById(R.id.statusi);
        progressBar = (ProgressBar)findViewById(R.id.progresbari);
        progressBar.setVisibility(View.GONE);
        setSupportActionBar(toolbar1);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(5.5f);
        shto = (TextView)toolbar1.findViewById(R.id.shtoSimp);
         btna = (Button)findViewById(R.id.btnVazhdo);
        final Button btnb = (Button)findViewById(R.id.btnFshij);
        btnb.setVisibility(View.GONE);
        btna.setVisibility(View.GONE);
        btnb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((LinearLayout) rl).getChildCount() > 0) {
                    ((LinearLayout) rl).removeAllViews();
                    Button btna = (Button)findViewById(R.id.btnVazhdo);
                    btna.setEnabled(true);
                }

                if(((LinearLayout) rl).getChildCount() == 0)
                {
                    Button btna = (Button)findViewById(R.id.btnVazhdo);
                    btna.setEnabled(false);
                    progressBar.setVisibility(View.GONE);
                }

            }
        });


        final LinearLayout rl = (LinearLayout) findViewById(R.id.linear1);
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                TextView textView = (TextView)view.findViewById(R.id.simptoma);
                String teksti = textView.getText().toString();
               for (int i =0; i<lstSource.length; i++)
               {
                   if (teksti == lstSource[i])
                   {
                       arrayList.add(i);
                       liste.add(teksti);
                       Log.d("TE", String.valueOf(liste));
                   }
               }

                Log.d("ORIGJINALI", "" + arrayList);
                final LinearLayout rl = (LinearLayout) findViewById(R.id.linear1);
                TextView txt1 = (TextView) findViewById(R.id.simptoms1);
                txt1.setText("Simptomat e zgjedhura: ");
                final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                chips = new Chip(AdvancedSearchBarActivity.this);
                ScrollView scroll = new ScrollView(AdvancedSearchBarActivity.this);
                chips.setChipText(teksti);
                chips.setCornerRadius(11);
                chips.setTextColor(Color.parseColor("#000000"));
                chips.changeBackgroundColor(Color.parseColor("#E2ECF5"));
                chips.setClosable(true);
                lparams.setMargins(5, 5, 5, 5);
                chips.setLayoutParams(lparams);
                rl.addView(chips);
                if(((LinearLayout) rl).getChildCount() > 0)
                {
                    btna.setVisibility(View.VISIBLE);
                    btnb.setVisibility(View.VISIBLE);
                    btnb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            rl.removeAllViews();
                            btna.setEnabled(false);
                            arrayList.clear();
                        }
                    });
                    btna.setEnabled(true);
                }


            }
        });
        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenti = new Intent(AdvancedSearchBarActivity.this, ShfaqSemundjet.class);
                bundle.putIntegerArrayList("listapozita", arrayList);
                intenti.putExtras(bundle);
                startActivity(intenti);
            }
        });


    }

    public class CAdapter1 extends BaseAdapter implements Filterable
    {
        ArrayList<DiseasesModel> filterList;
        ArrayList<DiseasesModel> diseasesModels;
        Context ct;
        CustommFilter filter;

        public CAdapter1(ArrayList<DiseasesModel> diseasesModels, Context ct) {
            this.diseasesModels = diseasesModels;
            this.ct = ct;
            this.filterList = diseasesModels;
        }

        @Override
        public int getCount() {
            return diseasesModels.size();
        }

        @Override
        public Object getItem(int position) {
            return diseasesModels.get(position);
        }

        @Override
        public long getItemId(int position) {
            return diseasesModels.indexOf(getItem(position));
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.listasemundjeve, null);
            }
            final TextView textView = (TextView) convertView.findViewById(R.id.simptoma);
            final String tst = textView.getText().toString();


            final int pozita = position;
            textView.setText(diseasesModels.get(position).getDname());
            btna.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intenti = new Intent(AdvancedSearchBarActivity.this, ShfaqSemundjet.class);
                    bundle.putIntegerArrayList("listapozita", arrayList);
                    intenti.putExtras(bundle);
                    startActivity(intenti);
                }
            });
            return convertView;
        }

        @Override
        public Filter getFilter() {
            if (filter == null) {
                filter = new CustommFilter();
            }
            return filter;
        }
        class CustommFilter extends Filter
        {

            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                int i = 0;
                if (constraint != null && constraint.length() > 0) {
                    constraint = constraint.toString().toUpperCase();
                    ArrayList<DiseasesModel> filters = new ArrayList<DiseasesModel>();
                    for (i = 0; i < filterList.size(); i++) {
                        simpt = (TextView) findViewById(R.id.simptoma);
                        final int finalI = i;
                        if (filterList.get(i).getDname().toUpperCase().contains(constraint)) {
                            DiseasesModel m = new DiseasesModel(filterList.get(i).getDname());
                            filters.add(m);
                        }


                    }
                    results.count = filters.size();
                    results.values = filters;
                } else {
                    results.count = filterList.size();
                    results.values = filterList;
                }
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                diseasesModels = (ArrayList<DiseasesModel>) results.values;
                notifyDataSetChanged();
            }
        }
    }

   public class DiseasesModel
   {
       private String dname;
       private int id;

       public DiseasesModel(String dname) {
           this.dname = dname;
       }

       public String getDname() {
           return dname;
       }

       public void setDname(String dname) {
           this.dname = dname;
       }

   }
   public class Model1
   {
       String name;

       public Model1(String name) {
           this.name = name;
       }

       public String getName() {
           return name;
       }
   }
    private ArrayList<DiseasesModel> getDiseases() {
        ArrayList<DiseasesModel> meds1 = new ArrayList<DiseasesModel>();
       DiseasesModel m;
        for (int i = 0; i < lstSource.length; i++) {
            m = new DiseasesModel(lstSource[i]);
            meds1.add(m);
        }
        return meds1;
    }
}
