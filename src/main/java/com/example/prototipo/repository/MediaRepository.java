package com.example.prototipo.repository;

import com.example.prototipo.controller.modelo.Media_;
import com.example.prototipo.repository.model.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  MediaRepository extends JpaRepository<Media, Long> {

    List<Media> findAll();
}
