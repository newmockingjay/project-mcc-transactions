package ru.zayceva.MccTransactions.entity;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "MccCode")
public class MccCode {
    @Id
    @Column(name = "mcc_code")
    @CsvBindByPosition(position = 0)
    private int mccCode;

    @Column(name = "mcc_description")
    @CsvBindByPosition(position = 1)
    private String mccDescription;

    @OneToMany(mappedBy = "mccCode")
    private List<Transaction> transactions;

    public MccCode() {
    }

    public MccCode(int mccCode, String mccDescription) {
        this.mccCode = mccCode;
        this.mccDescription = mccDescription;
    }

    public int getMccCode() {
        return mccCode;
    }

    public void setMccCode(int mccCode) {
        this.mccCode = mccCode;
    }

    public String getMccDescription() {
        return mccDescription;
    }

    public void setMccDescription(String mccDescription) {
        this.mccDescription = mccDescription;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
