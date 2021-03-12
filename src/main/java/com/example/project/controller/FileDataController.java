package com.example.project.controller;

import com.example.project.model.FileData;
import com.example.project.model.FileDataWrap;
import com.example.project.service.FileDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files-data")
public class FileDataController {

    private final FileDataService fileDataService;

//    GET /api/files-data - returns all FileData objects from the database as a JSON object (not a list)

    @GetMapping()
    public FileDataWrap getAll() {
        return fileDataService.getAll();
    }

//    GET /api/files-data/{id} - returns a FileData object with a specific identifier
//    (or throws an exception SdaException)

    @GetMapping("/{id}")
    public FileData getById(@PathVariable("id") String fileId) {
        return fileDataService.getById(fileId);
    }

//    POST /api/files-data - creates a FileData object and writes it to the database.
//    Returns the status 201 and in the Location header, the URI to get it.

    @PostMapping()
    public ResponseEntity<FileData> create(@RequestBody FileData fileData) {
        FileData savedFileData = fileDataService.save(fileData);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .location(URI.create("localhost:8080/api/files-data/" + savedFileData.getId()))
                .body(savedFileData);
    }

}
