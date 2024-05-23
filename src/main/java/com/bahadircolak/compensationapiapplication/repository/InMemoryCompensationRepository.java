package com.bahadircolak.compensationapiapplication.repository;

import com.bahadircolak.compensationapiapplication.model.Compensation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryCompensationRepository implements CompensationRepository {

    private final List<Compensation> compensations = new ArrayList<>();

    public InMemoryCompensationRepository() {
        compensations.add(new Compensation(1L, "Bahadir", "Colak", "Software Engineer", 57000, "34718"));
        compensations.add(new Compensation(2L, "Ege", "Bircan", "Software Engineer", 60000, "34718"));
        compensations.add(new Compensation(2L, "Firat", "Ercan", "Key Account Manager", 50000, "34718"));
    }

    public List<Compensation> findAll() {
        return new ArrayList<>(compensations);
    }

    @Override
    public Optional<Compensation> findById(Long id) {
        return compensations.stream()
                .filter(compensation -> compensation.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Compensation> findBySalaryGreaterThanEqual(double salary) {
        return compensations.stream()
                .filter(compensation -> compensation.getSalary() >= salary)
                .toList();
    }

    @Override
    public List<Compensation> findByZipCode(String zipCode) {
        return compensations.stream()
                .filter(compensation -> compensation.getZipCode().equals(zipCode))
                .toList();
    }

    @Override
    public List<Compensation> findBySalaryGreaterThanEqualAndZipCode(double salary, String zipCode) {
        return compensations.stream()
                .filter(compensation -> compensation.getSalary() >= salary && compensation.getZipCode().equals(zipCode))
                .toList();
    }
}