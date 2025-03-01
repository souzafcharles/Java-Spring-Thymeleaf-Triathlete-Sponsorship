package com.souza.charles.triathlete_sponsorship_web.services;

import com.souza.charles.triathlete_sponsorship_web.exceptions.TriathleteNotFoundException;
import com.souza.charles.triathlete_sponsorship_web.models.Triathlete;
import com.souza.charles.triathlete_sponsorship_web.repositories.TriathleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TriathleteService {

    @Autowired
    private TriathleteRepository triathleteRepository;

    public Triathlete createTriathlete(Triathlete triathlete) {
        return triathleteRepository.save(triathlete);
    }

    public List<Triathlete> readAllTriathletes() {
        return triathleteRepository.findAll();
    }

    public Triathlete readTriathleteById(Long id) throws TriathleteNotFoundException {
        Optional<Triathlete> optional = triathleteRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new TriathleteNotFoundException(id);
        }
    }

    public void deleteTriathlete(Long id) throws TriathleteNotFoundException {
        Triathlete triathlete = readTriathleteById(id);
        triathlete.getSponsors().clear();
        triathleteRepository.save(triathlete);
        triathleteRepository.delete(triathlete);
    }

    public Triathlete editTriathlete(Triathlete triathlete) {
        return triathleteRepository.save(triathlete);
    }

    public List<Triathlete> readAllTriathletesByName(String name) {
        return triathleteRepository.findByNameContainingIgnoreCase(name);
    }
}