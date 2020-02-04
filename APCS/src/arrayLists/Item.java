package arrayLists;

public class Item {

	private String name;
	private double price;
	private String type;

	public Item() {
		this("");
	}

	public Item(String name) {
		this(name, 0);
	}

	public Item(String name, int price) {
		this(name, price, "");
	}

	public Item(String name, int price, String type) {
		this.name = name;
		this.price = price;
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setType(String type) { // may need to change this depending on input methods
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return this.price;
	}

	public String getType() {
		return this.type;
	}

}
