package org.pursuit.marvelfordummies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import org.pursuit.marvelfordummies.data.model.Hero;
import org.pursuit.marvelfordummies.recyclerview.HeroAdapter;
import org.pursuit.marvelfordummies.util.MarvelUseCaseProvider;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public final class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private IMarvelUseCase useCase;
    private HeroAdapter heroAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.<SearchView>findViewById(R.id.search_view).setOnQueryTextListener(this);
        initHeroRecyclerView();
        useCase = MarvelUseCaseProvider.newInstance();
        useCase.getHeroList(liveHeroList -> heroAdapter.setData(liveHeroList),
          () -> {
              //TODO: Setup Failure Response
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

    @Override
    public boolean onQueryTextSubmit(String s) {
        useCase.getSearchedHeroes(s,
          liveHeroList -> heroAdapter.setData(liveHeroList),
          () -> {
              //TODO: Setup Failure Response
          });
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        Disposable disposable = Observable.fromIterable(useCase.getLiveHeroList())
          .subscribeOn(Schedulers.computation())
          .filter(hero -> heroFilter(hero, s))
          .toList()
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(heroes -> heroAdapter.setData(heroes));
        return false;
    }

    private boolean heroFilter(Hero h, String s) {
        return h.name.toLowerCase().startsWith(s.toLowerCase());
    }
}
