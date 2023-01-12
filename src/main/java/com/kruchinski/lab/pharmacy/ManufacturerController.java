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
    public List<Manufacturer> getAllManufacturers() {
        return manufacturerService.getManufacturers();
    }

    @GetMapping("{id}")
    public Manufacturer getManufacturer(@PathVariable Long id) {
        return manufacturerService.getManufacturer(id);
    }

    @PostMapping
    public void postManufacturer(@RequestBody Manufacturer manufacturer) {
        manufacturerService.addManufacturer(manufacturer);
    }

    @PutMapping("{id}")
    public Manufacturer updateManufacturer(@PathVariable Long id, @RequestBody Manufacturer manufacturer){
        return manufacturerService.putManufacturer(id, manufacturer);
    }

    @DeleteMapping("{id}")
    public void deleteManufacturer(@PathVariable Long id) {
        manufacturerService.deleteManufacturer(id);
    }
}
