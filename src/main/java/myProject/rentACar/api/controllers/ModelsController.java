package myProject.rentACar.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import myProject.rentACar.business.abstracts.ModelService;
import myProject.rentACar.business.dtos.requests.modelRequests.CreateModelRequest;
import myProject.rentACar.business.dtos.requests.modelRequests.UpdateModelRequest;
import myProject.rentACar.business.dtos.responses.modelResponses.CreatedModelResponse;
import myProject.rentACar.business.dtos.responses.modelResponses.DeletedModelResponse;
import myProject.rentACar.business.dtos.responses.modelResponses.GetModelResponse;
import myProject.rentACar.business.dtos.responses.modelResponses.UpdatedModelResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/models")
public class ModelsController {

    ModelService modelService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add")
    public CreatedModelResponse add(@Valid @RequestBody CreateModelRequest createModelRequest){
        return modelService.add(createModelRequest);
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update")
    public UpdatedModelResponse update(@RequestBody UpdateModelRequest updateModelRequest, @PathVariable int id){
        return modelService.update(updateModelRequest,id);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get By Id")
    public GetModelResponse getById(@PathVariable int id){
        return modelService.getById(id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete")
    public DeletedModelResponse delete(@PathVariable int id){
        return modelService.softDelete(id);
    }
}
