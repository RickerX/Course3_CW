package com.example.course3_cw.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum Size {
    SIZE_36(36),
    SIZE_37(37),
    SIZE_38(38),
    SIZE_39(39),
    SIZE_40(40),
    SIZE_41(41),
    SIZE_42(42);

    private final int size;

    Size(int size) {
        this.size = size;
    }
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public static Size forValues(@JsonProperty("size") int size){
        for (Size value : Size.values()) {
            if (value.size == size){
                return value;
            }
        }
        return null;
    }
}
