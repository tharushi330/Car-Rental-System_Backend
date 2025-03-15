package edu.icet.ecom.service;

import edu.icet.ecom.dto.Payment;

import java.util.List;

public interface PaymentService {
    Payment createPayment(Payment payment);
    Payment getPaymentById(Long paymentID);
    List<Payment> getAllPayments();
    Payment updatePayment(Long paymentID, Payment payment);
    void deletePayment(Long paymentID);
}
