package com.jamith.absd.service.impl;

import com.jamith.absd.dto.CustomerDto;
import com.jamith.absd.entity.Customer;
import com.jamith.absd.repository.CustomerRepository;
import com.jamith.absd.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream().map(Customer::getCustomerDTO).collect(Collectors.toList());
    }

    public Customer getCustomerById(String id){
        return customerRepository.findTopById(id);
    }

    @Override
    public Integer getCount() {
        return customerRepository.getCount();
    }

    @Override
    public boolean addCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setAddress(customerDto.getAddress());
        customer.setSalary(customerDto.getSalary());
        customerRepository.save(customer);
        return true;
    }

    @Override
    public boolean updateCustomer(CustomerDto customerDto) {
        Customer one = customerRepository.findTopById(customerDto.getId());
        one.setName(customerDto.getName());
        one.setAddress(customerDto.getAddress());
        one.setSalary(customerDto.getSalary());
        customerRepository.save(one);
        return true;
    }

    @Override
    public boolean deleteCustomer(String id) {
        Customer one = customerRepository.findTopById(id);
        customerRepository.delete(one);
        return true;
    }
}
