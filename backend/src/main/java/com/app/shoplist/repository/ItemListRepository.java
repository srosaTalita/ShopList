package com.app.shoplist.repository;

import com.app.shoplist.model.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemListRepository extends JpaRepository<ItemList, Long> {
}
