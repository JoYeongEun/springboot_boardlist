package com.n1.main.service;

import com.n1.main.domian.Profile;
import com.n1.main.repository.ProfileRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    private ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    public Profile findProfileByIdx(Long idx) {
        return profileRepository.findById(idx).orElse(new Profile());
    }

    public List<Profile> findProfilelist() {
        return profileRepository.findAll();
    }

    public Profile save(Profile profile){
        return profileRepository.save(profile);
    }

    public void delete(Long idx) { profileRepository.deleteById(idx); }

    public Profile getOne(Long idx) { return profileRepository.getOne(idx); }

}
