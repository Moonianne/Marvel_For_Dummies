package org.pursuit.marvelfordummies.recyclerview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.marvelfordummies.DetailActivity;
import org.pursuit.marvelfordummies.dummymodel.HeroSummary;
import org.pursuit.marvelfordummies.R;

class HeroViewHolder extends RecyclerView.ViewHolder {
    //TODO create relevant views


    HeroViewHolder(@NonNull View itemView) {
        super(itemView);

    }

    //TODO Pass object/primitve onBind needs
    void onBind(HeroSummary heroSummary) {
        itemView.<TextView>findViewById(R.id.hero_name_text_view).setText(heroSummary.getName());
        Picasso.get().load(heroSummary.getImage()).into(itemView.<ImageView>findViewById(R.id.hero_image_itemview));
        CardView container = itemView.findViewById(R.id.hero_itemview_container);
        container.setOnClickListener(v -> {
            Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
            itemView.getContext().startActivity(intent);
        });
    }
}
