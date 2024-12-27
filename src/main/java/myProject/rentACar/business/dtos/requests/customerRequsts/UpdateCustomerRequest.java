package myProject.rentACar.business.dtos.requests.customerRequsts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCustomerRequest {

    private String name;

    private String surName;

    private Integer birthDate;

    private long tcNo;


}
