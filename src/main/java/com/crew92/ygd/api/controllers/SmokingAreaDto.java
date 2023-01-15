package com.crew92.ygd.api.controllers;

import com.crew92.ygd.api.repositories.entity.ScaleUnitType;
import com.crew92.ygd.api.repositories.entity.SmokingAreaEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

@Getter
@Builder
@RequiredArgsConstructor
public class SmokingAreaDto {

    private final long id;
    private final String name;
    private final String description;
    private final CodeDto type;
    private final CategoryDto category;
    private final LocationDto location;
    private final ScaleDto scale;
    private final String establishedBy;
    private final LocalDateTime establishedAt;
    private final LocalDateTime updatedAt;

    @Getter
    @Builder
    @RequiredArgsConstructor
    static class LocationDto {
        private final LocationDetailDto si;
        private final LocationDetailDto gu;
        private final String road;
        private final int roadCode;
        private final String building;
        private final String displayString;
        private final double latitude;
        private final double longitude;

        @Getter
        @RequiredArgsConstructor
        static class LocationDetailDto {
            private final int id;
            private final String name;
        }
    }

    @Getter
    static class ScaleDto {
        private final ScaleUnitType unit;
        private final float value;
        private final String displayString;

        public ScaleDto(@NonNull ScaleUnitType unit, float value) {
            this.unit = unit;
            this.value = value;
            this.displayString = format("%f%s", value, unit.getDisplayString());
        }
    }

    @Getter
    @Builder
    @RequiredArgsConstructor
    static class Management {
        private final boolean underManagement;
        private final String managerName;
    }

    public static SmokingAreaDto transfer(SmokingAreaEntity entity) {
        return SmokingAreaDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .type(new CodeDto(entity.getType().name(), entity.getType().getDescription()))
                .establishedAt(entity.getEstablishedAt())
                .establishedBy(entity.getEstablishedBy())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public static List<SmokingAreaDto> transfer(List<SmokingAreaEntity> entities) {
        return entities.stream().map(SmokingAreaDto::transfer).collect(toList());
    }
}
