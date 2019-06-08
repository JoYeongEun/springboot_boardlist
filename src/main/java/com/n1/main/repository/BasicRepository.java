package com.n1.main.repository;

import com.n1.main.domian.Basic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BasicRepository extends JpaRepository<Basic,Long>{
    List<Basic> findAllByEmail(final String email);
    Basic findFirstByEmail(final String email);
}
