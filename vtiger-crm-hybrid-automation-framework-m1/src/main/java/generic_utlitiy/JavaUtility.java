package generic_utlitiy;

public class JavaUtility {
	public static int generateRandomNumber() {
		int random = (int) (Math.random() * 1000);
		return random;
	}
	
	public static long getTodaysDateTime() {
		return System.currentTimeMillis()/1000;
	}
}
