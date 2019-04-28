package org.pursuit.marvelfordummies;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.marvelfordummies.data.model.Hero;

public class DetailActivity extends AppCompatActivity {
    private static String heroName;
    private static String heroDescription;
    private static String heroThumbnail;

    private static final String HERO_PATH = "https://marvelcinematicuniverse.fandom.com/wiki/";
    private static final String HERO_NAME = "HERO NAME";
    private static final String HERO_DESCRIPTION = "HERO DESC";
    private static final String HERO_THUMBNAIL = "HERO THUMBNAIL";

    private ImageView heroImage;
    private TextView bioTextView;
    private Button linkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_detail_layout);
        initViews();

        getHeroIntent();
        Picasso.get().load(heroThumbnail).into(heroImage);
        bioTextView.setText(heroDescription);

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

    }

    private void getHeroIntent() {
        Intent intent = getIntent();
        heroName = intent.getStringExtra(HERO_NAME);
        heroDescription = intent.getStringExtra(HERO_DESCRIPTION);
        heroThumbnail = intent.getStringExtra(HERO_THUMBNAIL);
    }
}
