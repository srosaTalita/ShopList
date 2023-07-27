package com.app.shoplist.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CategoryItemEnum {
    BEVERAGES("Bebidas"),
    FRUITS("Frutas"),
    VEGETABLES("Legumes"),
    MEAT("Carnes"),
    DAIRY("Laticínios"),
    BAKERY("Padaria"),
    HYGIENE("Higiene"),
    CLEANING("Limpeza"),
    FROZEN("Congelados"),
    CEREALS("Cereais"),
    CONFECTIONERY("Confeitaria"),
    CANNED("Enlatados"),
    OTHERS("Outros");

    private final String description;

    public String getDescription() {
        return description;
    }
}