package com.guilherme.finance_tracker.controller;

import com.guilherme.finance_tracker.dto.CategoryRequestDTO;
import com.guilherme.finance_tracker.model.Category;
import com.guilherme.finance_tracker.service.CategoryService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

   @PostMapping
    public ResponseEntity<Category> create (@RequestBody @Valid CategoryRequestDTO dto) {
        Category created = categoryService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
   }

   @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(categoryService.findAll());
   }
}
