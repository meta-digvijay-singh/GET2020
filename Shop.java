import java.util.Scanner;

public class Shop {
	private static Scanner sc = new Scanner(System.in);
	
	/*
	 * Displays Available items in stock with their prices.
	 */
	private static void displayStockItems() {
		ShoppingCart.displayAvailableItems();
	}
	
	/*
	 * Allows user to enter only integer value.
	 * @return : value entered by user.
	 */
	private static int getIntegerValueOnly() {
		
		while (true) {
			try {
				return sc.nextInt();
			} catch (Exception ex) {
				System.out.println("Enter integer value only :");
				sc.next();
			}
		}
	}
	
	/*
	 * Takes itemName from user.
	 * @return : item name provided by user.
	 */
	private static String getItemName() {
		String itemName;
		
		System.out.println("Enter Item Name : ");
		itemName = sc.next();
		return itemName;
	}
	
	/*
	 * Takes quantity of the item from the user.
	 * @return : quantity provided by user.
	 */
	private static int getQuantity() {
		int quantity;
		
		System.out.println("Enter quantity : ");
		quantity = getIntegerValueOnly();
		
		return quantity;
		
	}
	
	/*
	 * Takes price of item from user.
	 * @return : price provided by user.
	 */
	private static int getPrice() {
		int price;
		
		System.out.println("Enter price of the item : ");
		price = getIntegerValueOnly();
		
		return price;
	}
	
	/*
	 * Actions user can perform.
	 */
	private static void userActions() {
		int choice = 1; //choice = 1 provides instructions to the user initially.
		String itemName;
		int quantity;
		boolean isExit = false;
		
		ShoppingCart userCart = new ShoppingCart();
		
		while(true) {	
			
			switch (choice) {
				
				case 1:
					System.out.println("\nInstructions : Press below keys for operation");
					System.out.println("1. To get Instructions.");
					System.out.println("2. Add Item to the cart");
					System.out.println("3. Update Item of the cart");
					System.out.println("4. Remove Item from the cart");
					System.out.println("5. Display Cart Items with quantity");
					System.out.println("6. Display Bill");
					System.out.println("7. Display Available Items in store.");
					System.out.println("Press any other digit for exit\n");
					break;
						
				case 2:
					itemName = getItemName();
					quantity = getQuantity();
					userCart.addItem(itemName, quantity);
					break;
					
				case 3:
					itemName = getItemName();
					quantity = getQuantity();
					userCart.updateItem(itemName, quantity);
					break;
					
				case 4:
					itemName = getItemName();
					userCart.removeItem(itemName);
					break;
					
				case 5:
					userCart.displayCart();
					break;
					
				case 6:
					userCart.generateBill();
					break;
				
				case 7:
					displayStockItems();
					break;
					
				default:
					isExit = true;
			}
			
			if (isExit) {
				System.out.println("Thanks for your time.");
				break;
			}
			
			System.out.println("Enter your choice : ");
			choice = getIntegerValueOnly();
		}
	}
	
	/*
	 * Actions administrator of the store can perform.
	 */
	private static void adminActions() {
		int choice = 1; //choice = 1 provides instructions to the administrator initially.
		int price;
		String itemName;
		boolean isExit = false;
		
		while(true) {
			
			switch(choice) {
				
				case 1:
					System.out.println("\nInstructions : press below keys for operation");
					System.out.println("1. To get Instructions.");
					System.out.println("2. Add item to the stock.");
					System.out.println("3. Remove item from stock.");
					System.out.println("4. Display Stock Items.");
					System.out.println("Enter any other number for exit.\n");
					break;
				
				case 2:
					itemName = getItemName();
					price = getPrice();
					ShoppingCart.addStockItem(itemName, price);
					break;
				
				case 3:
					itemName = getItemName();
					ShoppingCart.discardStockItem(itemName);
					break;
					
				case 4:
					displayStockItems();
					break;
				
				default:
					isExit = true;
			}
			
			if (isExit) {
				System.out.println("Thanks for your time.");
				break;
			}
			
			System.out.println("Enter your choice : ");
			choice = getIntegerValueOnly();
		}
	}
	
	/*
	 * Main method uses helper methods to provide complete functionality.
	 */
	public static void main(String args[]) {
		String person;
		
		System.out.println("Enter 'user' or 'admin' : ");
		person = sc.next();
		person = person.toLowerCase();
		
		if ("user".equals(person)) {
			
			// Functionality for user.
			displayStockItems();
			userActions();
			
		} else if("admin".equals(person)) {
			
			// Functionality for administrator.
			displayStockItems();
			adminActions();
			
		} else {
			
			System.out.println("You do not have permission to access this.");
		}
		sc.close();
	}
}
