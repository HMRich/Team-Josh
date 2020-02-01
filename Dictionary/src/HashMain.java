import java.io.FileNotFoundException;

public class HashMain {
	public static void main(String[] args) throws FileNotFoundException {
		HashTest hash = new HashTest();
		System.out.println(hash.isWord("a"));
	}
}
