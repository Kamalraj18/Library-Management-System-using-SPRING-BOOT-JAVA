package com.example.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.service.annotation.DeleteExchange;

//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.example.webapp.ENTITY.Book;
import com.example.webapp.repository.bookrepository;

@Controller
@RequestMapping("/books")
public class Bookcontroller {
@Autowired
    private bookrepository brepository;

    @GetMapping
    public String getAllbooks(Model model){
        List<Book> books = brepository.findAll();
        model.addAttribute("Books", books);
        return "books";
    }
    
    @GetMapping("/details/{id}")
    public String getBookbyid(@PathVariable Long id , Model model){
        Book book = brepository.findById(id).orElse(null);
        model.addAttribute("book", book);
        return "bookDetails";
    }

    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("newBook", new Book());
        return "addBook";
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book newBook){
        brepository.save(newBook);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBookForm(@PathVariable Long id, Model model){
        Book book = brepository.findById(id).orElse(null);
        model.addAttribute("Book", book);
        return "editBook";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, @ModelAttribute("Book") Book updateBook, Model model){
        Book existingBook = brepository.findById(id).orElse(null);
        if(existingBook !=null){
            existingBook.setTitle(updateBook.getTitle());
            existingBook.setAuthor(updateBook.getAuthor());
            brepository.save(existingBook);
        }
        return "redirect:/books";
    }

    @GetMapping("/delete")
    public String DeleteForm(Model model){
        model.addAttribute("id", new Book());
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteProduct(@ModelAttribute Book book, Model model) {
        Long id = book.getId();
        if(brepository.existsById(id)){
            brepository.deleteById(id);
            model.addAttribute("message","deleted succesfully");
        }
        else{
            model.addAttribute("message","not found");
        }
        return "redirect:/books";
    
        // Rest of the method logic
    }

}
