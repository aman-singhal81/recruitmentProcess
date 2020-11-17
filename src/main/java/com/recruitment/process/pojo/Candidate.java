package com.recruitment.process.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "first_name", nullable = false)
    private String FirstName;
    @Column(name = "last_name", nullable = false)
    private String LastName;
    @Column(name = "email", nullable = false)
    private String Email;

    @OneToMany(
            mappedBy = "candidate",
            fetch = FetchType.EAGER
    )
    private Set<Application> applications = new HashSet<Application>();

}
