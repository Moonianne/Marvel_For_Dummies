package org.pursuit.marvelfordummies.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.pursuit.marvelfordummies.DetailActivity;
import org.pursuit.marvelfordummies.R;
import org.pursuit.marvelfordummies.data.model.Hero;

final class HeroViewHolder extends RecyclerView.ViewHolder {

    HeroViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    void onBind(Hero hero) {
        itemView.<TextView>findViewById(R.id.hero_name_text_view).setText(hero.name);
        Picasso.get().load(hero.getImage()).into(itemView.<ImageView>findViewById(R.id.hero_image_itemview));
        if (hero.getImage().equals("http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg")) {
            Glide.with(itemView.getContext())
                    .load(R.drawable.groot_dancing)
                    .into(itemView.<ImageView>findViewById(R.id.hero_image_itemview));
        } else {
            Picasso.get().load(hero.getImage()).into(itemView.<ImageView>findViewById(R.id.hero_image_itemview));
        }
        itemView.setOnClickListener(v -> itemView.getContext().startActivity(DetailActivity.newInstance(itemView.getContext(), hero)));
    }
}
