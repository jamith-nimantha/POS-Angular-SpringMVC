package com.jamith.absd.entity;

import java.io.Serializable;
import java.util.Objects;

public class OrderDetailId implements Serializable {
    private static final long serialVersionUID = -8039918129484429972L;

    private String order;
    private String item;

    public OrderDetailId() {
    }

    public OrderDetailId(String order, String item) {
        this.order = order;
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetailId)) return false;
        OrderDetailId that = (OrderDetailId) o;
        return order.equals(that.order) &&
                item.equals(that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, item);
    }
}
