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

import com.example.groupproject.Adapters.UpComingMovieAdapter;
import com.example.groupproject.ApiClient;
import com.example.groupproject.Model.UpComingMovieResponse;
import com.example.groupproject.Model.Upcoming;
import com.example.groupproject.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpComingFragment extends Fragment {

    UpComingMovieAdapter upcomingMovieAdapter;
    RecyclerView recyclerView;
    List<Upcoming> upcomings;
    String apiKey = "0fef32e55b6fd07958bb5081341a0b88";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upcoming,container,false);


        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager( getContext()));

        getMovieData(apiKey);

        return view;
    }

    public void getMovieData(String apiKey){
        Call<UpComingMovieResponse> call = ApiClient.getInstance().getApi().getUpcomingMovies(apiKey);
        call.enqueue(new Callback<UpComingMovieResponse>() {
            @Override
            public void onResponse(Call<UpComingMovieResponse> call, Response<UpComingMovieResponse> response) {
                if (response.isSuccessful() && response.body() != null){
                    upcomings = response.body().getResults();
                    upcomingMovieAdapter = new UpComingMovieAdapter(getContext(),upcomings);
                    recyclerView.setAdapter(upcomingMovieAdapter);
                }
            }

            @Override
            public void onFailure(Call<UpComingMovieResponse> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
