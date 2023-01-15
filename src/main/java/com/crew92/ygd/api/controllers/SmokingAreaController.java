package com.crew92.ygd.api.controllers;

import com.crew92.ygd.api.services.SmokingAreaQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.crew92.ygd.api.controllers.SmokingAreaDto.transfer;

@RestController
@RequiredArgsConstructor
public class SmokingAreaController {

    private final SmokingAreaQueryService smokingAreaQueryService;

    @GetMapping("/api/v1/smoking-areas")
    public ResponseObject<List<SmokingAreaDto>> getAll() {
        return new ResponseObject<>(transfer(smokingAreaQueryService.getAll()));
    }

    @GetMapping("/api/v1/smoking-area/{id}")
    public ResponseObject<SmokingAreaDto> getById(@PathVariable int id) {
        return new ResponseObject<>(transfer(smokingAreaQueryService.getById(id)));
    }

}
