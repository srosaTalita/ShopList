package com.app.shoplist.service.impl;

import com.app.shoplist.exception.ObjectNotFoundException;
import com.app.shoplist.model.Category;
import com.app.shoplist.repository.CategoryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryItemServiceImpl {

    @Autowired
    CategoryItemRepository categoryItemRepository;

    public List<Category> findAll() {return categoryItemRepository.findAll();}

    public Category findById(Long id) {
        return categoryItemRepository
                .findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Not found"));
    }

    public List<Category> createCategories(List<Category> categories) {
        List<Category> createdCategories = new ArrayList<>();

        categories.forEach(category -> {
            Category createdCategory = categoryItemRepository.save(category);
            createdCategories.add(createdCategory);
        });

        return createdCategories;
    }

    public Category updateCategory(Long id, Category category) {
        if (!categoryItemRepository.existsById(id)) {
            throw new ObjectNotFoundException("Not found");
        }
        return categoryItemRepository.save(buildCategory(category));
    }

    public void deleteCategory(Long id) {
        if (!categoryItemRepository.existsById(id)) {
            throw new ObjectNotFoundException("Not found");
        }
        categoryItemRepository.deleteById(id);
    }
    
    private Category buildCategory(Category category) {
        Category updatedItemList = Category.builder()
                .id(categoryItemRepository.findById(category.getId()).get().getId())
                .category(category.getCategory())
                .description(category.getDescription())
                .build();

        return categoryItemRepository.save(updatedItemList);
    }
}
