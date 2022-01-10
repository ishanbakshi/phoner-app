package com.ish.phoner.app.service;

import com.ish.phoner.app.entity.Customer;
import com.ish.phoner.app.entity.PhoneNumberDetails;
import com.ish.phoner.app.repository.CustomerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;


class CustomerServiceTest {

    private CustomerRepository customerRepository = Mockito.mock(CustomerRepository.class);

    private CustomerService customerService = new CustomerService(customerRepository);

    @Test
    public void getAllPhoneNumbersByCustomerTest(){
        Customer mockedCustomer = Customer.builder()
                .firstName("Dwayne")
                .lastName("Johnson")
                .phoneNumberDetailsList(
                        List.of(
                                PhoneNumberDetails.builder().phoneNumber("111111").isStatusActive(false).build(),
                                PhoneNumberDetails.builder().phoneNumber("111112").isStatusActive(false).build(),
                                PhoneNumberDetails.builder().phoneNumber("111113").isStatusActive(false).build(),
                                PhoneNumberDetails.builder().phoneNumber("111114").isStatusActive(true).build()
                        )
                )
                .build();
        Mockito.when(customerRepository.getById(Mockito.any())).thenReturn(mockedCustomer);

        List<String> response = customerService.getAllPhoneNumbersByCustomer(123123);
        Assertions.assertThat(response).isEqualTo(List.of("111111", "111112", "111113", "111114"));

    }


}