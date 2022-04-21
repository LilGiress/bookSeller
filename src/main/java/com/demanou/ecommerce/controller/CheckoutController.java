package com.demanou.ecommerce.controller;

import com.demanou.ecommerce.dto.Purchase;
import com.demanou.ecommerce.dto.PurchaseResponse;
import com.demanou.ecommerce.service.CheckoutService;
import org.jetbrains.annotations.Contract;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    @Contract(pure = true)
    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService = checkoutService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        //        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);


        return checkoutService.placeOrder(purchase);
    }
}
