package com.example.acer.myapplicationiu;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AgingWellActivity extends AppCompatActivity {
   RecyclerView recyclerView;
   List<News> newsList;
   NewsAdapter newsAdapter;
   Timestamp timestamp;
   private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aging_well);
        recyclerView = (RecyclerView)findViewById(R.id.recNews);
        newsList = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.YYY hh:mm");
        String formatedDate = df.format(c);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsList.add(new News(R.drawable.healthy, "Aktiviteti fizik, çelësi për të qenë të shëndetshëm",
                "Sa më shumë të reja zbulon shkenca për të jetuarit shëndetshëm, aq më shumë forcohet...",formatedDate ));
        newsList.add(new News(R.drawable.healthy1, "Mënyra të thjeshta për të jetuar shëndetshëm",
                "Ngado reklamohet stili i shëndetshëm i jetës. Dhe ngado reklamohen produkte dhe...",formatedDate ));
        newsList.add(new News(R.drawable.healthy2, "Sekreti i thjeshtë i të jetuarit gjatë dhe shëndetshëm",
                "“Çohu dhe lëviz, nëse do që të jetosh më gjatë”, thotë një studim i Universitetit të ri të Pensilvanisë...",formatedDate ));
        newsAdapter = new NewsAdapter(this, newsList);
        recyclerView.setAdapter(newsAdapter);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = recyclerView.getChildAdapterPosition(v);
                Toast.makeText(getApplicationContext(), String.valueOf(itemPosition), Toast.LENGTH_LONG).show();
            }
        });

    }
    public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>
    {
        private Context context;
        private List<News> newsList;

        public NewsAdapter(Context context, List<News> newsList) {
            this.context = context;
            this.newsList = newsList;
        }

        @NonNull
        @Override
        public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.aginglayout, null);
            return new NewsViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.textView.setText(news.getTitulli());
        holder.textView1.setText(news.getPershkrimi());
        holder.imageView.setImageDrawable(context.getResources().getDrawable(news.getImages(), null));
        holder.textView2.setText((CharSequence) news.getTimestamp());
        }

        @Override
        public int getItemCount() {
            return newsList.size();
        }

        class NewsViewHolder extends RecyclerView.ViewHolder
        {
            ImageView imageView;
            TextView textView, textView1, textView2;
            Timestamp timestamp;

            public NewsViewHolder(View itemView) {
                super(itemView);
                imageView = (ImageView)itemView.findViewById(R.id.fotoja);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pozita = getAdapterPosition();
                        if (pozita ==1)
                        {
                            Intent intent = new Intent(AgingWellActivity.this, DetailedNews.class);
                            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(AgingWellActivity.this,
                                    findViewById(R.id.fotoja), "myImage");
                            startActivity(intent, activityOptionsCompat.toBundle());
                        }

                    }
                });
                textView = (TextView)itemView.findViewById(R.id.titulli);
                textView1 = (TextView)itemView.findViewById(R.id.desc1);
                textView2 = (TextView)itemView.findViewById(R.id.time1);
            }
        }
    }
    public class News
    {
        private int images;
        private String titulli, pershkrimi;
        private String timestamp;

        public int getImages() {
            return images;
        }

        public String getTitulli() {
            return titulli;
        }

        public String getPershkrimi() {
            return pershkrimi;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public News(int images, String titulli, String pershkrimi, String timestamp) {
            this.images = images;
            this.titulli = titulli;
            this.pershkrimi = pershkrimi;
            this.timestamp = timestamp;

        }
    }
    public class AnimationItem
    {
        private final String mName;
        private final int mResourceId;

        public String getName() {
            return mName;
        }

        public int getResourceId() {
            return mResourceId;
        }

        public AnimationItem(String mName, int mResourceId) {
            this.mName = mName;
            this.mResourceId = mResourceId;

        }
    }
}
