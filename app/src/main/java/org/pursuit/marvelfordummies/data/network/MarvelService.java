package org.pursuit.marvelfordummies.data.network;

import org.pursuit.marvelfordummies.data.model.HeroDataResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelService {
    String END_POINT = "characters";

    @GET(END_POINT)
    Observable<HeroDataResponse> getComics(@Query("orderBy") String orderBy,
                                           @Query("limit") long limit,
                                           @Query("ts") String timeStamp,
                                           @Query("apikey") String apiKey,
                                           @Query("hash") String hash);


}
