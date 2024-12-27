package myProject.rentACar.business.dtos.responses.brandResponses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatedBrandResponse {

    private int id;
    private String name;
}
