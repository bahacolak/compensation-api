package com.bahadircolak.compensationapiapplication.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompensationDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private Double salary;
    private String zipCode;
}
