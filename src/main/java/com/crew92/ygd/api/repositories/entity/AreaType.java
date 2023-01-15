package com.crew92.ygd.api.repositories.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AreaType {
    CLOSED("폐쇄형"),
    COMPLETELY_CLOSED("완전폐쇄형"),
    OPEN("개방형"),
    COMPLETELY_OPEN("완전개방형"),
    ;

    @Getter
    private final String description;
}
