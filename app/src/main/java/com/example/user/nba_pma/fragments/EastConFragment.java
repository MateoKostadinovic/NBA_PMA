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

public class EastConFragment extends Fragment {
    public static EastConFragment newInstance() {
        
        Bundle args = new Bundle();
        
        EastConFragment fragment = new EastConFragment();
        fragment.setArguments(args);
        return fragment;
    }

    TextView textViewEastCon;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_east_con,container,false);

        textViewEastCon = view.findViewById(R.id.text_view_id_east_con);

        return view;
    }
}
