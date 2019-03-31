package com.example.myapplication.home.adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.card.MaterialCardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.detail.DetailActivity;
import com.example.myapplication.model.News;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewHolder extends RecyclerView.ViewHolder {


    @BindView(R.id.imageNews)
    ImageView imageNews;
    @BindView(R.id.textViewTitleNews)
    TextView textViewTitleNews;
    @BindView(R.id.textViewDescNews)
    TextView textViewDescNews;
    @BindView(R.id.cardNews)
    MaterialCardView cardNews;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void bindView(final News news){
        textViewTitleNews.setText(news.title);
        textViewDescNews.setText(news.desc);
        imageNews.setImageResource(news.img);

    cardNews.setOnClickListener(v->{
        Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
        intent.putExtra("desc",news.desc);
        intent.putExtra("title",news.title);
        intent.putExtra("img",news.img);

        itemView.getContext().startActivity(intent);
    });
    }

}
