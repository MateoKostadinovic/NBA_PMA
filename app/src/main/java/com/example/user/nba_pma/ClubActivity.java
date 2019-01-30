package com.example.user.nba_pma;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.user.nba_pma.adapter.ClubFragmentViewPagerAdapter;
import com.example.user.nba_pma.adapter.StandingsFragmentViewPagerAdapter;
import com.example.user.nba_pma.fragments.ClubGamesFragment;
import com.example.user.nba_pma.fragments.ClubPlayersFragment;
import com.example.user.nba_pma.fragments.StandingsConFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClubActivity extends AppCompatActivity {
    private ViewPager viewPagerClub;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        viewPagerClub = findViewById(R.id.viewPagerClub);
        toolbar = findViewById(R.id.toolbar);
        setupViewPager(viewPagerClub);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPagerClub);

        toolbar.setTitle(this.getIntent().getExtras().getString("team_name"));

        if (savedInstanceState == null) {
            ClubGamesFragment details = new ClubGamesFragment();
            details.setArguments(getIntent().getExtras());
        }
    }

    private void setupViewPager(ViewPager viewPager)
    {
        List<Integer> fragmentDataList=new ArrayList<>();
        fragmentDataList.add(1);
        fragmentDataList.add(2);

        Collections.sort(fragmentDataList);
        ClubFragmentViewPagerAdapter adapter = new ClubFragmentViewPagerAdapter(getSupportFragmentManager(),fragmentDataList);
        adapter.addFragment(new ClubGamesFragment(), "Utakmice");
        adapter.addFragment(new ClubPlayersFragment(), "Igraci");
        viewPagerClub.setAdapter(adapter);
    }
}
