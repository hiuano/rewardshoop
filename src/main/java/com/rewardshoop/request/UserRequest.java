package com.rewardshoop.request;

import com.rewardshoop.validated.updataDefaultAddId;

import javax.validation.constraints.Min;

public class UserRequest {
    @Min(value = 0, message = "{NOT_LESS_THAN_THE_MIN}", groups = {updataDefaultAddId.class})
    private int id;
    @Min(value = 0, message = "{NOT_LESS_THAN_THE_MIN}", groups = {updataDefaultAddId.class})
    private int defaultAddId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDefaultAddId() {
        return defaultAddId;
    }

    public void setDefaultAddId(int defaultAddId) {
        this.defaultAddId = defaultAddId;
    }
}
