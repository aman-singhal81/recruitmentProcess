package com.recruitment.process.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(
        name = "offer"
        ,uniqueConstraints = @UniqueConstraint(columnNames = "jobTitle", name = "jobTitle")
)
public class Offer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "jobTitle")
    private String jobTitle;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "numberOfApplication")
    private long numberOfApplication;

    @OneToMany(
            mappedBy = "offer",
            fetch = FetchType.EAGER
    )
    private Set<Application> applications = new HashSet<Application>();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    protected void onCreate() {
        startDate = new Date();
    }

}
