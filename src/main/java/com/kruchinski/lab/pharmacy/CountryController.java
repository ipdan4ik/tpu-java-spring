package com.kruchinski.lab.pharmacy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/country")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping
    public List<Country> getCountry() {
        return countryService.getCountry();
    }

    @PostMapping
    public void postCountry(@RequestBody Country country) {
        countryService.addCountry(country);
    }
}