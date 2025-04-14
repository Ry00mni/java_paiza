package rankC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C015 {
//	C015:ポイントカードの計算
//	N　　　　#各レシートの数
//	d_1 p_1　#1枚目のレシートの日付 d_1 日, 購入金額 p_1 円
//	d_2 p_2　#2枚目のレシートの日付 d_2 日, 購入金額 p_2 円
//	...
//	d_N p_N　#N枚目のレシートの日付 d_N 日, 購入金額 p_N 円
//	・ 1 ≦ N ≦ 1000 (レシートの数)
//	・ 1 ≦ d_i ≦ 31 (i番目のレシートが発行された日付)
//	・ 1 ≦ p_i ≦ 10000 (i番目のレシートの購入金額)
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int receiptCounts = isValidRange(sc, 1, 1000, "レシート枚数");
			sc.nextLine();
			
//			List<Receipt> receipt = new ArrayList<>();
			List<String> dayList = new ArrayList<String>();
			List<Integer> priceList = new ArrayList<Integer>();
			
			int collectedPoint = 0;
			
			for (int i = 0; i < receiptCounts; i++) {
				// 日付の入力値検査の為一度intで取得
				int d = isValidRange(sc, 1, 31, "日付");
				// 文字列に変換
				String day = String.valueOf(d);
				int price = isValidRange(sc, 1, 10000, "購入金額");
//				receipt.add(new Receipt(day, price));
				dayList.add(day);
				priceList.add(price);
			}
			// 日付ごとに獲得ポイントを集計
			for (int i = 0; i < receiptCounts ; i++) {
				collectedPoint = collectedPoint + pointsCalc(dayList.get(i), priceList.get(i));
			}
//			for (Receipt r : receipt) {
//				if (r.day.contains("3")) {
//					collectedPoint = collectedPoint + (int)(r.price * 0.03);
//				} else if (r.day.contains("5")) {
//					collectedPoint = collectedPoint + (int)(r.price * 0.05);
//				} else {
//					collectedPoint = collectedPoint + (int)(r.price * 0.01);
//				}
//			}
			System.out.println(collectedPoint);
			
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
//	public static class Receipt {
//		String day;
//		int price;
//		
//		Receipt(String day, int price){
//			this.day = day;
//			this.price = price;
//		}
//	}
	private static int pointsCalc(String day, int price) {
		if (day.contains("3")) {
			return (int)(price * 0.03);
		} else if (day.contains("5")) {
			return (int)(price * 0.05);
		} else {
			return (int)(price * 0.01);
		}
		
	}
}
