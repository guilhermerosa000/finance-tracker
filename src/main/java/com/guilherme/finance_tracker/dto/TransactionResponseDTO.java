package com.guilherme.finance_tracker.dto;

import com.guilherme.finance_tracker.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionResponseDTO {

    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDate date;
    private TransactionType type;
    private String categoryName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public TransactionType getType() {
        return type;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setType(TransactionType type) {
    }
}
