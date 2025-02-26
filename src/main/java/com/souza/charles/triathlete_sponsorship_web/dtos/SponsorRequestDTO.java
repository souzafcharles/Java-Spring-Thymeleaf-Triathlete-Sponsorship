package com.souza.charles.triathlete_sponsorship_web.dtos;

import com.souza.charles.triathlete_sponsorship_web.utils.TriathleteSponsorshipMessages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record SponsorRequestDTO(
        Long id,

        @NotBlank(message = TriathleteSponsorshipMessages.SPONSOR_TITLE_REQUIRED)
        @Size(min = 2, message = TriathleteSponsorshipMessages.SPONSOR_TITLE_MIN_LENGTH)
        String title,

        List<Long> triathletes
) {}