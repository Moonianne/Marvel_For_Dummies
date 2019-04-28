package org.pursuit.marvelfordummies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.pursuit.marvelfordummies.data.model.Hero;

public class DetailActivity extends AppCompatActivity {
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

    public static Hero newInstance(Hero hero){
        if(hero != null){

        }
        return hero;
    }
    public void initViews(){
        heroImage = findViewById(R.id.hero_detail_imageView);
        bioTextView = findViewById(R.id.bio_textView);
        linkBtn = findViewById(R.id.mcu_link_button);



    }
}
