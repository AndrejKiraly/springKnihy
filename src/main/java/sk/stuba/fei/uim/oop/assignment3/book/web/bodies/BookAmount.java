package sk.stuba.fei.uim.oop.assignment3.book.web.bodies;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BookAmount {
    private Integer amount;

    public BookAmount(Integer amount) {
        this.amount = amount;
    }
}
