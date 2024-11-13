package com.kb.merco.journal.dao.impl;

import com.kb.merco.journal.dao.BookDao;
import com.kb.merco.journal.entity.Book;
import com.kb.merco.journal.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BookDaoImpl implements BookDao {
    @Autowired
    private  BookRepository bookRepository ;

    @Override
    public Book getBooksBybookId(Long bookid) {

        return bookRepository.getBooksBybookId(bookid);
    }

    @Override
    public List<Book> getBooks() {

       return bookRepository.findAll();
    }

    @Override
    public Book updateBooksBybookId(Long bookid ,Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
}
