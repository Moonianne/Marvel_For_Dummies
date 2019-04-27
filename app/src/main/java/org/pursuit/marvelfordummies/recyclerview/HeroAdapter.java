package org.pursuit.marvelfordummies.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.pursuit.marvelfordummies.dummymodel.HeroSummary;
import org.pursuit.marvelfordummies.R;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroViewHolder> {
    //TODO change genericList to list of objects from endpoint
    private List<HeroSummary> heroSummaryList;

    public HeroAdapter(List<HeroSummary> genericList) {
        this.heroSummaryList = genericList;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new HeroViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hero_itemview, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder heroViewHolder, int i) {
        heroViewHolder.onBind(heroSummaryList.get(i));
    }

    @Override
    public int getItemCount() {
        return heroSummaryList.size();
    }
}
