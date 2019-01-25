import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Validator {
	public static int getInt(Scanner scnr, String prompt) {
		
		System.out.print(prompt);
		try {
			int num = scnr.nextInt();
			scnr.nextLine();
			return num;
		} catch (InputMismatchException e) {
			System.out.println("Enter a whole number.");
			scnr.nextLine();
			return getInt(scnr, prompt);
		}
	}

	
	public static double getDouble(Scanner scnr, String prompt) {
		
		boolean isValid = false;
		do {
			System.out.print(prompt);
			isValid = scnr.hasNextDouble();
			if (!isValid) {
				scnr.nextLine();
				System.out.println("Enter a number.");
			}
		} while (!isValid);
		
		double number = scnr.nextDouble();
		scnr.nextLine();
		return number;
	}
	
	
	public static String getString(Scanner scnr, String prompt) {
		
		System.out.print(prompt);
		return scnr.nextLine();
	}
	
	
	public static int getInt(Scanner scnr, String prompt, int min, int max) {
		boolean isValid = false;
		int number;
		do {
			number = getInt(scnr, prompt);
			
			if (number < min) {
				isValid = false;
				System.out.println("The number must be at least " + min);
			} else if (number > max) {
				isValid = false;
				System.out.println("The number must not be larger than " + max);
			} else {
				isValid = true;
			}
			
		} while (!isValid);
		return number;
	}
	
	
	public static double getDouble(Scanner scnr, String prompt, double min, double max) {
		boolean isValid = false;
		double number;
		do {
			number = getDouble(scnr, prompt);
			
			if (number < min) {
				isValid = false;
				System.out.println("The number must be at least " + min);
			} else if (number > max) {
				isValid = false;
				System.out.println("The number must not be larger than " + max);
			} else {
				isValid = true;
			}
			
		} while (!isValid);
		return number;
	}
	
	
	public static String getStringMatchingRegex(Scanner scnr, String prompt, String regex) {
		boolean isValid = false;
		String input;
		do {
			input = getString(scnr, prompt);
			
			if (input.matches(regex)) {
				isValid = true;
			} else {
				System.out.println("Input must match the appropriate format.");
				isValid = false;
			}
			
		} while (!isValid);
		return input;
	}

	
	public static Date getDate(Scanner scnr, String prompt) {
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		format.setLenient(false); 
		boolean isValid = false;
		Date date = null;
		String input;
		do {
			
			input = getString(scnr, prompt);
			
			try {
				// A ParseException, which is a checked exception it has to be caught.
				date = format.parse(input);
				// If exception doesn't happen then it is valid.
				isValid = true;
			} catch (ParseException ex) {
				// If an exception does occur then it is valid.
				isValid = false;
				System.out.println("Enter a valid date in format mm/dd/yyyy.");
			}
			
		} while (!isValid);
		return date;
	}
	
	public static boolean isYes(String answer){
		return answer.equalsIgnoreCase("yes");
			
	}
	
	public static boolean isNo(String answer){
		return answer.equalsIgnoreCase("no");
			
	}
	
	public static boolean isYesOrNo(String answer) {
		if (isNo(answer) || isYes(answer)) {
			return true;
		}else {return false;
		}
	}
	public static void yesNoCheck(String answer) {
		if (!isYesOrNo(answer)) {
			System.out.println("Please enter a valid option (\"yes\" or \"no\")");
		}
	}

}


