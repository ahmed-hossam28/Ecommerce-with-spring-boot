package com.ecommerce.app.customer;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


class CustomerServiceTest {

    CustomerService customerService;
    @Test
    void findCustomerByIdTest(){
        assertEquals(customerService.findCustomerById(2L).get().getName(),"name");
    }
}