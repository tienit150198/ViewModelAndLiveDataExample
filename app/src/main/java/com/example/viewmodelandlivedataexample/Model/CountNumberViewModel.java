package com.example.viewmodelandlivedataexample.Model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/*
each activity or fragment should have one view corresponding model
 */
public class CountNumberViewModel extends AndroidViewModel {
    private MutableLiveData<Integer> mScoreTeamA = new MutableLiveData<>();
    private MutableLiveData<Integer> mScoreTeamB = new MutableLiveData<>();

    public CountNumberViewModel(@NonNull Application application) {
        super(application);

        // init value
        mScoreTeamA.setValue(0);
        mScoreTeamB.setValue(0);
    }

    public MutableLiveData<Integer> getmScoreTeamA() {
        return mScoreTeamA;
    }

    public void setmScoreTeamA(MutableLiveData<Integer> mScoreTeamA) {
        this.mScoreTeamA = mScoreTeamA;
    }

    public MutableLiveData<Integer> getmScoreTeamB() {
        return mScoreTeamB;
    }

    public void setmScoreTeamB(MutableLiveData<Integer> mScoreTeamB) {
        this.mScoreTeamB = mScoreTeamB;
    }

    public void increateScoreTeamA(int score){
        mScoreTeamA.setValue(mScoreTeamA.getValue() + score);
    }

    public void increateScoreTeamB(int score){
        mScoreTeamB.setValue(mScoreTeamB.getValue() + score);
    }
}
