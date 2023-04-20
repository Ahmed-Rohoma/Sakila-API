package iti.jets.service;

import java.util.List;

import iti.jets.model.dto.CustomerDTO;
import iti.jets.model.mapper.CustomerMapper;
import iti.jets.repository.connection.DBMananger;
import iti.jets.repository.dao.implementation.CustomerDao;
import iti.jets.repository.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class CustomerService {

    private CustomerDao customerDao = null;
    private EntityManagerFactory entityManagerFactory = DBMananger.getInstance();
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public CustomerService() {
        customerDao = new CustomerDao(entityManager);
    }

    public void update(Customer actor) {
        customerDao.update(actor);
    }

    public CustomerDTO getByID(int id) {
        return CustomerMapper.toDTO(customerDao.getById(id));
    }

    public void add(Customer actor) {
        customerDao.add(actor);
    }

    public void deleteByID(int id){
        customerDao.delete(id);
    }

    // public List<CustomerDTO> getAll() {
    //     return CustomerMapper.getDTOList(customerDao.getAll());
    // }

}
