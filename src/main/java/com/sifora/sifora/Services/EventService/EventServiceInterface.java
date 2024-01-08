package com.sifora.sifora.Services.EventService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import com.sifora.sifora.DTO.EventDTO;
import com.sifora.sifora.Entity.Event;

public interface EventServiceInterface {
 public Event create(EventDTO req, MultipartFile file) throws Exception;
 public Event getById(String id) throws Exception;   
 public Page<Event> getAll(Pageable page);   

}
