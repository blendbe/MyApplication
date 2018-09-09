package com.example.acer.myapplicationiu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class News_Fragment extends Fragment {
    ImageView imageView1, imageView2, imageView3, imageView4;
    RecyclerView recyclerView;
    List<News11> news11List;
    News1 news1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        recyclerView = (RecyclerView)view.findViewById(R.id.recNews1);
        news11List = new ArrayList<>();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        news11List.add(new News11(R.drawable.aging, "TE PLAKURIT MIRE"));
        news11List.add(new News11(R.drawable.heart1, "SHENDETI I ZEMRES"));
        news11List.add(new News11(R.drawable.digestive, "SHENDETI DIGJESTIV"));
        news11List.add(new News11(R.drawable.pain, "MENAXHIMI I DHIMBJES"));
        news11List.add(new News11(R.drawable.talking, "KANCERI"));
        news11List.add(new News11(R.drawable.diabeti, "DIABETI"));
        news11List.add(new News11(R.drawable.living, "JETO SHENDETSHEM"));
        news11List.add(new News11(R.drawable.mental1, "SHENDETI MENDOR"));
        news11List.add(new News11(R.drawable.pregnant, "SHTATZENIA DHE PRINDERIMI"));
        news1 = new News1(getContext(), news11List);
        recyclerView.setAdapter(news1);
        return view;
    }
  public class News1 extends RecyclerView.Adapter<News1.News1Holder>
  {
      private Context context;
      private List<News11> newsList;

      public News1(Context context, List<News11> newsList) {
          this.context = context;
          this.newsList = newsList;
      }

      @NonNull
      @Override
      public News1Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          LayoutInflater inflater = LayoutInflater.from(getContext());
          View view = inflater.inflate(R.layout.newslayout, null);
          return new News1Holder(view);
      }

      @Override
      public void onBindViewHolder(@NonNull News1Holder holder, int position) {
          News11 news = newsList.get(position);
          holder.textView.setText(news.getTitulli());
          holder.imageView.setImageDrawable(getContext().getResources().getDrawable(news.getImages(), null));
      }

      @Override
      public int getItemCount() {
          return newsList.size();
      }

      class News1Holder extends RecyclerView.ViewHolder
      {
          ImageView imageView;
          TextView textView;

          public News1Holder(View itemView) {
              super(itemView);
              imageView = (ImageView)itemView.findViewById(R.id.fotojaNews);
              textView = (TextView)itemView.findViewById(R.id.newsName);
              imageView.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      int pozita = getAdapterPosition();
                      if (pozita == 6)
                      {
                          Intent intent = new Intent(getActivity(), AgingWellActivity.class);
                          startActivity(intent);
                      }
                  }
              });
          }
      }
  }
  public class News11
  {
      private int images;
      private String titulli;

      public News11(int images, String titulli) {
          this.images = images;
          this.titulli = titulli;
      }

      public int getImages() {
          return images;
      }

      public String getTitulli() {
          return titulli;
      }
  }
}
