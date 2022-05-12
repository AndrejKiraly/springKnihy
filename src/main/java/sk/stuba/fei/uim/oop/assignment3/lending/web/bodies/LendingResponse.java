package sk.stuba.fei.uim.oop.assignment3.lending.web.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookResponse;
import sk.stuba.fei.uim.oop.assignment3.lending.data.Lending;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class LendingResponse {
    private Long id;
    private List<BookResponse> lendingList;
    private Boolean lended;

    public LendingResponse(Lending lending) {
        this.id = lending.getId();
        this.lendingList = new ArrayList<>();
        for (Book book : lending.getLendingList()){
            this.lendingList.add(new BookResponse(book));
        }
        this.lended = lending.getLended();
    }
}
