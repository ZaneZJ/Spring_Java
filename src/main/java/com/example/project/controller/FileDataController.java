package com.example.project.controller;

import com.example.project.model.FileDataWrap;
import com.example.project.service.FileDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files-data")
public class FileDataController {

    private final FileDataService fileDataService;

    @GetMapping()
    public FileDataWrap getAll() {
        return fileDataService.getAll();
    }
}
