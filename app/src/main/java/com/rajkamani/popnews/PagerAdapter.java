package com.rajkamani.popnews;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class PagerAdapter extends FragmentPagerAdapter {
    Context mContext;
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.Tab_home, R.string.tab_business,R.string.tab_tech,R.string.tab_entertain,R.string.tab_sport,R.string.tab_science,R.string.tab_health};
    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Frag_home();
            case 1:
                return new Frag_business();
            case 2:
                return new Frag_tech();
            case 3:
                return new Frag_entertainment();
            case 4:
                return new Frag_sports();
            case 5:
                return new Frag_science();
            case 6:
                return new Frag_health();
            default:
                return new Frag_home();
        }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return TAB_TITLES.length;
    }
}
