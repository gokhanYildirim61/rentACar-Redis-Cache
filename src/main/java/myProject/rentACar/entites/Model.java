package myProject.rentACar.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import myProject.rentACar.core.entites.BaseEntity;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="models")
public class Model extends BaseEntity {

    @Column(name="name")
    private String name;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY)
    private List<Car> cars;



}
