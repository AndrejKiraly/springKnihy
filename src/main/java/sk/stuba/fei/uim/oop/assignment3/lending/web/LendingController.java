package sk.stuba.fei.uim.oop.assignment3.lending.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lending.logic.ILendingService;
import sk.stuba.fei.uim.oop.assignment3.lending.web.bodies.LendingBookRequest;
import sk.stuba.fei.uim.oop.assignment3.lending.web.bodies.LendingResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class LendingController {
    @Autowired
    private ILendingService service;
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LendingResponse> addLending() throws NotFoundException {
        return new ResponseEntity<>(new LendingResponse(this.service.create()), HttpStatus.CREATED);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<LendingResponse> getAllLendings() {
        return this.service.getAll().stream().map(LendingResponse::new).collect(Collectors.toList());
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public LendingResponse getLending(@PathVariable("id") Long lendingId) throws NotFoundException {
        return new LendingResponse(this.service.getById(lendingId));
    }
    @DeleteMapping(value = "/{id}")
    public void deleteLending(@PathVariable("id") Long lendingId) throws NotFoundException {
        this.service.delete(lendingId);
    }
    @PostMapping(value = "/{id}/add")
    public LendingResponse addBookToLending(@PathVariable("id") Long lendingId, @RequestBody LendingBookRequest body) throws NotFoundException, IllegalOperationException {
        return new LendingResponse(this.service.addBook(lendingId, body));
    }
    @DeleteMapping(value = "/{id}/remove")
    public void deleteBookFromLending(@PathVariable("id") Long lendingId, @RequestBody LendingBookRequest body) throws NotFoundException {
        this.service.deleteBook(lendingId, body);
    }
    @GetMapping(value = "/{id}/lend")
    public void rentAllBooksFromLending(@PathVariable("id") Long lendingId) throws NotFoundException, IllegalOperationException {
        this.service.lend(lendingId);
    }
}
