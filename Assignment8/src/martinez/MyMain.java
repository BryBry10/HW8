package martinez;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyMain {

	private JFrame frame;
	private JTextField textSKU;
	private JTextField textTitle;
	private JTextField textPrice;
	private JTextField textQuantity;
	private JTextField textSKUToBeRemoved;
	private JTextField textDisplaySKU;
	public JTextField textBookOutput;
	public Inventory storage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMain window = new MyMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyMain() {
		initialize();
		storage = new Inventory();
		storage.loadInventory();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewBookInfo = new JLabel("Insert New Book Information");
		lblNewBookInfo.setBounds(10, 0, 138, 24);
		frame.getContentPane().add(lblNewBookInfo);
		
		textSKU = new JTextField();
		textSKU.setBounds(172, 21, 86, 20);
		frame.getContentPane().add(textSKU);
		textSKU.setColumns(10);
		
		textTitle = new JTextField();
		textTitle.setBounds(287, 21, 86, 20);
		frame.getContentPane().add(textTitle);
		textTitle.setColumns(10);
		
		JLabel lblSKU = new JLabel("SKU");
		lblSKU.setHorizontalAlignment(SwingConstants.CENTER);
		lblSKU.setBounds(193, 5, 46, 14);
		frame.getContentPane().add(lblSKU);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(307, 5, 46, 14);
		frame.getContentPane().add(lblTitle);
		
		textPrice = new JTextField();
		textPrice.setBounds(172, 52, 86, 20);
		frame.getContentPane().add(textPrice);
		textPrice.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(193, 39, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		textQuantity = new JTextField();
		textQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		textQuantity.setBounds(287, 52, 86, 20);
		frame.getContentPane().add(textQuantity);
		textQuantity.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Quantity");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(317, 39, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TextBook book = new TextBook(Integer.parseInt(textSKU.getText()), textTitle.getText(), Double.parseDouble(textPrice.getText()), Integer.parseInt(textQuantity.getText()));
				storage.addTextBook(book);
				storage.saveInventory();
				textSKU.setText("");         
		        textTitle.setText("");      
		        textPrice.setText("");       
		        textQuantity.setText("");   
				
			}
		});
		btnAddBook.setBounds(44, 35, 89, 23);
		frame.getContentPane().add(btnAddBook);
		
		JLabel lblRemoveATextbook = new JLabel("Remove a Textbook");
		lblRemoveATextbook.setBounds(44, 69, 104, 14);
		frame.getContentPane().add(lblRemoveATextbook);
		
		JButton btnRemoveBook = new JButton("Remove Book");
		btnRemoveBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storage.removeTextBook(Integer.parseInt(textSKUToBeRemoved.toString()));
				
			}
		});
		btnRemoveBook.setBounds(287, 83, 104, 23);
		frame.getContentPane().add(btnRemoveBook);
		
		textSKUToBeRemoved = new JTextField();
		textSKUToBeRemoved.setBounds(172, 83, 86, 20);
		frame.getContentPane().add(textSKUToBeRemoved);
		textSKUToBeRemoved.setColumns(10);
		
		JLabel lblRemovedSKU = new JLabel("SKU");
		lblRemovedSKU.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemovedSKU.setBounds(193, 69, 46, 14);
		frame.getContentPane().add(lblRemovedSKU);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 125, 394, -11);
		frame.getContentPane().add(separator);
		
		JLabel LineSeperator1 = new JLabel("------------------------------------------------------------------------------------------------------");
		LineSeperator1.setBounds(10, 64, 414, 14);
		frame.getContentPane().add(LineSeperator1);
		
		JLabel LineSeperator2 = new JLabel("------------------------------------------------------------------------------------------------------");
		LineSeperator2.setBounds(10, 100, 414, 14);
		frame.getContentPane().add(LineSeperator2);
		
		textDisplaySKU = new JTextField();
		textDisplaySKU.setBounds(47, 107, 86, 20);
		frame.getContentPane().add(textDisplaySKU);
		textDisplaySKU.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SKU:");
		lblNewLabel_1.setBounds(20, 110, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnDisplayBook = new JButton("Display Book Info");
		btnDisplayBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//here you will run the displayTextBook() method - you must input the book sku and the desired text field for your output
				Integer sku = Integer.parseInt(textDisplaySKU.getText());
				storage.displayTextBook(sku,textBookOutput );
				textSKU.setText("");         
		        textTitle.setText("");      
		        textPrice.setText("");       
		        textQuantity.setText("");   
			}
		});
		btnDisplayBook.setBounds(10, 131, 123, 23);
		frame.getContentPane().add(btnDisplayBook);
		
		textBookOutput = new JTextField();
		textBookOutput.setBounds(172, 125, 219, 20);
		textBookOutput.setEditable(false);
		frame.getContentPane().add(textBookOutput);
		textBookOutput.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(171, 171, 220, 79);
		frame.getContentPane().add(textArea);
		
		JButton btnDisplayInventory = new JButton("Display Inventory");
		btnDisplayInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				storage.displayInventory(textArea);

			}
		});
		btnDisplayInventory.setBounds(10, 172, 123, 23);
		frame.getContentPane().add(btnDisplayInventory);
		
		JLabel LineSeperator3 = new JLabel("------------------------------------------------------------------------------------------------------");
		LineSeperator3.setBounds(10, 147, 414, 14);
		frame.getContentPane().add(LineSeperator3);
	}
	

}
