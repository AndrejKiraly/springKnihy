package sk.stuba.fei.uim.oop.assignment3.lending.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.logic.BookService;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lending.data.Lending;
import sk.stuba.fei.uim.oop.assignment3.lending.data.LendingRepository;
import sk.stuba.fei.uim.oop.assignment3.lending.web.bodies.LendingBookRequest;

import java.util.List;

@Service
public class LendingService implements ILendingService{
    @Autowired
    LendingRepository lendingRepository;
    @Autowired
    BookService bookService;
    @Override
    public Lending create() {
        return this.lendingRepository.save(new Lending());
    }
    @Override
    public List<Lending> getAll(){
        return this.lendingRepository.findAll();
    }
    @Override
    public Lending getById(Long id) throws NotFoundException {
        Lending l = this.lendingRepository.findLendingById(id);
        if (l == null) {
            throw new NotFoundException();
        }
        return l;
    }
    @Override
    public void delete(Long id) throws NotFoundException {
        for (Book b : this.getById(id).getLendingList()){
            Book bookToEdit = this.bookService.getById(b.getId());
            bookToEdit.setLendCount(bookToEdit.getLendCount() - 1);
            this.bookService.save(b);
        }
        this.lendingRepository.delete(this.getById(id));
    }
    @Override
    public Lending addBook(Long id, LendingBookRequest request) throws NotFoundException, IllegalOperationException {
        Lending l = this.getById(id);
        Book b = this.bookService.getById(request.getId());
        if(l.getLendingList().contains(b) || l.getLended()){
            throw new IllegalOperationException();
        }
        l.getLendingList().add(b);
        this.lendingRepository.save(l);
        return l;
    }
    @Override
    public void deleteBook(Long id, LendingBookRequest request) throws NotFoundException {
        Lending l = this.getById(id);
        Book b = this.bookService.getById(request.getId());
        if(!l.getLendingList().remove(b)){
            throw new NotFoundException();
        }
    }
    @Override
    public void lend(Long id) throws NotFoundException, IllegalOperationException {
        Lending l = this.getById(id);
        if(l.getLended()){
            throw new IllegalOperationException();
        }
        l.setLended(true);
        for (Book b:l.getLendingList()){
            if(b.getAmount() > b.getLendCount()){
                b.setLendCount(b.getLendCount() + 1);
            }
        }
        this.lendingRepository.save(l);
    }
}
