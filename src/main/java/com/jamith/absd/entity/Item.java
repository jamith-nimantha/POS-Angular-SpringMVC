package com.jamith.absd.entity;

import com.jamith.absd.dto.ItemDto;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_ITEM")
public class Item implements Serializable {

    @Id
    @Column(name = "CODE")
    private String code;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "UNIT_PRICE")
    private Double unitPrice;

    @Column(name = "QTY_ON_HAND")
    private Integer qtyOnHand;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "item")
    private List<OrderDetail> orderDetails = new ArrayList<>();

    public Item() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(Integer qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public ItemDto getItemDto(){
        ItemDto dto = new ItemDto();
        dto.setCode(this.code);
        dto.setName(this.name);
        dto.setDescription(this.description);
        dto.setPrice(this.unitPrice);
        dto.setQty(this.qtyOnHand);
        return dto;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Item{");
        sb.append("code='").append(code).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", unitPrice=").append(unitPrice);
        sb.append(", qtyOnHand=").append(qtyOnHand);
        sb.append(", orderDetails=").append(orderDetails);
        sb.append('}');
        return sb.toString();
    }
}
