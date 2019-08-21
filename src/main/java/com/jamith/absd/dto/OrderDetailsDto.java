package com.jamith.absd.dto;

import java.util.List;

public class OrderDetailsDto {
    private OrderDto order;
    private List<ItemDto> cartItems;

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

    public List<ItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ItemDto> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderDetailsDto{");
        sb.append("order=").append(order);
        sb.append(", cartItems=").append(cartItems);
        sb.append('}');
        return sb.toString();
    }
}
