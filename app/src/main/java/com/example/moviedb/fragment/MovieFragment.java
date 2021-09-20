package com.example.moviedb.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviedb.R;
import com.example.moviedb.adapter.MovieAdapter;
import com.example.moviedb.model.Result;
import com.example.moviedb.model.UpResponse;
import com.example.moviedb.rest.MovieApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MovieFragment extends Fragment {


    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;
    private RecyclerView recyclerView = null;
    private final static String API_KEY ="8aec02431004e0f4cfe216a95d6995c4";



    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_movie1,container,false);
        recyclerView = view.findViewById(R.id.rc_view_fragment_movie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        getConnectApi();
        return view;
    }

    public  void getConnectApi(){
        if(retrofit == null){
            retrofit =new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        MovieApi movieApi = retrofit.create(MovieApi.class);
        Call<UpResponse> call =movieApi.getMovieUpcoming(API_KEY);
        call.enqueue(new Callback<UpResponse>() {
            @Override
            public void onResponse(Call<UpResponse> call, Response<UpResponse> response) {
                List<Result> results =response.body().getResults();
                recyclerView.setAdapter(new MovieAdapter(results,R.layout.movie_list_item,getActivity()));
                Log.d(MovieFragment.class.getSimpleName(),""+results.size());
            }

            @Override
            public void onFailure(Call<UpResponse> call, Throwable t) {
                Log.e(MovieFragment.class.getSimpleName(),t.toString());

            }
        });
    }
}