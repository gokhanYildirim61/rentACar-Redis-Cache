package myProject.rentACar.business.dtos.requests.customerRequsts;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerRequest {


    private String name;

    private String surName;

    private Integer birthDate;

    private long tcNo;

}
