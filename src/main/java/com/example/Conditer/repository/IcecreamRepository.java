package com.example.Conditer.repository;

import com.example.Conditer.entity.Icecream;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IcecreamRepository extends JpaRepository<Icecream, Long> {
}
