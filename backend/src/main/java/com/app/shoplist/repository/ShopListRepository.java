package com.app.shoplist.repository;

import com.app.shoplist.model.ShopList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopListRepository extends JpaRepository<ShopList, Long> {
}

