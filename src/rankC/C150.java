package rankC;

import java.util.Scanner;

public class C150 {
//	C150:ご挨拶
//	N D
//	X Y
//	x_1 y_1
//	x_2 y_2
//	...
//	x_N y_N
//	・1 行目に 家の数を表す整数 N とご挨拶に伺う範囲の距離 D が半角スペース区切りで与えられます。
//	・続く 2 行目に PAIZA さんの家の座標 X, Y が半角スペース区切りで与えられます。
//	・続く 3 行目から N+3 行目にわたって、町に建っている家の座標 x_i, y_i (1 ≦ i ≦ N) が半角スペース区切りで与えられます。
//	PIAZA さんがご挨拶に伺う家の数を出力してください。
//	・1 ≦ N ≦ 100
//	・1 ≦ D ≦ 200
//	・-100 ≦ X, Y ≦ 100
//	・-100 ≦ x_i, y_i ≦ 100 (1 ≦ i ≦ N)
//	・同じ座標に複数の家は存在しない
//	| x_1 - x_2 | + | y_1 - y_2 |
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int houses = isValidRange(sc, 1, 100, "軒数");
			int greetDisRange = isValidRange(sc, 1, 200, "距離");
			
			int x1 = isValidRange(sc, -100, 100, "x座標");
			int y1 = isValidRange(sc, -100, 100, "y座標");
			
			int count = 0;
			for (int i = 0; i < houses; i++) {
				int x2 = isValidRange(sc, -100, 100, "x座標");
				int y2 = isValidRange(sc, -100, 100, "y座標");
				int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
				if (distance <= greetDisRange) {
					count ++;
				}
			}
			System.out.println(count);
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
