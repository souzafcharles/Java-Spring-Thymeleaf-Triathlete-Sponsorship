package com.souza.charles.triathlete_sponsorship_api.services;

import com.souza.charles.triathlete_sponsorship_api.dtos.TriathleteRequestDTO;
import com.souza.charles.triathlete_sponsorship_api.dtos.TriathleteResponseDTO;
import com.souza.charles.triathlete_sponsorship_api.models.Triathlete;
import com.souza.charles.triathlete_sponsorship_api.repositories.TriathleteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TriathleteService {

    @Autowired
    private TriathleteRepository triathleteRepository;

    @Transactional
    public TriathleteResponseDTO createTriathlete(TriathleteRequestDTO data) {
        Triathlete entity = new Triathlete(data);
        Triathlete created = triathleteRepository.save(entity);
        return new TriathleteResponseDTO(created);
    }

}


