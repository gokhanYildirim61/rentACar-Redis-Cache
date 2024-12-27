package myProject.rentACar.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import myProject.rentACar.business.abstracts.BrandService;
import myProject.rentACar.business.abstracts.CarService;
import myProject.rentACar.business.dtos.requests.brandRequests.CreateBrandRequest;
import myProject.rentACar.business.dtos.requests.brandRequests.UpdateBrandRequest;
import myProject.rentACar.business.dtos.requests.carRequests.CreateCarRequest;
import myProject.rentACar.business.dtos.requests.carRequests.UpdateCarRequest;
import myProject.rentACar.business.dtos.responses.brandResponses.CreatedBrandResponse;
import myProject.rentACar.business.dtos.responses.brandResponses.DeletedBrandResponse;
import myProject.rentACar.business.dtos.responses.brandResponses.GetBrandResponse;
import myProject.rentACar.business.dtos.responses.brandResponses.UpdatedBrandResponse;
import myProject.rentACar.business.dtos.responses.carResponses.CreatedCarResponse;
import myProject.rentACar.business.dtos.responses.carResponses.DeletedCarResponse;
import myProject.rentACar.business.dtos.responses.carResponses.GetCarResponse;
import myProject.rentACar.business.dtos.responses.carResponses.UpdatedCarResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/cars")
public class CarsController {

    CarService carService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedCarResponse add(@Valid @RequestBody CreateCarRequest createCarRequest){
        return carService.add(createCarRequest);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public UpdatedCarResponse update(@RequestBody UpdateCarRequest updateCarRequest, @PathVariable int id){
        return carService.update(updateCarRequest,id);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get By Id")
    public GetCarResponse getById(@PathVariable int id){
        return carService.getById(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete")
    public DeletedCarResponse delete(@PathVariable int id){
        return carService.softDelete(id);
    }
}
