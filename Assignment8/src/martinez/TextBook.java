package martinez;

public class TextBook {

	public Integer sku;
	public String title;
	public double price;
	public Integer quantity;

	public TextBook(Integer sku, String title, double price, Integer quantity) {

		this.sku = sku;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Integer getSKU() {
		return sku;
	}
	
	public String getTitle() {
		return title;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
public String toString() {
		
		return sku + ", " + title + ", " + price + ", " + quantity; 
	}
	
	

}
