package com.souza.charles.triathlete_sponsorship_web.repositories;

import com.souza.charles.triathlete_sponsorship_web.models.Triathlete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TriathleteRepository extends JpaRepository<Triathlete, Long> {
    List<Triathlete> findByNameContainingIgnoreCase(String name);

    @Query("SELECT t FROM Triathlete t JOIN t.sponsors s WHERE s.title LIKE %:sponsorName%")
    List<Triathlete> findBySponsorName(@Param("sponsorName") String sponsorName);

}
