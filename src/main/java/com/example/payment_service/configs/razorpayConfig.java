package com.example.payment_service.configs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class razorpayConfig {
    @Value("${razorpay.key.id}")
    String razorpayKeyId ;
    @Value("${razorpay.key.secret}")
    String razorpaySecretKey;
    @Bean
    public RazorpayClient createRazorpayClient() throws RazorpayException {

        return new RazorpayClient(razorpayKeyId, razorpaySecretKey);
    }
}
