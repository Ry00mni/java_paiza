package rankC;

import java.util.Scanner;

public class C048 {
//	C048:タダ飲みコーヒー
//	X P
//	・コーヒーの価格を示す整数 X と 割引き率を示す整数 P が、この順に半角スペース区切りで与えられます。
//	以後タダで注文するのに必要な金額を出力してください。
//	・0 ≦ X ≦ 10000
//	・1 ≦ P ≦ 100
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int price = isValidRange(sc, 0, 10000, "コーヒーの価格");
			int discountPer = isValidRange(sc, 1, 100, "割引率");
			
			// 初回購入分
			int totalCosts = price;
			while (price > 0) {
				price = (int)(price * (1 - discountPer / 100.0));
				totalCosts += price; //合計金額足し込み
			}
			System.out.println(totalCosts);
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
