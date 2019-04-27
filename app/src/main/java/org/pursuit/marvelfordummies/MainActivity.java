package org.pursuit.marvelfordummies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import org.pursuit.marvelfordummies.dummymodel.DummyHero;
import org.pursuit.marvelfordummies.dummymodel.HeroSummary;
import org.pursuit.marvelfordummies.recyclerview.HeroAdapter;

import java.util.ArrayList;
import java.util.List;

public final class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity.DATA";

    private List<HeroSummary> heroSummaryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        heroSummaryList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            heroSummaryList.add(new DummyHero());
        }
        initHeroRecyclerView();

    }

    void initHeroRecyclerView(){
        RecyclerView heroRecyclerView = findViewById(R.id.hero_recyclerview);
        heroRecyclerView.setAdapter(new HeroAdapter(heroSummaryList));
        heroRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
}
