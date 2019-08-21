package com.jamith.absd.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderDto {
    private String id;
    private Date date;
    private String custId;
    private String custName;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("OrderDto{");
        sb.append("id='").append(id).append('\'');
        sb.append(", date=").append(date);
        sb.append(", custId='").append(custId).append('\'');
        sb.append(", custName='").append(custName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
