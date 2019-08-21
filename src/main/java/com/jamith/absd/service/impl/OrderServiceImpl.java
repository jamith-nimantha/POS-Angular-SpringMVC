package com.jamith.absd.service.impl;

import com.jamith.absd.dto.ItemDto;
import com.jamith.absd.dto.OrderDetailsDto;
import com.jamith.absd.dto.OrderDto;
import com.jamith.absd.entity.Customer;
import com.jamith.absd.entity.Item;
import com.jamith.absd.entity.Order;
import com.jamith.absd.entity.OrderDetail;
import com.jamith.absd.repository.OrderDetailsRepository;
import com.jamith.absd.repository.OrderRepository;
import com.jamith.absd.service.CustomerService;
import com.jamith.absd.service.ItemService;
import com.jamith.absd.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean saveOrder(OrderDetailsDto dto) {

        OrderDto orderDto = dto.getOrder();

        Customer customer = customerService.getCustomerById(orderDto.getCustId());

        Order order = new Order();
        order.setId(orderDto.getId());
        order.setDate(orderDto.getDate()==null ? new Date() : orderDto.getDate());
        order.setCustomer(customer);

        order = orderRepository.save(order);

        for (ItemDto itemDto: dto.getCartItems()){
            OrderDetail detail = new OrderDetail();
            Item item = itemService.getItemByCode(itemDto.getCode());
            detail.setItem(item);
            detail.setOrder(order);
            detail.setQty(itemDto.getQty());

            System.out.println(item.getQtyOnHand()-itemDto.getQty());
            itemService.updateItemQty(item.getQtyOnHand()-itemDto.getQty(), item.getCode());
            orderDetailsRepository.save(detail);
        }
        return true;

    }

    @Override
    public List<OrderDetailsDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDetailsDto> dtos = new ArrayList<>();
        for (Order order: orders){
            OrderDetailsDto dto = new OrderDetailsDto();

            OrderDto orderDto = new OrderDto();
            orderDto.setCustId(order.getCustomer().getId());
            orderDto.setId(order.getId());
            orderDto.setDate(order.getDate());
            orderDto.setCustName(order.getCustomer().getName());

            dto.setOrder(orderDto);

            List<ItemDto> itemDtoList = new ArrayList<>();

            List<OrderDetail> orderDetails = order.getOrderDetails();
            for (OrderDetail orderDetail: orderDetails){
                ItemDto itemDto = new ItemDto();
                itemDto.setCode(orderDetail.getItem().getCode());
                itemDto.setName(orderDetail.getItem().getName());
                itemDto.setDescription(orderDetail.getItem().getDescription());
                itemDto.setPrice(orderDetail.getItem().getUnitPrice());
                itemDto.setQty(orderDetail.getQty());
                itemDtoList.add(itemDto);
            }
            dto.setCartItems(itemDtoList);

            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public Integer getCount() {
        return orderRepository.getCount();
    }


}
