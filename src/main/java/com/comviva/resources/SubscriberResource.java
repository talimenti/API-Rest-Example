package com.comviva.resources;

import com.comviva.domain.entities.Subscriber;
import com.comviva.domain.repositories.ISubscriberRepository;
import com.mahindracomviva.secm.core.annotations.hasPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import java.util.List;

@RestController()
@Transactional
@Path("/subscriber")
public class SubscriberResource {

    private ISubscriberRepository subscriberRepository;

    @Autowired
    public SubscriberResource(ISubscriberRepository subscriberRepository){
        this.subscriberRepository = subscriberRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @hasPermission("read")
    @CrossOrigin(origins = "*")
    public List<Subscriber> list(){
        return subscriberRepository.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @hasPermission("read")
    public Subscriber get(@PathVariable(name = "id") Integer id){
        return subscriberRepository.findOne(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @hasPermission("write")
    public Subscriber save(@RequestBody Subscriber subscriber){
        return subscriberRepository.save(subscriber);
    }

    @PUT
    @Path("/{subscriber.id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @hasPermission("write")
    public Subscriber update(@RequestBody Subscriber subscriber){
        return subscriberRepository.save(subscriber);
    }

    @DELETE
    @Path("/{subscriber.id}")
    @Produces(MediaType.APPLICATION_JSON_VALUE)
    @hasPermission("write")
    public void delete(@RequestBody Subscriber subscriber){
        subscriberRepository.delete(subscriber.getId());
    }
}