import java.util.*;

public class DictionaryTester {

	private static Scanner kb = new Scanner(System.in);
	private static String result;

	public static void main(String[] args) {
		DictHashTable table = new DictHashTable();
		
		System.out.println(table.isWord("pistol"));
		
//		while(1 > 0) {
//			String value = getInput(result);
//			if(value.equals("0"))
//				System.exit(0);
//			System.out.println(value);
//			Integer[] input = convertToArray(value);
//			
//		//INSERT CODE HERE.
//		//You will pass input[] to your tree
//			
//			
//		}
		
	}

	public static String getInput(String result) {
		System.out.println("PLEASE ENTER A POSITIVE THREE-DIGIT NUMBER (0 to exit)");
		System.out.println("______________________________________________________");
		System.out.print("------>");
		result = kb.next();
		
		if (result.charAt(0) == '0') {
			System.exit(0);
			return "0";
		} else if (result.length() != 3) {
			System.out.println("Error Format");
			return getInput(result);
		}
		
		try {
			Integer.parseInt(result);
			return result;
		} catch (NumberFormatException x) {
			System.out.println("Format Error");
			return getInput(result);
		}
	}
	
	public static Integer[] convertToArray(String convert) {
		Integer[] input = new Integer[3];
		for(int i = 0; i < convert.length(); i++) {
			input[i] = Character.getNumericValue(convert.charAt(i));
		}
		return input;
	}
}
