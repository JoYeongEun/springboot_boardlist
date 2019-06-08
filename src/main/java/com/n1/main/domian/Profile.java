package com.n1.main.domian;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table
public class Profile implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String network;

    @Column
    private String username;

    @Column
    private String url;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;


    @Builder
    public Profile(Long idx, String network, String username, String url, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.idx = idx;
        this.network = network;
        this.username = username;
        this.url = url;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public void setCreatedDateNow() {
        this.createdDate = LocalDateTime.now();
    }

    public void update(Profile profile) {
        this.network = profile.getNetwork();
        this.username = profile.getUsername();
        this.url = profile.getUrl();
        this.updatedDate = LocalDateTime.now();
    }

}

