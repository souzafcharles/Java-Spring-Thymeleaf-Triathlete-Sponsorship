package com.souza.charles.triathlete_sponsorship_web.dtos;

import com.souza.charles.triathlete_sponsorship_web.utils.TriathleteSponsorshipMessages;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record TriathleteRequestDTO(
        Long id,

        @NotBlank(message = TriathleteSponsorshipMessages.TRIATHLETE_NAME_REQUIRED)
        @Size(min = 2, message = TriathleteSponsorshipMessages.TRIATHLETE_NAME_MIN_LENGTH)
        String name,

        @NotNull(message = "Age is required")
        @Min(value = 18, message = TriathleteSponsorshipMessages.TRIATHLETE_AGE_MIN)
        Integer age,

        List<Long> sponsors
) {
}
