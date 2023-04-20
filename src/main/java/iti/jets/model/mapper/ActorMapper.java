package iti.jets.model.mapper;

import java.util.ArrayList;
import java.util.List;

import iti.jets.model.dto.ActorDTO;
import iti.jets.repository.entity.Actor;

public class ActorMapper {
    public static ActorDTO toActorDTO(Actor actor) {
        ActorDTO actorDTO = new ActorDTO();
        actorDTO.setActorId(actor.getId());
        actorDTO.setFirstName(actor.getFirstName());
        actorDTO.setLastName(actor.getLastName());
        actorDTO.setLastUpdate(actor.getLastUpdate());
        return actorDTO;
    }

    public static Actor toActorEntity(ActorDTO actorDTO) {
        Actor actor = new Actor();
        actor.setId(actorDTO.getActorId());
        actor.setFirstName(actorDTO.getFirstName());
        actor.setLastName(actorDTO.getLastName());
        actor.setLastUpdate(actorDTO.getLastUpdate());
        return actor;
    }

    public static List<ActorDTO> getActorDTOList(List<Actor> actorList) {
        List<ActorDTO> actorDTOList = new ArrayList<>();
    
        for (Actor actor : actorList) {
            ActorDTO actorDTO = new ActorDTO();
            actorDTO.setActorId(actor.getId());
            actorDTO.setFirstName(actor.getFirstName());
            actorDTO.setLastName(actor.getLastName());
            actorDTO.setLastUpdate(actor.getLastUpdate());
    
            actorDTOList.add(actorDTO);
        }
    
        return actorDTOList;
    }
}
