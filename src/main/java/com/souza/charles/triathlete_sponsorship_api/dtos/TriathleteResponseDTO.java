package com.souza.charles.triathlete_sponsorship_api.dtos;

import com.souza.charles.triathlete_sponsorship_api.models.Sponsor;
import com.souza.charles.triathlete_sponsorship_api.models.Triathlete;
import java.util.List;

public record TriathleteResponseDTO(
        Long id,
        String name,
        Integer age,
        List<Sponsor> sponsors
) {
    public TriathleteResponseDTO(Triathlete triathlete) {
        this(triathlete.getId(), triathlete.getName(), triathlete.getAge(), triathlete.getSponsors());
    }
}
