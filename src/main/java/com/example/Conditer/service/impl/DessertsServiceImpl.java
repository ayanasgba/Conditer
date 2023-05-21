package com.example.Conditer.service.impl;

import com.example.Conditer.entity.Desserts;
import com.example.Conditer.repository.DessertsRepository;
import com.example.Conditer.service.DessertsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DessertsServiceImpl implements DessertsService {

    private DessertsRepository dessertsRepository;

    public DessertsServiceImpl(DessertsRepository dessertsRepository) {
        super();
        this.dessertsRepository = dessertsRepository;
    }

    @Override
    public List<Desserts> getAllDesserts() {
        return dessertsRepository.findAll();
    }

    @Override
    public Desserts saveDesserts(Desserts desserts) {
        return dessertsRepository.save(desserts);
    }

    @Override
    public Desserts getDessertsById(Long id) {
        return dessertsRepository.findById(id).get();
    }

    @Override
    public Desserts updateDesserts(Desserts desserts) {
        return dessertsRepository.save(desserts);
    }

    @Override
    public void deleteDessertsById(Long id) {
        dessertsRepository.deleteById(id);
    }
}

