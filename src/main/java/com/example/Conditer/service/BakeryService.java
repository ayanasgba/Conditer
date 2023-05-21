package com.example.Conditer.service;

import com.example.Conditer.entity.Bakery;

import java.util.List;

public interface BakeryService {
    List<Bakery> getAllBakery();

    Bakery saveBakery(Bakery bakery);

    Bakery getBakeryById(Long id);

    Bakery updateBakery(Bakery bakery);

    void deleteBakeryById(Long id);
}
