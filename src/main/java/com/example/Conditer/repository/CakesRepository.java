package com.example.Conditer.repository;

import com.example.Conditer.entity.Cakes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakesRepository extends JpaRepository<Cakes, Long> {
}
