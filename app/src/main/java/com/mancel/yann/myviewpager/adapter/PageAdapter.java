package com.mancel.yann.myviewpager.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.mancel.yann.myviewpager.controller.fragments.NewsPageFragment;
import com.mancel.yann.myviewpager.controller.fragments.ParameterPageFragment;
import com.mancel.yann.myviewpager.controller.fragments.ProfilePageFragment;

/**
 * Created by Yann MANCEL on 16/05/2019.
 * Name of the project: MyViewPager
 * Name of the package: com.mancel.yann.myviewpager.adapter
 */
public class PageAdapter extends FragmentPagerAdapter {

    // FIELDS --------------------------------------------------------------------------------------

    private int[] mColorArray;

    // CONSTRUCTORS --------------------------------------------------------------------------------

    /**
     * Initializes a PageAdapter object
     *
     * @param fm a FragmentManager object
     * @param colorArray an integer array that contains the color values
     */
    public PageAdapter(FragmentManager fm, final int[] colorArray) {
        super(fm);

        // Initializes the color array
        this.mColorArray = colorArray;
    }

    // METHODS -------------------------------------------------------------------------------------

    @Override
    public Fragment getItem(int i) {
        // Choice of fragment
        switch (i) {
            case 0: {
                return NewsPageFragment.newInstance(this.mColorArray[i]);
            }
            case 1: {
                return ProfilePageFragment.newInstance(this.mColorArray[i]);
            }
            case 2: {
                return ParameterPageFragment.newInstance(this.mColorArray[i]);
            }
            default: {
                Log.e(getClass().getSimpleName(), "getItem: out of bourdaries for the item position");
                return null;
            }
        }
    }

    @Override
    public int getCount() {
        return this.mColorArray.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        // Choice of fragment
        switch (position) {
            case 0: {
                return "News";
            }
            case 1: {
                return "Profile";
            }
            case 2: {
                return "Parameter";
            }
            default: {
                Log.e(getClass().getSimpleName(), "getPageTitle: out of bourdaries for the item position");
                return null;
            }
        }
    }
}
