package com.example.myapplication.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.card.MaterialCardView;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.detail.DetailActivity;
import com.example.myapplication.model.News;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyViewHolder> {
    private List<News> list = new ArrayList<>();
    private Context context;

    public AdapterRecycler(List<News> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list_berita, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.imageView.setImageResource(list.get(i).img);
        myViewHolder.txtDesc.setText(list.get(i).desc);
        myViewHolder.txtTittle.setText(list.get(i).title);
        myViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parseData(list.get(i).img,list.get(i).desc,list.get(i).title);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView txtDesc, txtTittle;
        private MaterialCardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardNews);
            imageView = itemView.findViewById(R.id.imageNews);
            txtDesc = itemView.findViewById(R.id.textViewDescNews);
            txtTittle = itemView.findViewById(R.id.textViewTitleNews);

        }
    }

    private void parseData (int img, String desc, String tittle){
        Intent intent = new Intent(context, DetailActivity.class);

        intent.putExtra("img",img);
        intent.putExtra("desc",desc);
        intent.putExtra("tittle",tittle);
        context.startActivity(intent);
    }
}

//akhir