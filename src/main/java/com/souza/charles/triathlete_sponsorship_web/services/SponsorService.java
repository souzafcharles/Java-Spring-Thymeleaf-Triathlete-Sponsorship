package com.souza.charles.triathlete_sponsorship_web.services;

import com.souza.charles.triathlete_sponsorship_web.dtos.SponsorRequestDTO;
import com.souza.charles.triathlete_sponsorship_web.dtos.SponsorResponseDTO;
import com.souza.charles.triathlete_sponsorship_web.models.Sponsor;
import com.souza.charles.triathlete_sponsorship_web.repositories.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class SponsorService {

    @Autowired
    private SponsorRepository sponsorRepository;

    @Transactional
    public SponsorResponseDTO createSponsor(SponsorRequestDTO dto) {
        Sponsor entity = new Sponsor(dto);
        Sponsor created = sponsorRepository.save(entity);
        return new SponsorResponseDTO(created);
    }

}
