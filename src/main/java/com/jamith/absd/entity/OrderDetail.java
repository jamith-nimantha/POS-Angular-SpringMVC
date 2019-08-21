package com.jamith.absd.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "T_ORDER_DETAIL")
@IdClass(OrderDetailId.class)
public class OrderDetail implements Serializable {

    private static final long serialVersionUID = 4359978811497264880L;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID")
    private Order order;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEM_CODE")
    private Item item;

    @Column(name = "QTY")
    private Integer qty;

    public OrderDetail() {
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderDetail{");
        sb.append("order=").append(order);
        sb.append(", item=").append(item);
        sb.append(", qty=").append(qty);
        sb.append('}');
        return sb.toString();
    }
}
