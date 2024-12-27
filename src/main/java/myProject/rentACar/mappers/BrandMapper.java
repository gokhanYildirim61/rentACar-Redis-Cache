package myProject.rentACar.mappers;

import myProject.rentACar.business.dtos.requests.brandRequests.CreateBrandRequest;
import myProject.rentACar.business.dtos.requests.brandRequests.UpdateBrandRequest;
import myProject.rentACar.business.dtos.responses.brandResponses.CreatedBrandResponse;
import myProject.rentACar.business.dtos.responses.brandResponses.DeletedBrandResponse;
import myProject.rentACar.business.dtos.responses.brandResponses.GetBrandResponse;
import myProject.rentACar.business.dtos.responses.brandResponses.UpdatedBrandResponse;
import myProject.rentACar.business.dtos.responses.customerResponse.DeletedCustomerResponse;
import myProject.rentACar.business.dtos.responses.customerResponse.GetCustomerResponse;
import myProject.rentACar.business.dtos.responses.customerResponse.UpdatedCustomerResponse;
import myProject.rentACar.entites.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapper {

    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);


    Brand brandFromCreateBrandRequest(CreateBrandRequest createBrandRequest);

    Brand brandFromUpdateBrandRequest(UpdateBrandRequest updateBrandRequest);

    CreatedBrandResponse createdBrandResponseFromBrand(Brand brand);

    UpdatedBrandResponse updatedBrandResponseFromBrand(Brand brand);

    GetBrandResponse getBrandResponseFromBrand(Brand brand);

    DeletedBrandResponse deletedBrandResponseFromBrand(Brand brand);


}
