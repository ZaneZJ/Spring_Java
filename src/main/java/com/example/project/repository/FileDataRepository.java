package com.example.project.repository;

import com.example.project.model.FileData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDataRepository extends JpaRepository<FileData,String> {

}
