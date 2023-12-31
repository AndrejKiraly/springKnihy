package sk.stuba.fei.uim.oop.assignment3.author.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findAuthorById(Long id);
}
