package com.example.Conditer.service.impl;

import com.example.Conditer.entity.Cakes;
import com.example.Conditer.repository.CakesRepository;
import com.example.Conditer.service.CakesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CakesServiceImpl implements CakesService {

    private CakesRepository cakesRepository;

    public CakesServiceImpl(CakesRepository cakesRepository){
        super();
        this.cakesRepository = cakesRepository;
    }

    @Override
    public List<Cakes> getAllCakes(){
        return cakesRepository.findAll();
    }

    @Override
    public Cakes saveCakes(Cakes cakes){
        return cakesRepository.save(cakes);
    }

    @Override
    public Cakes getCakesById(Long id){
        return cakesRepository.findById(id).get();
    }

    @Override
    public Cakes updateCakes(Cakes cakes){
        return cakesRepository.save(cakes);
    }

    @Override
    public void deleteCakesById(Long id){
        cakesRepository.deleteById(id);
    }
}
