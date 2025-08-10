package dev.paydev.paydev.repository.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.paydev.paydev.domain.transaction.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
