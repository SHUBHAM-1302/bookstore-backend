package com.kb.merco.journal.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatchException;
import com.kb.merco.journal.dao.BookDao;
import com.kb.merco.journal.dto.BookDto;
import com.kb.merco.journal.dto.JRNLPatchDocumentDto;
import com.kb.merco.journal.entity.Book;
import com.kb.merco.journal.exception.InvalidRequestException;
import com.kb.merco.journal.exception.RecordNotFoundException;
import com.kb.merco.journal.service.BookService;
import com.kb.merco.journal.service.patch.JsonPatchMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class BookServiceImpl implements BookService {

@Autowired
BookDao bookDao ;
    @Autowired
    private JsonPatchMapper<BookDto, JRNLPatchDocumentDto> patchMapper;
    @Override
    public BookDto getBooksBybookId(Long bookid) {
        return transferBookDtoToEntity(bookDao.getBooksBybookId(bookid));
    }

    private BookDto transferBookDtoToEntity(Book book){
        BookDto bookDto = new BookDto();
        bookDto.setBookId(book.getBookId());
        bookDto.setAuther(book.getAuther());
        bookDto.setRate(book.getRate());
        //bookDto.setPrice(book.getPrice());
        bookDto.setDescription(book.getDescription());
        bookDto.setTitle(book.getTitle());
        bookDto.setIsSold(book.getSold());

     return bookDto;
    }

    private Book transferBookEntityToDto(BookDto bookDto) {
        Book book = new Book();
        book.setBookId(bookDto.getBookId());
        book.setAuther(bookDto.getAuther());
        book.setRate(bookDto.getRate());
        //book.setPrice(bookDto.getPrice());
        book.setDescription(bookDto.getDescription());
        book.setTitle(bookDto.getTitle());
        book.setSold(bookDto.getIsSold());
        return book;
    }

    private List<BookDto> transferBookDtosToEntitys( List<Book> books){
        List<BookDto>  bookDto = new ArrayList<>();
       for (Book book : books){
           bookDto.add(transferBookDtoToEntity(bookDao.getBooksBybookId(book.getBookId())));
       }
        return bookDto;
    }
    @Override
    public List<BookDto> getBooks() {
        return  transferBookDtosToEntitys(bookDao.getBooks());
    }

    @Override
    public BookDto updateBooksBybookId(Long bookid , List<JRNLPatchDocumentDto> jrNLPatchDocumentDto) {
        BookDto bookDto = new BookDto();
        BookDto updateBookDto = new BookDto();
        Book book = bookDao.getBooksBybookId(bookid);
        if (Objects.isNull(book)) {
            throw new RecordNotFoundException(" The book data was not found for the given voucherId : " , HttpStatus.NOT_FOUND, " The book data was not found for the given voucherId , so Please Provide valid id ");
        }
        try {
            updateBookDto = transferBookDtoToEntity(book);
            for (JRNLPatchDocumentDto jrnlPatchDocumentDto : jrNLPatchDocumentDto) {
                updateBookDto = patchMapper.replace(updateBookDto, jrnlPatchDocumentDto, BookDto.class);
            }
        } catch (JsonPatchException e) {
            throw new InvalidRequestException("JsonPatchException at update  update book for id  : ", HttpStatus.BAD_REQUEST, " Give a valid request");
        } catch (JsonProcessingException e) {
            throw new InvalidRequestException("JsonProcessingException at update  update book for id : ", HttpStatus.BAD_REQUEST, " Give a valid request");
        } catch (OptimisticLockingFailureException e) {
            throw new InvalidRequestException("OptimisticLockingFailureException at update book for id : ", HttpStatus.BAD_REQUEST, " Give a valid request");
        }
      bookDao.updateBooksBybookId(bookid ,transferBookEntityToDto(updateBookDto));
        return getBooksBybookId(bookid);
    }

    @PostConstruct
    public void onInit(){
        if(CollectionUtils.isEmpty(bookDao.getBooks())) {
            bookDao.createBook(Book.builder()
                    .title("The Journey of Code")
                    .auther("John Doe")
                    .description("A deep dive into the world of programming.")
                    .price("$29.99")
                    .rate(29.99)
                    .sold(false)
                    .build());
            bookDao.createBook(Book.builder()
                    .title("Unlocking the Mind")
                    .auther("Jane Smith")
                    .description("Exploring the potential of human psychology and mental strength.")
                    .price("$19.95")
                    .rate(19.95)
                    .sold(false)
                    .build());
            bookDao.createBook(Book.builder()
                    .title("The World of AI")
                    .auther("Alex Harris")
                    .description("An introduction to artificial intelligence and its future.")
                    .price("$59.99")
                    .rate(59.99)
                    .sold(false)
                    .build());
            bookDao.createBook(Book.builder()
                    .title("Adventure Awaits")
                    .auther("Emily Carter")
                    .description("A thrilling novel filled with mystery and adventure.")
                    .price("$14.99")
                    .rate(14.99)
                    .sold(false)
                    .build());


        }
    }


}
