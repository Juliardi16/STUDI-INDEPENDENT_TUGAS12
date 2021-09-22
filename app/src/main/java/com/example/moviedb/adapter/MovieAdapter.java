package com.example.moviedb.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviedb.DetailMovieActivity;
import com.example.moviedb.R;
import com.example.moviedb.model.Result;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    public static final String IMAGE_URL_BASE_PATH ="https://image.tmdb.org/t/p/w500/";

    private List<Result> resultslist =new ArrayList<>();
    private int Rowlayout;
    private Context context;

    public MovieAdapter(List<Result> resultslist,int rowlayout, Context context) {
        this.resultslist = resultslist;
        this.Rowlayout = rowlayout;
        this.context = context;
    }

    public MovieAdapter(FragmentActivity activity, List<Result> result) {
    }


    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_list_item, parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context)
                .load(IMAGE_URL_BASE_PATH +resultslist.get(position).getBackdropPath())
                .into(holder.imageView);
        holder.title.setText(resultslist.get(position).getTitle());
        holder.tanggalRilis.setText(resultslist.get(position).getReleaseDate());
        holder.voteAverage.setText(resultslist.get(position).getVoteAverage());


        holder.cvKlik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailMovieActivity.class);
                intent.putExtra("poster",IMAGE_URL_BASE_PATH +resultslist.get(position).getPosterPath());
                intent.putExtra("backdrop",IMAGE_URL_BASE_PATH + resultslist.get(position).getBackdropPath());
                intent.putExtra("overview",resultslist.get(position).getOverview());
                intent.putExtra("title",resultslist.get(position).getTitle());
                intent.putExtra("rilis",resultslist.get(position).getReleaseDate());
                intent.putExtra("vote",resultslist.get(position).getVoteAverage());
                context.startActivity(intent);

            }
        });
        }


    @Override
    public int getItemCount() {
        return resultslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView title,tanggalRilis,voteAverage;
        CardView cvKlik;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.movie_img);
            title = itemView.findViewById(R.id.movie_title);
            tanggalRilis =itemView.findViewById(R.id.movieRilis);
            voteAverage = itemView.findViewById(R.id.movieVote);
            cvKlik =itemView.findViewById(R.id.card_view);
        }
    }
}
