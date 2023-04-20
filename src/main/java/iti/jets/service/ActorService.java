package iti.jets.service;

import java.util.List;

import iti.jets.model.dto.ActorDTO;
import iti.jets.model.mapper.ActorMapper;
import iti.jets.repository.connection.DBMananger;
import iti.jets.repository.dao.implementation.ActorDao;
import iti.jets.repository.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ActorService {

    private ActorDao actorDao = null;
    private EntityManagerFactory entityManagerFactory = DBMananger.getInstance();
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public ActorService() {
        actorDao = new ActorDao(entityManager);
    }

    public void update(Actor actor) {
        actorDao.update(actor);
    }

    public ActorDTO getByID(int id) {
        return ActorMapper.toActorDTO(actorDao.getById(id));
    }

    public void add(Actor actor) {
        actorDao.add(actor);
    }

    public void deleteByID(int id){
        actorDao.delete(id);
    }

    public List<ActorDTO> getAll() {
        return ActorMapper.getActorDTOList(actorDao.getAll());
    }

}
