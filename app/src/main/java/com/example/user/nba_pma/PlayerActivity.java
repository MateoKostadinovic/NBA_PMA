package com.example.user.nba_pma;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
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

import com.example.user.nba_pma.models_player_stats.Latest;
import com.example.user.nba_pma.models_player_stats.PlayerStatsResponse;
import com.example.user.nba_pma.network.RetrofitManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayerActivity extends AppCompatActivity {
    private Toolbar toolbar;

    public Latest latestPlayerStats;

    public TextView textViewMPG;
    public TextView textViewFG;
    public TextView textView3P;
    public TextView textViewFT;
    public TextView textViewPPG;
    public TextView textViewRPG;
    public TextView textViewAPG;
    public TextView textViewBPG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        toolbar = findViewById(R.id.toolbar);

        textViewMPG = findViewById(R.id.textViewMPG);
        textViewFG = findViewById(R.id.textViewFG);
        textView3P = findViewById(R.id.textView3P);
        textViewFT = findViewById(R.id.textViewFT);
        textViewPPG = findViewById(R.id.textViewPPG);
        textViewRPG = findViewById(R.id.textViewRPG);
        textViewAPG = findViewById(R.id.textViewAPG);
        textViewBPG = findViewById(R.id.textViewBPG);

        String sPlayerID = this.getIntent().getExtras().getString("player_id");
        Integer nPlayerID = Integer.parseInt(sPlayerID);
        String sName = this.getIntent().getExtras().getString("player_name");
        String sSurname = this.getIntent().getExtras().getString("player_surname");
        String sNumber = this.getIntent().getExtras().getString("player_jersey");
        String sPosition = this.getIntent().getExtras().getString("player_position");
        String sToolbarTitle = sName + " " + sSurname + " | #" + sNumber + " | " + sPosition;

        toolbar.setTitle(sToolbarTitle);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.nba_logo_icon);

        Call<PlayerStatsResponse> callResponsePlayerStats = RetrofitManager.getInstance().getApi().getPlayerStats(nPlayerID);
        callResponsePlayerStats.enqueue(new Callback<PlayerStatsResponse>() {
            @Override
            public void onResponse(Call<PlayerStatsResponse> call, Response<PlayerStatsResponse> response) {
                String textPlayer = "";
                if(response.isSuccessful() && response.body() != null)
                {
                    latestPlayerStats = response.body().getLeaguePlayerStats().getStandardPlayerStats().getStatsPlayer().getLatest();
                    setUpData(latestPlayerStats);
                }
                else
                {
                    textPlayer = "Problem u komunikaciji";
                }
            }

            @Override
            public void onFailure(Call<PlayerStatsResponse> call, Throwable t) {
                //setText("Doslo je do greske: " + t.getMessage());
            }
        });
    }
    void setUpData(Latest latestPlayerStats)
    {
        if (latestPlayerStats == null)
        {
            return;
        }
        textViewMPG.setText(latestPlayerStats.getMpg());
        textViewFG.setText(latestPlayerStats.getFgp());
        textView3P.setText(latestPlayerStats.getTpp());
        textViewFT.setText(latestPlayerStats.getFtp());
        textViewPPG.setText(latestPlayerStats.getPpg());
        textViewRPG.setText(latestPlayerStats.getRpg());
        textViewAPG.setText(latestPlayerStats.getApg());
        textViewBPG.setText(latestPlayerStats.getBpg());
    }
}
