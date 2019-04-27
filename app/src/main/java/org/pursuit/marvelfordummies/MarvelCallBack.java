package org.pursuit.marvelfordummies;

import org.pursuit.marvelfordummies.data.model.Hero;

import java.util.List;

public interface MarvelCallBack {
    interface Success {
        void onSuccess(List<Hero> liveHeroList);
    }

    interface Failure {
        void onFailure();
    }
}
