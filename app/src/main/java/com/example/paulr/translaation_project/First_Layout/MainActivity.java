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

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EnglishFragment EnglishFrag;
    androidx.fragment.app.FragmentTransaction Transactioner;
    JapaniseFragment JapFrag;
    ChineseFragment ChinaFrag;
    RussianFragment RussFrag;
    RecyclerView Words;
    ArrayList<Word> wordList;

    EditText wordEnglish;





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


    }

    public void Find(View view) {
        //FragmentManager fragmentManager = getFragmentManager();
        //Transactioner = getSupportFragmentManager().beginTransaction();
        //Transactioner.setTransitionStyle()
        //Transactioner.add(R.id.EnglishFragment, EnglishFrag);
        // Transactioner.addToBackStack(null);
        //Transactioner.commit();

//        Intent intent = new Intent(this, TranslateActivity.class);
//        startActivity(intent);

        AsyncTask_DB_Test asyncTask_db_test = new AsyncTask_DB_Test();
        wordEnglish  =  findViewById(R.id.wordEnglishMainActivity);
        asyncTask_db_test.execute(wordEnglish.getText().toString());
        Intent mainActivityIntent = new Intent();
        String checkMessge = mainActivityIntent.getStringExtra("defenitionEnglish");
        Toast toast = Toast.makeText(getApplicationContext(), checkMessge, Toast.LENGTH_LONG);
        toast.show();
        System.out.println(checkMessge);


        wordList.add(new Word(wordEnglish.getText()));
        Words.setLayoutManager(new GridLayoutManager(this, 1));
        Words.setAdapter(new WordAdapter(wordList));


        //try {
        //    Thread.sleep(2000);
        //  } catch (InterruptedException e) {
        //    e.printStackTrace();
        //  }
//        wordList.add( new Word(Edit.getText()));
//        Words.setLayoutManager(new GridLayoutManager(this, 1));
//        Words.setAdapter(new WordAdapter(wordList));

    }





}






