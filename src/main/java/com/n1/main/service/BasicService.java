package com.n1.main.service;

import com.n1.main.domian.Basic;
import com.n1.main.repository.BasicRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicService {
    private BasicRepository basicRepository;

    public BasicService(BasicRepository basicRepository){
        this.basicRepository = basicRepository;
    }

    public Basic findBasicByIdx(Long idx){
        return basicRepository.findById(idx).orElse(new Basic());
    }

    public List<Basic> findBasiclist() {
        return basicRepository.findAll();
    }

    public Basic save(Basic basic){
        return basicRepository.save(basic);
    }

    public Basic getOne(Long idx){
        return basicRepository.getOne(idx);
    }

    public void delete(Long idx){
        basicRepository.deleteById(idx);
    }

}
