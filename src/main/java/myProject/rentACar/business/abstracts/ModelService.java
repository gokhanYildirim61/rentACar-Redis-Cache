package myProject.rentACar.business.abstracts;

import myProject.rentACar.business.dtos.requests.modelRequests.CreateModelRequest;
import myProject.rentACar.business.dtos.requests.modelRequests.UpdateModelRequest;
import myProject.rentACar.business.dtos.responses.modelResponses.CreatedModelResponse;
import myProject.rentACar.business.dtos.responses.modelResponses.DeletedModelResponse;
import myProject.rentACar.business.dtos.responses.modelResponses.GetModelResponse;
import myProject.rentACar.business.dtos.responses.modelResponses.UpdatedModelResponse;

public interface ModelService {

    CreatedModelResponse add(CreateModelRequest createModelRequest);

    UpdatedModelResponse update(UpdateModelRequest updateModelRequest, int id);

    GetModelResponse getById(int id);

    DeletedModelResponse softDelete(int id);
}
