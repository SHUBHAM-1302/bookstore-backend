package com.kb.merco.journal.dao;

import com.kb.merco.journal.dto.BookDto;
import com.kb.merco.journal.entity.Book;

import java.util.List;

public interface BookDao {
    public Book getBooksBybookId(Long bookid);
    public List<Book> getBooks();
    public Book updateBooksBybookId(Long bookid,Book book);

    public Book createBook(Book book);
}
