package sk.stuba.fei.uim.oop.assignment3.author.logic;


import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.web.bodies.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface IAuthorService {
    Author create(AuthorRequest request);

    List<Author> getAll();

    Author getById(Long id) throws NotFoundException;

    void delete(Long id) throws NotFoundException;

    Author update(Long id, AuthorRequest request) throws NotFoundException;

    void save(Author author);
}
