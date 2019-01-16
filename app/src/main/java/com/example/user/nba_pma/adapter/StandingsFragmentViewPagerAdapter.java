package com.example.user.nba_pma.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.user.nba_pma.fragments.EastConFragment;
import com.example.user.nba_pma.fragments.WestConFragment;

import java.util.List;

public class StandingsFragmentViewPagerAdapter extends FragmentPagerAdapter {
    List<Integer> dataList;

    public StandingsFragmentViewPagerAdapter(FragmentManager fm, List<Integer> dataList) {
        super(fm);
        this.dataList=dataList;
    }

    @Override
    public Fragment getItem(int position) {
        int dataType = dataList.get(position);
        Fragment fragment = null;
        if(dataType == 1)
        {
            fragment = EastConFragment.newInstance();
        }
        else
        {
            fragment = WestConFragment.newInstance();
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }
}
