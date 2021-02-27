package com.example.groupproject.ViewHolders;

import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groupproject.R;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.flaviofaria.kenburnsview.RandomTransitionGenerator;
import com.squareup.picasso.Picasso;

public class SearchViewHolder extends RecyclerView.ViewHolder {

    private static KenBurnsView posterImage;
    public static TextView posterTitle;

    public SearchViewHolder(@NonNull View itemView) {
        super(itemView);
        posterImage=itemView.findViewById(R.id.iv_poster);
        posterTitle=itemView.findViewById(R.id.tv_postertitle);

        RandomTransitionGenerator generator = new RandomTransitionGenerator(1000,new DecelerateInterpolator());
        posterImage.setTransitionGenerator(generator);
    }

    public static void setPosterImage(Context context, String posterUrl) {
        Picasso.with(context).load(posterUrl).into(posterImage);
    }
}
