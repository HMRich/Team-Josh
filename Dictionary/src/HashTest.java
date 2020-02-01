import java.io.File;
import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Scanner;

public class HashTest {
	Hashtable<String, Integer> table = new Hashtable<String, Integer>();
	
	public HashTest() throws FileNotFoundException {
		File file = new File("src//dictionary.txt");
		Scanner read;
		
		read = new Scanner(file);
		while(read.hasNextLine()) {
			String[] result = read.next().split(",");
			table.put(result[0], 1);
		}
	}
	
	public boolean isWord(String value) {
		return table.contains(value);
	}
}
