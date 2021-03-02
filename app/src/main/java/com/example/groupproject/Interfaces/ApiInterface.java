package com.example.groupproject.Interfaces;

import com.example.groupproject.Model.MovieResponse;
import com.example.groupproject.Model.UpComingMovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("movie/now_playing")
    Call<MovieResponse> getPlayingMovies(
            @Query("api_key") String apiKey
    );
    @GET("movie/upcoming")
    Call<UpComingMovieResponse> getUpcomingMovies(
            @Query("api_key") String apiKey
    );

}
