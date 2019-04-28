package org.pursuit.marvelfordummies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.marvelfordummies.data.model.Hero;

public class DetailActivity extends AppCompatActivity {
    private static String heroName;
    private static String heroDescription;
    private static String heroThumbnail;

    public static final String HERO_NAME = "HERO NAME";
    public static final String HERO_DESCRIPTION = "HERO DESC";
    public static final String HERO_THUMBNAIL = "HERO THUMBNAIL";

    private static ImageView heroImage;
    private static TextView bioTextView;
    private Button linkBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hero_detail_layout);
        initViews();

       //Picasso.get().load(hero.getImage()).into(heroImage);
        //bioTextView.setText(hero.description);

        linkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Link to mcu
            }
        });
    }

    public static Intent newInstance(Context context, Hero hero){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(HERO_NAME, hero.name);
        intent.putExtra(HERO_DESCRIPTION, hero.description);
        intent.putExtra(HERO_THUMBNAIL, hero.getImage());
        return intent;
    }

    public void initViews(){
        heroImage = findViewById(R.id.hero_detail_imageView);
        bioTextView = findViewById(R.id.bio_textView);
        linkBtn = findViewById(R.id.mcu_link_button);



    }
}
