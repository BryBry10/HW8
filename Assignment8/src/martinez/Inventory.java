package martinez;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Inventory {
	
	public HashMap<Integer,TextBook> books;
    private static final String FILE_NAME = "inventory.txt"; 

	
	public Inventory() {
		books = new HashMap<>();
		loadInventory();
	}
	
	public void addTextBook(TextBook book) {
		
		books.put(book.getSKU(),book);
		saveInventory();
	}
	
	public void removeTextBook(Integer sku) {
		books.remove(sku);
	}
	
	public void displayTextBook(Integer sku, JTextField textfield) {
		
		TextBook book = books.get(sku);
		
		if(sku == null) {
			textfield.setText("This book does not exist in the database :(");
		}
		else {
			textfield.setText(book.toString());
		}
	}
	
	public void displayInventory(JTextArea textArea) {
		String displayInventory = "";
		
		if(books.isEmpty()) {
			textArea.setText("This inventory is empty :(");
		}
		else {
			for (TextBook book : books.values()) {
		        displayInventory += ("\n" + book.toString());
		    }
		}
		textArea.setText(displayInventory);
	}
	
	 public void saveInventory() {
	        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
	            out.writeObject(books);  
	        } catch (IOException e) {
	            System.out.println("Error saving inventory: " + e.getMessage());
	        }
	    }

	    // Method to load the inventory from a file
	    @SuppressWarnings("unchecked")
		void loadInventory() {
	        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
	            books = (HashMap<Integer, TextBook>) in.readObject();  // Deserialize the list of books
	        } catch (IOException | ClassNotFoundException e) {
	            // If no saved data exists (or file doesn't exist), we start with an empty list
	            System.out.println("Error loading inventory or file not found. Starting with an empty inventory.");
	        }
	    }
}
