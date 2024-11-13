package com.kb.merco.journal.service;

import com.kb.merco.journal.dto.BookDto;
import com.kb.merco.journal.dto.JRNLPatchDocumentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    public BookDto getBooksBybookId(Long bookid);
    public List<BookDto> getBooks();
    public BookDto updateBooksBybookId(Long bookid , List<JRNLPatchDocumentDto> jrNLPatchDocumentDto );
}
