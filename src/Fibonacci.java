/**
 * Assignment 1 
 * Five Algorithm for the Fibonacci sequence.
 * @author Moiz Abdullah
 *
 */
public class Fibonacci {	
	
	/**
	 * 1.
	 * Recursive method for Fibonacci sequence.
	 * @param n is the index of the Fibonacci sequence
	 * @return Fibonacci number at n
	 */
	public static long fibRec(int n) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		return fibRec(n - 1) + fibRec(n - 2);
	}
	// it take f(n) times to do f(n-1) + f(n-2)

	/**
	 * 2.
	 * Memoization method for Fibonacci sequence.
	 * @param n is the index of the Fibonacci sequence
	 * @return Fibonacci number at n
	 */
	public static long fibMem(int n) {
		long[] arr = new long[n + 1];
		return fibMem(n, arr);
	}
	
	/**
	 * Helper function for Memoization method.
	 * @param nn is the index of the Fibonacci sequence
	 * @param arr of long to hold computations
	 * @return Fibonacci number at n
	 */
	private static long fibMem(int n, long[] arr) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		if (arr[n] != 0)
			return arr[n];
		long result = fibMem(n - 2, arr) + fibMem(n - 1, arr);
		arr[n] = result;
		return result;
	}

	/**
	 * 3.
	 * Dynamic method for Fibonacci sequence.
	 * @param n is the index of the Fibonacci sequence
	 * @return Fibonacci number at n
	 */
	public static long fibDyn(int n) {
		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		long[] arr = new long[n + 1];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		return arr[n];
	}

	/**
	 * 4.
	 * Iterative method for Fibonacci sequence.
	 * @param n is the index of the Fibonacci sequence
	 * @return Fibonacci number at n
	 */
	public static long fibIter(int n) {
		if (n == 0)
			return 0;
		long x = 0;
		long y = 1;
		for (int i = 2; i <= n; i++) {
			long temp = y;
			y = y + x;
			x = temp;
		}
		return y;
	}

	/**
	 * 5.
	 * Matrix exponentiation method for Fibonacci sequence.
	 * @param n is the index of the Fibonacci sequence
	 * @return Fibonacci number at n
	 */
	public static long fibMat(int n) {
		if (n == 0)
			return 0;
		long FM[][] = { { 1, 1 }, { 1, 0 } };
		MatrixPower(n - 1, FM);
		return FM[0][0];
	}
	
	/**
	 * Helper function for Matrix exponentiation method.
	 * @param n is the index of the Fibonacci sequence
	 * @param FM long matrix 
	 */
	private static void MatrixPower (int n, long FM [][] ) {
		if (n > 1) {
			MatrixPower(n/2, FM);
			//multiplication 
			long temp [][]= new long[2][2];
			temp [0][0] = (FM [0][0]*FM [0][0]) + (FM [0][1]*FM [1][0]);
			temp [0][1] = (FM [0][0]*FM [0][1]) + (FM [0][1]*FM [1][1]);	
			temp [1][0] = (FM [1][0]*FM [0][0]) + (FM [1][1]*FM [1][0]);
			temp [1][1] = (FM [1][0]*FM [0][1]) + (FM [1][1]*FM [1][1]);	
			FM [0][0] = temp [0][0];
			FM [0][1] = temp [0][1];
			FM [1][0] = temp [1][0];
			FM [1][1] = temp [1][1];
			
			if ((n%2)!= 0 ) {
				long a [][] = { { 1, 1 }, { 1, 0 } };
				temp = new long[2][2];
				temp [0][0] = (FM [0][0]*a [0][0]) + (FM [0][1]*a [1][0]);
				temp [0][1] = (FM [0][0]*a [0][1]) + (FM [0][1]*a [1][1]);	
				temp [1][0] = (FM [1][0]*a [0][0]) + (FM [1][1]*a [1][0]);
				temp [1][1] = (FM [1][0]*a [0][1]) + (FM [1][1]*a [1][1]);	
				FM [0][0] = temp [0][0];
				FM [0][1] = temp [0][1];
				FM [1][0] = temp [1][0];
				FM [1][1] = temp [1][1];
			}
		}
	}
	
	/**
	 * The main function calls each of the five functions and prints the time taken 
	 * for a sample of the starting values of the Fibonacci sequence. 
	 * @param args not used 
	 */
	public static void main(String[] args) {
		int i, j;
		long start, end, x, avg, sum; 
		//Algorithm 1: sample from 0 to 35
		System.out.println("\n-----------");
		System.out.println("Algorithm 1");
		System.out.println("-----------");
		for (i = 0; i < 36; i++) {
			for (j = 0, sum = 0; j < 100; j++) {
				start = System.nanoTime();
				x = fibRec(i);
				end = System.nanoTime();
				sum += (end - start);
			}
			avg = sum/j;
			System.out.println(avg + " ns to compute F" + i + " with alg.1");
		}
		//Algorithm 2: sample from 0 to 50
		System.out.println("\n-----------");
		System.out.println("Algorithm 2");
		System.out.println("-----------");
		for (i = 0; i < 51; i++) {
			for (j = 0, sum = 0; j < 100; j++) {
				start = System.nanoTime();
				x = fibMem(i);
				end = System.nanoTime();
				sum += (end - start);
			}
			avg = sum/j;
			System.out.println(avg + " ns to compute F" + i + " with alg.2");
		}
		//Algorithm 3: sample from 0 to 50
		System.out.println("\n-----------");
		System.out.println("Algorithm 3");
		System.out.println("-----------");
		for (i = 0; i < 51; i++) {
			for (j = 0, sum = 0; j < 100; j++) {
				start = System.nanoTime();
				x = fibDyn(i);
				end = System.nanoTime();
				sum += (end - start);
			}
			avg = sum/j;
			System.out.println(avg + " ns to compute F" + i + " with alg.3");
		}
		//Algorithm 4: sample from 0 to 50
		System.out.println("\n-----------");
		System.out.println("Algorithm 4");
		System.out.println("-----------");
		for (i = 0; i < 51; i++) {
			for (j = 0, sum = 0; j < 100; j++) {
				start = System.nanoTime();
				x = fibIter(i);
				end = System.nanoTime();
				sum += (end - start);
			}
			avg = sum/j;
			System.out.println(avg + " ns to compute F" + i + " with alg.4");
		}
		//Algorithm 5: sample from 0 to 50
		System.out.println("\n-----------");
		System.out.println("Algorithm 5");
		System.out.println("-----------");
		for (i = 0; i < 51; i++ ) {
			for (j = 0, sum = 0; j < 100; j++) {
				start = System.nanoTime();
				x = fibMat(i);
				end = System.nanoTime();
				sum += (end - start);
			}
			avg = sum/j;
			System.out.println(avg + " ns to compute F" + i + " with alg.5");
		}
	}

}
