package com.nicofrnds02734.cocobakery.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nicofrnds02734.cocobakery.R;
import com.nicofrnds02734.cocobakery.Slider;

import java.util.ArrayList;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.ViewHolder> {
    private ArrayList<Slider> slidersItem;

    public SliderAdapter(ArrayList<Slider> list){
        this.slidersItem = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.img_slider, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Slider slider = slidersItem.get(position);
        Glide.with(holder.itemView.getContext())
                .load(slider.getSlider())
                .into(holder.img_url);
    }

    @Override
    public int getItemCount() {
        return slidersItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img_url;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_url = itemView.findViewById(R.id.img_url);
        }
    }
}
