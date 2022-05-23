package com.example.sablonabackend.model;

import javax.persistence.*;

@Entity
@Table(name = "home")
public class Home {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "home_text")
    private String HomeText;

    public Home(){
    }

    public Home(
//            Long id,
            String homeText) {
//        this.id = id;
        HomeText = homeText;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHomeText() {
        return HomeText;
    }

    public void setHomeText(String homeText) {
        HomeText = homeText;
    }
}
