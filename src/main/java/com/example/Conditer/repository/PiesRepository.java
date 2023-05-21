package com.example.Conditer.repository;

import com.example.Conditer.entity.Pies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiesRepository extends JpaRepository<Pies, Long> {
}
