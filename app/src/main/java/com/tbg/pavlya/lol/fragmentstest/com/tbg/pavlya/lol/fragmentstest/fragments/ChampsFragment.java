package com.tbg.pavlya.lol.fragmentstest.com.tbg.pavlya.lol.fragmentstest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tbg.pavlya.lol.fragmentstest.R;
import com.tbg.pavlya.lol.fragmentstest.dbhelper.Champion;
import com.tbg.pavlya.lol.fragmentstest.dbhelper.ChampionDataSource;

import java.util.ArrayList;
import java.util.List;


public class ChampsFragment extends Fragment {

    private TextView textView;
    private Button btnLoadData;
    private Button btnClearData;

    public ChampsFragment() {
    }

    ChampionDataSource championDataSource;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_champions, container,
                false);
        championDataSource = new ChampionDataSource(getActivity());
        textView = (TextView)rootView.findViewById(R.id.tv_main_fragment_one);
        btnLoadData = (Button)rootView.findViewById(R.id.btn_load_data);
        btnClearData = (Button)rootView.findViewById(R.id.btn_clear_data);

        btnLoadData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fillTvWithData();
            }
        });

        btnClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Clean");
            }
        });

        return rootView;
    }

    private void fillTvWithData() {
        championDataSource.open();
        List<Champion> champs = new ArrayList<>();
        champs = championDataSource.getAllChamps();
        StringBuilder sbData = new StringBuilder();
        for(Champion champ: champs){
            sbData.append(champ.toString()+ " \n ");
        }
        textView.setText(sbData);
        if(championDataSource!= null) {
            championDataSource.close();
        }
    }

}
