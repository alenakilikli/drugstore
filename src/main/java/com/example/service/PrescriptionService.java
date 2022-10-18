package com.example.service;

import com.example.entity.Prescription;
import org.springframework.stereotype.Service;

@Service
public interface PrescriptionService {
    Prescription getByIdPrescription(Long id);

    Prescription create(Prescription prescription);

    void delete(Long id);
}
