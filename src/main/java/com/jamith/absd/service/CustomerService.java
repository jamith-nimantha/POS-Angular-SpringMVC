package com.jamith.absd.service;

import com.jamith.absd.dto.CustomerDto;
import com.jamith.absd.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<CustomerDto> getAllCustomers();

    boolean addCustomer(CustomerDto customerDto);

    boolean updateCustomer(CustomerDto customerDto);

    boolean deleteCustomer(String id);

    Customer getCustomerById(String id);

    Integer getCount();
}
