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

    public List<Substance> getSubstance() {
        return substanceRepository.findAll();
    }

    public void addSubstance(Substance substance) {
        substanceRepository.save(substance);
    }
}
