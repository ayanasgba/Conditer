package com.example.Conditer.service;

import com.example.Conditer.entity.Drinks;

import java.util.List;

public interface DrinksService {

    List<Drinks> getAllDrinks();

    Drinks saveDrinks(Drinks drinks);

    Drinks getDrinksById(Long id);

    Drinks updateDrinks(Drinks drinks);

    void deleteDrinksById(Long id);
}
