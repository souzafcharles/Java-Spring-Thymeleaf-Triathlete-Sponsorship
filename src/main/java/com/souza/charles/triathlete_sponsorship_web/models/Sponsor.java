package com.souza.charles.triathlete_sponsorship_web.models;

import com.souza.charles.triathlete_sponsorship_web.dtos.SponsorRequestDTO;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_sponsor")
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany(mappedBy = "sponsors")
    private List<Triathlete> triathletes = new ArrayList<>();

    public Sponsor() {
    }

    public Sponsor(Long id, String title, List<Triathlete> triathletes) {
        this.id = id;
        this.title = title;
        this.triathletes = triathletes;
    }

    public Sponsor(SponsorRequestDTO dto, List<Triathlete> triathletes) {
        this.id = dto.id();
        this.title = dto.title();
        this.triathletes = triathletes;
    }

    public Sponsor(SponsorRequestDTO dto) {
        this.id = dto.id();
        this.title = dto.title();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Triathlete> getTriathletes() {
        return triathletes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return Objects.equals(id, sponsor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}