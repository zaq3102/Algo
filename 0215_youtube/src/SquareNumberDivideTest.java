import java.util.Scanner;

public class SquareNumberDivideTest {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int n = sc.nextInt();

		System.out.println(exp(x, n));
		System.out.println(callCnt);
	}

	static int callCnt = 0;

	public static long exp(long x, long n) {
		System.out.println("test1 : " + n);
		callCnt++;
		if (n == 1)
			return x;

		long y = exp(x, n / 2);

		System.out.println("test2 : " + y + n);
		return (n % 2 == 0) ? y * y : y * y * x; // ex) 2^5 = 2^2 * 2^2 *2

	}

}

// 분할정복기법
