package com.recruitment.process.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "createDate")
    private Date createdDate;

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.EAGER
    )
    private Set<Offer> offers = new HashSet<Offer>();

    public User() {
    }

    public User(Long id, String userName, String password, Date createdDate) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.createdDate = createdDate;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }


}
