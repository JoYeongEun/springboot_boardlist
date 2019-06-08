package com.n1.main.controller;

import com.n1.main.domian.Basic;
import com.n1.main.domian.Profile;
import com.n1.main.service.BasicService;
import com.n1.main.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Controller
public class MainController {

    @Autowired
    private BasicService basicService;

    @Autowired
    private ProfileService profileService;

    public MainController(BasicService basicService, ProfileService profileService) {
        this.basicService = basicService;
        this.profileService = profileService;
    }

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("basicList", basicService.findBasiclist());
        model.addAttribute("profileList", profileService.findProfilelist());
        return "index";
    }

    @GetMapping("/basic/new")
    public String create_basic(Basic basic){
        return "new";
    }

    @GetMapping("/profile/new2")
    public String create_profile(Profile profile){
        return "new2";
    }

    @PostMapping("/basic/add")
    public String add_basic(Basic basic, Model model) {

        Basic savedBasic = basicService.save(basic);

        model.addAttribute("basic", basicService.findBasicByIdx(savedBasic.getIdx()));
        return "basictxt";
    }

    @PostMapping("/profile/add")
    public String add_profile(Profile profile, Model model) {

        profile.setCreatedDateNow();
        Profile savedProfile = profileService.save(profile);

        model.addAttribute("profile", profileService.findProfileByIdx(savedProfile.getIdx()));
        return "profiletxt";
    }

    @GetMapping("/basic/{idx}")
    public String read_basic(@PathVariable Long idx, Model model) {
        model.addAttribute("basic", basicService.findBasicByIdx(idx));
        return "item";
    }

    @GetMapping("/profile/{idx}")
    public String read_profile(@PathVariable Long idx, Model model) {
        model.addAttribute("profile", profileService.findProfileByIdx(idx));
        return "item2";
    }

    @DeleteMapping("/basic/{idx}")
    public ResponseEntity<?> deleteBasic(@PathVariable("idx") Long idx) {
        basicService.delete(idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @DeleteMapping("/profile/{idx}")
    public ResponseEntity<?> deleteProfile(@PathVariable("idx") Long idx) {
        profileService.delete(idx);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @PutMapping("/basic/{idx}")
    public ResponseEntity<?> updateBasic(@PathVariable("idx") Long idx, @RequestBody Basic basic) {
        Basic persistBasic = basicService.getOne(idx);
        persistBasic.update(basic);
        basicService.save(persistBasic);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }

    @PutMapping("/profile/{idx}")
    public ResponseEntity<?> updateProfile(@PathVariable("idx") Long idx, @RequestBody Profile profile) {
        Profile persistProfile = profileService.getOne(idx);
        persistProfile.update(profile);
        profileService.save(persistProfile);
        return new ResponseEntity<>("{}", HttpStatus.OK);
    }






}
