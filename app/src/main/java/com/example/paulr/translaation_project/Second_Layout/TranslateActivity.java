package com.example.paulr.translaation_project.Second_Layout;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.paulr.translaation_project.Adapters.MyAdapter;
import com.example.paulr.translaation_project.First_Layout.AsyncTask_DB_Test;
import com.example.paulr.translaation_project.R;

public class TranslateActivity extends FragmentActivity  {
    private static final int  NUM_PAGES = 5;
    private ViewPager TranslationPager;
    private PagerAdapter TranslationAdapter;



    private String wordEnglish;
    private String defenitionEnglish;
    private String wordRussian;
    private String defenitionRussian;
    private String wordChina;
    private String defenitionChina;
    private String wordJapan;
    private String defenitionJapan;



    public String getWordEnglish() {
        return wordEnglish;
    }

    public void setWordEnglish(String wordEnglish) {
        this.wordEnglish = wordEnglish;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
//        Bundle bundle = new Bundle();
//        Intent intent = getIntent();
//        String Word = intent.getStringExtra("data");
//        bundle.putString("word", Word );


        Bundle b = new Bundle();
        b = getIntent().getExtras();

        wordEnglish = b.getString("wordEnglish");
        defenitionEnglish = b.getString("defenitionEnglish");
        wordRussian = b.getString("wordRussian");
        defenitionRussian = b.getString("defenitionRussian");
        wordChina = b.getString("wordChina");
        defenitionChina = b.getString("defenitionChina");
        wordJapan = b.getString("wordJapan");
        defenitionJapan = b.getString("defenitoinJapan");
        Log.e("tryingtodosmth",wordEnglish);
        Log.e("tryingtodosmth2",defenitionEnglish);


        ViewPager pager=(ViewPager)findViewById(R.id.pager);
         pager.setAdapter(new MyAdapter(getSupportFragmentManager(),wordEnglish,defenitionEnglish,wordRussian,defenitionRussian,wordChina,defenitionChina,wordJapan,defenitionJapan));




//        Bundle bundle = new Bundle();
//        bundle.putString("wordEnglish2", wordEnglish);
//        EnglishFragment english = new EnglishFragment();
//        english.newInstance(wordEnglish,defenitionEnglish);


    }


}
