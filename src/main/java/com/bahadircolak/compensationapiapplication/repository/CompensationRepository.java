package com.bahadircolak.compensationapiapplication.repository;

import com.bahadircolak.compensationapiapplication.model.Compensation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompensationRepository {
    Optional<Compensation> findById(Long id);

    List<Compensation> findBySalaryGreaterThanEqual(double salary);
    List<Compensation> findByZipCode(String zipCode);
    List<Compensation> findBySalaryGreaterThanEqualAndZipCode(double salary, String zipCode);
}
