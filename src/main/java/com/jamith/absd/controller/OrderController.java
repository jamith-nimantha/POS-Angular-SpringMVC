package com.jamith.absd.controller;

import com.jamith.absd.dto.OrderDetailsDto;
import com.jamith.absd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/save")
    @ResponseBody
    public ResponseEntity saveOrder(@RequestBody OrderDetailsDto orderDetailsDto){
        return new ResponseEntity(orderService.saveOrder(orderDetailsDto), HttpStatus.OK);
    }

    @GetMapping("/count")
    @ResponseBody
    public ResponseEntity getCount(){
        return new ResponseEntity(orderService.getCount(), HttpStatus.OK);
    }

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity getAllOrders(){
        return new ResponseEntity(orderService.getAllOrders(),HttpStatus.OK);
    }
}
