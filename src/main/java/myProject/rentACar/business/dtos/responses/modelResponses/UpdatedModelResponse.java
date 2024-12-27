package myProject.rentACar.business.dtos.responses.modelResponses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdatedModelResponse {

    private int id;

    private String name;

    private int brandId;
}