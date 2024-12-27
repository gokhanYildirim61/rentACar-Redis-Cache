package myProject.rentACar.mappers;

import myProject.rentACar.business.dtos.requests.customerRequsts.CreateCustomerRequest;
import myProject.rentACar.business.dtos.requests.customerRequsts.UpdateCustomerRequest;
import myProject.rentACar.business.dtos.responses.customerResponse.CreatedCustomerResponse;
import myProject.rentACar.business.dtos.responses.customerResponse.DeletedCustomerResponse;
import myProject.rentACar.business.dtos.responses.customerResponse.GetCustomerResponse;
import myProject.rentACar.business.dtos.responses.customerResponse.UpdatedCustomerResponse;
import myProject.rentACar.entites.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer customerFromCreateCustomerRequest(CreateCustomerRequest createCustomerRequest);


    Customer customerFromUpdateCustomerRequest(UpdateCustomerRequest updateCustomerRequest);


    CreatedCustomerResponse createdCustomerResponseFromCustomer(Customer customer);


    UpdatedCustomerResponse updatedCustomerResponseFromCustomer(Customer customer);


    GetCustomerResponse getCustomerResponseFromCustomer(Customer customer);


    DeletedCustomerResponse deletedCustomerResponseFromCustomer(Customer customer);



}
