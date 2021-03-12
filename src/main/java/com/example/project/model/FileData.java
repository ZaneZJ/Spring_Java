package com.example.project.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FileData {

    @Id
    @GeneratedValue(generator = "vvid2")
    @GenericGenerator(name = "vvid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String fileName;
    private String extension;
    private long sizeInKb;
    private String content;

}
