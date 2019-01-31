package com.example.user.nba_pma.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.nba_pma.ClubActivity;
import com.example.user.nba_pma.R;
import com.example.user.nba_pma.models.ClubGamesModel;
import com.example.user.nba_pma.models.StandingsModel;

import java.util.ArrayList;

public class RecyclerViewClubGamesAdapter extends RecyclerView.Adapter<RecyclerViewClubGamesAdapter.ViewHolder>{
    private static final String TAG = "TEST";


    public ArrayList<ClubGamesModel> clubGamesModelList = new ArrayList<>();
    private Context mContext;

    public RecyclerViewClubGamesAdapter(Context context, ArrayList<ClubGamesModel> clubGamesModelList) {
        this.clubGamesModelList = clubGamesModelList;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerViewClubGamesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout_club_games, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewClubGamesAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.setIsRecyclable(false); // pomaze kod podebljavanja pobjednika, odnosno ne poziva dva put metode na isti view.
        if(clubGamesModelList.get(i).getsTeamHScore().equals("") || clubGamesModelList.get(i).getsTeamVScore().equals(""))
        {
            String sTeamHScore = "-";
            String sTeamVScore = "-";

            viewHolder.textViewTeamHNaziv.setText(clubGamesModelList.get(i).getsTeamHName());
            viewHolder.textViewTeamHScore.setText(sTeamHScore);
            viewHolder.textViewTeamVNaziv.setText(clubGamesModelList.get(i).getsTeamVName());
            viewHolder.textViewTeamVScore.setText(sTeamVScore);
            viewHolder.textViewGameDate.setText(clubGamesModelList.get(i).getsDate());
        }
        else
        {
            if((Integer.parseInt(clubGamesModelList.get(i).getsTeamHScore())) > (Integer.parseInt(clubGamesModelList.get(i).getsTeamVScore())))
            {
                if((viewHolder.textViewTeamHNaziv.getTypeface().getStyle() & Typeface.BOLD)==0 || (viewHolder.textViewTeamHScore.getTypeface().getStyle() & Typeface.BOLD)==0)
                {
                    viewHolder.textViewTeamHNaziv.setTypeface(null, Typeface.BOLD);
                    viewHolder.textViewTeamHScore.setTypeface(null, Typeface.BOLD);
                }

                viewHolder.textViewTeamHNaziv.setText(clubGamesModelList.get(i).getsTeamHName());
                viewHolder.textViewTeamHScore.setText(clubGamesModelList.get(i).getsTeamHScore());
                viewHolder.textViewTeamVNaziv.setText(clubGamesModelList.get(i).getsTeamVName());
                viewHolder.textViewTeamVScore.setText(clubGamesModelList.get(i).getsTeamVScore());
                viewHolder.textViewGameDate.setText(clubGamesModelList.get(i).getsDate());
            }
            else if((Integer.parseInt(clubGamesModelList.get(i).getsTeamVScore())) > (Integer.parseInt(clubGamesModelList.get(i).getsTeamHScore())))
            {
                if((viewHolder.textViewTeamVNaziv.getTypeface().getStyle() & Typeface.BOLD)==0 || (viewHolder.textViewTeamVScore.getTypeface().getStyle() & Typeface.BOLD)==0)
                {
                    viewHolder.textViewTeamVNaziv.setTypeface(null, Typeface.BOLD);
                    viewHolder.textViewTeamVScore.setTypeface(null, Typeface.BOLD);
                }

                viewHolder.textViewTeamHNaziv.setText(clubGamesModelList.get(i).getsTeamHName());
                viewHolder.textViewTeamHScore.setText(clubGamesModelList.get(i).getsTeamHScore());
                viewHolder.textViewTeamVNaziv.setText(clubGamesModelList.get(i).getsTeamVName());
                viewHolder.textViewTeamVScore.setText(clubGamesModelList.get(i).getsTeamVScore());
                viewHolder.textViewGameDate.setText(clubGamesModelList.get(i).getsDate());
            }
            else
            {
                viewHolder.textViewTeamHNaziv.setText(clubGamesModelList.get(i).getsTeamHName());
                viewHolder.textViewTeamHScore.setText(clubGamesModelList.get(i).getsTeamHScore());
                viewHolder.textViewTeamVNaziv.setText(clubGamesModelList.get(i).getsTeamVName());
                viewHolder.textViewTeamVScore.setText(clubGamesModelList.get(i).getsTeamVScore());
                viewHolder.textViewGameDate.setText(clubGamesModelList.get(i).getsDate());
            }
        }
    }

    @Override
    public int getItemCount() {
        return clubGamesModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textViewTeamHNaziv;
        TextView textViewTeamHScore;
        TextView textViewTeamVNaziv;
        TextView textViewTeamVScore;
        TextView textViewGameDate;

        ConstraintLayout customLayoutClubGames;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textViewTeamHNaziv = itemView.findViewById(R.id.textViewTeamHNaziv);
            textViewTeamHScore = itemView.findViewById(R.id.textViewTeamHScore);
            textViewTeamVNaziv = itemView.findViewById(R.id.textViewTeamVNaziv);
            textViewTeamVScore = itemView.findViewById(R.id.textViewTeamVScore);
            textViewGameDate = itemView.findViewById(R.id.textViewGameDate);

            customLayoutClubGames = itemView.findViewById(R.id.custom_layout_club_games);
        }
    }
}
