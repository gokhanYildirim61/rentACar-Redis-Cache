package myProject.rentACar.business.abstracts;


import myProject.rentACar.business.dtos.requests.customerRequsts.CreateCustomerRequest;
import myProject.rentACar.business.dtos.requests.customerRequsts.UpdateCustomerRequest;

import myProject.rentACar.business.dtos.responses.customerResponse.CreatedCustomerResponse;
import myProject.rentACar.business.dtos.responses.customerResponse.DeletedCustomerResponse;
import myProject.rentACar.business.dtos.responses.customerResponse.GetCustomerResponse;
import myProject.rentACar.business.dtos.responses.customerResponse.UpdatedCustomerResponse;

public interface CustomerService {

    CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest) throws Exception;

    UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest, int id);

    GetCustomerResponse getById(int id);

    DeletedCustomerResponse softDelete(int id);

}
