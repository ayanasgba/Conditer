package com.example.Conditer.service;

import com.example.Conditer.entity.Desserts;

import java.util.List;

public interface DessertsService {

    List<Desserts> getAllDesserts();

    Desserts saveDesserts(Desserts desserts);

    Desserts getDessertsById(Long id);

    Desserts updateDesserts(Desserts desserts);

    void deleteDessertsById(Long id);
}
