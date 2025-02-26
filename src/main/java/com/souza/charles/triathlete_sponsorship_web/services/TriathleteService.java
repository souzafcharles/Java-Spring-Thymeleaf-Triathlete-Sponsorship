package com.souza.charles.triathlete_sponsorship_web.services;

import com.souza.charles.triathlete_sponsorship_web.dtos.TriathleteRequestDTO;
import com.souza.charles.triathlete_sponsorship_web.dtos.TriathleteResponseDTO;
import com.souza.charles.triathlete_sponsorship_web.exceptions.TriathleteNotFoundException;
import com.souza.charles.triathlete_sponsorship_web.models.Triathlete;
import com.souza.charles.triathlete_sponsorship_web.repositories.TriathleteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
public class TriathleteService {

    @Autowired
    private TriathleteRepository triathleteRepository;

    @Transactional
    public TriathleteResponseDTO createTriathlete(TriathleteRequestDTO dto) {
        Triathlete entity = new Triathlete(dto);
        Triathlete created = triathleteRepository.save(entity);
        return new TriathleteResponseDTO(created);
    }

    @Transactional(readOnly=true)
    public List<TriathleteResponseDTO> readAllTriathletes() {
        return triathleteRepository.findAll().stream()
                .map(TriathleteResponseDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public TriathleteResponseDTO readById(Long id) {
        Triathlete entity = triathleteRepository.findById(id).orElseThrow(() -> new TriathleteNotFoundException(id));
        return new TriathleteResponseDTO (entity);
    }

    @Transactional
    public void deleteTriathlete(Long id) {
        Triathlete entity = triathleteRepository.findById(id).orElseThrow(() -> new TriathleteNotFoundException(id));
        triathleteRepository.delete(entity);
    }
}