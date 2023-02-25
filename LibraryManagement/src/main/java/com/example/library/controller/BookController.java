package com.example.library.controller;

import com.example.library.dto.BookDto;
import com.example.library.entity.Book;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getAll")
    public List<Book> getAllBooks() throws Exception{
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Book fetchBookDetails(int id)throws Exception{
        return bookService.fetchBookDetails(id);
    }

    @PostMapping("/addBook")
    public boolean addNewBook(@RequestBody BookDto bookDto)throws Exception{
        boolean b=bookService.addNewBook(bookDto);
        if(b){
            return true;
        }
        else {
            return false;
        }
    }

    @GetMapping("/getAllOfCategory")
    public List<Book> getAllBooksOfCategory(@RequestParam String category){
        return bookService.findBooksBasedOnCategory(category);
    }

    @PostMapping("/removeBook")
    public boolean removeBook(@RequestBody BookDto bookDto)throws Exception{
        return bookService.removeBook(bookDto);
    }
}
