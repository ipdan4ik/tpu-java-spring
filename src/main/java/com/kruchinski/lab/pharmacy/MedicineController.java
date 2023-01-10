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
    public List<Medicine> getMedicine() {
        return medicineService.getMedicine();
    }

    @PostMapping
    public void postMedicine(@RequestBody Medicine medicine) {
        medicineService.addMedicine(medicine);
    }
}
