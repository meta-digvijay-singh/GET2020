import java.util.Map;
import java.util.HashMap;

public class ShoppingCart {
	/* Items with their prices available in store. */
	private static final Map<String, Integer> availableItems = new HashMap<String, Integer>(); 
	/* Cart of the user to put items and quantities. */
	private Map<String, Integer> cartItems; 
	
	/* Initializing the Menu of Items. */
	static {
		/* Putting item and price per quantity. */
		availableItems.put("notebook", 50);
		availableItems.put("pen", 20);
		availableItems.put("pencil", 10);
		availableItems.put("crayons", 40);
		availableItems.put("rubber", 10);
	}
	
	/*
	 * It creates an empty cart. 
	 */
	public ShoppingCart() {
		
		cartItems = new HashMap<String, Integer>();
	}
	
	/*
	 * Display available items in the stock to user.
	 */
	public static void displayAvailableItems() {
		
		System.out.println("Available Items in store");
		
		/* Get each item from cart and print item and its price */
		for (String item : availableItems.keySet()) {
			int pricePerQuantity = availableItems.get(item);
			
			System.out.println("Item Name : " + item + ", Price(for one quantity) : " + pricePerQuantity);
		}
	}
	
	/*
	 * Add item in the cart with quantity.
	 * if item already in cart then increases the quantity.
	 * @param itemName : item to be added.
	 * @param quantity : quantity of the item. Assume quantity > 0;
	 */
	public void addItem(String itemName, int quantity) {
		itemName = itemName.toLowerCase();
		
		if (quantity > 0) {
			
			/* Validation Check : Checks whether that item is available in store. */
			if (availableItems.containsKey(itemName)) {
				
				/* Validation Check : Checks whether item is already available in user's cart. */
				if (cartItems.containsKey(itemName)) {
					final int previousQuantity = cartItems.get(itemName);
					final int newQuantity = previousQuantity + quantity;
					
					cartItems.put(itemName, newQuantity);
				} else {
					
					cartItems.put(itemName, quantity);
				}

			} else {
				
				System.out.println(itemName + " is not available in store.");
			}

		} else {
			
			System.out.println("Quantity should be greater than 0.");
		}
	}
	
	/*
	 * Update Cart Items and Quantity.
	 * @param itemName : item to be updated. 
	 * @param quantity : quantity to be updated.
	 */
	public void updateItem(String itemName, int quantity) {
		itemName = itemName.toLowerCase();
		
		if (quantity == 0) {
			
			removeItem(itemName);
		} else if (quantity > 0) {
			
			/*Validation Check : Checks whether that 
			  item is available in the user's cart already. */
			if (cartItems.containsKey(itemName)) {
				
				cartItems.replace(itemName, quantity); // Updates quantity.
				System.out.println(itemName + " updated to quantity " + quantity);
			} else {
				
				System.out.println(itemName + " is not available in Cart.");
			}

		} else {
			
			System.out.println("quantity should be greater than 0.");
		}
	}
	
	/*
	 * Remove item from the cart if available.
	 * @param itemName : item to be removed.
	 */
	public void removeItem(String itemName) {
		itemName = itemName.toLowerCase();
		
		/* Checks whether item is present in the cart. */
		if (cartItems.containsKey(itemName)) {
			
			cartItems.remove(itemName);
			System.out.println(itemName + " removed from cart.");
		} else {
			
			System.out.println(itemName + " is not present in the cart.");
		}
	}
	
	/*
	 * Display Cart Items.
	 */
	public void displayCart() {
		
		if (!cartItems.isEmpty()) {
			
			for (String item : cartItems.keySet()) {
				System.out.println("Item : " + item + ", Quantity : " + cartItems.get(item));
			}
			
		} else {
			System.out.println("Cart is Empty.");
		}
	}
	
	/*
	 * Generates Bill.
	 */
	public void generateBill() {
		
		if (!cartItems.isEmpty()) {
			int grandTotal = 0;
			
			for (String item : cartItems.keySet()) {
				int quantity = cartItems.get(item); 
				int priceOfEachItem = availableItems.get(item); 
				int totalPrice = quantity * priceOfEachItem;
				
				System.out.println("Item : " + item + ", Price(for one quantity) : " + priceOfEachItem + ", Quantity : " + quantity + ", Total Price : " + totalPrice);
				grandTotal += totalPrice;
			}
			
			System.out.println("Grand Total : " + grandTotal);
		} else {
			
			System.out.println("Cart is Empty.");
		}
	}
	
	/*
	 * Add items and price to the store.
	 * @param itemName : item to added to store.
	 * @param price : price of the item.
	 */
	public static void addStockItem(String itemName, int price) {
		itemName = itemName.toLowerCase();
		
		availableItems.put(itemName, price);
	}
	
	/*
	 * Remove items from store.
	 * @param itemName : item to be removed from store.
	 */
	public static void discardStockItem(String itemName) {
		itemName = itemName.toLowerCase();
		
		if (availableItems.containsKey(itemName)) {
			
			availableItems.remove(itemName);
			System.out.println(itemName + " removed from store.");
		} else {
			
			System.out.println(itemName + " is not available in stock");
		}
	}
}
