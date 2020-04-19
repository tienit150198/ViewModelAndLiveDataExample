package com.example.viewmodelandlivedataexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.viewmodelandlivedataexample.Example1.CountNumberViewModel;
import com.example.viewmodelandlivedataexample.Example1.DemoActivity;
import com.example.viewmodelandlivedataexample.Example2.MasterFragment;
import com.example.viewmodelandlivedataexample.Example2.ShareDataActivity;
import com.example.viewmodelandlivedataexample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        // instead of setContentView(R.layout.activity_main);
        setContentView(mainBinding.getRoot());

        // listener click
        mainBinding.example1.setOnClickListener(this);
        mainBinding.example2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.example1:
                Intent intent = new Intent(this, DemoActivity.class);
                startActivity(intent);
                break;
            case R.id.example2:
                Intent intent1 = new Intent(this, ShareDataActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
