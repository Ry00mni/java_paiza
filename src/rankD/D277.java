package rankD;

import java.util.Scanner;

public class D277 {
	//残りの枚数
	//・1 ≦ n ≦ 100
//	・1 ≦ m ≦ n
	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)){
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (n < 1 || n > 100) {
				return;
			}
			if (m < 1 || m > n) {
				return;
			}
			System.out.println(n - m);
			
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}

}
