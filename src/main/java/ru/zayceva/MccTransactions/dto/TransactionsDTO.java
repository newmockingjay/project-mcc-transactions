package ru.zayceva.MccTransactions.dto;

import com.opencsv.bean.CsvBindByPosition;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import ru.zayceva.MccTransactions.entity.MccCode;

import java.time.LocalTime;

public class TransactionsDTO {
    //customer_id,tr_datetime,mcc_code,tr_type,amount,term_id

    @CsvBindByPosition(position = 0)
    private int customerId;

    @CsvBindByPosition(position = 1)
    private String trDatetime;
    @CsvBindByPosition(position = 2)
    private int mccCode;
    @CsvBindByPosition(position = 3)
    private int trType;
    @CsvBindByPosition(position = 4)
    private Double amount;
    @CsvBindByPosition(position = 5)
    private String termId;

    public TransactionsDTO() {
    }

    public TransactionsDTO(int customerId, String trDatetime, int mccCode, int trType, Double amount, String termId) {
        this.customerId = customerId;
        this.trDatetime = trDatetime;
        this.mccCode = mccCode;
        this.trType = trType;
        this.amount = amount;
        this.termId = termId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getTrDatetime() {
        return trDatetime;
    }

    public void setTrDatetime(String trDatetime) {
        this.trDatetime = trDatetime;
    }

    public int getMccCode() {
        return mccCode;
    }

    public void setMccCode(int mccCode) {
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

    @Override
    public String toString() {
        return "TransactionsDTO{" +
                "customerId=" + customerId +
                ", trDatetime='" + trDatetime + '\'' +
                ", mccCode=" + mccCode +
                ", trType=" + trType +
                ", amount=" + amount +
                ", termId=" + termId +
                '}';
    }
}
