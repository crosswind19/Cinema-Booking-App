package com.example.groupproject.Interfaces;

import com.example.groupproject.Model.MovieResponse;
import com.example.groupproject.Model.PersonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("search/movie")
    static Call<MovieResponse> getMoviesByQuery(@Query("0fef32e55b6fd07958bb5081341a0b88") String api_key, @Query("query") String query) {
        return null;
    }

    @GET("search/person")
    static Call<PersonResponse> getPersonByQuery(@Query("0fef32e55b6fd07958bb5081341a0b88") String api_key, @Query("query") String query) {
        return null;
    }

}
