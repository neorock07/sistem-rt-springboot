package com.sifora.sifora.Services.EventService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sifora.sifora.DTO.EventDTO;
import com.sifora.sifora.Entity.Event;
import com.sifora.sifora.Repository.RepoEvent;

@Service
public class EventService {
    
    @Autowired
    RepoEvent repo;

    public Event create(EventDTO req){
        Event event = new Event();
        event.setTitle(req.getTitle());
        event.setDeskripsi(req.getDeskripsi());
        event.setLokasi(req.getLokasi());
        event.setDate(req.getDate());
        event.setPenyelenggara(req.getPenyelenggara());
        event.setImage(req.getImage());
        return repo.save(event);    
    }

    public List<Event> findAll(){
        return repo.findAll();
    }

    public List<Event> findNewestEvents(){
        Long before = System.currentTimeMillis() - (3 * 24 * 60 * 60 * 1000);
        Date beforeday = new Date(before);
        return repo.findByDateGreaterThanEqual(beforeday);        
    }

    public void delete(Event req){
        // Event req = new Event();
        // req = repo.findById(id).isPresent() ? repo.findById(id).get() : repo.findById(id).orElseThrow(); 
        repo.delete(req);
    }

}
