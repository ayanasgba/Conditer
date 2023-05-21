package com.example.Conditer.service;

import com.example.Conditer.entity.Cakes;

import java.util.List;

public interface CakesService {

    List<Cakes> getAllCakes();

    Cakes saveCakes(Cakes cakes);

    Cakes getCakesById(Long id);

    Cakes updateCakes(Cakes cakes);

    void deleteCakesById(Long id);
}
