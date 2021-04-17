package io.github.brunoalves24.hrpayroll.service;

import io.github.brunoalves24.hrpayroll.entity.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public Payment getPayment(long workerId, int days) {
        return new Payment("Bob", 200.0, days);
    }
}
