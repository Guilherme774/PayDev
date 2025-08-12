package dev.paydev.paydev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.paydev.paydev.domain.transaction.Transaction;


@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
