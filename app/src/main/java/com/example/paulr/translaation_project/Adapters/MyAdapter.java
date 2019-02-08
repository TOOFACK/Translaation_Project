package com.example.paulr.translaation_project.Adapters;

import android.os.Bundle;
import android.util.Log;

import com.example.paulr.translaation_project.First_Layout.AsyncTask_DB_Test;
import com.example.paulr.translaation_project.Second_Layout.ChineseFragment;
import com.example.paulr.translaation_project.Second_Layout.EnglishFragment;
import com.example.paulr.translaation_project.Second_Layout.JapaniseFragment;
import com.example.paulr.translaation_project.Second_Layout.RussianFragment;
import com.example.paulr.translaation_project.Second_Layout.TranslateActivity;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter  {
    private com.example.paulr.translaation_project.Second_Layout.EnglishFragment EnglishFragment;
   private String englishWord;
    private String defenitionEnglish;
    private String wordRussian;
    private String defenitionRussian;
    private String wordChina;
    private String defenitionChina;
    private String wordJapan;
    private String defenitionJapan;





    public MyAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public MyAdapter(@NonNull FragmentManager fm,  String englishWord, String defenitionEnglish, String wordRussian, String defenitionRussian, String wordChina, String defenitionChina, String wordJapan, String defenitionJapan) {
        super(fm);
        this.englishWord = englishWord;
        this.defenitionEnglish = defenitionEnglish;
        this.wordRussian = wordRussian;
        this.defenitionRussian = defenitionRussian;
        this.wordChina = wordChina;
        this.defenitionChina = defenitionChina;
        this.wordJapan = wordJapan;
        this.defenitionJapan = defenitionJapan;
    }





    @NonNull
    @Override
    public Fragment getItem(int position) {


        switch(position) {
            case 0:
                return EnglishFragment.newInstance(getEnglishWord(),getDefenitionEnglish());
            case 1:
                return JapaniseFragment.newInstance(getWordJapan(),getDefenitionJapan());
            case 2:
                return ChineseFragment.newInstance(getWordChina(),getDefenitionChina());
            case 3:
                return RussianFragment.newInstance(getWordRussian(),getDefenitionRussian());
                default: return EnglishFragment;
        }


    }

    @Override
    public int getCount() {
        return 4;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }


    public String getDefenitionEnglish() {
        return defenitionEnglish;
    }

    public void setDefenitionEnglish(String defenitionEnglish) {
        this.defenitionEnglish = defenitionEnglish;
    }

    public String getWordRussian() {
        return wordRussian;
    }

    public void setWordRussian(String wordRussian) {
        this.wordRussian = wordRussian;
    }

    public String getDefenitionRussian() {
        return defenitionRussian;
    }

    public void setDefenitionRussian(String defenitionRussian) {
        this.defenitionRussian = defenitionRussian;
    }

    public String getWordChina() {
        return wordChina;
    }

    public void setWordChina(String wordChina) {
        this.wordChina = wordChina;
    }

    public String getDefenitionChina() {
        return defenitionChina;
    }

    public void setDefenitionChina(String defenitionChina) {
        this.defenitionChina = defenitionChina;
    }

    public String getWordJapan() {
        return wordJapan;
    }

    public void setWordJapan(String wordJapan) {
        this.wordJapan = wordJapan;
    }

    public String getDefenitionJapan() {
        return defenitionJapan;
    }

    public void setDefenitionJapan(String defenitionJapan) {
        this.defenitionJapan = defenitionJapan;
    }
}
