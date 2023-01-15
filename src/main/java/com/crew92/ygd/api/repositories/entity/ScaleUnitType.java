package com.crew92.ygd.api.repositories.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ScaleUnitType {
    SQUARE_METER("㎡"),
    ;

    @Getter
    private final String displayString;
}
