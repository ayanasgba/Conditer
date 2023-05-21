package com.example.Conditer.service.impl;

import com.example.Conditer.entity.Icecream;
import com.example.Conditer.repository.IcecreamRepository;
import com.example.Conditer.service.IcecreamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IcecreamServiceImpl implements IcecreamService {

    private IcecreamRepository icecreamRepository;

    public IcecreamServiceImpl(IcecreamRepository icecreamRepository) {
        super();
        this.icecreamRepository = icecreamRepository;
    }

    @Override
    public List<Icecream> getAllIcecream() {
        return icecreamRepository.findAll();
    }

    @Override
    public Icecream saveIcecream(Icecream icecream) {
        return icecreamRepository.save(icecream);
    }

    @Override
    public Icecream getIcecreamById(Long id) {
        return icecreamRepository.findById(id).get();
    }

    @Override
    public Icecream updateIcecream(Icecream icecream) {
        return icecreamRepository.save(icecream);
    }

    @Override
    public void deleteIcecreamById(Long id) {
        icecreamRepository.deleteById(id);
    }
}
