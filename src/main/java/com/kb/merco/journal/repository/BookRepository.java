package com.kb.merco.journal.repository;


import com.kb.merco.journal.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM Book sb WHERE sb.book_id= :bookid ;", nativeQuery = true)
    public Book getBooksBybookId(Long bookid);


}
