package com.example.groupproject.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groupproject.Fragment.DetailedFragment;
import com.example.groupproject.Model.Upcoming;
import com.example.groupproject.R;
import com.example.groupproject.searchlist;
import com.squareup.picasso.Picasso;

import java.util.List;

public class UpComingMovieAdapter extends RecyclerView.Adapter<UpComingMovieAdapter.ViewHolder> {

    Context context;
    List<Upcoming> upcomings;


    public UpComingMovieAdapter(Context context, List<Upcoming> upcomings) {
        this.context = context;
        this.upcomings = upcomings;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.upcoming_movie_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Upcoming upcoming = upcomings.get(position);

        String img_base_url = "https://image.tmdb.org/t/p/w185_and_h278_bestv2/";
        final String imgUrl = img_base_url+upcoming.getPoster_path();
        Picasso.with(context).load(imgUrl).into(holder.imageView);
        final String rating = upcoming.getVote_average()+"/10";
        holder.tvRating.setText(rating);
        holder.tvReleaseDate.setText(upcoming.getRelease_date());
        holder.tvTitle.setText(upcoming.getTitle());

        holder.btnBuyTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailedFragment detailedFragment = new DetailedFragment();
                Bundle bundle = new Bundle();
                bundle.putString("movieTitle",upcoming.getTitle());
                bundle.putString("movieRating",rating);
                bundle.putString("movieReleaseDate",upcoming.getRelease_date());
                bundle.putString("movieDesc",upcoming.getOverview());
                bundle.putString("moviePosterPath",imgUrl);
                detailedFragment.setArguments(bundle);
                ((searchlist)context).getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,detailedFragment).addToBackStack(null).commit();
            }
        });



    }

    @Override
    public int getItemCount() {
        return upcomings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvRating,tvTitle,tvReleaseDate;
        ImageView imageView;
        Button btnBuyTicket;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRating = itemView.findViewById(R.id.movieRating);
            tvTitle = itemView.findViewById(R.id.movieTitle);
            tvReleaseDate = itemView.findViewById(R.id.releaseDate);
            imageView = itemView.findViewById(R.id.imgPoster);
            btnBuyTicket = itemView.findViewById(R.id.btnBuyTicket);

        }
    }

}
