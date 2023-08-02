package com.app.shoplist.controller;

import com.app.shoplist.model.ShopList;
import com.app.shoplist.service.impl.ShopListServiceImpl;
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

import java.util.List;

@RestController
@RequestMapping("/shoplist")
public class ShopListController {
    
    @Autowired
    ShopListServiceImpl shopListServiceImpl;

    @GetMapping
    public ResponseEntity<List<ShopList>> getAll() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(shopListServiceImpl.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopList> getById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(shopListServiceImpl.findById(id));
    }

    @PostMapping
    public ResponseEntity<ShopList> create(@RequestBody ShopList shopList) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(shopListServiceImpl.createShopList(shopList));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShopList> update(@PathVariable Long id, @RequestBody ShopList category) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(shopListServiceImpl.updateShopList(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        shopListServiceImpl.deleteShopList(id);
        return ResponseEntity.ok().build();
    }
}


