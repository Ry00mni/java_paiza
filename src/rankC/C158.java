package rankC;

import java.util.Scanner;

public class C158 {
//	C158:定期購読の価格計算
//	N M
//	f_1 p_1
//	...
//	f_N p_N
//	・1 行目に定期購入している商品の種類 N と、何週間後までの金額を計算するかを表す整数 M がこの順に半角スペース区切りで与えられます。
//	・続く N 行の i 行目 (1 ≦ i ≦ H) には、i 番目の商品の購入頻度を表す整数 f_i と、価格 p_i がこの順に半角スペース区切りで与えられます。
//	1 週目に全ての商品の定期購入があったとき、M 週目までの間に合計いくら支払うことになるかを出力してください。
//	・2 ≦ N ≦ 100
//	・10 ≦ M ≦ 100
//	・1 ≦ i ≦ N に対し、
//	　・1 ≦ f_i ≦ 16
//	　・100 ≦ p_i ≦ 100,000
//	　・p_i は 100 の倍数
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int types = isValidRange(sc, 2, 100, "商品種類");
			int weeks = isValidRange(sc, 10, 100, "何週間?");
			
			// 購入頻度、価格を格納する配列作成
			int[] freqArr = new int[types];
			int[] priArr = new int[types];
			
			for (int i = 0; i < types; i++) {
				freqArr[i] = isValidRange(sc, 1, 16, "購入頻度");
				priArr[i] = isValidRange(sc, 100, 100000, "商品価格");
			}
			
//			M-1週目を頻度で割ったときの剰余が0以上のタイミングで購入
			int totalCosts = 0;
			for (int i = 1; i <= weeks; i++) {
				int purchaseCount = 0; // 購入個数カウント
				int perWeekCosts = 0; // 週ごとの費用
				// すべての商品に対して購入するかどうかを判定
				for (int j = 0; j < freqArr.length; j++) { 
					if ((i - 1) % freqArr[j] == 0) { 
						purchaseCount ++;
						perWeekCosts += priArr[j];
					}
				}
				
				// 割引処理
				if (purchaseCount == 2) {
					perWeekCosts = (int) ((int) perWeekCosts * 0.9);
				} else if (purchaseCount >= 3) {
					perWeekCosts = (int) ((int) perWeekCosts * 0.85);
				}
				
				// 合計金額足し込み
				totalCosts += perWeekCosts;
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
