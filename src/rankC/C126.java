package rankC;

import java.util.Scanner;

public class C126 {
//	C126:宿泊費と交通費
//	A B N
//	x_1 y_1
//	x_2 y_2
//	...
//	x_N y_N
//	・1 行目に新幹線の片道の料金を表す整数 A、ホテルの一泊あたりの料金を表す整数 B、インターンシップの回数を表す整数 N 
//	・続く N 行のうちの i 行目 (1 ≦ i ≦ N) には、i 番目のインターンシップの初日を表す整数 x_i と最終日を表す整数 y_i 
//	一番安く行動したときの宿泊費と交通費の合計の自己負担額を整数で出力してください。
//	・1 ≦ A, B ≦ 10,000
//	・1 ≦ N ≦ 20
//	・0 ≦ x_i ≦ y_i ≦ 100 (1 ≦ i ≦ N)
//	・y_i < x_{i+1} (1 ≦ i < N)
//	・それぞれのインターンシップの期間は被らない
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int singleFare = isValidRange(sc, 1, 10000, "片道料金");
			int acFee = isValidRange(sc, 1, 10000, "宿泊費");
			int isCount = isValidRange(sc, 1, 20, "インターンシップの回数");
			
			int stayCost = 0;
			int notStayCost = 0;
			int totalCost = singleFare; // 最初に向かう文の交通費を初期値とする
			
			int[] startArr = new int[isCount];
			int[] endArr = new int[isCount];
			for (int i = 0; i < isCount; i++) {
				startArr[i] = isValidRange(sc, 0, 100, "開始日");
				endArr[i] = isValidRange(sc, 0, 100, "終了日");
			}
			
			for (int i = 0; i < isCount; i++) {
				if (i == isCount - 1) {  // 最終日は帰宅するだけなので、交通費だけ足してbreak
					totalCost += singleFare;
					break;
				}
				// 次のインターンシップが始まるまでの空白期間を算出
				int durationDay = startArr[i + 1] - endArr[i];
				stayCost = acFee * durationDay;  // 滞在した場合の費用
				notStayCost = singleFare * 2;	 // 帰宅した場合の交通費
				totalCost += Math.min(stayCost, notStayCost);
			}
			
			System.out.println(totalCost);
			
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