package org.pursuit.marvelfordummies.data.network;

import org.pursuit.marvelfordummies.data.model.Hero;
import org.pursuit.marvelfordummies.domain.IHeroRepository;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public final class HeroRepository implements IHeroRepository {
    private MarvelService marvelService;

    public HeroRepository() {
        marvelService = MarvelRetrofit.getInstance().create(MarvelService.class);
    }

    @Override
    public Observable<List<Hero>> getHeroes() {
        HashCalculator hashCalculator = new HashCalculator();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String hash = hashCalculator.calculate(timeStamp, "7cd7338a40cf7f51ee2af3a678bbe9daf9bc62ed",
          "e0f9c064715b8340e32ee57262f090e1");
        return marvelService
          .getComics("-modified", 90, timeStamp, "e0f9c064715b8340e32ee57262f090e1", hash)
          .subscribeOn(Schedulers.io())
          .map(response -> response.data.results);
    }

    @Override
    public Observable<List<Hero>> getSearchedHeroes(String search) {
        HashCalculator hashCalculator = new HashCalculator();
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String hash = hashCalculator.calculate(timeStamp, "7cd7338a40cf7f51ee2af3a678bbe9daf9bc62ed",
          "e0f9c064715b8340e32ee57262f090e1");
        return marvelService
          .getSearchedHero(search, 10, timeStamp, "e0f9c064715b8340e32ee57262f090e1", hash)
          .subscribeOn(Schedulers.io())
          .map(response -> response.data.results);
    }
}
