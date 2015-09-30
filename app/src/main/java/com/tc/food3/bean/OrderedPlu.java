package com.tc.food3.bean;

import java.lang.reflect.Modifier;
import java.util.List;

/**
 * Created by tianxuefeng on 28/9/15.
 */
public class OrderedPlu {

    /*
    "uniqueID": 81856,
          "pluID": 95518,
          "qty": 1,
          "name": "TheHalf&Half",
          "portion_size_name": "Regular",
          "price": "22.0000",
          "modifiers": [
     */

    private Integer uniqueID;
    private Integer pluID;
    private Integer qty;
    private String name;
    private String portion_size_name;
    private List<Modifier> modifiers;
    private String price;

    public Integer getPluID() {
        return pluID;
    }

    public void setPluID(Integer pluID) {
        this.pluID = pluID;
    }

    public Integer getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(Integer uniqueID) {
        this.uniqueID = uniqueID;
    }

    public List<Modifier> getModifiers() {
        return modifiers;
    }

    public void setModifiers(List<Modifier> modifiers) {
        this.modifiers = modifiers;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPortion_size_name() {
        return portion_size_name;
    }

    public void setPortion_size_name(String portion_size_name) {
        this.portion_size_name = portion_size_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
}
