package com.ish.phoner.app.service;

import com.ish.phoner.app.repository.CustomerRepository;
import com.ish.phoner.app.repository.PhoneNumberDetailsRepository;

import java.util.List;

public class PhoneNumberDetailsService {

    private PhoneNumberDetailsRepository phoneNumberDetailsRepository;

    public PhoneNumberDetailsService(PhoneNumberDetailsRepository phoneNumberDetailsRepository) {
        this.phoneNumberDetailsRepository = phoneNumberDetailsRepository;
    }

    public List<String> getAllPhoneNumbers(){
        List<String> phoneNumbers =  phoneNumberDetailsRepository.findAll()
                .stream()
                .map(x->x.getPhoneNumber())
                .toList();
        return phoneNumbers;
    }
}
