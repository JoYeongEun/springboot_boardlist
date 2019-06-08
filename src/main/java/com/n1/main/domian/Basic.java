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
public class Basic implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String name;

    @Column
    private String lable;

    @Column
    private String email;

    @Column
    private String phone;

    @Builder
    public Basic(Long idx, String name, String lable, String email, String phone) {
        this.idx = idx;
        this.name = name;
        this.lable = lable;
        this.email = email;
        this.phone = phone;
    }

    public void update(Basic basic) {
        this.name = basic.name;
        this.lable = basic.lable;
        this.email = basic.email;
        this.phone = basic.phone;
    }
}
