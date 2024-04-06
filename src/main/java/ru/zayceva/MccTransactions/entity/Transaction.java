package ru.zayceva.MccTransactions.entity;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "Transaction")
public class Transaction {
    @Id
    @SequenceGenerator(name = "sequence_id_auto_gen", allocationSize = 1000)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_id_auto_gen")
    @Column(name = "id")
    private int id;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "tr_day")
    private int trDay;

    @Column(name = "tr_time")
    private String trTime;

    @ManyToOne()
    @JoinColumn(name = "mcc_code")
    private MccCode mccCode;

    @Column(name = "tr_type")
    private int trType;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "term_id")
    private String termId;

    public Transaction() {
    }


    public Transaction(int customerId, int trDay, String trTime, MccCode mccCode, int trType, Double amount, String termId) {
        this.customerId = customerId;
        this.trDay = trDay;
        this.trTime = trTime;
        this.mccCode = mccCode;
        this.trType = trType;
        this.amount = amount;
        this.termId = termId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getTrDay() {
        return trDay;
    }

    public void setTrDay(int trDay) {
        this.trDay = trDay;
    }

    public String getTrTime() {
        return trTime;
    }

    public void setTrTime(String trTime) {
        this.trTime = trTime;
    }

    public MccCode getMccCode() {
        return mccCode;
    }

    public void setMccCode(MccCode mccCode) {
        this.mccCode = mccCode;
    }

    public int getTrType() {
        return trType;
    }

    public void setTrType(int trType) {
        this.trType = trType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }
}
