package com.example.controller;

import com.example.entity.Prescription;
import com.example.service.PrescriptionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;

    @GetMapping("/accounts/{id}/prescriptions")
    @PreAuthorize("hasAuthority('admin.roles.ro')")
    public Prescription getById(@PathVariable Long id) {
        return prescriptionService.getByIdPrescription(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin.roles.rw')")
    public Prescription create(Prescription prescription) {
        return prescriptionService.create(prescription);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('admin.remove_user.rw')")
    public void deleteById(@PathVariable Long id) {
        prescriptionService.delete(id);
    }
}
