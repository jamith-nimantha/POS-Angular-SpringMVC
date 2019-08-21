package com.jamith.absd.controller;

import com.jamith.absd.dto.CustomerDto;
import com.jamith.absd.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity getAllCustomers(){
        return new ResponseEntity(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/count")
    @ResponseBody
    public ResponseEntity getCount(){
        return new ResponseEntity(customerService.getCount(), HttpStatus.OK);
    }

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity saveCustomer(@RequestBody CustomerDto customerDto){
       return new ResponseEntity(customerService.addCustomer(customerDto), HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity updateCustomer(@RequestBody CustomerDto customerDto){
        return new ResponseEntity(customerService.updateCustomer(customerDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity deleteCustomer(@PathVariable(name = "id") String id){
        return new ResponseEntity(customerService.deleteCustomer(id), HttpStatus.OK);
    }
}
