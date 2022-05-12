package sk.stuba.fei.uim.oop.assignment3.book.logic;

import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookAmount;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookUpdate;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface IBookService {
    Book create(BookRequest request) throws NotFoundException;

    List<Book> getAll();

    Book getById(Long id) throws NotFoundException;

    void delete(Long id) throws NotFoundException;

    Book update(Long id, BookUpdate update) throws NotFoundException;

    Integer getAmount(Long id) throws NotFoundException;

    Integer increaseAmount(Long id, BookAmount request) throws NotFoundException;

    Integer getLendCount(Long id) throws NotFoundException;

    void save(Book book);
}
