package myProject.rentACar.business.concretes;

import lombok.AllArgsConstructor;
import myProject.rentACar.business.abstracts.CarService;
import myProject.rentACar.business.dtos.requests.carRequests.CreateCarRequest;
import myProject.rentACar.business.dtos.requests.carRequests.UpdateCarRequest;
import myProject.rentACar.business.dtos.responses.carResponses.CreatedCarResponse;
import myProject.rentACar.business.dtos.responses.carResponses.DeletedCarResponse;
import myProject.rentACar.business.dtos.responses.carResponses.GetCarResponse;
import myProject.rentACar.business.dtos.responses.carResponses.UpdatedCarResponse;
import myProject.rentACar.core.utilites.ModelMapperService;
import myProject.rentACar.dataAccess.abstracts.BrandRepository;
import myProject.rentACar.dataAccess.abstracts.CarRepository;
import myProject.rentACar.entites.Brand;
import myProject.rentACar.entites.Car;
import myProject.rentACar.mappers.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@CacheConfig(cacheNames = "cars")
public class CarManager implements CarService {
    private CarRepository carRepository;

    private ModelMapperService modelMapperService;


    @Override
    public CreatedCarResponse add(CreateCarRequest createCarRequest) {

        Car car=modelMapperService.forRequest().map(createCarRequest,Car.class);
       Car createdCar= carRepository.save(car);
        CreatedCarResponse createdCarResponse= modelMapperService.forResponse().map(createdCar,CreatedCarResponse.class);
        return createdCarResponse;

    }

    @Override
    public UpdatedCarResponse update(UpdateCarRequest updateBrandRequest, int id) {
        Car car=modelMapperService.forRequest().map(updateBrandRequest,Car.class);
        Car updatedCar=carRepository.save(car);
        UpdatedCarResponse updatedCarResponse=modelMapperService.forResponse().map(updatedCar,UpdatedCarResponse.class);
        return updatedCarResponse;
    }

    @Override
    public GetCarResponse getById(int id) {
        Car car=carRepository.findById(id).get();
        GetCarResponse getCarResponse=modelMapperService.forResponse().map(car,GetCarResponse.class);
        return getCarResponse;
    }

    @Override
    public DeletedCarResponse softDelete(int id) {
        Car car=carRepository.findById(id).get();
        car.setDeletedDate(LocalDateTime.now());
        carRepository.save(car);
        DeletedCarResponse deletedCarResponse=modelMapperService.forResponse().map(car,DeletedCarResponse.class);
        return deletedCarResponse;
    }
}
