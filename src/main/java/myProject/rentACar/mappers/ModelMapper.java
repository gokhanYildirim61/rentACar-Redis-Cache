package myProject.rentACar.mappers;

import myProject.rentACar.business.dtos.requests.customerRequsts.CreateCustomerRequest;
import myProject.rentACar.business.dtos.requests.customerRequsts.UpdateCustomerRequest;
import myProject.rentACar.business.dtos.requests.modelRequests.CreateModelRequest;
import myProject.rentACar.business.dtos.requests.modelRequests.UpdateModelRequest;
import myProject.rentACar.business.dtos.responses.customerResponse.CreatedCustomerResponse;
import myProject.rentACar.business.dtos.responses.customerResponse.DeletedCustomerResponse;
import myProject.rentACar.business.dtos.responses.customerResponse.GetCustomerResponse;
import myProject.rentACar.business.dtos.responses.customerResponse.UpdatedCustomerResponse;
import myProject.rentACar.business.dtos.responses.modelResponses.CreatedModelResponse;
import myProject.rentACar.business.dtos.responses.modelResponses.DeletedModelResponse;
import myProject.rentACar.business.dtos.responses.modelResponses.GetModelResponse;
import myProject.rentACar.business.dtos.responses.modelResponses.UpdatedModelResponse;
import myProject.rentACar.entites.Customer;
import myProject.rentACar.entites.Model;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapper {

    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);


    Model modelFromCreateModelRequest(CreateModelRequest createModelRequest);

    Model modelFromUpdateModelRequest(UpdateModelRequest updateCustomerRequest);

    CreatedModelResponse createdModelResponseFromModel(Model model);

    UpdatedModelResponse updatedModelResponseFromModel(Model model);

    GetModelResponse getModelResponseFromModel(Model model);

    DeletedModelResponse deletedModelResponseFromModel(Model model);

}
