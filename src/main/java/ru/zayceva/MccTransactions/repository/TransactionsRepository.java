package ru.zayceva.MccTransactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.zayceva.MccTransactions.entity.Transaction;

public interface TransactionsRepository extends JpaRepository<Transaction, Integer> {
    @Modifying
    @Transactional
    @Query(value = "ALTER SEQUENCE sequence_id_auto_gen RESTART WITH 1", nativeQuery = true)
    void resetAutoIncrement();
}
