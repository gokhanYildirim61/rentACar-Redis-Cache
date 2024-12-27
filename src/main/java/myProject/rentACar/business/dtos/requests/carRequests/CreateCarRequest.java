package myProject.rentACar.business.dtos.requests.carRequests;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
    private int modelYear;

    private String plate;

    private int state;

    private int dailyPrice;

    private int kilometer;

    private int modelId;
}
