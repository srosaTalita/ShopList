package com.app.shoplist.controller;

import com.app.shoplist.model.ItemList;
import com.app.shoplist.service.impl.ItemListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("api/v1/items-list")
@RestController
public class ItemListController {

    @Autowired
    private ItemListServiceImpl itemListService;

    @GetMapping
    public ResponseEntity<List<ItemList>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(itemListService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ItemList>> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemListService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<ItemList> create(@RequestBody ItemList user) {
        return ResponseEntity.status(HttpStatus.OK).body(itemListService.createItemList(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemList> edit(@PathVariable Long id, @RequestBody ItemList user) {
        return ResponseEntity.status(HttpStatus.OK).body(itemListService.editItemList(id, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(itemListService.deleteItemList(id));
    }
}
