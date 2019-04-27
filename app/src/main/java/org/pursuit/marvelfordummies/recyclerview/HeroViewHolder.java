package org.pursuit.marvelfordummies.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.marvelfordummies.R;

class HeroViewHolder extends RecyclerView.ViewHolder {
    //TODO create relevant views


    HeroViewHolder(@NonNull View itemView) {
        super(itemView);

    }

    //TODO Pass object/primitve onBind needs
    void onBind(int i) {
        itemView.<TextView>findViewById(R.id.hero_name_itemview).setText(String.valueOf(i));
    }
}
