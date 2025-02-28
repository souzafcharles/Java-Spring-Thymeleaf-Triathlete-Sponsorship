package com.souza.charles.triathlete_sponsorship_web.services;

import com.souza.charles.triathlete_sponsorship_web.exceptions.SponsorAlreadyExistsException;
import com.souza.charles.triathlete_sponsorship_web.models.Sponsor;
import com.souza.charles.triathlete_sponsorship_web.repositories.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SponsorService {

    @Autowired
    private SponsorRepository sponsorRepository;

    public Sponsor createSponsor(Sponsor sponsor) {
        Optional<Sponsor> existingSponsor = sponsorRepository.findByTitleIgnoreCase(sponsor.getTitle());
        if (existingSponsor.isPresent()) {
            throw new SponsorAlreadyExistsException(sponsor.getTitle());
        }
        return sponsorRepository.save(sponsor);
    }

    public List<Sponsor> readAllSponsors() {
        return sponsorRepository.findAll();
    }

}
