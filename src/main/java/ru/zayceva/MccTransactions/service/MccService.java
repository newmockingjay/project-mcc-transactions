package ru.zayceva.MccTransactions.service;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.zayceva.MccTransactions.entity.MccCode;
import ru.zayceva.MccTransactions.repository.MccCodeRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Service
public class MccService {
    private final MccCodeRepository mccCodeRepository;

    @Autowired
    public MccService(MccCodeRepository mccCodeRepository) {
        this.mccCodeRepository = mccCodeRepository;
    }

    @Transactional
    public void save() throws FileNotFoundException {
        FileReader reader = new FileReader("src/main/resources/tr_mcc_codes.csv");
        CsvToBean<MccCode> csvToBean = new CsvToBeanBuilder<MccCode>(reader)
                .withType(MccCode.class)
                .withSeparator(';')
                .withIgnoreLeadingWhiteSpace(true)
                .withSkipLines(1) // Пропускаем первую строку (заголовок)
                .build();

        List<MccCode> list = csvToBean.parse();
        mccCodeRepository.saveAll(list);
    }
}
