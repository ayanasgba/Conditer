package com.example.Conditer.service;

import com.example.Conditer.entity.Icecream;

import java.util.List;

public interface IcecreamService {
    List<Icecream> getAllIcecream();

    Icecream saveIcecream(Icecream icecream);

    Icecream getIcecreamById(Long id);

    Icecream updateIcecream(Icecream icecream);

    void deleteIcecreamById(Long id);
}
