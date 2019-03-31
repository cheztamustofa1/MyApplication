package com.example.myapplication.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.home.adapter.AdapterRecycler;
import com.example.myapplication.model.News;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyleMain)
    RecyclerView recyleMain;

    private AdapterRecycler mAdapter;
    private List<News> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setViews();
        recyleMain.setAdapter(mAdapter);
    }

    private void setViews(){
        list.add(new News(R.drawable.news_satu, "Wisuda BSI Deskripsi", "Wisuda BSI"));
        list.add(new News(R.drawable.news_dua, "Wisuda BSI 2017", "Wisuda BSI disini"));
        list.add(new News(R.drawable.news_satu, "Wisuda BSI 2018", "Wisuda BSI disana"));
        list.add(new News(R.drawable.news_dua, "Wisuda BSI 2019", "Wisuda BSI ini"));
        list.add(new News(R.drawable.news_satu, getString(R.string.title_news_satu),getString(R.string.desc_news_satu)));
//        list.add(new News(R.drawable.news_dua, getString(R.string.title_news_satu),getString(R.string.des)));
        mAdapter = new AdapterRecycler(list, this);
        recyleMain.setLayoutManager(new LinearLayoutManager(this));
    }
}
