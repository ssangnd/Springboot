package com.springboot.api.Springboot.models;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Objects;

//POJO
@Entity
@Table(name="tblProduct")
public class Product {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private  Long id;
//this is "primary key"
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) //auto-increment
    //you can also use "sequence"
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1 //increment by 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
)
    private Long id;
    @Column(nullable = false, unique = true, length = 300)
    private  String productName;
    private  int productYear;
    private  Double price;
    private  String url;
    public  Product() {}

    @Transient
    private int age;
    public int getAge(){
        return Calendar.getInstance().get(Calendar.YEAR)-productYear;
    }

    public Product(
//            Long id,
                   String productName, int productYear, Double price, String url) {
//        this.id = id;
        this.productName = productName;
        this.productYear = productYear;
        this.price = price;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productYear=" + productYear +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductYear() {
        return productYear;
    }

    public void setProductYear(int productYear) {
        this.productYear = productYear;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productYear == product.productYear
                && age == product.age && Objects.equals(id, product.id)
                && Objects.equals(productName, product.productName) &&
                Objects.equals(price, product.price) && Objects.equals(url, product.url);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productYear, price, url, age);
    }
}
