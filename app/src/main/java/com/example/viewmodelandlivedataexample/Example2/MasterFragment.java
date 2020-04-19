package com.example.viewmodelandlivedataexample.Example2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewmodelandlivedataexample.databinding.FragmentMasterBinding;

import java.util.ArrayList;

import static android.widget.LinearLayout.VERTICAL;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment implements OnClickItemListener {

    // TODO: Rename and change types of parameters
    private MasterViewModel mViewModel;
    private FragmentMasterBinding masterBinding;
    private Adapter mAdapter;

    public MasterFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // important: getActivity()
        mViewModel = ViewModelProviders.of(getActivity()).get(MasterViewModel.class);
        // init data
        mViewModel.setmData(mViewModel.getSampleData());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // binding fragment
        masterBinding = FragmentMasterBinding.inflate(inflater, container, false);

        // Inflate the layout for this fragment
        return masterBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new Adapter((ArrayList<String>) mViewModel.getmData().getValue(), this);
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(masterBinding.getRoot().getContext(), VERTICAL);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(masterBinding.getRoot().getContext());

        masterBinding.masterRecycler.setAdapter(mAdapter);
        masterBinding.masterRecycler.addItemDecoration(dividerItemDecoration);
        masterBinding.masterRecycler.setLayoutManager(layoutManager);
        masterBinding.masterRecycler.setHasFixedSize(true);

        // listener when change data
        mViewModel.getmData().observe(this, strings -> mAdapter.setData((ArrayList<String>) strings));
    }

    @Override
    public void onClickItem(String result) {
        mViewModel.setmSelectedItem(result);
    }
}
