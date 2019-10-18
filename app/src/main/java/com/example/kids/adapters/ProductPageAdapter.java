package com.example.kids.adapters;


import com.example.kids.fragments.ProductPage;
import com.example.kids.fragments.ProductPage1;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ProductPageAdapter extends FragmentStatePagerAdapter {
    public ProductPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ProductPage tab1 = new ProductPage();
                return tab1;
            case 1:
                ProductPage1 tab2 = new ProductPage1();
                return tab2;
            case 2:
                ProductPage tab3 = new ProductPage();
                return tab3;
            case 3:
                ProductPage1 tab4 = new ProductPage1();
                return tab4;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
