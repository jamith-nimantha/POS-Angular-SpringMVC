package com.jamith.absd.service;

import com.jamith.absd.dto.OrderDetailsDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    boolean saveOrder(OrderDetailsDto dto);

    List<OrderDetailsDto> getAllOrders();

    Integer getCount();
}
