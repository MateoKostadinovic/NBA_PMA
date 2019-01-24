package com.example.user.nba_pma.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.nba_pma.R;
import com.example.user.nba_pma.models.StandingsModel;

import java.util.ArrayList;

public class RecyclerViewStandingsAdapter extends RecyclerView.Adapter<RecyclerViewStandingsAdapter.ViewHolder>{

    private static final String TAG = "TEST";

    public ArrayList<StandingsModel> standingsModelsList = new ArrayList<>();
    private Context mContext;

    public RecyclerViewStandingsAdapter(Context context, ArrayList<StandingsModel> standingsModelsList) {
        this.standingsModelsList = standingsModelsList;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout_west, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.textViewTim.setText(standingsModelsList.get(i).getTeamName());
        viewHolder.textViewW.setText(standingsModelsList.get(i).getTeamWin());
        viewHolder.textViewL.setText(standingsModelsList.get(i).getTeamLoss());
        viewHolder.textViewGB.setText(standingsModelsList.get(i).getTeamGamesBehind());
        viewHolder.textViewPCT.setText(standingsModelsList.get(i).getTeamWinPctV2());

        viewHolder.customLayoutWest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG,"onClick: clicked on: " + standingsModelsList.get(i).getTeamName());

                Toast.makeText(mContext, standingsModelsList.get(i).getTeamId(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return standingsModelsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView textViewTim;
        TextView textViewW;
        TextView textViewL;
        TextView textViewGB;
        TextView textViewPCT;

        ConstraintLayout customLayoutWest;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textViewTim = itemView.findViewById(R.id.textViewTim);
            textViewW = itemView.findViewById(R.id.textViewW);
            textViewL = itemView.findViewById(R.id.textViewL);
            textViewGB = itemView.findViewById(R.id.textViewGB);
            textViewPCT = itemView.findViewById(R.id.textViewPCT);

            customLayoutWest = itemView.findViewById(R.id.custom_layout_west);
        }
    }
}
