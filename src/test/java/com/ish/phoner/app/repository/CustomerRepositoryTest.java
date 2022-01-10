package com.ish.phoner.app.repository;

import com.ish.phoner.app.entity.Customer;
import com.ish.phoner.app.entity.PhoneNumberDetails;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    private void prepareDataforTest(){

        Customer customer1 = Customer.builder()
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

        customerRepository.save(customer1);

        Customer customer2 = Customer.builder()
                .firstName("Stone")
                .lastName("Cold")
                .phoneNumberDetailsList(
                        List.of(
                                PhoneNumberDetails.builder().phoneNumber("222221").isStatusActive(false).build(),
                                PhoneNumberDetails.builder().phoneNumber("222222").isStatusActive(false).build()
                        )
                )
                .build();

        customerRepository.save(customer2);
    }


    @Test
    public void getCustomerByIdTest(){
        Customer customer = customerRepository.findAll().get(0);
        List<PhoneNumberDetails> response =  customerRepository.getById(customer.getId()).getPhoneNumberDetailsList();
        Assertions.assertThat(response).isEqualTo(customer.getPhoneNumberDetailsList());
    }

}
