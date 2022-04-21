package com.demanou.ecommerce.service;

import com.demanou.ecommerce.dto.Purchase;
import com.demanou.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);

}
