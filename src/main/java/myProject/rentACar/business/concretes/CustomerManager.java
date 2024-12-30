package myProject.rentACar.business.concretes;

import lombok.AllArgsConstructor;

import myProject.rentACar.business.abstracts.CustomerService;
import myProject.rentACar.business.dtos.requests.customerRequsts.CreateCustomerRequest;
import myProject.rentACar.business.dtos.requests.customerRequsts.UpdateCustomerRequest;
import myProject.rentACar.business.dtos.responses.customerResponse.CreatedCustomerResponse;
import myProject.rentACar.business.dtos.responses.customerResponse.DeletedCustomerResponse;
import myProject.rentACar.business.dtos.responses.customerResponse.GetCustomerResponse;
import myProject.rentACar.business.dtos.responses.customerResponse.UpdatedCustomerResponse;
import myProject.rentACar.core.utilites.ModelMapperService;
import myProject.rentACar.dataAccess.abstracts.CustomerRepository;
import myProject.rentACar.entites.Customer;
//import myProject.rentACar.kafka.producers.CustomerProducer;
import myProject.rentACar.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

    private CustomerRepository customerRepository;

    private ModelMapperService modelMapperService;

//    private CustomerProducer customerProducer;


    @Override
    public CreatedCustomerResponse add(CreateCustomerRequest createCustomerRequest) throws Exception {
        Customer customer=modelMapperService.forRequest().map(createCustomerRequest,Customer.class);
        Customer addedcustomer=customerRepository.save(customer);
        CreatedCustomerResponse createdCustomerResponse =modelMapperService.forResponse().map(addedcustomer,CreatedCustomerResponse.class);

//        CustomerCreatedEvent customerCreatedEvent=new CustomerCreatedEvent();
//        customerCreatedEvent.setName(createCustomerRequest.getName());
//        customerCreatedEvent.setId(createdCustomerResponse.getId());
//        customerProducer.sendMessage(customerCreatedEvent);
        return createdCustomerResponse;
//        return modelMapperService.forResponse().map(addedcustomer,CreatedCustomerResponse.class);


    }

    @Override
    public UpdatedCustomerResponse update(UpdateCustomerRequest updateCustomerRequest, int id) {
        return null;
    }

    @Override
    public GetCustomerResponse getById(int id) {
        return null;
    }

    @Override
    public DeletedCustomerResponse softDelete(int id) {
        return null;
    }
}
