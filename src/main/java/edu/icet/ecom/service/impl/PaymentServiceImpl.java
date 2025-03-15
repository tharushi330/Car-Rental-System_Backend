package edu.icet.ecom.service.impl;

import edu.icet.ecom.dto.Payment;
import edu.icet.ecom.entity.PaymentEntity;
import edu.icet.ecom.repository.BookingRepository;
import edu.icet.ecom.repository.PaymentRepository;
import edu.icet.ecom.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;

    @Override
    public Payment createPayment(Payment payment) {
        PaymentEntity entity = modelMapper.map(payment, PaymentEntity.class);
        PaymentEntity savedEntity = paymentRepository.save(entity);
        return modelMapper.map(savedEntity, Payment.class);
    }

    @Override
    public Payment getPaymentById(Long paymentID) {
        PaymentEntity entity = paymentRepository.findById(paymentID)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        return modelMapper.map(entity, Payment.class);
    }

    @Override
    public List<Payment> getAllPayments() {
        List<PaymentEntity> entities = paymentRepository.findAll();
        return entities.stream()
                .map(entity -> modelMapper.map(entity, Payment.class))
                .collect(Collectors.toList());

    }

    @Override
    public Payment updatePayment(Long paymentID, Payment payment) {
        PaymentEntity existingEntity = paymentRepository.findById(paymentID)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        modelMapper.map(payment, existingEntity);
        PaymentEntity updatedEntity = paymentRepository.save(existingEntity);
        return modelMapper.map(updatedEntity, Payment.class);
    }

    @Override
    public void deletePayment(Long paymentID) {
        paymentRepository.deleteById(paymentID);
    }
}
