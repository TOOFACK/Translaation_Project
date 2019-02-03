package com.example.paulr.translaation_project.Second_Layout;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

import com.example.paulr.translaation_project.Adapters.MyAdapter;
import com.example.paulr.translaation_project.R;

public class TranslateActivity extends FragmentActivity {
    private static final int  NUM_PAGES = 5;
    private ViewPager TranslationPager;
    private PagerAdapter TranslationAdapter;

   private EnglishFragment EnglishFrag;
   private FragmentTransaction ft;
   private JapaniseFragment JapFrag;
   private ChineseFragment ChinaFrag;
   private RussianFragment RussFrag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);
        ViewPager pager=(ViewPager)findViewById(R.id.pager);
         pager.setAdapter(new MyAdapter(getSupportFragmentManager()));





        //androidx.fragment.app.FragmentManager fragmentManager = getSupportFragmentManager();
      //  FragmentTransaction ft = fragmentManager.beginTransaction();
     //  EnglishFragment EnglishFrag = new EnglishFragment();
    //   RussianFragment RussFrag = new RussianFragment();
     //   JapaniseFragment JapFrag = new JapaniseFragment();
     //   ChineseFragment ChinaFrag = new ChineseFragment();
     //   ft.add(R.id.Translation, EnglishFrag, "fragment1");
        //ft.add(R.id.Translation, RussFrag, "fragment2");
        //ft.add(R.id.Translation, JapFrag, "fragment3");
        //ft.add(R.id.Translation, ChinaFrag, "fragment4");

      //  ft.commit();
      //
    }


}
