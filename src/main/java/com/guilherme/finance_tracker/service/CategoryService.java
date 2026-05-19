package com.guilherme.finance_tracker.service;

import com.guilherme.finance_tracker.dto.CategoryRequestDTO;
import com.guilherme.finance_tracker.model.Category;
import com.guilherme.finance_tracker.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category create(CategoryRequestDTO dto) {
        if(categoryRepository.existsByName(dto.getName())) {
            throw new IllegalArgumentException("Category already exist: " + dto.getName());
        }
        Category category = new Category(dto.getName());
        return categoryRepository.save(category);
    }


    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
