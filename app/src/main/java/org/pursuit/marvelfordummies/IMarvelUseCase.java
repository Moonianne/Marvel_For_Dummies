package org.pursuit.marvelfordummies;

import org.pursuit.marvelfordummies.data.model.Hero;

import java.util.List;

public interface IMarvelUseCase {
    void getHeroList(MarvelCallBack.Success success,
                     MarvelCallBack.Failure failure);

    void getSearchedHeroes(String search,
                           MarvelCallBack.Success success,
                           MarvelCallBack.Failure failure);

    List<Hero> getLiveHeroList();

    void dispose();
}
