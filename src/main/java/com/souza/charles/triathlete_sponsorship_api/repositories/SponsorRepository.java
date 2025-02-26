package com.souza.charles.triathlete_sponsorship_api.repositories;

import com.souza.charles.triathlete_sponsorship_api.models.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SponsorRepository extends JpaRepository<Sponsor, Long> {
}
