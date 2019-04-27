package org.pursuit.marvelfordummies.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class HeroData {
    @SerializedName("count")
    public final int count;

    @SerializedName("total")
    public final int total;

    @SerializedName("results")
    public final List<Hero> results;

    public HeroData(int count, int total, List<Hero> results) {
        this.count = count;
        this.total = total;
        this.results = results;
    }
}
