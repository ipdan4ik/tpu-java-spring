package com.kruchinski.lab.pharmacy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country getCountry(Long id) {
        return countryRepository.findById(id).get();
    }

    public void addCountry(Country country) {
        countryRepository.save(country);
    }

    public List<Country> getCountries() {return countryRepository.findAll();}

    public Country putCountry(Long id, Country country) {
        Country cnt = countryRepository.findById(id).get();
        cnt.setName(country.getName());
        return countryRepository.save(cnt);
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
