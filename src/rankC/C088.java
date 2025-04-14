package rankC;

import java.util.Scanner;

public class C088 {
//	C088:RPGでお買い物
//	N  道具の個数を表す整数 N 
//	a_1 ... a_N  N 個の各道具の単価が半角スペース区切り
//	T Q   最初の所持金を表す整数 T と注文回数を表す整数 Q
//	x_1 k_1
//	...
//	x_Q k_Q  道具の番号を表す整数 x_j とその個数 k_j 
//	所持金よりも x_Q k_Q  の値段が高いときは何もしない
//	・1 ≦ N ≦ 100
//	・1 ≦ a_i ≦ 999,999 (1 ≦ i ≦ N)
//	・0 ≦ T ≦ 999,999
//	・1 ≦ Q ≦ 100
//	・1 ≦ x_j ≦ N (1 ≦ j ≦ Q)
//	・1 ≦ k_j ≦ 99 (1 ≦ j ≦ Q)
//	最終的な残金を表す整数を 1 行で出力してください。
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int itemCount = isValidRange(sc, 1, 100, "道具の数");
			
			int[] price = new int[itemCount];
			for (int i = 0; i < itemCount; i++) {
				price[i] = isValidRange(sc, 1, 999999, "道具の単価");
			}
			
			int balance = isValidRange(sc, 0, 999999, "初期所持金");
			int orderCount = isValidRange(sc, 1, 100, "注文回数");
			
			for (int i = 0; i < orderCount; i++) {
				int itemId = isValidRange(sc, 1, itemCount, "道具番号");
				int howManyItems = isValidRange(sc, 1, 99, "購入個数");
				int total = price[itemId - 1] * howManyItems;
				if (total <= balance) {
					balance = balance - total;
				}
			}
			
			System.out.println(balance);
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
