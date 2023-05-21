package com.example.Conditer.repository;

import com.example.Conditer.entity.Desserts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DessertsRepository extends JpaRepository<Desserts, Long> {
}
