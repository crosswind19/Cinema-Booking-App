package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.angmarch.views.NiceSpinner;

import java.util.ArrayList;

public class searchlist extends AppCompatActivity {
    private NiceSpinner sourceSpinner;
    private EditText queryEditText;
    private Button querySearchButton;
    private RecyclerView resultsRecyclerView;
    private String movie = "By movie title",person = "By person name";

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

        final ArrayList<String> category = new ArrayList<>();
        category.add(movie);
        category.add(person);

        int position = sourceSpinner.getSelectedIndex();
        if(position==0) {
            queryEditText.setText("Enter any movie name");
        }
        else {
            queryEditText.setText("Enter any person name");
        }

        sourceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id){
                if(position==0)
                    queryEditText.setText("Enter any movie name");
                else
                    queryEditText.setText("Enter any person name");
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent){

            }
        });

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

                            }
                        }
                    }
                }

            }
        });
    }
}