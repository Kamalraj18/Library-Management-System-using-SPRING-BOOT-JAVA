package com.example.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webapp.ENTITY.Book;

public interface bookrepository extends JpaRepository<Book,Long>{

}
