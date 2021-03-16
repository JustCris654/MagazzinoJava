/*
 * 3/16/21, 12:49 PM. Scapin Cristian @JustCris654
 */

package com.justcris.Magazzino;

import java.util.ArrayList;

public class Items {
    private ArrayList<Item> items;

    public Items() {
        items = new ArrayList<>();
    }

    public Items(ArrayList<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        for (Item k :
                this.items) {
            if (k.getId() == item.getId()) {
                int q = k.getQuantity();
                k.setQuantity(q+item.getQuantity());
                return;
            }
        }
        this.items.add(item);
    }

    public boolean removeItem(int id_toremove) {
        return this.items.removeIf(x -> x.getId() == id_toremove);
    }

    public Item getItemClone(int id_toget) {
        for (Item k :
                this.items) {
            if (k.getId() == id_toget) {
                return new Item(k.getId(), k.getTitle(), k.getPrice(), 1);
            }
        }
        return null;
    }

    public Item getItem(int id_toget) {
        for (Item k :
                this.items) {
            if (k.getId() == id_toget) {
                return k;
            }
        }
        return null;
    }

    public int getQuantity(int id_toget){
        for (Item k :
                this.items) {
            if (k.getId() == id_toget) {
                return k.getQuantity();
            }
        }
        return -1;
    }

    public boolean changeQuantity(int id_toget, int newQuantity){
        for (Item k :
                this.items) {
            if (k.getId() == id_toget) {
                k.setQuantity(newQuantity);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Item> getItems() {
        ArrayList<Item> clone = new ArrayList<>(this.items.size());
        for (Item k : this.items) clone.add(new Item(
                k.getId(), k.getTitle(), k.getPrice(), k.getQuantity(), k.getImage()
        ));
        return clone;
    }

    public String toString(int id_toget) {
        return "Items{" +
                "items=" + this.items.get(id_toget) +
                '}';
    }
}

