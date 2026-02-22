package com.bibek.InternalWorkingOfSpringBoot;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

//@Component
//@Service
//@RestController
//@Repository
//@Controller
@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "stripe")
public class StripePaymentService implements PaymentService{


    @Override
    public String pay() {
        String payment = "Stripe Payment";
        System.out.println("Payment from"+ payment);
        return payment;
    }
}
