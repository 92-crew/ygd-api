package com.crew92.ygd.api.repositories.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "smoking_areas")
public class SmokingAreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 256)
    private String description;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 20, nullable = false)
    private AreaType type;

    @Column(nullable = false)
    private int categoryId;

//    @OneToOne
//    @JoinColumn(name = "categoryId")
//    private CategoryEntity category;

    @Column(nullable = false)
    private int locationSi;

//    @OneToOne
//    @JoinColumn(name = "locationSi")
//    private RegionEntity si;

    @Column(nullable = false)
    private int locationGu;

    @Column(nullable = false)
    private int locationDong;

    @Column(length = 50)
    private String locationRoad;

    private int locationRoadCode;

    @Column(length = 50)
    private String locationBuilding;

    private float scaleValue;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ScaleUnitType scaleUnit;

    @Column(nullable = false)
    private boolean isUnderManagement;

    @Column(length = 20)
    private String managerName;

    private String establishedBy;
    private LocalDateTime establishedAt;
    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;
}
