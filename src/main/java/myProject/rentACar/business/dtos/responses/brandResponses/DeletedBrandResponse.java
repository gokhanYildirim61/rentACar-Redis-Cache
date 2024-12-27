package myProject.rentACar.business.dtos.responses.brandResponses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeletedBrandResponse implements Serializable {

    private int id;
    private String name;
}
