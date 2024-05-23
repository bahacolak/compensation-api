package com.bahadircolak.compensationapiapplication.service;

import com.bahadircolak.compensationapiapplication.model.Compensation;
import com.bahadircolak.compensationapiapplication.repository.InMemoryCompensationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompensationService {

    private final InMemoryCompensationRepository repository;

    public CompensationService(InMemoryCompensationRepository repository) {
        this.repository = repository;
    }

    public List<Compensation> getAllCompensations() {
        return repository.findAll();
    }

    public Compensation getCompensationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Compensation> getFilteredCompensations(Optional<Double> salaryGte, Optional<String> zipCode) {
        if (salaryGte.isEmpty() && zipCode.isEmpty()) {
            return repository.findAll();
        }

        if (salaryGte.isPresent() && zipCode.isPresent()) {
            return repository.findBySalaryGreaterThanEqualAndZipCode(salaryGte.get(), zipCode.get());
        }

        if (salaryGte.isPresent()) {
            return repository.findBySalaryGreaterThanEqual(salaryGte.get());
        }

        return repository.findByZipCode(zipCode.get());
    }
}
