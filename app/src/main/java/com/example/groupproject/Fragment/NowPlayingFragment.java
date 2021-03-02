package com.example.groupproject.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groupproject.Adapters.NowPlayingMovieAdapter;
import com.example.groupproject.ApiClient;
import com.example.groupproject.Model.MovieResponse;
import com.example.groupproject.Model.NowPlaying;
import com.example.groupproject.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NowPlayingFragment extends Fragment {

    NowPlayingMovieAdapter nowPlayingMovieAdapter;
    RecyclerView recyclerView;
    List<NowPlaying> nowPlayings;
    String apiKey = "0fef32e55b6fd07958bb5081341a0b88";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_now_playing,container,false);


        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager( getContext()));

        getMovieData(apiKey);

        return view;
    }

    public void getMovieData(String apiKeyz){
        Call<MovieResponse> call = ApiClient.getInstance().getApi().getPlayingMovies(apiKey);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body() != null){
                    nowPlayings = response.body().getResults();
                    nowPlayingMovieAdapter = new NowPlayingMovieAdapter(getContext(),nowPlayings);
                    recyclerView.setAdapter(nowPlayingMovieAdapter);
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
