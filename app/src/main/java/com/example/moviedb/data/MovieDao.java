package com.example.moviedb.data;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.moviedb.model.Result;

import java.util.List;

@Dao
public interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void addData(Result movie);

    @Query("Select*from movie")
    public List<Result> getMovieData();

    @Delete
    public void delete(Result movie);
}
