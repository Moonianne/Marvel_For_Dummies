package org.pursuit.marvelfordummies.domain;

import org.pursuit.marvelfordummies.data.model.Hero;

import java.util.List;

import io.reactivex.Observable;

public interface IHeroRepository {
    Observable<List<Hero>> getHeroes();
}
