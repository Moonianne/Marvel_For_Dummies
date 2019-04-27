package org.pursuit.marvelfordummies.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.pursuit.marvelfordummies.R;
import org.pursuit.marvelfordummies.data.model.Hero;

import java.util.List;

public class HeroAdapter extends RecyclerView.Adapter<HeroViewHolder> {
    private List<Hero> heroList;

    public HeroAdapter(List<Hero> genericList) {
        this.heroList = genericList;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new HeroViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hero_itemview, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder heroViewHolder, int i) {
        heroViewHolder.onBind(heroList.get(i));
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public void setData(List<Hero> heroes) {
        heroList = heroes;
        notifyDataSetChanged();
    }
}
