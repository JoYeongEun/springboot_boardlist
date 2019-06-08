package com.n1.main.repository;

import com.n1.main.domian.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile,Long>{
    List<Profile> findAllByUrl(final String url);
    Profile findFirstByUrl(final String url);
}
