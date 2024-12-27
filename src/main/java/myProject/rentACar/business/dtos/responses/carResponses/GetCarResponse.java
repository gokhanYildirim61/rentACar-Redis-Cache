package myProject.rentACar.business.dtos.responses.carResponses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCarResponse {

    private int id;

    private int modelYear;

    private String plate;

    private int state;

    private int dailyPrice;

    private int kilometer;

    private int modelId;
}
