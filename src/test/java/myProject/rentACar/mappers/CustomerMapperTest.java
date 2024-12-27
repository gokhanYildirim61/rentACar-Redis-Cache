package myProject.rentACar.mappers;

import myProject.rentACar.business.dtos.requests.customerRequsts.CreateCustomerRequest;
import myProject.rentACar.business.dtos.responses.customerResponse.CreatedCustomerResponse;
import myProject.rentACar.entites.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerMapperTest {

        @Mock
        CustomerMapper customerMapper;



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
    void customerFromCreateCustomerRequest() {

        when(customerMapper.customerFromCreateCustomerRequest(createCustomerRequest)).thenReturn(customer);


        Customer mappedCustomer = customerMapper.customerFromCreateCustomerRequest(createCustomerRequest);

        // Assert - Beklentileri kontrol ediyoruz
        assertEquals(createCustomerRequest.getName(), mappedCustomer.getName());
        assertEquals(createCustomerRequest.getSurName(), mappedCustomer.getSurName());
        assertEquals(createCustomerRequest.getBirthDate(), mappedCustomer.getBirthDate());
    }

    @Test
    void customerFromUpdateCustomerRequest() {
    }

    @Test
    void createdCustomerResponseFromCustomer() {
    }

    @Test
    void updatedCustomerResponseFromCustomer() {
    }

    @Test
    void getCustomerResponseFromCustomer() {
    }

    @Test
    void deletedCustomerResponseFromCustomer() {
    }
}