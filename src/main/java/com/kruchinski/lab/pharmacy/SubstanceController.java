package com.kruchinski.lab.pharmacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/substance")
public class SubstanceController {
    private final SubstanceService substanceService;

    @Autowired
    public SubstanceController(SubstanceService substanceService) {
        this.substanceService = substanceService;
    }

    @GetMapping
    public List<Substance> getSubstance() {
        return substanceService.getSubstance();
    }

    @PostMapping
    public void postSubstance(@RequestBody Substance substance) {
        substanceService.addSubstance(substance);
    }
}
