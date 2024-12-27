package myProject.rentACar.business.abstracts;

import myProject.rentACar.business.dtos.requests.brandRequests.CreateBrandRequest;
import myProject.rentACar.business.dtos.requests.brandRequests.UpdateBrandRequest;
import myProject.rentACar.business.dtos.responses.brandResponses.CreatedBrandResponse;
import myProject.rentACar.business.dtos.responses.brandResponses.DeletedBrandResponse;
import myProject.rentACar.business.dtos.responses.brandResponses.GetBrandResponse;
import myProject.rentACar.business.dtos.responses.brandResponses.UpdatedBrandResponse;


public interface BrandService {

    CreatedBrandResponse add(CreateBrandRequest createBrandRequest);

    GetBrandResponse update(UpdateBrandRequest updateBrandRequest, int id);

    GetBrandResponse getById(int id);

    DeletedBrandResponse softDelete(int id);

}
