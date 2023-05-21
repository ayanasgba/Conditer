package com.example.Conditer.service;

import com.example.Conditer.entity.Pies;

import java.util.List;

public interface PiesService {
    List<Pies> getAllPies();

    Pies savePies(Pies pies);

    Pies getPiesById(Long id);

    Pies updatePies(Pies pies);

    void deletePiesById(Long id);
}
