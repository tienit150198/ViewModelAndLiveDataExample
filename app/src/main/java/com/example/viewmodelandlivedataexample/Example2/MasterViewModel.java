package com.example.viewmodelandlivedataexample.Example2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MasterViewModel extends AndroidViewModel {
    private MutableLiveData<String> mSelectedItem = new MutableLiveData<>();
    private MutableLiveData<List<String>> mData = new MutableLiveData<>();

    public MasterViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getmSelectedItem() {
        return mSelectedItem;
    }

    public void setmSelectedItem(String data) {
        this.mSelectedItem.setValue(data);
    }

    public MutableLiveData<List<String>> getmData() {
        return mData;
    }

    public void setmData(List<String> mData) {
        this.mData.setValue(mData);
    }


    public List<String> getSampleData() {
        List<String> result = new ArrayList<>();
        result.add("Susanna Mcmillian");
        result.add("Cheryl Stockman");
        result.add("Jesus Pitts");
        result.add("Shirly Grado");
        result.add("Stevie Kucera");
        result.add("Oneida Lafrance");
        result.add("Ashli Kenna");
        result.add("Madlyn Keasey");
        result.add("Sharonda Wisneski");
        result.add("Eliz Hildebrand");
        result.add("Tod Kellerhouse");
        result.add("Sung Farnan");
        result.add("Elenor Darrow");
        result.add("Max Garlick");
        result.add("Yolanda Digirolamo");
        result.add("Liane Scoby");
        result.add("Jed Hunger");
        result.add("Hilario Schreffler");
        result.add("Shanda Eadie");
        result.add("Londa Shelnutt");
        return result;
    }
}
