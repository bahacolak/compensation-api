package com.bahadircolak.compensationapiapplication.controller;

import com.bahadircolak.compensationapiapplication.model.Compensation;
import com.bahadircolak.compensationapiapplication.service.CompensationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/compensations")
public class CompensationController {

    private final CompensationService compensationService;

    public CompensationController(CompensationService compensationService) {
        this.compensationService = compensationService;
    }

    @GetMapping
    public List<Compensation> getAllCompensations() {
        return compensationService.getAllCompensations();
    }

    @GetMapping("/{id}")
    public Compensation getCompensationById(@PathVariable Long id) {
        return compensationService.getCompensationById(id);
    }

    @GetMapping("/filter")
    public List<Compensation> getFilteredCompensations(
            @RequestParam Optional<Double> salaryGte,
            @RequestParam Optional<String> zipCode) {
        return compensationService.getFilteredCompensations(salaryGte, zipCode);
    }
}
