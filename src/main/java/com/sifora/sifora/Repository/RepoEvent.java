package com.sifora.sifora.Repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sifora.sifora.Entity.Event;

@Repository
public interface RepoEvent extends JpaRepository<Event,String> {

    public List<Event> findByDateGreaterThanEqual(Date date);
}
