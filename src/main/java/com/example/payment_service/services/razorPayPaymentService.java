package com.example.payment_service.services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class razorPayPaymentService implements PaymentService{


            private RazorpayClient razorpayClient;

            public razorPayPaymentService(RazorpayClient razorpayClient) {
                this.razorpayClient = razorpayClient;
            }

            @Override
            public String createPaymentLink(String orderId) throws RazorpayException {
                JSONObject paymentLinkRequest = new JSONObject();
                paymentLinkRequest.put("amount",1000);
                paymentLinkRequest.put("currency","INR");
                paymentLinkRequest.put("accept_partial",false);
                //paymentLinkRequest.put("first_min_partial_amount",100);
                paymentLinkRequest.put("expire_by",System.currentTimeMillis() + (15*60*1000));
                paymentLinkRequest.put("reference_id",orderId);
                paymentLinkRequest.put("description","Payment for order no"+ orderId);
                JSONObject customer = new JSONObject();
                customer.put("name","+917018442936");
                customer.put("contact","Kartik Punj");
                customer.put("email","kartikpunj15@gmail.com");
                paymentLinkRequest.put("customer",customer);
                JSONObject notify = new JSONObject();
                notify.put("sms",true);
                notify.put("email",true);
                paymentLinkRequest.put("reminder_enable",true);
                JSONObject notes = new JSONObject();
                notes.put("ordered_item","1. Apple Vision Pro");
                paymentLinkRequest.put("notes",notes);
                paymentLinkRequest.put("callback_url","https://http://userservice.kartikpunj.tech/");
                paymentLinkRequest.put("callback_method","get");

                PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
                return payment.get("short_url");
            }

            @Override
            public String getPaymentStatus(String paymentId) {
                return "Payment status fetched using razorpay";
            }
}
