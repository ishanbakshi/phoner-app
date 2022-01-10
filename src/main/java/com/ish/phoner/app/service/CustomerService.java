package com.ish.phoner.app.service;

import com.ish.phoner.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<String> getAllPhoneNumbersByCustomer(long customerId){
        List<String> phoneNumbers =  customerRepository.getById(customerId)
                .getPhoneNumberDetailsList()
                .stream()
                .map(x->x.getPhoneNumber())
                .toList();
        return phoneNumbers;
    }
}
