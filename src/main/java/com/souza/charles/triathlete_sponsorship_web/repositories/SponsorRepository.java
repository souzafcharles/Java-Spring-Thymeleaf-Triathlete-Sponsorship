package com.souza.charles.triathlete_sponsorship_web.repositories;

import com.souza.charles.triathlete_sponsorship_web.models.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SponsorRepository extends JpaRepository<Sponsor, Long> {
    Optional<Sponsor> findByTitleIgnoreCase(String title);
}

