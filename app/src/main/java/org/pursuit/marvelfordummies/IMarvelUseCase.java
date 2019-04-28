package org.pursuit.marvelfordummies;

public interface IMarvelUseCase {
    void getHeroList(MarvelCallBack.Success success,
                     MarvelCallBack.Failure failure);

    void dispose();
}
