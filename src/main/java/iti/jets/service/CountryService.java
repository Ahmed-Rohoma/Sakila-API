package iti.jets.service;

import java.util.List;

import iti.jets.model.dto.CountryDTO;
import iti.jets.model.mapper.CountryMapper;
import iti.jets.repository.connection.DBMananger;
import iti.jets.repository.dao.implementation.CountryDao;
import iti.jets.repository.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class CountryService {

    private CountryDao countryDao = null;
    private EntityManagerFactory entityManagerFactory = DBMananger.getInstance();
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public CountryService() {
        countryDao = new CountryDao(entityManager);
    }

    public void update(Country country) {
        countryDao.update(country);
    }

    public CountryDTO getByID(int id) {
        return CountryMapper.toDTO(countryDao.getById(id));
    }

    public void add(Country country) {
        countryDao.add(country);
    }

    public void deleteByID(int id){
        countryDao.delete(id);
    }

    // public List<CountryDTO> getAll() {
    //     return CountryMapper.getActorDTOList(countryDao.getAll());
    // }

}
