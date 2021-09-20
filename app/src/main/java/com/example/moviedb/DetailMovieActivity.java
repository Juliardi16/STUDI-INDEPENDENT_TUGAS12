package com.example.moviedb;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.moviedb.model.Result;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailMovieActivity extends AppCompatActivity {
    ImageView imgBackdrop,imgPoster;
    TextView titleDetail,rilisDate,voteDetail,desc;
    Result result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        initView();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        String poster = getIntent().getStringExtra("poster");
        String backdropPath = getIntent().getStringExtra("backdrop");
        String detail = getIntent().getStringExtra("overview");
        String title = getIntent().getStringExtra("title");
        String rilis = getIntent().getStringExtra("rilis");
        String vote = getIntent().getStringExtra("vote");


        Glide.with(DetailMovieActivity.this).load(poster).into(imgPoster);
        Glide.with(DetailMovieActivity.this).load(backdropPath).error(R.drawable.ic_launcher_background)
        .into(imgBackdrop);
        desc.setText(detail);
        titleDetail.setText(title);
        rilisDate.setText(rilis);
        voteDetail.setText(vote);



    }

    private void initView() {
        imgPoster = findViewById(R.id.img_poster);
        imgBackdrop = findViewById(R.id.img_mv_detail);
        desc = findViewById(R.id.movie_deskripsi);
        titleDetail =findViewById(R.id.movie_title_detail);
        rilisDate =findViewById(R.id.movie_rilis_detail);
        voteDetail = findViewById(R.id.movie_vote_detail);

    }
}