package com.example.library.Repository;

import com.example.library.entity.Book;
import com.example.library.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface IssueRepository extends JpaRepository<Issue,Integer> {

    Optional<Issue> findById(int id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update issue set return_date=?3 where book_id=?1 and student_id=?2")
    void setReturnDate(int bookId, int studentId, String returnDate);

    @Query(nativeQuery = true,value = "select * from issue where student_id=?1 order by id asc")
    List<Issue> findByStudent(int studentId);

    @Query(nativeQuery = true,value = "select * from issue where student_id=?1 and return_date is null")
    List<Issue> findByStudentId(int id);
}
