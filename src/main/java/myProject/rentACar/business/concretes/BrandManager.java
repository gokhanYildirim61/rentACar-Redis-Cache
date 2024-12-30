package myProject.rentACar.business.concretes;

import lombok.AllArgsConstructor;
import myProject.rentACar.business.abstracts.BrandService;
import myProject.rentACar.business.dtos.requests.brandRequests.CreateBrandRequest;
import myProject.rentACar.business.dtos.requests.brandRequests.UpdateBrandRequest;
import myProject.rentACar.business.dtos.responses.brandResponses.CreatedBrandResponse;
import myProject.rentACar.business.dtos.responses.brandResponses.DeletedBrandResponse;
import myProject.rentACar.business.dtos.responses.brandResponses.GetBrandResponse;
import myProject.rentACar.business.dtos.responses.brandResponses.UpdatedBrandResponse;
import myProject.rentACar.business.rules.BrandBusinessRules;
import myProject.rentACar.core.utilites.ModelMapperService;
import myProject.rentACar.dataAccess.abstracts.BrandRepository;
import myProject.rentACar.entites.Brand;

import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
@CacheConfig(cacheNames = "brands")
public class BrandManager implements BrandService {

     BrandRepository brandRepository;

    BrandBusinessRules brandBusinessRules;

    ModelMapperService modelMapperService;


    @Override
//    @Caching(evict = {@CacheEvict(value = "brand", allEntries = true)})
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        Brand brand= modelMapperService.forRequest().map(createBrandRequest,Brand.class);
        Brand createdBrand=brandRepository.save(brand);
        CreatedBrandResponse createdBrandResponse=modelMapperService.forResponse().map(createdBrand,CreatedBrandResponse.class);
        return createdBrandResponse;
    }

    @Override
    @CachePut(key = "#id")
    public GetBrandResponse update(UpdateBrandRequest updateBrandRequest, int id) {
        Brand brand= this.brandRepository.findById(id).get();
        brandBusinessRules.brandDeletedDateShouldNotExists(brand.getDeletedDate());
        brand.setName(updateBrandRequest.getName());
        brand.setUpdatedDate(LocalDateTime.now());
        Brand updatedBrand=brandRepository.save(brand);
        GetBrandResponse getBrandResponse =modelMapperService.forResponse().map(updatedBrand,GetBrandResponse.class);
        return getBrandResponse;
    }

    @Override
    @Cacheable(key = "#id")
    public GetBrandResponse getById(int id) {
        Brand brand= this.brandRepository.findById(id).get();
        brandBusinessRules.brandDeletedDateShouldNotExists(brand.getDeletedDate());
        GetBrandResponse getBrandResponse =modelMapperService.forResponse().map(brand,GetBrandResponse.class);
        this.methodWithDelay();
        return getBrandResponse;
    }


    @Override
    @CacheEvict(key =  "#id")
    public DeletedBrandResponse softDelete(int id) {
        Brand existedBrand=this.brandRepository.findById(id).get();
        existedBrand.setDeletedDate(LocalDateTime.now());
        brandRepository.save(existedBrand);

        DeletedBrandResponse deletedBrandResponse =modelMapperService.forResponse().map(existedBrand,DeletedBrandResponse.class);
        return deletedBrandResponse;
    }

    public String methodWithDelay() {
        // 5 saniye (5000 milisaniye) bekleme
        try {
            System.out.println("5 saniye bekleniyor...");
            Thread.sleep(5000);  // 5 saniye bekler
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Bekleme sonrası geri dönüş değeri
        return "Dönüş yapıldı.";
    }

}
