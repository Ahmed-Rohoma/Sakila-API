package iti.jets.model.mapper;

import iti.jets.model.dto.PaymentDTO;
import iti.jets.repository.entity.Payment;

public class PaymentMapper {
    public static PaymentDTO toDTO(Payment payment) {
        PaymentDTO dto = new PaymentDTO();
        dto.setId(payment.getId());
        dto.setCustomer(CustomerMapper.toDTO(payment.getCustomer()));
        dto.setRental(RentalMapper.toDTO(payment.getRental()));
        dto.setAmount(payment.getAmount());
        dto.setPaymentDate(payment.getPaymentDate());
        dto.setLastUpdate(payment.getLastUpdate());
        return dto;
    }
    
    public static Payment toEntity(PaymentDTO dto) {
        Payment payment = new Payment();
        payment.setId(dto.getId());
        payment.setCustomer(CustomerMapper.toEntity(dto.getCustomer()));
        payment.setRental(RentalMapper.toEntity(dto.getRental()));
        payment.setAmount(dto.getAmount());
        payment.setPaymentDate(dto.getPaymentDate());
        payment.setLastUpdate(dto.getLastUpdate());
        return payment;
    }
}

