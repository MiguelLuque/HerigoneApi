package com.maik.ApiPostgresTemplate.Domain.services;

import com.maik.ApiPostgresTemplate.models.dto.HerigoneDTO;

public interface HerigoneService {

    public HerigoneDTO findHerigoneByDate(String date);

}
