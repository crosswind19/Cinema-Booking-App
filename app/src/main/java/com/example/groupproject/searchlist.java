package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.groupproject.Adapters.MovieSearchAdapters;
import com.example.groupproject.Adapters.PersonSearchAdapters;
import com.example.groupproject.Client.RetrofitClient;
import com.example.groupproject.Interfaces.RetrofitService;
import com.example.groupproject.Model.MovieResponse;
import com.example.groupproject.Model.MovieResponseResults;
import com.example.groupproject.Model.PersonResponse;
import com.example.groupproject.Model.PersonResponseResults;
import com.google.gson.Gson;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;
import java.util.List;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class searchlist extends AppCompatActivity {
    private NiceSpinner sourceSpinner;
    private EditText queryEditText;
    private Button querySearchButton;
    private RecyclerView resultsRecyclerView;
    private String movie = "By movie title",person = "By person name";
    private RetrofitService retrofitService;
    private MovieSearchAdapters movieSearchAdapters;
    private PersonSearchAdapters personSearchAdapters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchlist);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        sourceSpinner=findViewById(R.id.source_spinner);
        queryEditText=findViewById(R.id.et_search);
        querySearchButton=findViewById(R.id.btn_search);
        resultsRecyclerView=findViewById(R.id.rv_results);
        resultsRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        Paper.init(this);
        retrofitService= RetrofitClient.getClient().create(RetrofitService.class);

        final ArrayList<String> category = new ArrayList<>();
        category.add(movie);
        category.add(person);

        sourceSpinner.attachDataSource(category);

        int position = sourceSpinner.getSelectedIndex();
        if(position==0) {
            queryEditText.setHint("Enter any movie name");
        }
        else {
            queryEditText.setHint("Enter any person name");
        }

        if(Paper.book().read("position") !=null){
            int Position = Paper.book().read("position");
            sourceSpinner.setSelectedIndex(Position);
        }

        sourceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id){
                if(position==0)
                    queryEditText.setHint("Enter any movie name");
                else
                    queryEditText.setHint("Enter any person name");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });

        if(Paper.book().read("cache")!=null){
            String results = Paper.book().read("cache");
            if(Paper.book().read("source")!=null){
                String source = Paper.book().read("source");
                if (source.equals(movie)){
                    MovieResponse movieResponse = new Gson().fromJson(results,MovieResponse.class);
                    if(movieResponse!=null){
                        List<MovieResponseResults> movieResponseResults=movieResponse.getResults();
                        movieSearchAdapters = new MovieSearchAdapters(searchlist.this,movieResponseResults);
                        resultsRecyclerView.setAdapter(movieSearchAdapters);
                        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(searchlist.this,R.anim.layout_slide_right);
                        resultsRecyclerView.setLayoutAnimation(controller);
                        resultsRecyclerView.scheduleLayoutAnimation();
                        Paper.book().write("cache", new Gson().toJson(movieResponse));
                        Paper.book().write("source","movie");
                    }
                }else {
                   PersonResponse personResponse = new Gson().fromJson(results,PersonResponse.class);
                    if(personResponse!=null){
                        List<PersonResponseResults> personResponseResults=personResponse.getResults();
                        personSearchAdapters = new PersonSearchAdapters(searchlist.this,personResponseResults);
                        resultsRecyclerView.setAdapter(personSearchAdapters);
                        LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(searchlist.this,R.anim.layout_slide_right);
                        resultsRecyclerView.setLayoutAnimation(controller);
                        resultsRecyclerView.scheduleLayoutAnimation();
                        Paper.book().write("cache", new Gson().toJson(personResponse));
                        Paper.book().write("source","person");
                    }
                }
            }
        }

        querySearchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(queryEditText.getText()!=null){
                    String query = queryEditText.getText().toString();
                    if(query.equals("")||query.equals(" ")){
                        Toast.makeText(searchlist.this,"Please enter any text",Toast.LENGTH_SHORT).show();
                    }else {
                        queryEditText.setText("");

                        String finalQuery = query.replaceAll(" ","+");

                        if(category.size()>0){
                            String categoryName = category.get(sourceSpinner.getSelectedIndex());

                            if(categoryName.equals(movie)){
                                Call<MovieResponse> movieResponseCall = RetrofitService.getMoviesByQuery(BuildConfig.THE_MOVIE_DB_API_KEY,finalQuery);

                                movieResponseCall.enqueue(new Callback<MovieResponse>() {
                                    @Override
                                    public void onResponse(@NonNull Call<MovieResponse> call,@NonNull Response<MovieResponse> response) {
                                        MovieResponse movieResponse = response.body();

                                        if(movieResponse != null){
                                            List<MovieResponseResults> movieResponseResults = movieResponse.getResults();
                                        }

                                    }
                                    @Override
                                    public void onFailure(@NonNull Call<MovieResponse> call,@NonNull Throwable t) {

                                    }
                                });
                            }else {
                                Call<PersonResponse> personResponseCall = RetrofitService.getPersonByQuery(BuildConfig.THE_MOVIE_DB_API_KEY,finalQuery);

                                personResponseCall.enqueue(new Callback<PersonResponse>() {
                                    @Override
                                    public void onResponse(@NonNull Call<PersonResponse> call,@NonNull Response<PersonResponse> response) {
                                        PersonResponse personResponse = response.body();

                                    }
                                    @Override
                                    public void onFailure(@NonNull Call<PersonResponse> call,@NonNull Throwable t) {

                                    }
                                });
                            }
                        }
                    }
                }

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Paper.book().write("position",sourceSpinner.getSelectedIndex());
    }
}