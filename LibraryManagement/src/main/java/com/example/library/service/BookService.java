package com.example.library.service;

import com.example.library.Repository.BookRepository;
import com.example.library.dto.BookDto;
import com.example.library.dto.IssueDto;
import com.example.library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    IssueService issueService;

    public Book fetchBookDetails(int id) throws Exception{
        return bookRepo.findById(id).get();
    }

    public boolean addNewBook(BookDto bookDto) {
        Book bk=new Book();
        bk.setBookName(bookDto.getBookName());
        bk.setAuthor(bookDto.getAuthor());
        bk.setCategory(bookDto.getCategory());
        bk.setEdition(bookDto.getEdition());
        bk.setSerialNo(bookDto.getSerialNo());
        bk.setAvailable(true);
        Book bkNew=bookRepo.save(bk);
        return bkNew != null ? true : false;
    }

    public List<Book> findBooksBasedOnCategory(String category){
        List<Book> bk=bookRepo.findByCategory(category);
        return bk;
    }

    public int findBookIdByName(String name){
        int id=bookRepo.findByName(name);
        return id;
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

//    public boolean bookABook(BookDto bookDto) {
//        int studentId=bookDto.getStudentId();
//        IssueDto issueDto=new IssueDto(0,bookDto.getBookId(),studentId,null,null,null);
//        bookRepo.setAvailable(bookDto.getId(),false);
//        boolean setAv= issueService.addIssueRecord(issueDto);
//        if(setAv)
//            return true;
//        else
//            return false;
//    }

//    public boolean returnBook(BookDto bookDto) {
//        IssueDto issueDto=new IssueDto(bookDto.getStudentId(),bookDto.getId());
//        if(issueService.setReturnDate(issueDto)){
//            bookRepo.setAvailable(bookDto.getId(),true);
//        }
//        return true;
//    }

    public boolean removeBook(BookDto bookDto) {
        String bookName=bookDto.getBookName();
        System.out.println(bookName);
        Book bk=bookRepo.findByBookName(bookName);
        int id=bk.getId();
        bookRepo.setAvailable(id,false);
        bk=bookRepo.findByBookName(bookName);
        if(!bk.isAvailable())
            return true;
        else
            return false;
    }


}
