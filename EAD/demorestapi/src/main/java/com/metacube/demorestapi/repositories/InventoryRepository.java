package com.metacube.demorestapi.repositories;

import java.util.ArrayList;
import java.util.List;

import com.metacube.demorestapi.pojo.Inventory;

public class InventoryRepository {
	private List<Inventory> inventories;
	
	public InventoryRepository() {
		inventories = new ArrayList<Inventory>();
		Inventory first = new Inventory();
		first.setName("Apples");
		first.setQuantity(3);
		
		Inventory second = new Inventory();
		second.setName("Oranges");
		second.setQuantity(7);
		
		Inventory third = new Inventory();
		third.setName("Pomegranates");
		third.setQuantity(55);
		inventories.add(first);
		inventories.add(second);
		inventories.add(third);
		
	}
	
	public List<Inventory> getInventories() {
		return inventories;
	}
	
	public Inventory getInventory(String name) {
		for (Inventory i : inventories) {
			if (i.getName().equals(name)) {
				return i;
			}
		}
		return new Inventory();
	}
	
	private int isInventoryExist(Inventory inv) {
		int numberOfInventories = inventories.size();
		for (int index = 0; index < numberOfInventories; index++) {
			if (inventories.get(index).getName().equals(inv.getName())) {
				return index;
			}
		}
		return -1;
	}
	
	public Inventory addInventory(Inventory inv) {
		int index = isInventoryExist(inv);
		if (index == -1) {
			inventories.add(inv);
			return inv;
		}
		Inventory currentInventory = inventories.get(index);
		int currentQuantity = currentInventory.getQuantity();
		int newQuantity = inv.getQuantity();
		currentInventory.setQuantity(currentQuantity + newQuantity);
		return currentInventory;
	}
	
	public List<Inventory> deleteInventories() {
		inventories.clear();
		return inventories;
	}

	public Inventory deleteInventory(String inventoryName) {
		Inventory inv = new Inventory();
		inv.setName(inventoryName);
		int index = isInventoryExist(inv);
		if (index == -1) {
			System.out.println("InventoryNotFound.");
			return new Inventory();
		}
		inventories.remove(index);
		return inv;
	}
	
	public Inventory updateInventory(String inventoryName, Inventory inv) {
		Inventory tempInventory = new Inventory();
		tempInventory.setName(inventoryName);
		int index = isInventoryExist(tempInventory);
		if (index == -1) {
			return new Inventory();
		}
		inventories.set(index, inv);
		return inventories.get(index);
	}
	
	public List<Inventory> updateInventories(List<Inventory> newInventories) {
		inventories = newInventories;
		return inventories;
	}
}
