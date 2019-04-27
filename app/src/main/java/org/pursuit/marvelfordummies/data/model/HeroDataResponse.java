package org.pursuit.marvelfordummies.data.model;

import com.google.gson.annotations.SerializedName;

public final class HeroDataResponse {

    @SerializedName("status")
    public final String status;

    @SerializedName("code")
    public final int code;

    @SerializedName("data")
    public final HeroData data;

    public HeroDataResponse(String status, int code, HeroData data) {
        this.status = status;
        this.code = code;
        this.data = data;
    }
}
