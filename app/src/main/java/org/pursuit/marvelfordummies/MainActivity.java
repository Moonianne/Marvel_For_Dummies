package org.pursuit.marvelfordummies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.pursuit.marvelfordummies.recyclerview.HeroAdapter;
import org.pursuit.marvelfordummies.util.MarvelUseCaseProvider;

import java.util.Collections;

public final class MainActivity extends AppCompatActivity {
    private IMarvelUseCase useCase;
    private HeroAdapter heroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initHeroRecyclerView();
        useCase = MarvelUseCaseProvider.newInstance();
        useCase.getHeroList(liveHeroList -> heroAdapter.setData(liveHeroList),
          () -> {
              //No-op
          });
    }

    @Override
    protected void onDestroy() {
        useCase.dispose();
        super.onDestroy();
    }

    private void initHeroRecyclerView() {
        RecyclerView heroRecyclerView = findViewById(R.id.hero_recyclerview);
        heroAdapter = new HeroAdapter(Collections.emptyList());
        heroRecyclerView.setAdapter(heroAdapter);
        heroRecyclerView.setLayoutManager(
          new LinearLayoutManager(
            this, LinearLayoutManager.HORIZONTAL, false));
    }
}
