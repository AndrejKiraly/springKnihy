package sk.stuba.fei.uim.oop.assignment3.author.data;

import lombok.Data;
import sk.stuba.fei.uim.oop.assignment3.author.web.bodies.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    @OneToMany(orphanRemoval = true)
    private List<Book> books;

    public Author(AuthorRequest authorRequest) {
        this.name = authorRequest.getName();
        this.surname = authorRequest.getSurname();
        this.books = new ArrayList<>();
    }

    public Author() {

    }
}
