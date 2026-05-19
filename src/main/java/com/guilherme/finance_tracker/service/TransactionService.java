package com.guilherme.finance_tracker.service;


import com.guilherme.finance_tracker.dto.TransactionRequestDTO;
import com.guilherme.finance_tracker.dto.TransactionResponseDTO;
import com.guilherme.finance_tracker.model.Category;
import com.guilherme.finance_tracker.model.Transaction;
import com.guilherme.finance_tracker.repository.CategoryRepository;
import com.guilherme.finance_tracker.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;

    public TransactionService(TransactionRepository transactionRepository,
                              CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
    }

    public TransactionResponseDTO create(TransactionRequestDTO dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found: "
                        + dto.getCategoryId()));

        Transaction transaction = new Transaction();
        transaction.setDescription(dto.getDescription());
        transaction.setAmount(dto.getAmount());
        transaction.setDate(dto.getDate());
        transaction.setType(dto.getType());
        transaction.setCategory(category);

        Transaction saved = transactionRepository.save(transaction);
        return toDTO(saved);
    }
    public List<TransactionResponseDTO> findAll() {
        return transactionRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    public TransactionResponseDTO findById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transaction not found: " + id));
        return toDTO(transaction);
    }

    private TransactionResponseDTO toDTO(Transaction transaction) {
        TransactionResponseDTO dto = new TransactionResponseDTO();
        dto.setId(transaction.getId());
        dto.setDescription(transaction.getDescription());
        dto.setAmount(transaction.getAmount());
        dto.setDate(transaction.getDate());
        dto.setType(transaction.getType());
        dto.setCategoryName(transaction.getCategory().getName());
        return dto;
    }
}
