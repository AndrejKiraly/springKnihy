package sk.stuba.fei.uim.oop.assignment3.author.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.data.AuthorRepository;
import sk.stuba.fei.uim.oop.assignment3.author.web.bodies.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

@Service
public class AuthorService implements IAuthorService{
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public Author create(AuthorRequest request){
        return this.authorRepository.save(new Author(request));
    }
    @Override
    public List<Author> getAll(){
        return this.authorRepository.findAll();
    }
    @Override
    public Author getById(Long id) throws NotFoundException {
        Author p = this.authorRepository.findAuthorById(id);
        if (p == null) {
            throw new NotFoundException();
        }
        return p;
    }
    @Override
    public void delete(Long id) throws NotFoundException {
        this.authorRepository.delete(this.getById(id));
    }
    @Override
    public Author update(Long id, AuthorRequest request) throws NotFoundException {
        Author a = this.getById(id);
        if (request.getName() != null) {
            a.setName(request.getName());
        }
        if (request.getSurname() != null) {
            a.setSurname(request.getSurname());
        }
        return this.authorRepository.save(a);
    }
    @Override
    public void save(Author author){
        this.authorRepository.save(author);
    }
}
