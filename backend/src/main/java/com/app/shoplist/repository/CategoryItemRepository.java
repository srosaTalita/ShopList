package com.app.shoplist.repository;

import com.app.shoplist.model.CategoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryItemRepository extends JpaRepository<CategoryItem, Long> {
}
