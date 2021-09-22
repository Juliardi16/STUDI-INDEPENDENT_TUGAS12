package com.example.moviedb.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviedb.R;
import com.example.moviedb.adapter.MovieAdapter;
import com.example.moviedb.data.MovieDB;
import com.example.moviedb.model.Result;

import java.util.List;


public class FavoriteFragment extends Fragment{
  RecyclerView rcv;
 MovieDB movieDB;
 List<Result> result;
 MovieAdapter mvAdapter;

 public FavoriteFragment(){

 }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite1,container,false);
        Context context = view.getContext();
        rcv = view.findViewById(R.id.rc_view_fragment_favorite);
        rcv.setLayoutManager(new LinearLayoutManager(getContext()));

        movieDB = Room.databaseBuilder(context, MovieDB.class,"movieDB").allowMainThreadQueries().build();
        result = movieDB.movieDao().getMovieData();
        rcv.setAdapter(new MovieAdapter(result,R.layout.movie_list_item,getActivity()));

        return view;
    }


}