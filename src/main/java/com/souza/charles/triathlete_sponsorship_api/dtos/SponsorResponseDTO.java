package com.souza.charles.triathlete_sponsorship_api.dtos;

import com.souza.charles.triathlete_sponsorship_api.models.Sponsor;
import com.souza.charles.triathlete_sponsorship_api.models.Triathlete;

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