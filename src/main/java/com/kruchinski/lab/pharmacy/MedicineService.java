package com.kruchinski.lab.pharmacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {

    private final MedicineRepository medicineRepository;

    @Autowired
    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public List<Medicine> getMedicine() {
        return medicineRepository.findAll();
    }

    public void addMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
    }

}
