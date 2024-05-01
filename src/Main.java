
public class Main {

	public static void main(String[] args) {
		CaesarBreaker testBreaker = new CaesarBreaker();
		String enc = "./encrypted1.txt";
		testBreaker.testBreakCaesarCipher(enc);
	}
}
