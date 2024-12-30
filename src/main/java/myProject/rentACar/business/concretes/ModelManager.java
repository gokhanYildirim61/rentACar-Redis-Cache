package myProject.rentACar.business.concretes;

import lombok.AllArgsConstructor;
import myProject.rentACar.business.abstracts.ModelService;
import myProject.rentACar.business.dtos.requests.modelRequests.CreateModelRequest;
import myProject.rentACar.business.dtos.requests.modelRequests.UpdateModelRequest;
import myProject.rentACar.business.dtos.responses.modelResponses.CreatedModelResponse;
import myProject.rentACar.business.dtos.responses.modelResponses.DeletedModelResponse;
import myProject.rentACar.business.dtos.responses.modelResponses.GetModelResponse;
import myProject.rentACar.business.dtos.responses.modelResponses.UpdatedModelResponse;
import myProject.rentACar.core.utilites.ModelMapperService;
import myProject.rentACar.dataAccess.abstracts.ModelRepository;
import myProject.rentACar.entites.Model;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@CacheConfig(cacheNames = "models")
public class ModelManager implements ModelService {

    private  ModelRepository modelRepository;

    private ModelMapperService modelMapperService;



    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {
        Model model=modelMapperService.forRequest().map(createModelRequest,Model.class);
        Model exitedModel = modelRepository.save(model);
        CreatedModelResponse createdModelResponse =modelMapperService.forResponse().map(exitedModel,CreatedModelResponse.class);
        return createdModelResponse;
    }

    @Override
    public UpdatedModelResponse update(UpdateModelRequest updateModelRequest, int id) {
        Model model=modelRepository.findById(id).get();
        model.setName(updateModelRequest.getName());
        model.setUpdatedDate(LocalDateTime.now());
        modelRepository.save(model);
        UpdatedModelResponse updatedModelResponse=modelMapperService.forResponse().map(model,UpdatedModelResponse.class);
        return updatedModelResponse;
    }

    @Override
    public GetModelResponse getById(int id) {
        Model model=modelRepository.findById(id).get();
        GetModelResponse getModelResponse=modelMapperService.forResponse().map(model,GetModelResponse.class);
        return getModelResponse;
    }

    @Override
    public DeletedModelResponse softDelete(int id) {
        Model model=modelRepository.findById(id).get();
        model.setDeletedDate(LocalDateTime.now());
        modelRepository.save(model);
        DeletedModelResponse deletedModelResponse=modelMapperService.forResponse().map(model,DeletedModelResponse.class);
        return deletedModelResponse;
    }
}
