package com.example.service.impl;

import com.example.entity.Prescription;
import com.example.repository.PrescriptionRepository;
import com.example.repository.RoleRepository;
import com.example.service.PrescriptionService;

public class PrescriptionServiceImpl implements PrescriptionService {
    private final PrescriptionRepository prescriptionRepository;
    private RoleRepository roleRepository;

    public PrescriptionServiceImpl(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    @Override
    public Prescription getByIdPrescription(Long id) {
        return prescriptionRepository.findById(id);
    }

    @Override
    public Prescription create(Prescription prescription) {

        Prescription prescript = new Prescription(
                prescription.getId(),
                prescription.getDrugName(),
                prescription.getPrescribedBy(),
                prescription.getPrescribedTo()

        );
        return prescriptionRepository.save(prescript);
    }

    @Override
    public void delete(Long id) {
        prescriptionRepository.deleteById(id);
    }
}
