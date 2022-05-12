package sk.stuba.fei.uim.oop.assignment3.lending.logic;

import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lending.data.Lending;
import sk.stuba.fei.uim.oop.assignment3.lending.web.bodies.LendingBookRequest;

import java.util.List;

public interface ILendingService {
    Lending create() throws NotFoundException;

    List<Lending> getAll();

    Lending getById(Long id) throws NotFoundException;

    void delete(Long id) throws NotFoundException;

    Lending addBook(Long id, LendingBookRequest request) throws NotFoundException, IllegalOperationException;

    void deleteBook(Long id, LendingBookRequest request) throws NotFoundException;

    void lend(Long id) throws NotFoundException, IllegalOperationException;
}
