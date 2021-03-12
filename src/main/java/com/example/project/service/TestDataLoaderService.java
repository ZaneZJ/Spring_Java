package com.example.project.service;

import com.example.project.model.FileData;
import com.example.project.repository.FileDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestDataLoaderService implements CommandLineRunner {

    private final FileDataRepository fileDataRepository;

    @Override
    public void run(String... args) throws Exception {

        fileDataRepository.saveAll(
                List.of(
                        FileData.builder().fileName("First").build(),
                        FileData.builder().fileName("Second").build(),
                        FileData.builder().fileName("Third").build()
                )
        );

    }

}
