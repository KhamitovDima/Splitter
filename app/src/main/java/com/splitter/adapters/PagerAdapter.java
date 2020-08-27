package com.splitter.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.splitter.ui.ContactListFragment;
import com.splitter.ui.EventListFragment;
import com.splitter.ui.GroupListFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    private static int PAGE_COUNT = 3;
    private String[] tabTitles = new String[] { "Contacts", "Groups", "Events" };

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ContactListFragment.newInstance(0, "Page 1");
            case 1:
                return GroupListFragment.newInstance(1, "Page 2");
            case 2:
                return EventListFragment.newInstance(2, "Page 3");
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
