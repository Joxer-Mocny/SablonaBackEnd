package com.example.sablonabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "about")
public class About {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "aboutText")
    private String AboutText;

    public About(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public About(Long id, String aboutText) {
        this.id = id;
        AboutText = aboutText;
    }


    public String getAboutText() {
        return AboutText;
    }

    public void setAboutText(String aboutText) {
        AboutText = aboutText;
    }
}
