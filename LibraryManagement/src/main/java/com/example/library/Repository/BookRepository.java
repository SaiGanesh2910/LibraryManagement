package com.example.library.Repository;

import com.example.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Optional<Book> findById(int id);

    @Query(nativeQuery = true,value = "select * from book where category=?1")
    List<Book> findByCategory(String category);

    @Query(nativeQuery = true,value = "select id from book where book_name=?1")
    int findByName(String name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update book set is_available=?2 where id=?1")
    void setAvailable(int id,boolean b);

    @Query(nativeQuery = true,value = "select * from book where book_name=?1")
    Book findByBookName(String bookName);
}
