package iti.jets.service;

import iti.jets.model.dto.CityDTO;
import iti.jets.model.mapper.CityMapper;
import iti.jets.repository.connection.DBMananger;
import iti.jets.repository.dao.implementation.CityDao;
import iti.jets.repository.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class CityService {

    private CityDao cityDao = null;
    private EntityManagerFactory entityManagerFactory = DBMananger.getInstance();
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public CityService() {
        cityDao = new CityDao(entityManager);
    }

    public void update(City city) {
        cityDao.update(city);
    }

    public CityDTO getByID(int id) {
        return CityMapper.toDTO(cityDao.getById(id));
    }

    public void add(City city) {
        cityDao.add(city);
    }

    public void deleteByID(int id){
        cityDao.delete(id);
    }

}
