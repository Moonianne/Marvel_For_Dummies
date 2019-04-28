package org.pursuit.marvelfordummies;

import org.pursuit.marvelfordummies.data.model.Hero;

import java.util.List;

public interface IMarvelUseCase {
    void getHeroList(MarvelCallBack.Success success,
                     MarvelCallBack.Failure failure,
                     MarvelCallBack.Complete complete);

    void getSearchedHeroes(String search,
                           MarvelCallBack.Success success,
                           MarvelCallBack.Failure failure,
                           MarvelCallBack.Complete complete);

    List<Hero> getLiveHeroList();

    void dispose();
}
