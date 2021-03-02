package com.example.groupproject.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.groupproject.Fragment.NowPlayingFragment;
import com.example.groupproject.Fragment.UpComingFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int count;
    public PagerAdapter(FragmentManager fm, int oount) {
        super(fm);
        this.count = oount;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                NowPlayingFragment nowPlayingFragment = new NowPlayingFragment();
                return nowPlayingFragment;
            case 1:
                UpComingFragment upcomingFragment = new UpComingFragment();
                return upcomingFragment;
            default:
                nowPlayingFragment = new NowPlayingFragment();
                return nowPlayingFragment;
        }
    }

    @Override
    public int getCount() {
        return count;
    }
}
