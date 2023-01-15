package com.crew92.ygd.api.services;

import com.crew92.ygd.api.repositories.SmokingAreaRepository;
import com.crew92.ygd.api.repositories.entity.SmokingAreaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@Service
@RequiredArgsConstructor
public class SmokingAreaQueryService {

    private final SmokingAreaRepository smokingAreaRepository;

    public List<SmokingAreaEntity> getAll() {
        return stream(smokingAreaRepository.findAll(Sort.by("id")).spliterator(), false)
                .collect(toList());
    }

    public SmokingAreaEntity getById(long id) {
        return smokingAreaRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("존재하지 않는 흡연구역입니다."));
    }
}
