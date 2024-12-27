package myProject.rentACar.dataAccess.abstracts;

import myProject.rentACar.entites.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {


   List<Brand> findByDeletedDate(LocalDateTime deletedDate);

    Optional<Brand> findByNameIgnoreCase(String name);


}
