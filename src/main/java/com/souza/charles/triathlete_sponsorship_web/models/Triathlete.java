package com.souza.charles.triathlete_sponsorship_web.models;

import com.souza.charles.triathlete_sponsorship_web.dtos.TriathleteRequestDTO;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_triathlete")
public class Triathlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Integer age;

    @ManyToMany
    @JoinTable(name = "tb_triathlete_sponsor",
            joinColumns = @JoinColumn(name = "triathlete_id"),
            inverseJoinColumns = @JoinColumn(name = "sponsor_id"))
    private List<Sponsor> sponsors = new ArrayList<>();

    public Triathlete() {}

    public Triathlete(Long id, String name, Integer age, List<Sponsor> sponsors) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sponsors = sponsors;
    }

    public Triathlete(TriathleteRequestDTO dto, List<Sponsor> sponsors) {
        this.id = dto.id();
        this.name = dto.name();
        this.age = dto.age();
        this.sponsors = sponsors;
    }

    public Triathlete(TriathleteRequestDTO dto) {
        this.id = dto.id();
        this.name = dto.name();
        this.age = dto.age();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triathlete that = (Triathlete) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}