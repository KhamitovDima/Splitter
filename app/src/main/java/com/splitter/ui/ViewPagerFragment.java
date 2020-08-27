package com.splitter.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.splitter.adapters.PagerAdapter;
import com.splitter.R;

public class ViewPagerFragment extends Fragment {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    

    public static ViewPagerFragment newInstance() {
        ViewPagerFragment fragment = new ViewPagerFragment();
        Bundle args = new Bundle();
        //args.putInt("someInt", page);
        //args.putString("someTitle", title);
        //fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_viewpager, container, false);

        mViewPager = v.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new PagerAdapter(getChildFragmentManager()));

        mTabLayout = v.findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("activity", "qqq");
                AddExpenseFragment addExpenseFragment = AddExpenseFragment.newInstance("add", "qwety");
                getFragmentManager().beginTransaction().
                        replace(R.id.container, addExpenseFragment).
                        addToBackStack("2").
                        commit();

                //Toast.makeText(getContext(), "Floating Action Button 2", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }
}
