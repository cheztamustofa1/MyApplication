package com.example.myapplication.detail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.detailImage)
    ImageView detailImage;
    @BindView(R.id.detailTitle)
    TextView detailTitle;
    @BindView(R.id.detailDesc)
    TextView detailDesc;
    @BindView(R.id.detailCallCenter)
    ImageView detailCallCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        String title = getIntent().getStringExtra("tittle");
        String desc = getIntent().getStringExtra("desc");
        int img = getIntent().getIntExtra("img", 9);

        detailImage.setImageResource(img);
        detailTitle.setText(title);
        detailDesc.setText(desc);

        detailCallCenter.setOnClickListener( v -> {
            String phoneNumber = "022-7100124";
            Intent dialPhoneIntent =  new Intent(Intent.ACTION_DIAL,
                    Uri.parse("tel:"+ phoneNumber));
            startActivity(dialPhoneIntent);
        });
    }

}

