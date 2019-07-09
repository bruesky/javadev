package solution;

public class Application
{
	public static void main(String args[]) throws CloneNotSupportedException {
		Catalog catalog = new Catalog();

		Group summerPackage = new Group(100, "Summer Package", "Popular Summer Products");
		summerPackage.add(new ProductItem(010, "Boogie Board", "Long Beach Boogie Surfing Board", 250));
		summerPackage.add(new ProductItem(107, "Raybans", "Rayban Snobish Sunglasses", 135));
		summerPackage.add(new ProductItem(237, "Swim suit", "Dolphin Dark Blue Swim Suit", 150));

		Group globeTrotter = new Group(321, "Globe Trotter", "Travel Accessories");
		globeTrotter.add(new ProductItem(032, "GPS", "Never-lost GPS Device", 330));
		globeTrotter.add(new ProductItem(016, "Portable", "Card-based Cell Phone", 35));
		summerPackage.add(globeTrotter);

		summerPackage.add(new ProductItem(180, "Easy Bow", "Beginner's Bow", 95));

		catalog.add(summerPackage);

		// Add an entire clone of "Summer Package"

		Group winterPackage = (Group)(summerPackage.clone());
		winterPackage.setName("Winter Package");
		winterPackage.add(new ProductItem(463, "Space Heater", "Keeps you warm", 125));
		catalog.add(winterPackage);
		catalog.showAll();
	}
}
