package myProject.rentACar.business.dtos.responses.customerResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedCustomerResponse {

    private int id;

    private String name;

    private String surName;

    private Integer birthDate;

    private long tcNo;
}
