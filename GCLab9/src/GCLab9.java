import java.util.ArrayList;
import java.util.Scanner;


import java.util.Map;
import java.util.HashMap;
import java.util.List;
public class GCLab9 {
	public static class Validator {

		public static int getInt(Scanner scnr, String string, int i, int j) {
			
			return 0;
		}

		public static String getString(Scanner scnr, String string) {
			
			return null;
		}
		

	}

	public static void main(String[] args) {

	//Created this string for our items we will be using for the market.
		Scanner scnr = new Scanner(System.in);
		String item1 = "Apple";
		String item2 = "banana";
		String item3 = "cauliflower";
		String item4 = "dragonfruit";
		String item5 = "Elderberry";
		String item6 = "figs";
		String item7 = "grapefruit";
		String item8 = "honeydew";

		String userCont = "y";
		String userInput;
		int userNum;

		List<String> itemsOrdered = new ArrayList<>();
		List<Double> itemPrices = new ArrayList<>();
		List<Integer> itemAmounts = new ArrayList<>();

		Map<String, Double> itemList = new HashMap<>();
//Created String to make the item list prices. We use a double so that way we can us decimal places.
		itemList.put(item1, .99);
		itemList.put(item2, .59);
		itemList.put(item3, 1.59);
		itemList.put(item4, 2.19);
		itemList.put(item5, 1.79);
		itemList.put(item6, 2.09);
		itemList.put(item7, 1.99);
		itemList.put(item8, 3.49);
//Here is our prompt that displays the welcome greeting along with the items displayed underneath in a menu. 
		System.out.println("Welcome to Guenther's Market!");
		System.out.println("Item                Price        ");
		System.out.println("=============================");
		for (String name : itemList.keySet()) {
			String key = name;
			Double value = itemList.get(name);
			System.out.printf("%-20s", key);
			System.out.printf("$%-13.2f", value);
			System.out.println();
		}
//need a do-while loop to keep the program running and asking the user what they want to order
		do {
			System.out.println();
			System.out.println("What item would you like to order?");
//using if & else statements along with our validator to see how many the user wants and add their input to our "Cart".
//else statement prompt is for not inputing what we have set in our parameters. 
			userInput = scnr.nextLine();
			if (itemList.containsKey(userInput)) {
				if (!itemsOrdered.contains(userInput)) {
					itemPrices.add(itemList.get(userInput));
					itemsOrdered.add(userInput);
					userNum = Validator.getInt(scnr, "How many would you like?", 1, 20);
					itemAmounts.add(userNum);
					System.out.printf(userNum + " " + userInput + " added to cart", itemList.get(userInput));
					System.out.println(" each.");

				} else {
					int newAmount = 0;
					userNum = Validator.getInt(scnr, "How many would you like?", 1, 20);
					newAmount = itemAmounts.get(itemsOrdered.indexOf(userInput)) + userNum;
					itemAmounts.set((itemsOrdered.indexOf(userInput)), newAmount);
					System.out.printf(userNum + " " + userInput + " added to cart" , itemList.get(userInput));
					
				}
			} else {
				System.out.println("Sorry we don't have those. Please try again");
			}
//using our validator it checks if the user wants to keep going or end if, else statements to move on.
			userCont = Validator.getString(scnr,
					"Would you like to order anything else? Press \"y\" to continue or \"n\" to end your order");
		} while (userCont.equalsIgnoreCase("y"));

		if (itemsOrdered.size() > 0) {
			System.out.println();
			System.out.println("Thank you for your order!");
			System.out.println("Here's what you got:");

			for (int i = 0; i < itemsOrdered.size(); i++) {
				System.out.printf("%-5d", itemAmounts.get(i));
				System.out.printf(" " + "%-20s", itemsOrdered.get(i));
				System.out.printf("$%-13.2f", itemPrices.get(i) * itemAmounts.get(i));
				System.out.println();
			}
			

		} else {
			System.out.println("Well then GOODBYE!");
		}
	}

	public static Double maxDouble(List<Double> input) {
		Double max = input.get(0);
		for (Double item : input) {
			if (item > max) {
				max = item;
			}
		}
		return max;
	}

	public static Double minDouble(List<Double> input) {
		Double min = input.get(0);
		for (Double item : input) {
			if (item < min) {
				min = item;
			}
		}
		return min;
	}

	public static Double doubleSum(List<Double> input) {
		Double total = 0.00;
		for (Double item : input) {
			total += item;
		}
		return total;
	}

	public static Double doubleSum(List<Double> input, List<Integer> multiplier) {
		Double total = 0.00;
		for (int i = 0; i < input.size(); i++) {
			total += (input.get(i) * multiplier.get(i));
		}
		return total;
	}

	public static Double doubleAvg(List<Double> input) {
		Double total = 0.00;
		for (Double item : input) {
			total += item;
		}
		Double avg = total / input.size();
		return avg;
	}

	public static int sumItems(List<Integer> input) {
		int total = 0;
		for (Integer item : input) {
			total += item;
		}
		return total;
	}

	public static Double doubleAvg(List<Double> input, List<Integer> multiplier) {
		Double total = 0.00;
		for (int i = 0; i < input.size(); i++) {
			total += (input.get(i) * multiplier.get(i));
		}
		Double avg = total / sumItems(multiplier);
		return avg;
	}
}
