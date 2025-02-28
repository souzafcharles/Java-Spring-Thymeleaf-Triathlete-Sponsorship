package com.souza.charles.triathlete_sponsorship_web.models;

import com.souza.charles.triathlete_sponsorship_web.utils.TriathleteSponsorshipMessages;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "tb_sponsor")
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = TriathleteSponsorshipMessages.SPONSOR_TITLE_REQUIRED)
    @Size(min = 2, message = TriathleteSponsorshipMessages.SPONSOR_TITLE_MIN_LENGTH)
    private String title;

    @ManyToMany(mappedBy = "sponsors")
    private List<Triathlete> triathletes;

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

    public void setTriathletes(List<Triathlete> triathletes) {
        this.triathletes = triathletes;
    }
}
