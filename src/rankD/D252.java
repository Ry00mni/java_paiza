package rankD;

import java.util.Scanner;

public class D252 {
//	D252:日課のランニング
//	10 ≦ X ≦ 1,000
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int x = sc.nextInt();
			if (x < 10 || x > 1000) {
				return;
			}
			System.out.println(x * 4);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}

}
