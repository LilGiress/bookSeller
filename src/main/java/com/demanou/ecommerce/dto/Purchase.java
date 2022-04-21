package com.demanou.ecommerce.dto;


import com.demanou.ecommerce.entity.Address;
import com.demanou.ecommerce.entity.Customer;
import com.demanou.ecommerce.entity.Order;
import com.demanou.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
