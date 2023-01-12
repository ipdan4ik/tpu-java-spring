package com.kruchinski.lab.pharmacy;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/country")
@SecurityRequirement(name = "basicAuth")
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping
    public List<Country> getAllCountries(){
        return countryService.getCountries();
    }

    @GetMapping("{id}")
    public Country getCountry(@PathVariable Long id) {
        return countryService.getCountry(id);
    }

    @PostMapping
    public void postCountry(@RequestBody Country country) {
        countryService.addCountry(country);
    }

    @PutMapping("{id}")
    public Country updateCountry(@PathVariable Long id, @RequestBody Country country){
        return countryService.putCountry(id, country);
    }

    @DeleteMapping("{id}")
    public void deleteCountry(@PathVariable Long id) {
        countryService.deleteCountry(id);
    }

}