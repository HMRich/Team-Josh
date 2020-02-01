import java.io.*;
import java.util.*;

public class DictHashTable {
	private Hashtable<Integer, String> hashtable = new Hashtable<Integer, String>();
	
	public DictHashTable() {
		File file = new File("src//dictionary.txt");
		Scanner read;
		
		try {
			read = new Scanner(file);
			
			while(read.hasNextLine()) {
				String[] result = read.nextLine().split(",");
				hashtable.put(1, result[0]);
			}
			read.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isWord(String value) {
		return hashtable.contains(value);
	}
	//TODO edit this so it will iterate through the entire array. Use other arrays to keep track of true or false.
//	public boolean isWord(String[] value) {
//		for(int i = 0; i < value.length; i++) {
//			if(hashtable.contains(value[i]))
//				return true;
//		}
//		return false;
//	}
	
}
