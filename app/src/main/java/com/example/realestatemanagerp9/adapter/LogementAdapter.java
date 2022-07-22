package com.example.realestatemanagerp9.adapter;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.realestatemanagerp9.DetailLogementActivity;
import com.example.realestatemanagerp9.DummyLogement;
import com.example.realestatemanagerp9.R;

import java.util.ArrayList;
import java.util.List;

public class LogementAdapter extends RecyclerView.Adapter<LogementAdapter.ViewHolder> {


    private List<DummyLogement> logements =new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_content, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(LogementAdapter.ViewHolder holder, int position) {
        DummyLogement dummyLogement = logements.get(position);

        holder.city.setText(dummyLogement.getCity());
        holder.type.setText(dummyLogement.getType());
        holder.price.setText(Integer.toString(dummyLogement.getPrice()));

        //Start the detail activity.
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(view.getContext(), DetailLogementActivity.class);
            intent.putExtra("ID",dummyLogement.getId());
            try {
                view.getContext().startActivity(intent);
            }
            catch (Exception exception){
                exception.printStackTrace();
            }
        });
    }

    public void updateLogements(@NonNull final List<DummyLogement> logements) {
        this.logements = logements;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
         return  logements.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView type;
        private TextView city;
        private TextView price;
        //transformer la les photos par une liste de string pour ROOM
        private TextView photos;
        private TextView description;
        private TextView roomNumbers;
        private TextView surface;
        private TextView bathroomNumbers;
        private TextView bedroomNumbers;
        private TextView Location;
        public ViewHolder( View itemView) {
            super(itemView);

            type=itemView.findViewById(R.id.type);
            city=itemView.findViewById(R.id.city);
            price=itemView.findViewById(R.id.price);

        }
    }
}

