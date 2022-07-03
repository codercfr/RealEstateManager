package com.example.realestatemanagerp9.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realestatemanagerp9.R;

public class LogementAdapter extends RecyclerView.Adapter<LogementAdapter.ViewHolder> {


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(LogementAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder( View itemView) {
            super(itemView);

        }

    }
}

