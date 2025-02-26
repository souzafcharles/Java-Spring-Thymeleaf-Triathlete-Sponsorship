package com.souza.charles.triathlete_sponsorship_web.dtos;

import com.souza.charles.triathlete_sponsorship_web.models.Sponsor;
import com.souza.charles.triathlete_sponsorship_web.models.Triathlete;

import java.util.List;

public record SponsorResponseDTO(
        Long id,
        String title,
        List<Triathlete> triathletes
) {
    public SponsorResponseDTO(Sponsor sponsor) {
        this(sponsor.getId(), sponsor.getTitle(), sponsor.getTriathletes());
    }
}