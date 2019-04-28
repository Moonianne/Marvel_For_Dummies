package org.pursuit.marvelfordummies.domain;

import android.util.Log;

import org.pursuit.marvelfordummies.IMarvelUseCase;
import org.pursuit.marvelfordummies.MarvelCallBack;
import org.pursuit.marvelfordummies.data.model.Hero;

import java.util.LinkedList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public final class MarvelUseCase implements IMarvelUseCase {
    private static final String TAG = "MarvelUseCase.Network";
    private final IHeroRepository repository;
    private List<Hero> liveHeroList;
    private Disposable disposable;

    public MarvelUseCase(final IHeroRepository repository) {
        this.repository = repository;
    }

    public void getHeroList(MarvelCallBack.Success success,
                            MarvelCallBack.Failure failure) {
        disposable = repository.getHeroes()
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(heroes -> {
                Log.d(TAG, "getHeroList: " + heroes.get(0).name);
                liveHeroList = new LinkedList<>(heroes);
                success.onSuccess(liveHeroList);
            },
            throwable -> {
                Log.d(TAG, "getHeroList: " + throwable.getMessage());
                failure.onFailure();
            });
    }

    @Override
    public void dispose() {
        disposable.dispose();
    }
}
