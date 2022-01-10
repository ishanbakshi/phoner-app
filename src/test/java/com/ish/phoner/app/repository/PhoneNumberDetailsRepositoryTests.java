package com.ish.phoner.app.repository;

import com.ish.phoner.app.entity.PhoneNumberDetails;
import com.ish.phoner.app.repository.PhoneNumberDetailsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
public class PhoneNumberDetailsRepositoryTests {

    @Autowired
    private PhoneNumberDetailsRepository phoneNumberDetailsRepository;

    @BeforeEach
    private void prepareDataforTest(){
        PhoneNumberDetails phoneNumberDetails1 = PhoneNumberDetails.builder()
                .phoneNumber("111111")
                .isStatusActive(false)
                .build();

        PhoneNumberDetails phoneNumberDetails2 = PhoneNumberDetails.builder()
                .phoneNumber("222222")
                .isStatusActive(false)
                .build();

        PhoneNumberDetails phoneNumberDetails3 = PhoneNumberDetails.builder()
                .phoneNumber("333333")
                .isStatusActive(false)
                .build();

        phoneNumberDetailsRepository.save(phoneNumberDetails1);
        phoneNumberDetailsRepository.save(phoneNumberDetails2);
        phoneNumberDetailsRepository.save(phoneNumberDetails3);
    }

    @Test
    public void getAllPhoneNumbersTest(){
        Assertions.assertThat(phoneNumberDetailsRepository.findAll().size()).isEqualTo(3);
        //All the phone numbers are nested inside the response of phoneNumberDetailsRepository.findAll()
        //Scope of improvement is we could assert the values of each phone number instead of just testing the size of the list returned
    }


    @Test
    @Rollback(value = false)
    public void activatePhoneNumberTest(){
        PhoneNumberDetails phoneToUpdate = phoneNumberDetailsRepository.findAll().get(0);
        phoneNumberDetailsRepository.updateActiveStatusByPhoneNumber(true, phoneToUpdate.getPhoneNumber());
        Assertions.assertThat(phoneNumberDetailsRepository.getById(phoneToUpdate.getId()).isStatusActive()).isEqualTo(true);
    }



}
