package myProject.rentACar.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import myProject.rentACar.business.abstracts.CustomerService;
import myProject.rentACar.business.dtos.requests.carRequests.CreateCarRequest;
import myProject.rentACar.business.dtos.requests.customerRequsts.CreateCustomerRequest;
import myProject.rentACar.business.dtos.responses.carResponses.CreatedCarResponse;
import myProject.rentACar.business.dtos.responses.customerResponse.CreatedCustomerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {

    CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedCustomerResponse add(@Valid @RequestBody CreateCustomerRequest createCustomerRequest) throws Exception {
        return customerService.add(createCustomerRequest);
    }
}
