package com.example.viewmodelandlivedataexample.Example2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.viewmodelandlivedataexample.R;
import com.example.viewmodelandlivedataexample.databinding.FragmentDetailBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    // TODO: Rename and change types of parameters
    private FragmentDetailBinding detailBinding;
    private MasterViewModel mViewModel;
    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // important: getActivity()
        mViewModel = ViewModelProviders.of(getActivity()).get(MasterViewModel.class);
        /* listener when selected new item
        should listener in onCreate, avoid calling multiple times
         */
        mViewModel.getmSelectedItem().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                detailBinding.tvContent.setText(s);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        detailBinding = FragmentDetailBinding.inflate(inflater, container, false);
        // Inflate the layout for this fragment
        return detailBinding.getRoot();
    }
}
