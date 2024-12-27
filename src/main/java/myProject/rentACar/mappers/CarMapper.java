package myProject.rentACar.mappers;


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
import myProject.rentACar.entites.Brand;
import myProject.rentACar.entites.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);


    Car carFromCreateCarRequest(CreateCarRequest createCarRequest);

    Car carFromUpdateCarRequest(UpdateCarRequest updateCarRequest);

    CreatedCarResponse createdCarResponseFromCar(Car car);

    UpdatedCarResponse updatedCarResponseFromCar(Car car);

    GetCarResponse getCarResponseFromCar(Car car);

    DeletedCarResponse deletedCarResponseFromCar(Car car);

}
