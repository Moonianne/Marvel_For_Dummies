package org.pursuit.marvelfordummies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.pursuit.marvelfordummies.data.model.Hero;

public class DetailActivity extends AppCompatActivity {
    private static ImageView heroImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_detail_layout);

        heroImage = findViewById(R.id.hero_detail_imageView);

    }

    public static void newInstance(View view, Hero hero){
        view.getContext().startActivity(new Intent(view.getContext(), DetailActivity.class));
        if(hero != null){
           Picasso.get().load(hero.getImage()).into(heroImage);
        }

    }
}
