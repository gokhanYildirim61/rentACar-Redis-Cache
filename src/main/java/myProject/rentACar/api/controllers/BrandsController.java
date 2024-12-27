package myProject.rentACar.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import myProject.rentACar.business.abstracts.BrandService;
import myProject.rentACar.business.dtos.requests.brandRequests.CreateBrandRequest;
import myProject.rentACar.business.dtos.requests.brandRequests.UpdateBrandRequest;
import myProject.rentACar.business.dtos.responses.brandResponses.CreatedBrandResponse;
import myProject.rentACar.business.dtos.responses.brandResponses.DeletedBrandResponse;
import myProject.rentACar.business.dtos.responses.brandResponses.GetBrandResponse;
import myProject.rentACar.business.dtos.responses.brandResponses.UpdatedBrandResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@AllArgsConstructor
@RequestMapping("api/v1/brands")
public class BrandsController {
    BrandService brandService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedBrandResponse add(@Valid @RequestBody CreateBrandRequest createBrandRequest){
        return brandService.add(createBrandRequest);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public GetBrandResponse update(@RequestBody UpdateBrandRequest updateBrandRequest,@PathVariable int id){
        return brandService.update(updateBrandRequest,id);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get By Id")
    public GetBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete")
    public DeletedBrandResponse delete(@PathVariable int id){
        return brandService.softDelete(id);
    }



}
