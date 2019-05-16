package com.mancel.yann.myviewpager.controller.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mancel.yann.myviewpager.R;
import com.mancel.yann.myviewpager.adapter.PageAdapter;

public class MainActivity extends AppCompatActivity {

    // FIELDS --------------------------------------------------------------------------------------

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    // METHODS -------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Associates the layout file to this class
        setContentView(R.layout.activity_main);

        // Configures and show the ViewPager field
        this.configureAndShowViewPager();

        // Configures and show the TabLayout field
        this.configureAndShowTabLayout();
    }

    /**
     * Configures and show the ViewPager field
     */
    private void configureAndShowViewPager() {
        // Retrieves the integer array from a XML file
        final int[] colorArray = getResources().getIntArray(R.array.colorArray);

        // Creates a PageAdapter thanks to the integer array
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), colorArray);

        // Initializes the ViewPager with the XML file
        this.mViewPager = (ViewPager) findViewById(R.id.activity_main_ViewPager);

        // Connects the ViewPager with the PageAdapter object
        this.mViewPager.setAdapter(pageAdapter);
    }

    /**
     * Configures and show the TabLayout field
     */
    private void configureAndShowTabLayout() {
        // Initializes the TabLayout with the XML file
        this.mTabLayout = (TabLayout) findViewById(R.id.activity_main_TabLayout);

        // Binds the TabLayout field with the ViewPager field
        this.mTabLayout.setupWithViewPager(this.mViewPager);

        // The Tabs are all the same width
        this.mTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }
}
