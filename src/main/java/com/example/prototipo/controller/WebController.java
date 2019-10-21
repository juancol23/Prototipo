package com.example.prototipo.controller;

import com.example.prototipo.controller.modelo.Media_;
import com.example.prototipo.repository.MediaRepository;
import com.example.prototipo.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/web")
public class WebController {

    @Autowired
    private UploadFileService uploadFileService;

    @Autowired
    MediaRepository mediaRepository;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/listarMedia", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public List<com.example.prototipo.repository.model.Media> saveLog() {
        List<com.example.prototipo.repository.model.Media> response = new ArrayList<>();
        try {

            List<com.example.prototipo.repository.model.Media> media = mediaRepository.findAll();
            response.addAll(media);
            /*response.add(new Media(
                    "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Medios_de_comunicaci%C3%B3n.jpg/1200px-Medios_de_comunicaci%C3%B3n.jpg",
                    "Título del Imagen",
                    "orem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididu"));
            response.add(new Media(
                    "https://www.youtube.com/watch?v=k977K6EVuwE&t=91s",
                    "Título del Video",
                    "orem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididu"));
            response.add(new Media(
                    "https://media.giphy.com/media/13gvXfEVlxQjDO/giphy.gif",
                    "Título del Gif",
                    "orem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididu"));
*/
        } catch (Exception e) {
            System.out.println("Error listarMedia Controller "+e);
        }

        return response;
    }

    @CrossOrigin(origins = "*")
   @RequestMapping(value = "/uploadMedia", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    //@RequestMapping(value = "/updaloadI", method = RequestMethod.POST, consumes = "multipart/form-data" ,
         //   produces = { "application/json", "application/xml" })
    public Media_ uploadData(@RequestBody Media_ media_) {
        Media_ response = new Media_();
        try {
            response.setFile(media_.getFile());
            response.setDescripcion(media_.getDescripcion());
            response.setTitulo(media_.getTitulo());

            com.example.prototipo.repository.model.Media media = new com.example.prototipo.repository.model.Media();
            media.setImage("file");
            media.setDescripcion(media_.getDescripcion());
            media.setTitulo(media_.getTitulo());
            mediaRepository.save(media);
/*
            if (file == null) {
                throw new RuntimeException("You must select the a file for uploading");
            }
            uploadFileService.saveFile(file);*/

        } catch (Exception e) {
            System.out.println("Error uploadData Controller "+e);
        }
        System.out.println("uploadData "+response);

        return response;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) throws Exception {
        if (file == null) {
            throw new RuntimeException("You must select the a file for uploading");
        }

        InputStream inputStream = file.getInputStream();
        String originalName = file.getOriginalFilename();
        String name = file.getName();
        String contentType = file.getContentType();
        long size = file.getSize();
        System.out.println("inputStream: " + inputStream);
        System.out.println("originalName: " + originalName);
        System.out.println("name: " + name);
        System.out.println("contentType: " + contentType);
        System.out.println("size: " + size);
        // Do processing with uploaded file data in Service layer
        return new ResponseEntity<String>(originalName, HttpStatus.OK);
    }




}
