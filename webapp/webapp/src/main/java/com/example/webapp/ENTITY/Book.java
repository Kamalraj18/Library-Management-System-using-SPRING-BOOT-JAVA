package com.example.webapp.ENTITY;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)    
private Long id;
//@Column(name="title",nullable = false)
private String title;
//@Column(name="author",nullable = false)
private String author;





public Book() {
}


public Book(String title, String author) {
    //this.id = id;
    this.title = title;
    this.author = author;
}
public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getTitle() {
    return title;
}
public void setTitle(String title) {
    this.title = title;
}
public String getAuthor() {
    return author;
}
public void setAuthor(String author) {
    this.author = author;
}



}

