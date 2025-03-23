package com.example.payment_service.controllers;

import com.example.payment_service.DTOs.createPaymentLinkRequestDTO;
import com.example.payment_service.services.PaymentService;
import com.razorpay.RazorpayException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    @PostMapping("/")
    public String createPaymentLink(@RequestBody createPaymentLinkRequestDTO requestDTO) throws RazorpayException {
        String link = paymentService.createPaymentLink(requestDTO.getOrderId());

        return link;
    }
}
