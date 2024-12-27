package myProject.rentACar.dataAccess.abstracts;

import myProject.rentACar.entites.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelRepository extends JpaRepository<Model,Integer> {
}
