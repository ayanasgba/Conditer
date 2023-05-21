package com.example.Conditer.service.impl;

import com.example.Conditer.entity.Pies;
import com.example.Conditer.repository.PiesRepository;
import com.example.Conditer.service.PiesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PiesServiceImpl implements PiesService {
    private PiesRepository piesRepository;

    public PiesServiceImpl(PiesRepository piesRepository) {
        super();
        this.piesRepository = piesRepository;
    }

    @Override
    public List<Pies> getAllPies() {
        return piesRepository.findAll();
    }

    @Override
    public Pies savePies(Pies pies) {
        return piesRepository.save(pies);
    }

    @Override
    public Pies getPiesById(Long id) {
        return piesRepository.findById(id).get();
    }

    @Override
    public Pies updatePies(Pies pies) {
        return piesRepository.save(pies);
    }

    @Override
    public void deletePiesById(Long id) {
        piesRepository.deleteById(id);
    }
}
