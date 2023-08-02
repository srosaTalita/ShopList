package com.app.shoplist.service.impl;

import com.app.shoplist.exception.errors.ShopListNotFoundException;
import com.app.shoplist.model.ShopList;
import com.app.shoplist.repository.ShopListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopListServiceImpl {

    @Autowired
    private ShopListRepository shopListRepository;

    public List<ShopList> findAll() {return shopListRepository.findAll();}

    public ShopList findById(Long id) {
        return shopListRepository
                .findById(id)
                .orElseThrow(() -> new ShopListNotFoundException("Not found"));
    }

    public ShopList createShopList(ShopList shopList) {return shopListRepository.save(shopList);}

    public ShopList updateShopList(Long id, ShopList category) {
        if (!shopListRepository.existsById(id)) {
            throw new ShopListNotFoundException("Not found");
        }
        return shopListRepository.save(buildShopList(category));
    }

    public void deleteShopList(Long id) {
        if (!shopListRepository.existsById(id)) {
            throw new ShopListNotFoundException("Not found");
        }
        shopListRepository.deleteById(id);
    }

    private ShopList buildShopList(ShopList shopList) {
        ShopList updatedShopList = ShopList.builder()
                .id(shopListRepository.findById(shopList.getId()).get().getId())
                .name(shopList.getName())
                .build();

        return shopListRepository.save(updatedShopList);
    }
}
