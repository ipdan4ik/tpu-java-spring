package com.kruchinski.lab.pharmacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubstanceService {
    private final SubstanceRepository substanceRepository;

    @Autowired
    public SubstanceService(SubstanceRepository substanceRepository) {
        this.substanceRepository = substanceRepository;
    }

    public Substance getSubstance(Long id) {
        return substanceRepository.findById(id).get();
    }

    public List<Substance> getSubstances() {
        return substanceRepository.findAll();
    }

    public void addSubstance(Substance substance) {
        substanceRepository.save(substance);
    }

    public Substance putSubstance(Long id, Substance substance) {
        Substance item = substanceRepository.findById(id).get();
        item.setName(substance.getName());
        item.setDescription(substance.getDescription());
        return substanceRepository.save(item);
    }

    public void deleteSubstance(Long id) {
        substanceRepository.deleteById(id);
    }
}
