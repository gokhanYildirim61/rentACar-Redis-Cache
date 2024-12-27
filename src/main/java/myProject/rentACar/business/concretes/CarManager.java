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
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CarManager implements CarService {
    private CarRepository carRepository;


    @Override
    public CreatedCarResponse add(CreateCarRequest createCarRequest) {

        Car car=CarMapper.INSTANCE.carFromCreateCarRequest(createCarRequest);
       Car createdCar= carRepository.save(car);
        CreatedCarResponse createdCarResponse= CarMapper.INSTANCE.createdCarResponseFromCar(createdCar);
        return createdCarResponse;

    }

    @Override
    public UpdatedCarResponse update(UpdateCarRequest updateBrandRequest, int id) {
        Car car=CarMapper.INSTANCE.carFromUpdateCarRequest(updateBrandRequest);
        Car updatedCar=carRepository.save(car);
        UpdatedCarResponse updatedCarResponse=CarMapper.INSTANCE.updatedCarResponseFromCar(updatedCar);
        return updatedCarResponse;
    }

    @Override
    public GetCarResponse getById(int id) {
        Car car=carRepository.findById(id).get();
        GetCarResponse getCarResponse=CarMapper.INSTANCE.getCarResponseFromCar(car);
        return getCarResponse;
    }

    @Override
    public DeletedCarResponse softDelete(int id) {
        Car car=carRepository.findById(id).get();
        car.setDeletedDate(LocalDateTime.now());
        carRepository.save(car);
        DeletedCarResponse deletedCarResponse=CarMapper.INSTANCE.deletedCarResponseFromCar(car);
        return deletedCarResponse;
    }
}
