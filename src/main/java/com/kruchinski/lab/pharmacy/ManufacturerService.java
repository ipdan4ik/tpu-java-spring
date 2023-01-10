package com.kruchinski.lab.pharmacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public List<Manufacturer> getManufacturer() {
        return manufacturerRepository.findAll();
    }

    public void addManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
        }
}
