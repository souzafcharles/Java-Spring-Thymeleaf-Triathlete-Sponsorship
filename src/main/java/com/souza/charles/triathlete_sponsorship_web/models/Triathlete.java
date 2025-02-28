package com.souza.charles.triathlete_sponsorship_web.models;

import com.souza.charles.triathlete_sponsorship_web.utils.TriathleteSponsorshipMessages;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "tb_triathlete")
public class Triathlete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = TriathleteSponsorshipMessages.TRIATHLETE_NAME_REQUIRED)
    @Size(min = 2, message = TriathleteSponsorshipMessages.TRIATHLETE_NAME_MIN_LENGTH)
    private String name;

    @Min(value = 18, message = TriathleteSponsorshipMessages.TRIATHLETE_AGE_MIN)
    private Integer age;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "tb_triathlete_sponsor",
            joinColumns = @JoinColumn(name = "triathlete_id"),
            inverseJoinColumns = @JoinColumn(name = "sponsor_id"))
    private List<Sponsor> sponsors;

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

    public void setSponsors(List<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }
}