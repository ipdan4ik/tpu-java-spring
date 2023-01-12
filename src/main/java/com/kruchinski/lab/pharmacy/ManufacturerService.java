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

    public Manufacturer getManufacturer(Long id) {
        return manufacturerRepository.findById(id).get();
    }

    public List<Manufacturer> getManufacturers() {
        return manufacturerRepository.findAll();
    }

    public void addManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
        }

    public Manufacturer putManufacturer(Long id, Manufacturer manufacturer) {
        Manufacturer item = manufacturerRepository.findById(id).get();
        item.setName(manufacturer.getName());
        item.setCountry(manufacturer.getCountry());
        return manufacturerRepository.save(item);
    }

    public void deleteManufacturer(Long id) {
        manufacturerRepository.deleteById(id);
    }
}
