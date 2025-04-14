package rankC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C117 {
//	C117:大量出店
//	N M 出店する店舗の数を表す整数 N および営業する月数を表す整数 M 
//	A B C 建設費、人件費、1杯あたりの利益
//	R_1 Mヶ月で何杯販売したか
//	R_2
//	...
//	R_N
//	・1 ≦ N ≦ 1,000
//	・1 ≦ M ≦ 12
//	・1 ≦ A, B ≦ 10,000
//	・1 ≦ C ≦ 500
//	・1 ≦ R_i ≦ 1,200 (1 ≦ i ≦ N)
//	3 3
//	1000 1000 50
//	25
//	80
//	500
	public static void main(String[] args) {
		try  (Scanner sc = new Scanner(System.in)) {
			
			// 各入力値の取得、メソッドでまとめて検証
			int storesCount = readIntInRange(sc, 1, 1000, "店舗数");
			int howManyMonths = readIntInRange(sc, 1, 12, "営業期間");
			int constructCosts = readIntInRange(sc, 1, 10000, "建設費");
			int laborCosts = readIntInRange(sc, 1, 10000, "人件費");
			int profitPerServing = readIntInRange(sc, 1, 500, "1杯あたりの利益");
			
//			//店舗数取得
//			int storesCount = sc.nextInt();
//			if (storesCount < 1 || storesCount > 1000) {
//				System.out.println("店舗数は1以上、100以下");
//				return;
//			}
//			// 営業期間(~ヶ月)取得
//			int howManyMonths = sc.nextInt();
//			if (howManyMonths < 1 || howManyMonths > 12) {
//				System.out.println("営業期間は1以上、12以下");
//				return;
//			}
//			// 建設費取得
//			int constructCosts= sc.nextInt();
//			if (constructCosts < 1 || constructCosts > 10000) {
//				System.out.println("建設費は1以上、10000以下");
//				return;
//			}
//			//人件費取得
//			int laborCosts = sc.nextInt();
//			if (laborCosts < 1 || laborCosts > 10000) {
//				System.out.println("人件費は1以上、10000以下");
//				return;
//			}
//			// 1杯あたりの利益取得
//			int profitPerServing = sc.nextInt();
//			if (profitPerServing < 1 || profitPerServing > 500) {
//				System.out.println("利益は1以上、500以下");
//				return;
//			}
//			System.out.println(storesCount);
//			System.out.println(howManyMonths);
//			System.out.println(constructCosts);
//			System.out.println(laborCosts);
//			System.out.println(profitPerServing);
//			sc.nextLine();
			
			List<Integer> salesResultPerStore = new ArrayList<Integer>();
			
			// 各店舗の販売杯数を配列に格納
			for (int i = 0; i < storesCount; i++) {
				//　次に取得できるトークン(要素)があるか
				if (!sc.hasNext()) {
					System.out.println("入力値が足りません。");
					break;
				}
				int n = sc.nextInt();
				if (n < 1 || n > 1200) {
					System.out.println("異常値を検出");
					return;
				}
				salesResultPerStore.add(n);
			}
			
			int closeStoresCount = 0;
			
			for (int i = 0; i < storesCount; i++) {
				int income = profitPerServing * salesResultPerStore.get(i) - constructCosts - laborCosts * howManyMonths;
//				System.out.println(income);
				if (income < 0) {
					closeStoresCount ++;
				}
			}
			System.out.println(closeStoresCount); // 閉店店舗数出力
//			System.out.println("閉店は" + closeStoresCount + "店舗です。");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}
	// 入力値チェック関数
	private static int readIntInRange(Scanner sc, int min, int max, String label) {
	    int value = sc.nextInt();
	    if (value < min || value > max) {
	        System.out.printf("%sは%d以上、%d以下でなければなりません。\n", label, min, max);
	        System.exit(1); //プログラム自体の終了 メソッドを終了させたければreturnにする
	    }
	    return value;
	}
}
