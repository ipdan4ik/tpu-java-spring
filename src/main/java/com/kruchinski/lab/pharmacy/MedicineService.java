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

    public Medicine getMedicine(Long id) {
        return medicineRepository.findById(id).get();
    }

    public List<Medicine> getMedicines() {
        return medicineRepository.findAll();
    }

    public void addMedicine(Medicine medicine) {
        medicineRepository.save(medicine);
    }

    public Medicine putMedicine(Long id, Medicine medicine) {
        Medicine item = medicineRepository.findById(id).get();
        item.setName(medicine.getName());
        item.setComposition(medicine.getComposition());
        item.setActive_substance(medicine.getActive_substance());
        item.setManufacturer(medicine.getManufacturer());
        return medicineRepository.save(item);
    }

    public void deleteMedicine(Long id) {
        medicineRepository.deleteById(id);
    }

}
