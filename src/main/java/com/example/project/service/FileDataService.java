package com.example.project.service;

import com.example.project.exception.SdaException;
import com.example.project.model.FileData;
import com.example.project.model.FileDataWrap;
import com.example.project.repository.FileDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileDataService {

    private final FileDataRepository fileDataRepository;

    public FileDataWrap getAll() {
        return new FileDataWrap(fileDataRepository.findAll());
    }

    public FileData getById(String fileId) {
        return fileDataRepository
                .findById(fileId)
                .orElseThrow(
                        ()->new SdaException("No such file!")
                );
    }

    public FileData save(FileData fileData) {
        return fileDataRepository.save(fileData);
    }
}
