package sk.stuba.fei.uim.oop.assignment3.book.data;

import lombok.Data;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;

import javax.persistence.*;
@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    private Author author;

    private Integer pages;

    private Integer amount;

    private Integer lendCount;

    public Book(BookRequest bookRequest, Author author) {
        this.name = bookRequest.getName();
        this.description = bookRequest.getDescription();
        this.author = author;
        this.pages = bookRequest.getPages();
        this.amount = bookRequest.getAmount();
        this.lendCount = bookRequest.getLendCount();
    }

    public Book() {

    }
}
