package org.pursuit.marvelfordummies;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.pursuit.marvelfordummies.data.model.Hero;

public class DetailActivity extends AppCompatActivity {
    private static String heroName;
    private static String heroDescription;
    private static String heroThumbnail;

    private static final String HERO_PATH = "https://marvelcinematicuniverse.fandom.com/wiki/Special:Search?query=";
    //private static final String HERO_PATH = "https://marvelcinematicuniverse.fandom.com/wiki/";
    private static final String HERO_NAME = "HERO NAME";
    private static final String HERO_DESCRIPTION = "HERO DESC";
    private static final String HERO_THUMBNAIL = "HERO THUMBNAIL";

    private ImageView heroImage, logo;
    private TextView bioTextView, heroNameTextView;
    private Button linkBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_detail_layout);
        initViews();

        getHeroIntent();
        heroNameTextView.setText(heroName);

        if (heroThumbnail.equals("http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available.jpg")){
            Glide.with(this)
                    .load(R.drawable.groot_dancing)
                    .into(heroImage);
        }else {
            Picasso.get().load(heroThumbnail).into(heroImage);
        }
        if (heroDescription.length() <= 5) {
            bioTextView.setText(getString(R.string.classified_string));
            bioTextView.setTextSize(60);
        }else {
            bioTextView.setText(heroDescription);

        }
        linkBtn.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(HERO_PATH + heroName));
            startActivity(intent);
        });
    }

    public static Intent newInstance(Context context, Hero hero) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(HERO_NAME, hero.name);
        intent.putExtra(HERO_DESCRIPTION, hero.description);
        intent.putExtra(HERO_THUMBNAIL, hero.getImage());
        return intent;
    }

    public void initViews() {
        heroImage = findViewById(R.id.hero_detail_imageView);
        bioTextView = findViewById(R.id.bio_textView);
        linkBtn = findViewById(R.id.mcu_link_button);
        heroNameTextView = findViewById(R.id.detail_hero_name_text_view);
        logo = findViewById(R.id.logo_image_view);
    }

    private void getHeroIntent() {
        Intent intent = getIntent();
        heroName = intent.getStringExtra(HERO_NAME);
        heroDescription = intent.getStringExtra(HERO_DESCRIPTION);
        heroThumbnail = intent.getStringExtra(HERO_THUMBNAIL);

    }
}
