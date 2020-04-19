package com.example.viewmodelandlivedataexample.Example1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;

import com.example.viewmodelandlivedataexample.R;
import com.example.viewmodelandlivedataexample.databinding.ActivityDemoBinding;
import com.example.viewmodelandlivedataexample.databinding.ActivityMainBinding;

public class DemoActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityDemoBinding binding;
    CountNumberViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // inflate xml
        binding = ActivityDemoBinding.inflate(getLayoutInflater());

        // instead of "setContentView(R.layout.activity_demo)"
        setContentView(binding.getRoot());
//        setContentView(R.layout.activity_demo);

        // This way is used instead of the new syntax. Should use this way.
        // which retains ViewModels while a scope of given controller ( fragment, activity,...) is alive
        mViewModel = ViewModelProviders.of(this).get(CountNumberViewModel.class);

        registerLiveDataListener();
        listenerClick();
    }

    private void listenerClick() {
        binding.btnScoreA9.setOnClickListener(this);
        binding.btnScoreA6.setOnClickListener(this);
        binding.btnScoreA3.setOnClickListener(this);
        binding.btnScoreB9.setOnClickListener(this);
        binding.btnScoreB6.setOnClickListener(this);
        binding.btnScoreB3.setOnClickListener(this);
    }

    private void registerLiveDataListener() {
        // update data when data change. It's update live
        mViewModel.getmScoreTeamA().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.tvScoreTeamA.setText(String.valueOf(integer));
            }
        });

        mViewModel.getmScoreTeamB().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.tvScoreTeamB.setText(String.valueOf(integer));
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
