package com.example.project.controller;

import com.example.project.model.FileData;
import com.example.project.model.FileDataWrap;
import com.example.project.service.FileDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    PUT /api/files-data/{id} - updates an existing FileData object stored in the database.
//    Returns status * 204 * (or throws SdaException when no object with the given id exists).

    @PutMapping("/{id}")
    public FileData update (@PathVariable("id") String fileId,
                            @RequestBody FileData fileData) {
        return fileDataService.update(fileId, fileData);
    }

//    DELETE /api/files-data/{id} - removes an existing FileData object stored in the database.
//    Returns status * 204 * (or throws SdaException when no object with the given id exists).

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable("id") String fileId) {
        try {
            fileDataService.delete(fileId);
        } catch (EmptyResultDataAccessException ex) {
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .body("No file data with provided id found!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

//    OR:

    @DeleteMapping("/test/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTest(@PathVariable final String id) {
        fileDataService.delete(id);
    }

}
