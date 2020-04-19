package com.example.viewmodelandlivedataexample;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.viewmodelandlivedataexample.Model.CountNumberViewModel;
import com.example.viewmodelandlivedataexample.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding mainBinding;
    CountNumberViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // inflate xml
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        // similar to the command "setContentView(R.layout.activity_main)"
        setContentView(mainBinding.getRoot());
//        setContentView(R.layout.activity_main);

        // This way is used instead of the new syntax. Should use this way.
        // which retains ViewModels while a scope of given controller ( fragment, activity,...) is alive
        mViewModel = ViewModelProviders.of(this).get(CountNumberViewModel.class);

        registerLiveDataListener();
        listenerClick();
    }

    private void listenerClick() {
        mainBinding.btnScoreA9.setOnClickListener(this);
        mainBinding.btnScoreA6.setOnClickListener(this);
        mainBinding.btnScoreA3.setOnClickListener(this);
        mainBinding.btnScoreB9.setOnClickListener(this);
        mainBinding.btnScoreB6.setOnClickListener(this);
        mainBinding.btnScoreB3.setOnClickListener(this);
    }

    private void registerLiveDataListener() {
        // update data when data change. It's update live
        mViewModel.getmScoreTeamA().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mainBinding.tvScoreTeamA.setText(String.valueOf(integer));
            }
        });

        mViewModel.getmScoreTeamB().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mainBinding.tvScoreTeamB.setText(String.valueOf(integer));
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_score_A_9:
                mViewModel.increateScoreTeamA(9);
                break;
            case R.id.btn_score_A_6:
                mViewModel.increateScoreTeamA(6);
                break;
            case R.id.btn_score_A_3:
                mViewModel.increateScoreTeamA(3);
                break;
            case R.id.btn_score_B_9:
                mViewModel.increateScoreTeamB(9);
                break;
            case R.id.btn_score_B_6:
                mViewModel.increateScoreTeamB(6);
                break;
            case R.id.btn_score_B_3:
                mViewModel.increateScoreTeamB(3);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}
