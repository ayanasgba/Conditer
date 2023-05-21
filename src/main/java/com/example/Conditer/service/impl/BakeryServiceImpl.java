package com.example.Conditer.service.impl;

import com.example.Conditer.entity.Bakery;
import com.example.Conditer.repository.BakeryRepository;
import com.example.Conditer.service.BakeryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BakeryServiceImpl implements BakeryService {

    private BakeryRepository bakeryRepository;

    public BakeryServiceImpl(BakeryRepository bakeryRepository){
        super();
        this.bakeryRepository = bakeryRepository;
    }

    @Override
    public List<Bakery> getAllBakery(){
        return bakeryRepository.findAll();
    }

    @Override
    public Bakery saveBakery(Bakery bakery){
        return bakeryRepository.save(bakery);
    }

    @Override
    public Bakery getBakeryById(Long id){
        return bakeryRepository.findById(id).get();
    }

    @Override
    public Bakery updateBakery(Bakery bakery){
        return bakeryRepository.save(bakery);
    }

    @Override
    public void deleteBakeryById(Long id){
        bakeryRepository.deleteById(id);
    }
}
