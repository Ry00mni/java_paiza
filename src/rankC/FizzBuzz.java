package rankC;

import java.util.Scanner;

public class FizzBuzz {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			int N = sc.nextInt();
			if (N < 1 || N > 100) {
				System.out.println("1~100でオナシャス");
				return;
			}
			
			for (int i = 1 ; i <= N ; i++) {
				if (i % 3 == 0 && i % 5 == 0) {
					System.out.println("Fizz Buzz");
				} else if (i % 3 == 0) {
					System.out.println("Fizz");
				} else if (i % 5 == 0) {
					System.out.println("Buzz");
				} else {
					System.out.println(i);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}

}
