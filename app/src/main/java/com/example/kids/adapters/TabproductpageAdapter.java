package com.example.kids.adapters;

import com.example.kids.data.InfoProductPage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class TabproductpageAdapter extends FragmentPagerAdapter {
    int numoftabs;

    public TabproductpageAdapter(FragmentManager fm, int  mnumoftabs ) {
        super(fm);
        this.numoftabs = mnumoftabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                InfoProductPage tab1 = new InfoProductPage();
                return tab1;

            case 1:
                InfoProductPage tab2 = new InfoProductPage();
                return tab2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
            return numoftabs;
    }
}
