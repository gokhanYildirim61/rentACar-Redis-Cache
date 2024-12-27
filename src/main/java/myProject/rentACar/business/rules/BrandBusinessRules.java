package myProject.rentACar.business.rules;

import lombok.AllArgsConstructor;
import myProject.rentACar.dataAccess.abstracts.BrandRepository;
import myProject.rentACar.entites.Brand;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    private BrandRepository brandRepository;

    public  void brandDeletedDateShouldNotExists(LocalDateTime deletedDate) {

        List<Brand> brands = brandRepository.findByDeletedDate(deletedDate);
        for (Brand brand : brands){
            if (brand.getDeletedDate() !=null){
                throw new RuntimeException("Brand Is Deleted");
            }
        }

    }


    public  void checkIfBrandNameExists(String brandName){
        Optional<Brand> brand = brandRepository.findByNameIgnoreCase(brandName);
        if (brand.isPresent() && brand.get().getDeletedDate()==null){
            throw new RuntimeException("Brand Name Exists");
        }
    }
}
