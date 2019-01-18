package com.example.paulr.translaation_project;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {
    private EnglishFragment EnglishFragment;

    public MyAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return EnglishFragment.newInstance("Hello world","Hi");
            case 1:
                return RussianFragment.newInstance("Hello world","Hi");
            case 3:
                return JapaniseFragment.newInstance("Hello world","Hi");
            case 4:
                return ChineseFragment.newInstance("Hello world","Hi");
                default: return EnglishFragment;
        }


    }

    @Override
    public int getCount() {
        return 4;
    }
}
