package org.pursuit.marvelfordummies.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.marvelfordummies.R;

class HeroViewHolder extends RecyclerView.ViewHolder {
    //TODO create relevant views
    private TextView genericTextView;

    HeroViewHolder(@NonNull View itemView) {
        super(itemView);
        genericTextView = itemView.findViewById(R.id.hero_name_itemview);
    }

    //TODO Pass object/primitve onBind needs
    void onBind(int i) {
        genericTextView.setText(String.valueOf(i));
    }
}
