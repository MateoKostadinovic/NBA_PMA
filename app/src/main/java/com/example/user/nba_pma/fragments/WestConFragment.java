package com.example.user.nba_pma.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.nba_pma.R;

public class WestConFragment extends Fragment {
    public static WestConFragment newInstance() {
        
        Bundle args = new Bundle();
        
        WestConFragment fragment = new WestConFragment();
        fragment.setArguments(args);
        return fragment;
    }
    TextView textViewWest;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_west_con,container,false);

        textViewWest = view.findViewById(R.id.text_view_id_west_con);

        return view;
    }
}
