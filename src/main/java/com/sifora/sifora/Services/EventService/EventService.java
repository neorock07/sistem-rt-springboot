package com.sifora.sifora.Services.EventService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sifora.sifora.DTO.EventDTO;
import com.sifora.sifora.Entity.Event;
import com.sifora.sifora.Repository.RepoEvent;

@Service
public class EventService implements EventServiceInterface{

    @Autowired
    RepoEvent repo;

    EventService(RepoEvent repo){
        this.repo = repo;
    }

    public Event create(EventDTO req, MultipartFile file) throws Exception {
        // String fileUrl = "";
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new IllegalArgumentException("Filename contains invalid path " + fileName);
            }
            Event event = new Event();
            event.setTitle(req.getTitle());
            event.setDeskripsi(req.getDeskripsi());
            event.setLokasi(req.getLokasi());
            event.setDate(req.getDate());
            event.setPenyelenggara(req.getPenyelenggara());
            event.setFileName(fileName);
            event.setFileType(file.getContentType());
            event.setData(file.getBytes());
            return repo.save(event);
        } catch (Exception e) {
            throw new Exception("Tidak dapat menyimpan file ", e);
        }

    }

    // public List<Event> findAll() {
    //     var data = repo.findAll();
    //     List<EventDTO> response = new ArrayList<>();

    //     return repo.findAll();
    // }

    public Event getById(String id) throws Exception{
        return repo.findById(id)
                    .orElseThrow(() -> new Exception("File tidak ditemukan"));
    }

    public List<Event> findNewestEvents() {
        Long before = System.currentTimeMillis() - (3 * 24 * 60 * 60 * 1000);
        Date beforeday = new Date(before);
        return repo.findByDateGreaterThanEqual(beforeday);
    }

    public void delete(Event req) {
        // Event req = new Event();
        // req = repo.findById(id).isPresent() ? repo.findById(id).get() :
        // repo.findById(id).orElseThrow();
        repo.delete(req);
    }

    @Override
    public Page<Event> getAll(Pageable page) {
        return repo.findAll(page);
    }

}
