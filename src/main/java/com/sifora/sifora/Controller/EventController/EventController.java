package com.sifora.sifora.Controller.EventController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    public EventController(EventService service) {
        this.serv = service;
    }

    // @PostMapping()
    // public ResponseEntity<Event> create(@RequestBody EventDTO req){
    // return ResponseEntity.ok(
    // serv.create(req)
    // );
    // }

    // private String id;
    // // private Role role;
    // private String filename;
    // private String fileUrl;
    // private String fileType;

    // private String title;
    // private String deskripsi;
    // private String lokasi;
    // private Date date;
    // private String penyelenggara;

    @PostMapping("/upload")
    public EventDTO create(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("deskripsi") String deskripsi,
            @RequestParam("lokasi") String lokasi,
            @RequestParam("date") Date date,
            @RequestParam("penyelenggara") String penyelenggara) throws Exception {

        String fileUrl = "";
        EventDTO dto = new EventDTO(
                file.getOriginalFilename(),
                fileUrl,
                file.getContentType(),
                title,
                deskripsi,
                lokasi,
                date,
                penyelenggara);
        Event event = serv.create(dto, file);
        fileUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/events/download/")
                .path(event.getId())
                .toUriString();
        return new EventDTO(
                event.getId(),
                file.getOriginalFilename(),
                fileUrl,
                file.getContentType(),
                event.getTitle(),
                event.getDeskripsi(),
                event.getLokasi(),
                event.getDate(),
                event.getPenyelenggara());
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String id) throws Exception {
        Event event = serv.getById(id);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(event.getFileType()))
                .header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"" + event.getFileName() + "\"")
                .body(new ByteArrayResource(event.getData()));
    }

    @GetMapping
    public List<EventDTO> getAllData(@RequestParam("page") int pageIndex,
            @RequestParam("size") int pageSize) throws Exception {
        List<Event> event = serv.getAll(PageRequest.of(pageIndex, pageSize)).getContent();
        List<EventDTO> dto = new ArrayList<>();

         for (int i = 0; i < event.size(); i++) {
                dto.add(new EventDTO(
                        event.get(i).getId(),
                        event.get(i).getFileName(),
                        ServletUriComponentsBuilder
                                .fromCurrentContextPath()
                                .path("/api/v1/events/download/")
                                .path(event.get(i).getId())
                                .toUriString(),
                        event.get(i).getFileType(),
                        event.get(i).getTitle(),
                        event.get(i).getDeskripsi(),
                        event.get(i).getLokasi(),
                        event.get(i).getDate(),
                        event.get(i).getPenyelenggara()));
            }
        return dto;
    }

    @GetMapping("/recent")
    public ResponseEntity<List<Event>> getNewestEvent() {
        return ResponseEntity.ok(
                serv.findNewestEvents());
    }

    @DeleteMapping
    public void delete(@RequestBody Event req) {
        serv.delete(req);
        // return ResponseEntity.ok();
    }

}
