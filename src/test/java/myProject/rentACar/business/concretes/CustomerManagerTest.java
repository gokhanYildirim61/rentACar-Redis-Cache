package myProject.rentACar.business.concretes;

import myProject.rentACar.business.abstracts.CustomerService;
import myProject.rentACar.business.dtos.requests.customerRequsts.CreateCustomerRequest;
import myProject.rentACar.business.dtos.responses.customerResponse.CreatedCustomerResponse;
import myProject.rentACar.dataAccess.abstracts.CustomerRepository;
import myProject.rentACar.entites.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerManagerTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerManager customerManager;

    private Customer customer;

    private CreateCustomerRequest createCustomerRequest;

    private CreatedCustomerResponse createdCustomerResponse;


    @BeforeEach
    void setUp() {
        customer=new Customer();
        customer.setName("deneme1Name");
        customer.setSurName("deneme1Surname");
        customer.setBirthDate(1999);

        createCustomerRequest=new CreateCustomerRequest();
        createCustomerRequest.setName("deneme1Name");
        createCustomerRequest.setSurName("deneme1Surname");
        createCustomerRequest.setBirthDate(1999);

        createdCustomerResponse=new CreatedCustomerResponse();
        createdCustomerResponse.setName("deneme1Name");
        createdCustomerResponse.setSurName("deneme1Surname");
        createdCustomerResponse.setBirthDate(1999);


    }

    @Test
    void add() throws Exception {
        // Setting up the customerRepository.save call with when
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);


        // Act - calling the add method
        CreatedCustomerResponse response = customerManager.add(createCustomerRequest);

        assertEquals(createdCustomerResponse.getName(), response.getName());
        assertEquals(createdCustomerResponse.getSurName(), response.getSurName());
        assertEquals(createdCustomerResponse.getBirthDate(), response.getBirthDate());
    }

    @Test
    void update() {
    }

    @Test
    void getById() {
    }
}