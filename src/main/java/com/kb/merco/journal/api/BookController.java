package com.kb.merco.journal.api;

import com.kb.merco.journal.dto.BookDto;
import com.kb.merco.journal.dto.JRNLMultiplePatchRequestDto;
import com.kb.merco.journal.dto.JRNLPatchDocumentDto;
import com.kb.merco.journal.service.BookService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Api(tags = "BookStore")
public class BookController implements BookStoreApi{
@Autowired
private BookService bookService;
    @Override
    public ResponseEntity<BookDto> getBooksBybookId(Long bookid) throws Exception {
        return new ResponseEntity<>(bookService.getBooksBybookId(bookid), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<List<BookDto>> getBooks() throws Exception {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BookDto> updateBook(Long bookid, List<JRNLPatchDocumentDto> jrNLPatchDocumentDto) throws Exception {
        return new ResponseEntity<>(bookService.updateBooksBybookId(bookid,jrNLPatchDocumentDto), HttpStatus.OK);
    }
}
