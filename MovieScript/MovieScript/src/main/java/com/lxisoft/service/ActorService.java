package com.lxisoft.service;

import com.lxisoft.model.Actor;
import com.lxisoft.model.User;
import com.lxisoft.repository.ActorReppo;
import com.lxisoft.repository.UserReppo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActorService {
    @Autowired
    private ActorReppo actorReppo;

    @Transactional
    public List<Actor> getAllActors()
    {
        return actorReppo.findAll();
    }

    @Transactional
    public void saveActor(Actor actor)
    {
        actorReppo.save(actor);
    }
    @Transactional
    public  void deleteActor(int actorId)
    {
        actorReppo.deleteById(actorId);

    }

}