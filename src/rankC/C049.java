package rankC;

import java.util.Scanner;

public class C049 {
//	C049:【ぱいじょ！コラボ問題】エレベーター
//	N
//	f_1
//	...
//	f_N
//	・1 行目にログの行数を示す整数 N が入力が与えられます。
//	・続く N 行にエレベーターが止まった階 f_i (1 ≦ i ≦ N) が整数で順に入力されます。
//	何回分動いたか
//	・1 ≦ N ≦ 100
//	・1 ≦ f_i ≦ 100 (1 ≦ i ≦ N)
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int logs = isValidRange(sc, 1, 100, "ログの数");
			
			
			int[] floor = new int[logs];
			
			for (int i = 0; i < logs; i++) {
				floor[i] = isValidRange(sc, 1, 100, "何階?");
			}
			
			int moveCount = 0;
			for (int i = 0; i < floor.length; i++) {
				if (i == 0) {
					moveCount = Math.abs(floor[i] - 1);
				} else {
					moveCount += Math.abs(floor[i - 1] - floor[i]);
				}
			}
			System.out.println(moveCount);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	private static int isValidRange(Scanner sc, int min, int max, String label) {
		int value = sc.nextInt();
		if (value < min || value > max) {
	        System.out.printf("%sは%d以上、%d以下でなければなりません。\n", label, min, max);
	        System.exit(1); //プログラム自体の終了 メソッドを終了させたければreturnにする
		}
		return value;
	}


}
