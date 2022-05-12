package sk.stuba.fei.uim.oop.assignment3.lending.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LendingRepository extends JpaRepository<Lending, Long> {
    Lending findLendingById(Long id);
}
