package ru.zayceva.MccTransactions.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zayceva.MccTransactions.dto.TransactionsDTO;
import ru.zayceva.MccTransactions.entity.Transaction;
import ru.zayceva.MccTransactions.repository.MccCodeRepository;
import ru.zayceva.MccTransactions.repository.TransactionsRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class FileService {
    private final TransactionsRepository transactionsRepository;
    private final MccCodeRepository mccCodeRepository;

    @Autowired
    public FileService(TransactionsRepository transactionsRepository, MccCodeRepository mccCodeRepository) {
        this.transactionsRepository = transactionsRepository;
        this.mccCodeRepository = mccCodeRepository;
    }

    public void save(InputStream file) throws Exception {
        System.out.println("start");
        BufferedReader reader = new BufferedReader(new InputStreamReader(file));

        CsvToBean<TransactionsDTO> csvToBean = new CsvToBeanBuilder<TransactionsDTO>(reader)
                .withType(TransactionsDTO.class)
                .withIgnoreLeadingWhiteSpace(true)
                .withSkipLines(1) // Пропускаем первую строку (заголовок)
                .build();

        transactionsRepository.deleteAllInBatch();
        transactionsRepository.resetAutoIncrement();
        System.out.println("deleted");
        convertToTransactions(csvToBean.parse());
    }

    @Transactional
    public void convertToTransactions(List<TransactionsDTO> list) throws Exception {

        List<Transaction> transactions = new ArrayList<>();

        for (TransactionsDTO tr : list){
            Transaction transaction = new Transaction(
                tr.getCustomerId(),
                    Integer.valueOf(tr.getTrDatetime().split(" ")[0]),
                    tr.getTrDatetime().split(" ")[1],
                    mccCodeRepository.getById(tr.getMccCode()),
                    tr.getTrType(),
                    tr.getAmount(),
                    tr.getTermId()
            );
            transactions.add(transaction);
        }

        System.out.println("start saving");
        transactionsRepository.saveAll(transactions);
        System.out.println("Finish");
    }

}
