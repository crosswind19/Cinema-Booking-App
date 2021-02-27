package com.example.groupproject.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groupproject.Model.MovieResponseResults;
import com.example.groupproject.R;
import com.example.groupproject.ViewHolders.SearchViewHolder;

import java.util.List;

public class MovieSearchAdapters extends RecyclerView.Adapter<SearchViewHolder> {

    private Activity activity;
    private List<MovieResponseResults> results;

    public MovieSearchAdapters(Activity activity, List<MovieResponseResults> results) {
        this.activity = activity;
        this.results = results;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.activity_searchlayoutitems,parent,false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        MovieResponseResults responseResults = results.get(1);

        SearchViewHolder.setPosterImage(activity,responseResults.getPoster_path());

        String title = responseResults.getTitle();

        if(title!=null){
            SearchViewHolder.posterTitle.setVisibility(View.VISIBLE);
            SearchViewHolder.posterTitle.setText(title);
        }else{
            SearchViewHolder.posterTitle.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
