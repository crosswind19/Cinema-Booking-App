package com.example.groupproject.Fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.groupproject.R;
import com.example.groupproject.showingmovie;
import com.squareup.picasso.Picasso;


public class DetailedFragment extends Fragment {

    TextView tvTitle,tvDesc,tvRating,tvReleaseDate;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    ImageView movieImage;

    String movieTitle,movieRating,movieReleaseDate,movieDesc,movieImagePath;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detailed,container,false);
        tvTitle = view.findViewById(R.id.movieTitle);
        tvDesc = view.findViewById(R.id.movieDesc);
        tvRating = view.findViewById(R.id.movieRating);
        tvReleaseDate = view.findViewById(R.id.movieReleaseDate);

        final Button btnTicketBooking = (Button) view.findViewById(R.id.btnBuyTicket);
        btnTicketBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                alert.setMessage("Are you sure to proceed the movie?");

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getActivity(), showingmovie.class);
                        startActivity(intent);

                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.show();
            }
        });

        movieImage = view.findViewById(R.id.imgPoster);

        Bundle bundle = getArguments();

        movieTitle = bundle.getString("movieTitle");
        movieRating = bundle.getString("movieRating");
        movieDesc = bundle.getString("movieDesc");
        movieReleaseDate = bundle.getString("movieReleaseDate");
        movieImagePath = bundle.getString("moviePosterPath");


        tvTitle.setText(movieTitle);
        tvRating.setText(movieRating);
        tvDesc.setText(movieDesc);
        tvReleaseDate.setText(movieReleaseDate);

        Picasso.with(getContext()).load(movieImagePath).into(movieImage);

        return view;
    }
}
