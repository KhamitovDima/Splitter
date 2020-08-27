package com.splitter.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.splitter.model.Contact;
import com.splitter.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private Toolbar mToolbar;
    private FloatingActionButton fab;
    private List<Contact> mContacts;

    private Fragment viewPagerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        viewPagerFragment = ViewPagerFragment.newInstance();
        getSupportFragmentManager().beginTransaction().
                add(R.id.container, viewPagerFragment).
                addToBackStack("1").
                commit();

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
