package org.pursuit.marvelfordummies.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.pursuit.marvelfordummies.R;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroViewHolder> {
    //TODO change genericList to list of objects from endpoint
    List<Object> genericList;

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View childView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hero_itemview, viewGroup, false);
        return new HeroViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder heroViewHolder, int i) {
        heroViewHolder.onBind(i);
    }

    @Override
    public int getItemCount() {
        return genericList.size();
    }
}
