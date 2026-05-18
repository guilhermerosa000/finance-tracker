package com.guilherme.finance_tracker.repository;

import com.guilherme.finance_tracker.model.Transaction;
import com.guilherme.finance_tracker.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByType(TransactionType type);
    List<Transaction> findByCategory_Id(Long categoryId);
    List<Transaction> findByDateBetween(LocalDate start, LocalDate end);
}
