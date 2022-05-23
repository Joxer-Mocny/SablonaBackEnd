package com.example.sablonabackend.model;



import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String Title;
    @Column(name = "product_text")
    private String ProductText;

    public Product(){

    }

    public Product(
//            Long id,
                   String title, String productText) {
//        this.id = id;
        Title = title;
        ProductText = productText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getProductText() {
        return ProductText;
    }

    public void setProductText(String productText) {
        ProductText = productText;
    }
}
