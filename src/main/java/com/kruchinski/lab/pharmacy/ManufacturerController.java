package com.kruchinski.lab.pharmacy;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/manufacturer")
@SecurityRequirement(name = "basicAuth")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public List<Manufacturer> getManufacturer() {
        return manufacturerService.getManufacturer();
    }

    @PostMapping
    public void postManufacturer(@RequestBody Manufacturer manufacturer) {
        manufacturerService.addManufacturer(manufacturer);
    }
}
