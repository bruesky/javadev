package lesson7.lecture.java8;

import java.time.LocalDate;

public class Admin {
	private DisplayItem[] items;
	public Admin() {
		populateItems();
	}
	public DisplayItem[] getAllDisplayItems() {
		return items;
	}
	
	private void populateItems() {
		items = new DisplayItem[4];
		items[0] = 
		  new Book("Willie", LocalDate.of(2018, 1, 1), "Willie's First Book");
		items[1] = 
		  new Poster("Rich", LocalDate.of(2017, 12, 1), 20, 20);
		items[2] =
		  new Software("Al", LocalDate.of(2017, 11, 1), "Insert install CD and run");
		// Possible to include enum type which implements DisplayItem
		items[3] =
		  DinosaurStatue.Dinosaur_Item;
	}
}
