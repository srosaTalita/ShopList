package com.app.shoplist.service.impl;

import com.app.shoplist.model.ItemList;
import com.app.shoplist.repository.ItemListRepository;
import com.app.shoplist.service.ItemListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemListServiceImpl implements ItemListService {
    
    @Autowired
    private ItemListRepository itemListRepository;

    public List<ItemList> findAll() {
        return itemListRepository.findAll();
    }

    public Optional<ItemList> findById(Long id) {
        return itemListRepository.findById(id);
    }
    

    public ItemList createItemList(ItemList itemList) {
        return itemListRepository.save(itemList);
    }

    public ItemList editItemList(Long id, ItemList itemList) {
        Optional<ItemList> optionalItemList = itemListRepository.findById(id);

        if (optionalItemList.isPresent()) {
            ItemList updatedItemList = ItemList.builder()
                    .id(optionalItemList.get().getId())
                    .name(itemList.getName())
                    .quantity(itemList.getQuantity())
                    .isItemBought(itemList.isItemBought())
                    .shopLists(itemList.getShopLists())
                    .category(itemList.getCategory())
                    .build();

            return itemListRepository.save(updatedItemList);
        }
        else {
            throw new RuntimeException("Item não encontrado");
        }
    }

    public String deleteItemList(Long id) {
        Optional<ItemList> itemList = itemListRepository.findById(id);
        if (itemList.isPresent()) {
            itemListRepository.deleteById(id);
            return "Item deletado com sucesso";
        }
        return "Item não encontrado";
    }
}
