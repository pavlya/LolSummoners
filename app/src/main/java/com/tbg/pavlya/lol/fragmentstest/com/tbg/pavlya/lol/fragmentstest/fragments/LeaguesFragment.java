package com.tbg.pavlya.lol.fragmentstest.com.tbg.pavlya.lol.fragmentstest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tbg.pavlya.lol.fragmentstest.R;
import com.tbg.pavlya.lol.fragmentstest.dbhelper.League;
import com.tbg.pavlya.lol.fragmentstest.dbhelper.LeaguesDataSource;

import java.util.ArrayList;
import java.util.List;


public class LeaguesFragment extends Fragment implements View.OnClickListener{
    private TextView tvInfo;
    private Button btnLoad;
    private Button btnClear;
    LeaguesDataSource leaguesDataSource;

    public LeaguesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_leagues, container,
                false);
        leaguesDataSource = new LeaguesDataSource(getActivity());
        tvInfo = (TextView)rootView.findViewById(R.id.tv_main_fragment_leagues);
        btnClear = (Button)rootView.findViewById(R.id.btn_clear_data_leagues);
        btnClear.setOnClickListener(this);
        btnLoad = (Button)rootView.findViewById(R.id.btn_load_data_leagues);
        btnLoad.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_clear_data_leagues:
                tvInfo.setText("Leagues info");
                break;
            case R.id.btn_load_data_leagues:
                fillWithData();
                break;
            default:
                break;
        }

    }

    private void fillWithData() {
        leaguesDataSource.open();
        List<League> leagues = new ArrayList<>();
        StringBuilder sbData = new StringBuilder();
        leagues = leaguesDataSource.getAllLeagues(0);
        for (League league: leagues){
            sbData.append(league.toString() + "\n");
        }
        tvInfo.setText(sbData);
        if(leaguesDataSource != null){
            leaguesDataSource.close();
        }
    }
}
