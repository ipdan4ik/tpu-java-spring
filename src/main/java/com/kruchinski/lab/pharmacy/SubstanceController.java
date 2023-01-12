package com.kruchinski.lab.pharmacy;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/substance")
@SecurityRequirement(name = "basicAuth")
public class SubstanceController {
    private final SubstanceService substanceService;

    @Autowired
    public SubstanceController(SubstanceService substanceService) {
        this.substanceService = substanceService;
    }

    @GetMapping
    public List<Substance> getAllSubstances() {
        return substanceService.getSubstances();
    }

    @GetMapping("{id}")
    public Substance getSubstance(@PathVariable Long id) {
        return substanceService.getSubstance(id);
    }

    @PostMapping
    public void postSubstance(@RequestBody Substance substance) {
        substanceService.addSubstance(substance);
    }

    @PutMapping("{id}")
    public Substance updateSubstance(@PathVariable Long id, @RequestBody Substance substance){
        return substanceService.putSubstance(id, substance);
    }

    @DeleteMapping("{id}")
    public void deleteSubstance(@PathVariable Long id) {
        substanceService.deleteSubstance(id);
    }
}
