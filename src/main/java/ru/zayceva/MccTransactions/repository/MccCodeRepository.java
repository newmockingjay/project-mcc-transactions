package ru.zayceva.MccTransactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.zayceva.MccTransactions.entity.MccCode;

public interface MccCodeRepository extends JpaRepository<MccCode, Integer> {
}
