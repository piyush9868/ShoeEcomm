package com.example.ShoeFactory.model;

import com.example.ShoeFactory.entity.OrderEntity;
import com.example.ShoeFactory.entity.PaymentEntity;
import com.example.ShoeFactory.entity.ShoeEntity;
import com.example.ShoeFactory.entity.UserEntity;
import com.example.ShoeFactory.model.enums.OrderStatus;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    private List<ShoeEntity> shoeEntity;
    private UserEntity userEntity;
    private int orderTotal;
    private OrderStatus orderStatus;
    private PaymentEntity paymentEntity;
    private String invoiceLink;
    private Date orderTimeStamp;

    public OrderEntity convertModelToEntity(){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setPaymentEntity(this.paymentEntity);
        orderEntity.setShoeEntity(this.shoeEntity);
        orderEntity.setOrderStatus(this.orderStatus);
        orderEntity.setUserEntity(this.userEntity);
        orderEntity.setOrderTimeStamp(this.orderTimeStamp);
        orderEntity.setInvoiceLink(this.invoiceLink);
        orderEntity.setOrderTotal(this.orderTotal);
        return orderEntity;
    }

}
