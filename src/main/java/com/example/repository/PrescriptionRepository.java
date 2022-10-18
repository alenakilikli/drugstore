package com.example.repository;

import com.example.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

    Optional<Prescription> findById(Long id);
}
