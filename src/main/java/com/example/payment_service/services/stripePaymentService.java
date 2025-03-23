package com.example.payment_service.services;

public class stripePaymentService implements PaymentService{

        @Override
        public String createPaymentLink(String orderId) {
            return "Payment link created using stripe";
        }

        @Override
        public String getPaymentStatus(String paymentId) {
            return "Payment status fetched using stripe";
        }
}
