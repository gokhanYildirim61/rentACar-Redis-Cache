package myProject.rentACar.entites;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import myProject.rentACar.core.entites.BaseEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cars")
public class Car extends BaseEntity {
    @Column(name="modelYear")
    private int modelYear;
    @Column(name="plate", unique = true)
    private String plate;
    @Column(name="state")//1-Available 2-Rented 3-Under Maintenance
    private int state;
    @Column(name="dailyPrice")
    private double dailyPrice;
    @ManyToOne()
    @JoinColumn(name="model_id")
    private Model model;

    @Column(name = "kilometer")
    private int kilometer;


}
