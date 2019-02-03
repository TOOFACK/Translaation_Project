package com.example.paulr.translaation_project.First_Layout;

import android.content.Intent;
import android.os.Bundle;

import com.example.paulr.translaation_project.Adapters.Word;
import com.example.paulr.translaation_project.Adapters.WordAdapter;
import com.example.paulr.translaation_project.R;
import com.example.paulr.translaation_project.Second_Layout.ChineseFragment;
import com.example.paulr.translaation_project.Second_Layout.EnglishFragment;
import com.example.paulr.translaation_project.Second_Layout.JapaniseFragment;
import com.example.paulr.translaation_project.Second_Layout.RussianFragment;
import com.example.paulr.translaation_project.Second_Layout.TranslateActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.EditText;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AsyncTask_DB_Test.AsyncResponse {


    EnglishFragment EnglishFrag;
    androidx.fragment.app.FragmentTransaction Transactioner;
    JapaniseFragment JapFrag;
    ChineseFragment ChinaFrag;
    RussianFragment RussFrag;
    RecyclerView Words;
    ArrayList<Word> wordList;

    EditText wordEnglish;

    String search;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EnglishFrag = new EnglishFragment();
        JapFrag = new JapaniseFragment();
        ChinaFrag = new ChineseFragment();
        RussFrag = new RussianFragment();
        Words = findViewById(R.id.Recycler);
        wordList = new ArrayList<>();

        wordEnglish = findViewById(R.id.wordEnglishMainActivity);


    }



    public void Find(View view) {

       Intent intentToFragments = new Intent(this, TranslateActivity.class);
        startActivity(intentToFragments);


        search = wordEnglish.getText().toString();
        new AsyncTask_DB_Test((AsyncTask_DB_Test.AsyncResponse) this).execute(search);

        wordList.add(new Word(wordEnglish.getText()));
        Words.setLayoutManager(new GridLayoutManager(this, 1));
        Words.setAdapter(new WordAdapter(wordList));



    }


    @Override
    public void processFinish(String[] output) {
        Log.e("check",output[0]);
    }
}






