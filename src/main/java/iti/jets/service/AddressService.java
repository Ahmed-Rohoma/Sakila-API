package iti.jets.service;


import iti.jets.model.dto.AddressDTO;
import iti.jets.model.mapper.AddressMapper;
import iti.jets.repository.connection.DBMananger;
import iti.jets.repository.dao.implementation.AddressDao;
import iti.jets.repository.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class AddressService {

    private AddressDao addressDao = null;
    private EntityManagerFactory entityManagerFactory = DBMananger.getInstance();
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public AddressService() {
        addressDao = new AddressDao(entityManager);
    }

    public void update(Address address) {
        addressDao.update(address);
    }

    public AddressDTO getByID(int id) {
        return AddressMapper.toDTO(addressDao.getById(id));
    }

    public void add(Address address) {
        addressDao.add(address);
    }

    public void deleteByID(int id){
        addressDao.delete(id);
    }



}
