package com.example.user.nba_pma;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.example.user.nba_pma.adapter.StandingsFragmentViewPagerAdapter;
import com.example.user.nba_pma.fragments.StandingsConFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainStandings extends AppCompatActivity {
    private ViewPager viewPagerStandings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_standings);

        viewPagerStandings = findViewById(R.id.viewPagerStandings);
        setupViewPager(viewPagerStandings);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPagerStandings);

    }

    private void setupViewPager(ViewPager viewPager)
    {
        List<Integer> fragmentDataList=new ArrayList<>();
        fragmentDataList.add(1);
        fragmentDataList.add(2);

        Collections.sort(fragmentDataList);
        StandingsFragmentViewPagerAdapter adapter = new StandingsFragmentViewPagerAdapter(getSupportFragmentManager(),fragmentDataList);
        adapter.addFragment(new StandingsConFragment(), "Eastern Conference");
        adapter.addFragment(new StandingsConFragment(), "Western Conference");
        viewPagerStandings.setAdapter(adapter);
    }
}
