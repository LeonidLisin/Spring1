package com.geekbrains.geekspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file")
    private String imageFilename;

    @OneToOne(mappedBy = "image")
    Student student;

    public String getImageFilename() {
        return imageFilename;
    }
}
