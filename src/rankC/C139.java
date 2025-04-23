package rankC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C139 {
//	C139:誤発注
//	N
//	x_1
//	x_2
//	...
//	x_N
//	・1 行目に必要な製品番号の範囲を表す整数 N が与えられます。
//	・続く N 行の i 行目 (1 ≦ i ≦ N) には、i 番目に届いた製品の製品番号が与えられます。
//	・入力は合計で N + 1 行からなり、入力値最終行の末尾に改行が 1 つ入ります。
//
//	1 番から N 番までの製品の中でまだ届いていない製品が何種類あるか出力
//	・1 ≦ N ≦ 10,000
//	・1 ≦ x_i ≦ 100,000 (1 ≦ i ≦ N)
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int productCount = isValidRange(sc, 1, 10000, "商品個数");
			
			List<Integer> productList = new ArrayList<Integer>();
			for (int i = 0; i < productCount; i++) {
				productList.add(isValidRange(sc, 1, 100000, "製品番号"));
			}
			
			int missCount = 0;
			for (int i = 1; i <= productCount; i++) {
				if (!productList.contains(i)) {
					missCount ++;
				}
			}
			System.out.println(missCount);
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
