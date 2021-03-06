package org.pursuit.marvelfordummies;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.View;

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
    private AlertDialog alertDialog;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        alertDialog = getLoadingDialog();
        snackbar = getSnackBar(findViewById(R.id.list_activity));

        this.<SearchView>findViewById(R.id.search_view).setOnQueryTextListener(this);

        initHeroRecyclerView();
        useCase = MarvelUseCaseProvider.newInstance();
        alertDialog.show();
        useCase.getHeroList(liveHeroList -> heroAdapter.setData(liveHeroList),
          () -> {
              alertDialog.dismiss();
              snackbar.show();
          },
          () -> alertDialog.dismiss());
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
        alertDialog.show();
        useCase.getSearchedHeroes(s,
          liveHeroList -> heroAdapter.setData(liveHeroList),
          () -> {
              alertDialog.dismiss();
              snackbar.show();
          }, () -> alertDialog.dismiss());
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

    public final AlertDialog getLoadingDialog() {
        return new AlertDialog.Builder(this)
          .setTitle(R.string.loading_dialog_title)
          .setView(R.layout.loading_dialog)
          .create();
    }

    private Snackbar getSnackBar(final View view) {
        return Snackbar.make(view, "Connection failed.", Snackbar.LENGTH_LONG)
          .setDuration(Snackbar.LENGTH_INDEFINITE)
          .setAction("Try Again", v -> {
              alertDialog.show();
              useCase.getHeroList(liveHeroList -> heroAdapter.setData(liveHeroList),
                () -> {
                    alertDialog.dismiss();
                    snackbar.show();
                },
                () -> alertDialog.dismiss());
          });
    }
}
