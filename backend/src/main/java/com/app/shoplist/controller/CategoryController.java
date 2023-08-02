package com.app.shoplist.controller;

import com.app.shoplist.model.Category;
import com.app.shoplist.service.impl.CategoryItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryItemServiceImpl categoryItemServiceImpl;

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryItemServiceImpl.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable Long id) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(categoryItemServiceImpl.findById(id));
    }

    @PostMapping
    public ResponseEntity<List<Category>> create(@RequestBody List<Category> categories) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryItemServiceImpl.createCategories(categories));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category category) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(categoryItemServiceImpl.updateCategory(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoryItemServiceImpl.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
}
