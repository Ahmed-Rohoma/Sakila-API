package iti.jets.model.mapper;

import iti.jets.model.dto.CustomerDTO;
import iti.jets.repository.entity.Customer;

public class CustomerMapper {
    public static CustomerDTO toDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());
        dto.setAddress(AddressMapper.toDTO(customer.getAddress()));
        dto.setActive(customer.getActive());
        dto.setCreateDate(customer.getCreateDate());
        dto.setLastUpdate(customer.getLastUpdate());
        return dto;
    }
    
    public static Customer toEntity(CustomerDTO dto) {
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setFirstName(dto.getFirstName());
        customer.setLastName(dto.getLastName());
        customer.setEmail(dto.getEmail());
        customer.setAddress(AddressMapper.toEntity(dto.getAddress()));
        customer.setActive(dto.isActive());
        customer.setCreateDate(dto.getCreateDate());
        customer.setLastUpdate(dto.getLastUpdate());
        return customer;
    }
}

