package myProject.rentACar.business.abstracts;

import myProject.rentACar.business.dtos.requests.carRequests.CreateCarRequest;
import myProject.rentACar.business.dtos.requests.carRequests.UpdateCarRequest;
import myProject.rentACar.business.dtos.responses.carResponses.CreatedCarResponse;
import myProject.rentACar.business.dtos.responses.carResponses.DeletedCarResponse;
import myProject.rentACar.business.dtos.responses.carResponses.GetCarResponse;
import myProject.rentACar.business.dtos.responses.carResponses.UpdatedCarResponse;

public interface CarService {


    CreatedCarResponse add(CreateCarRequest createCarRequest);

   UpdatedCarResponse update(UpdateCarRequest updateBrandRequest, int id);

    GetCarResponse getById(int id);

    DeletedCarResponse softDelete(int id);
}
