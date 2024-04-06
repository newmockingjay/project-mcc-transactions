package ru.zayceva.MccTransactions;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.zayceva.MccTransactions.dto.TransactionsDTO;
import ru.zayceva.MccTransactions.entity.MccCode;
import ru.zayceva.MccTransactions.repository.MccCodeRepository;
import ru.zayceva.MccTransactions.service.MccService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@SpringBootApplication
public class MccTransactionsApplication {

    public static void main(String[] args) throws Exception {
		SpringApplication.run(MccTransactionsApplication.class, args);
	}

}
