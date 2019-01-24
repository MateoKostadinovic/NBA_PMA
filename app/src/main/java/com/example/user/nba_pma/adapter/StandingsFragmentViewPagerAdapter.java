package com.example.user.nba_pma.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.user.nba_pma.fragments.StandingsConFragment;

import java.util.ArrayList;
import java.util.List;

public class StandingsFragmentViewPagerAdapter extends FragmentPagerAdapter {
    List<Integer> dataList;
    List<Fragment> fragmentList = new ArrayList<>();
    List<String> fragmentTitleList = new ArrayList<>();

    public StandingsFragmentViewPagerAdapter(FragmentManager fm, List<Integer> dataList) {
        super(fm);
        this.dataList=dataList;
    }
    public void addFragment(Fragment fragment, String title)
    {
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        int dataType = dataList.get(position);
        Fragment fragment = null;
        if(dataType == 1)
        {
            fragment = StandingsConFragment.newInstance(StandingsConFragment.CONFERENCE_EAST);
        }
        else if(dataType == 2)
        {
            fragment = StandingsConFragment.newInstance(StandingsConFragment.CONFERENCE_WEST);
        }
        else
        {
            return null;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }
}
