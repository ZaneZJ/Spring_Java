package com.example.project.service;

import com.example.project.model.FileData;
import com.example.project.model.FileDataWrap;
import com.example.project.repository.FileDataRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class FileDataServiceTest {

    private FileDataService fileDataService;
    private FileDataRepository mockRepo;

    @BeforeEach
    void setUp() {
        mockRepo = Mockito.mock(FileDataRepository.class);
        // need to add repository
        fileDataService = new FileDataService(mockRepo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAll() {
        List<FileData> listOfFiles = List.of(
                FileData.builder().fileName("1").build()
        );
        FileDataWrap expected = new FileDataWrap(
                listOfFiles
        );
        when(mockRepo.findAll()).thenReturn(listOfFiles);
        FileDataWrap result = fileDataService.getAll();
        assertEquals(expected,result);
    }
}