package myProject.rentACar.business.dtos.requests.modelRequests;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateModelRequest {

    private String name;

    private int brandId;
}
