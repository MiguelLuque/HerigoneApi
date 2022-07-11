package com.maik.ApiPostgresTemplate.web;

import com.maik.ApiPostgresTemplate.Domain.services.HerigoneService;
import com.maik.ApiPostgresTemplate.api.HerigoneApiDelegate;
import com.maik.ApiPostgresTemplate.models.dto.HerigoneDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ApiDelegateImpl implements HerigoneApiDelegate {

    @Autowired
    private HerigoneService herigoneService;

    @Override
    public ResponseEntity<HerigoneDTO> findHerigoneByDate(String date) {
        return ResponseEntity.ok().body(herigoneService.findHerigoneByDate(date));
    }

}
