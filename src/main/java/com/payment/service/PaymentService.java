package com.payment.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {



    private final RazorpayClient razorpayClient;
    private final PaymentRepository paymentRepository;

    public PaymentService(RazorpayClient razorpayClient,
                          PaymentRepository paymentRepository) {
        this.razorpayClient = razorpayClient;
        this.paymentRepository = paymentRepository;
    }

    public String createPayment(Payment payment) throws Exception {

        JSONObject options = new JSONObject();

        options.put("amount", payment.getAmount() * 100);
        options.put("currency", "INR");
        options.put("receipt", "receipt_" + System.currentTimeMillis());

        Order order = razorpayClient.orders.create(options);

        payment.setOrderId(order.get("id"));
        payment.setStatus("CREATED");

        paymentRepository.save(payment);

        return order.get("id");
    }
}
