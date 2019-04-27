package org.pursuit.marvelfordummies.util;

import org.pursuit.marvelfordummies.IMarvelUseCase;
import org.pursuit.marvelfordummies.data.network.HeroRepository;
import org.pursuit.marvelfordummies.domain.MarvelUseCase;

public final class MarvelUseCaseProvider {
    public static IMarvelUseCase newInstance() {
        return new MarvelUseCase(new HeroRepository());
    }
}
