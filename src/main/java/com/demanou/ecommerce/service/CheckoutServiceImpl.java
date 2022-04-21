package com.demanou.ecommerce.service;

import com.demanou.ecommerce.dao.CustomerRepository;
import com.demanou.ecommerce.dto.Purchase;
import com.demanou.ecommerce.dto.PurchaseResponse;
import com.demanou.ecommerce.entity.Customer;
import com.demanou.ecommerce.entity.Order;
import com.demanou.ecommerce.entity.OrderItem;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;


    @Contract(pure = true)
    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(@NotNull Purchase purchase) {


        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber;
        orderTrackingNumber = generateOrderTrackingNumber();
        


        // populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        //orderItems.forEach(order::add);
//        orderItems.forEach(order::add);
//
        orderItems.forEach(item -> order.add(item));



        // populate order with billingAddress and shippingAddress
            order.setBillingAddress(purchase.getBillingAddress());
            order.setShippingAddress(purchase.getShippingAddress());


        // populate customer with order
        Customer customer = purchase.getCustomer();
        customer.add(order);

        //save to the database
        customerRepository.save(customer);


        // return a response
        //return new PurchaseResponse(orderTrackingNumber);
        return new PurchaseResponse(orderTrackingNumber);



    }

    //@NotNull
    private String generateOrderTrackingNumber() {
        // generate a random UUID number (UUID version-4)
        // for details see :https://en.wikipedia.org/wiki/Universally_unique_identifier

        return UUID.randomUUID().toString();
    }

}
