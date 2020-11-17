package com.recruitment.process.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.recruitment.process.enums.ApplicationStatus;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
@Data
@Table(
        name = "application",
        uniqueConstraints=
        @UniqueConstraint(columnNames={"offer_id", "email"})
)
@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "offer_id")
    private Offer offer;
    @NonNull
    @Column(name = "email")
    private String email;
    @NonNull
    @Column(name = "resume")
    private String resume;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @Column(name = "applicationStatus")
    private ApplicationStatus applicationStatus;


    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", offer=" + offer +
                ", email='" + email + '\'' +
                ", resume='" + resume + '\'' +
                ", candidate=" + candidate +
                ", applicationStatus=" + applicationStatus +
                '}';
    }

    public Application() {
    }
}
