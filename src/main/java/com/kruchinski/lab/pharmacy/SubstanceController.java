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
    public List<Substance> getSubstance() {
        return substanceService.getSubstance();
    }

    @PostMapping
    public void postSubstance(@RequestBody Substance substance) {
        substanceService.addSubstance(substance);
    }
}
