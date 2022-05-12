package sk.stuba.fei.uim.oop.assignment3.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.logic.IBookService;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookAmount;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookResponse;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookUpdate;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService service;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest body) throws NotFoundException {
        return new ResponseEntity<>(new BookResponse(this.service.create(body)), HttpStatus.CREATED);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookResponse> getAllBooks() {
        return this.service.getAll().stream().map(BookResponse::new).collect(Collectors.toList());
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookResponse getBook(@PathVariable("id") Long bookId) throws NotFoundException {
        return new BookResponse(this.service.getById(bookId));
    }
    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable("id") Long bookId) throws NotFoundException {
        this.service.delete(bookId);
    }
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookResponse updateBook(@PathVariable("id") Long bookId, @RequestBody BookUpdate body) throws NotFoundException {
        return new BookResponse(this.service.update(bookId, body));
    }
    @GetMapping(value = "/{id}/amount", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookAmount getAmount(@PathVariable("id") Long bookId) throws NotFoundException {
        return new BookAmount(this.service.getAmount(bookId));
    }
    @PostMapping(value = "/{id}/amount", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookAmount increaseAmount(@PathVariable("id") Long bookId, @RequestBody HashMap<String, Object> body) throws NotFoundException {
        return new BookAmount(this.service.increaseAmount(bookId, new BookAmount(Integer.parseInt(body.get("amount").toString()))));
    }
    @GetMapping(value = "/{id}/lendCount", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookAmount getBookLendCount(@PathVariable("id") Long bookId) throws NotFoundException {
        return new BookAmount(this.service.getLendCount(bookId));
    }


}
