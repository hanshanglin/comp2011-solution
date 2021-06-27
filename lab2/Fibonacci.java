package comp2011.lab2;

public class Fibonacci {
	// a recursive (and very bad) way to calculate fibonacci numbers.
	// 不允許用矩陣算法。。。
	public static long recursive(int n) {
		if (n <= 1) return n;
		return recursive(n - 2) + recursive(n - 1);
	}

	public static long good(int n) {
		return -1;
	}
	public static void main(String[] args) {
		long startTime = 0;
		double duration = 0;
		int n = 32; 
		while (true) {
			startTime = System.currentTimeMillis();
			System.out.println(recursive(n));
			duration = (System.currentTimeMillis() - startTime) / 1000.;
			System.out.println("fibonacci(" + n + ") takes " + duration + " seconds.");
			
			// quit after it becomes too slow 
			if (duration > 1800) System.exit(0);
			
			startTime = System.currentTimeMillis();
			System.out.println(good(n));
			duration = (System.currentTimeMillis() - startTime) / 1000.;
			System.out.println("good(" + n + ") takes " + duration + " seconds.");
			n++;
		}
	}
}
