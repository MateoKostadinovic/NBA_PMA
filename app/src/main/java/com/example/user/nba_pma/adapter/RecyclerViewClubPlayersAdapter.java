package com.example.user.nba_pma.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.nba_pma.PlayerActivity;
import com.example.user.nba_pma.R;
import com.example.user.nba_pma.models.PlayerPositionComparison;
import com.example.user.nba_pma.models_club_players.StandardClubPlayers;
import com.example.user.nba_pma.models_players.StandardPlayers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecyclerViewClubPlayersAdapter extends RecyclerView.Adapter<RecyclerViewClubPlayersAdapter.ViewHolder> {
    ArrayList<StandardPlayers> standardPlayersModelList = new ArrayList<>();
    private Context mContext;

    public PlayerPositionComparison playerPositionComparison;
    public ArrayList<PlayerPositionComparison> playerPositionComparisonsList = new ArrayList<>();

    public RecyclerViewClubPlayersAdapter(Context mContext, ArrayList<StandardPlayers> standardPlayersModelList) {
        this.mContext = mContext;
        this.standardPlayersModelList = standardPlayersModelList;
    }

    @NonNull
    @Override
    public RecyclerViewClubPlayersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout_club_players, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        playerPositionComparisonsList.add(new PlayerPositionComparison("G","Guard"));
        playerPositionComparisonsList.add(new PlayerPositionComparison("F","Forward"));
        playerPositionComparisonsList.add(new PlayerPositionComparison("C","Central"));
        playerPositionComparisonsList.add(new PlayerPositionComparison("C-F","Central Forward"));
        playerPositionComparisonsList.add(new PlayerPositionComparison("F-C","Forward Central"));
        playerPositionComparisonsList.add(new PlayerPositionComparison("G-F","Guard Forward"));
        playerPositionComparisonsList.add(new PlayerPositionComparison("F-G","Forward Guard"));

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewClubPlayersAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.setIsRecyclable(false);

        for(PlayerPositionComparison oPosition: playerPositionComparisonsList)
        {
            String positionFullName = "";
            if(standardPlayersModelList.get(i).getPositionPlayer().equals(oPosition.getPositionKey()))
            {
                positionFullName = oPosition.getPositionValue();
                viewHolder.textViewPlayerPozicija.setText(positionFullName);
            }
        }

        viewHolder.textViewPlayerIme.setText(standardPlayersModelList.get(i).getFirstNamePlayer());
        viewHolder.textViewPlayerPrezime.setText(standardPlayersModelList.get(i).getLastNamePlayer());
        viewHolder.textViewPlayerBroj.setText("#" + standardPlayersModelList.get(i).getJerseyPlayer());

        viewHolder.customLayoutClubPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, standardPlayersModelList.get(i).getFirstNamePlayer() + " " + standardPlayersModelList.get(i).getLastNamePlayer(), Toast.LENGTH_LONG).show();

                Intent intent= new Intent(mContext, PlayerActivity.class);
                intent.putExtra("player_id", standardPlayersModelList.get(i).getPersonIdPlayer());
                intent.putExtra("player_name", standardPlayersModelList.get(i).getFirstNamePlayer());
                intent.putExtra("player_surname", standardPlayersModelList.get(i).getLastNamePlayer());
                for(PlayerPositionComparison oPosition: playerPositionComparisonsList)
                {
                    String positionFullName = "";
                    if (standardPlayersModelList.get(i).getPositionPlayer().equals(oPosition.getPositionKey()))
                    {
                        positionFullName = oPosition.getPositionValue();
                        intent.putExtra("player_position", positionFullName);
                    }
                }
                intent.putExtra("player_jersey", standardPlayersModelList.get(i).getJerseyPlayer());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return standardPlayersModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textViewPlayerIme;
        TextView textViewPlayerPrezime;
        TextView textViewPlayerBroj;
        TextView textViewPlayerPozicija;

        ConstraintLayout customLayoutClubPlayers;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textViewPlayerIme = itemView.findViewById(R.id.textViewPlayerIme);
            textViewPlayerPrezime = itemView.findViewById(R.id.textViewPlayerPrezime);
            textViewPlayerBroj = itemView.findViewById(R.id.textViewPlayerBroj);
            textViewPlayerPozicija = itemView.findViewById(R.id.textViewPlayerPozicija);

            customLayoutClubPlayers = itemView.findViewById(R.id.custom_layout_club_players);
        }
    }
}
