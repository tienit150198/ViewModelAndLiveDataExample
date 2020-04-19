package com.example.viewmodelandlivedataexample.Example2;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.viewmodelandlivedataexample.databinding.RecyclerItemBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<String> mData;
    private OnClickItemListener listener;

    public Adapter(ArrayList<String> mData, OnClickItemListener listener) {
        this.mData = mData;
        this.listener = listener;
    }

    public void setData(ArrayList<String> data){
        if(data == mData){
            return;
        }

        mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // bind xml
        RecyclerItemBinding binding = RecyclerItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String data = mData.get(position);
        holder.bindData(data);
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerItemBinding itemBinding;

        public ViewHolder(@NonNull final RecyclerItemBinding itemBinding) {
            super(itemBinding.getRoot());

            this.itemBinding = itemBinding;

            itemBinding.tvTitle.setOnClickListener((v) -> listener.onClickItem(mData.get(getLayoutPosition())));
        }

        public void bindData(String data) {
            itemBinding.tvTitle.setText(data);
        }
    }
}
