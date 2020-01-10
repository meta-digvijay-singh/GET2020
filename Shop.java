import java.util.Scanner;

public class Shop
{
	public static void main(String args[])
	{
		int choice = 1; // Choice = 1 initially displays Instructions for the person.  
		boolean isExit = false;
		String person;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter user or admin : ");
		person = sc.next();
		person = person.toLowerCase();
		if ("user".equals(person))
		{
			String itemName;
			int quantity;
			ShoppingCart userCart = new ShoppingCart();
			ShoppingCart.displayAvailableItems(); //Display Available items in store.
			while(true)
			{	
				switch (choice)
				{
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
						System.out.println("Enter Item Name : ");
						itemName = sc.next();
						System.out.println("Enter quantity : ");
						quantity = sc.nextInt();
						userCart.addItem(itemName, quantity);
						break;
						
					case 3:
						System.out.println("Enter Item Name : ");
						itemName = sc.next();
						System.out.println("Enter quantity : ");
						quantity = sc.nextInt();
						userCart.updateItem(itemName, quantity);
						break;
						
					case 4:
						System.out.println("Enter Item Name : ");
						itemName = sc.next();
						userCart.removeItem(itemName);
						break;
						
					case 5:
						userCart.displayCart();
						break;
						
					case 6:
						userCart.generateBill();
						break;
					
					case 7:
						ShoppingCart.displayAvailableItems();
						break;
						
					default:
						isExit = true;
				}
				if (isExit)
				{
					System.out.println("Thanks for your time.");
					break;
				}
				System.out.println("Enter your choice : ");
				choice = sc.nextInt();
				
			}
			
		} 
		
		else if("admin".equals(person))
		{
			String itemName;
			int price;
			while(true)
			{
				switch(choice)
				{
					case 1:
						System.out.println("Instructions : press below keys for operation");
						System.out.println("1. To get Instructions.");
						System.out.println("2. Add item to the stock.");
						System.out.println("3. Remove item from stock.");
						System.out.println("4. Display Stock Items.");
						System.out.println("Enter any other number for exit.");
						break;
					
					case 2:
						System.out.println("Enter item name : ");
						itemName = sc.next();
						System.out.println("Enter price of the item : ");
						price = sc.nextInt();
						itemName = itemName.toLowerCase();
						ShoppingCart.addStockItem(itemName, price);
						break;
					
					case 3:
						System.out.println("Enter item name");
						itemName = sc.next();
						itemName = itemName.toLowerCase();
						ShoppingCart.discardStockItem(itemName);
						break;
						
					case 4:
						ShoppingCart.displayAvailableItems();
						break;
					
					default:
						isExit = true;
				}
				if (isExit)
				{
					System.out.println("Thanks for your time.");
					break;
				}
				System.out.println("Enter your choice : ");
				choice = sc.nextInt();
			}
		}
		else
		{
			System.out.println("You do not have permission to access this.");
		}
		sc.close();
	}
		
}