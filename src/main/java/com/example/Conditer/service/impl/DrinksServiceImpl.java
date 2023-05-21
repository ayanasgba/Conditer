package com.example.Conditer.service.impl;

import com.example.Conditer.entity.Drinks;
import com.example.Conditer.repository.DrinksRepository;
import com.example.Conditer.service.DrinksService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinksServiceImpl implements DrinksService {

    private DrinksRepository drinksRepository;

    public DrinksServiceImpl(DrinksRepository drinksRepository) {
        super();
        this.drinksRepository = drinksRepository;
    }

    @Override
    public List<Drinks> getAllDrinks() {
        return drinksRepository.findAll();
    }

    @Override
    public Drinks saveDrinks(Drinks drinks) {
        return drinksRepository.save(drinks);
    }

    @Override
    public Drinks getDrinksById(Long id) {
        return drinksRepository.findById(id).get();
    }

    @Override
    public Drinks updateDrinks(Drinks drinks) {
        return drinksRepository.save(drinks);
    }

    @Override
    public void deleteDrinksById(Long id) {
        drinksRepository.deleteById(id);
    }
}
