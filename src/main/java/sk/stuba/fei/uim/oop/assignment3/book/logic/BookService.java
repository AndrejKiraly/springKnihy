package sk.stuba.fei.uim.oop.assignment3.book.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.logic.IAuthorService;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.data.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookAmount;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookUpdate;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    IAuthorService iAuthorService;
    @Override
    public Book create(BookRequest request) throws NotFoundException {
        Author author = this.iAuthorService.getById(request.getAuthor());
        Book book =  this.bookRepository.save(new Book(request,author));
        author.getBooks().add(book);
        this.iAuthorService.save(author);
        return book;
    }
    @Override
    public List<Book> getAll(){
        return this.bookRepository.findAll();
    }
    @Override
    public Book getById(Long id) throws NotFoundException {
        Book b = this.bookRepository.findBookById(id);
        if (b == null) {
            throw new NotFoundException();
        }
        return b;
    }
    @Override
    public void delete(Long id) throws NotFoundException {
        Author author = this.iAuthorService.getById(this.getById(id).getAuthor().getId());
        author.getBooks().remove(this.getById(id));
        this.iAuthorService.save(author);
        this.bookRepository.delete(this.getById(id));
    }
    @Override
    public Book update(Long id, BookUpdate update) throws NotFoundException {
        Book b = this.getById(id);
        if (update.getName() != null) {
            b.setName(update.getName());
        }
        if (update.getDescription() != null) {
            b.setDescription(update.getDescription());
        }
        if (update.getPages() != null && update.getPages() != 0) {
            b.setPages(update.getPages());
        }
        if (update.getAuthor() != null && update.getAuthor() != 0) {
            Author author = this.iAuthorService.getById(update.getAuthor());
            b.setAuthor(author);
        }
        return this.bookRepository.save(b);
    }
    @Override
    public Integer getAmount(Long id) throws NotFoundException {
        return this.getById(id).getAmount();
    }
    @Override
    public Integer increaseAmount(Long id, BookAmount request) throws NotFoundException {
        Book book = this.getById(id);
        book.setAmount(book.getAmount() + request.getAmount());
        this.bookRepository.save(book);
        return book.getAmount();
    }
    @Override
    public Integer getLendCount(Long id) throws NotFoundException {
        return this.getById(id).getLendCount();
    }
    @Override
    public void save(Book book){
        this.bookRepository.save(book);
    }
}
