package sk.stuba.fei.uim.oop.assignment3.lending.data;

import lombok.Data;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Lending {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Book> lendingList;

    private Boolean lended;

    public Lending() {
        this.lendingList = new ArrayList<>();
        this.lended = false;
    }
}
