package com.souza.charles.triathlete_sponsorship_api.repositories;

import com.souza.charles.triathlete_sponsorship_api.models.Triathlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TriathleteRepository extends JpaRepository<Triathlete, Long> {
}
