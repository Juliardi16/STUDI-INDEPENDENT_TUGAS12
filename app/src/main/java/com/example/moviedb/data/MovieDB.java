package com.example.moviedb.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.moviedb.model.Result;

@Database(entities = {Result.class},version = 2, exportSchema = false)
@TypeConverters({Converter.class})
public abstract class MovieDB extends RoomDatabase {
public abstract MovieDao movieDao();

}
