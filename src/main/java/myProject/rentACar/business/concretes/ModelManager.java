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
import myProject.rentACar.mappers.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private  ModelRepository modelRepository;



    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {
        Model model=ModelMapper.INSTANCE.modelFromCreateModelRequest(createModelRequest);
        Model exitedModel = modelRepository.save(model);
        CreatedModelResponse createdModelResponse =ModelMapper.INSTANCE.createdModelResponseFromModel(exitedModel);
        return createdModelResponse;
    }

    @Override
    public UpdatedModelResponse update(UpdateModelRequest updateModelRequest, int id) {
        Model model=modelRepository.findById(id).get();
        model.setName(updateModelRequest.getName());
        model.setUpdatedDate(LocalDateTime.now());
        modelRepository.save(model);
        UpdatedModelResponse updatedModelResponse=ModelMapper.INSTANCE.updatedModelResponseFromModel(model);
        return updatedModelResponse;
    }

    @Override
    public GetModelResponse getById(int id) {
        Model model=modelRepository.findById(id).get();
        GetModelResponse getModelResponse=ModelMapper.INSTANCE.getModelResponseFromModel(model);
        return getModelResponse;
    }

    @Override
    public DeletedModelResponse softDelete(int id) {
        Model model=modelRepository.findById(id).get();
        model.setDeletedDate(LocalDateTime.now());
        modelRepository.save(model);
        DeletedModelResponse deletedModelResponse=ModelMapper.INSTANCE.deletedModelResponseFromModel(model);
        return deletedModelResponse;
    }
}
