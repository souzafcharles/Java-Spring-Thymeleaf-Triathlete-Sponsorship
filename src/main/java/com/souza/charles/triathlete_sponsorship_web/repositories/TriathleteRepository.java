package com.souza.charles.triathlete_sponsorship_web.repositories;

import com.souza.charles.triathlete_sponsorship_web.models.Triathlete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TriathleteRepository extends JpaRepository<Triathlete, Long> {

    List<Triathlete> findByNameContainingIgnoreCase(String name);

}
