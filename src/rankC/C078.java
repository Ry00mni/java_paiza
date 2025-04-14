package rankC;

import java.util.Scanner;

public class C078 {
//	C078:株の売買
//	N c_1 c_2　　株を売買する日数を表す整数 N、
//	p_1　　　　　株の売買条件を表す整数 c_1, c_2 
//	p_2
//	...
//	p_N
//	・1 ≦ N ≦ 100
//	・1 ≦ c1 < c2 ≦ 1000
//	・1 ≦ p_i ≦ 1000 (1 ≦ i ≦ N)
//	赤字もありうる
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int day = isValidRange(sc, 1, 100, "日数");
			int buyPrice = isValidRange(sc, 1, 1000, "購入価格設定");
			int sellPrice = isValidRange(sc, 1, 1000, "売却価格設定");
			
			int holding = 0; //持ち株数カウンタ
			int profits = 0; //利益
			for (int i = 0; i < day - 1; i++) {
				int stockPrice = isValidRange(sc, 1, 1000, "株価");
				if (stockPrice < 1 || stockPrice > 1000) {
					break;
				}
				
				if (stockPrice <= buyPrice) { // 購入設定価格以下の値段であれば1株買う
					holding ++;
					profits = profits - stockPrice;
				} else if (sellPrice <= stockPrice) { // 売却設定価格以上であれば持ち株全売却
					profits = profits + holding * stockPrice;
					holding = 0;
				} else {
				}
			}
			int finalDayStockPrice = isValidRange(sc, 1, 1000, "最終日株価");
			if (finalDayStockPrice < 1 || finalDayStockPrice > 1000) {
				return;
			}
			if ( 0 < holding ) {
				profits = profits + holding * finalDayStockPrice;
			}
			
			
			System.out.println(profits);
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
