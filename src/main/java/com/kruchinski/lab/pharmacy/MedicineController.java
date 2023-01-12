package com.kruchinski.lab.pharmacy;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/medicine")
@SecurityRequirement(name = "basicAuth")
public class MedicineController {

    private final MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping
    public List<Medicine> getAllMedicine() {
        return medicineService.getMedicines();
    }

    @GetMapping("{id}")
    public Medicine getMedicine(@PathVariable Long id) {
        return medicineService.getMedicine(id);
    }

    @PostMapping
    public void postMedicine(@RequestBody Medicine medicine) {
        medicineService.addMedicine(medicine);
    }

    @PutMapping("{id}")
    public Medicine updateMedicine(@PathVariable Long id, @RequestBody Medicine medicine){
        return medicineService.putMedicine(id, medicine);
    }

    @DeleteMapping("{id}")
    public void deleteMedicine(@PathVariable Long id) {
        medicineService.deleteMedicine(id);
    }
}
