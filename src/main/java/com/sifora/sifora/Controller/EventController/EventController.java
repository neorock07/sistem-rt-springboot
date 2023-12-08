package com.sifora.sifora.Controller.EventController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sifora.sifora.DTO.EventDTO;
import com.sifora.sifora.Entity.Event;
import com.sifora.sifora.Repository.RepoEvent;
import com.sifora.sifora.Services.EventService.EventService;

@RequestMapping("/api/v1/events")
@RestController
public class EventController {
    
    @Autowired
    RepoEvent repo;

    @Autowired
    EventService serv;


    @PostMapping()
    public ResponseEntity<Event> create(@RequestBody EventDTO req){
        return ResponseEntity.ok(
            serv.create(req)
        );
    }

    @GetMapping
    public ResponseEntity<List<Event>> findAll(){
        return ResponseEntity.ok(serv.findAll());
    }

    @GetMapping("/recent")
    public ResponseEntity<List<Event>> getNewestEvent(){
        return ResponseEntity.ok(
            serv.findNewestEvents()
        );
    }

    @DeleteMapping
    public void delete(@RequestBody Event req){
        serv.delete(req);
        // return ResponseEntity.ok();
    }


}
