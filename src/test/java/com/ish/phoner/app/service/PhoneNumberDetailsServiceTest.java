package com.ish.phoner.app.service;

import com.ish.phoner.app.entity.Customer;
import com.ish.phoner.app.entity.PhoneNumberDetails;
import com.ish.phoner.app.repository.CustomerRepository;
import com.ish.phoner.app.repository.PhoneNumberDetailsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberDetailsServiceTest {
    private PhoneNumberDetailsRepository phoneNumberDetailsRepository = Mockito.mock(PhoneNumberDetailsRepository.class);

    private PhoneNumberDetailsService phoneNumberDetailsService = new PhoneNumberDetailsService(phoneNumberDetailsRepository);

    @Test
    public void getAllPhoneNumbers(){
        Mockito.when(phoneNumberDetailsRepository.findAll()).thenReturn(List.of(
                PhoneNumberDetails.builder().phoneNumber("111111").isStatusActive(false).build(),
                PhoneNumberDetails.builder().phoneNumber("111122").isStatusActive(false).build(),
                PhoneNumberDetails.builder().phoneNumber("111133").isStatusActive(false).build(),
                PhoneNumberDetails.builder().phoneNumber("111144").isStatusActive(true).build()
        ));

        List<String> response = phoneNumberDetailsService.getAllPhoneNumbers();
        Assertions.assertThat(response).isEqualTo(List.of("111111", "111122", "111133", "111144"));

    }
}