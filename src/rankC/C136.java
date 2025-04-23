package rankC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C136 {
//	C136:ダイエットの連続記録
//	N
//	x_1
//	x_2
//	...
//	x_N
//	・1 行目に記録した体重の総数を表す整数 N が与えられます。
//	・続く N 行のうちの i 行目 (1 ≦ i ≦ N) には、記録を始めてから i 日目の体重を表す整数 x_i が与えられます。
//	・入力は合計で N + 1 行となり、入力値最終行の末尾に改行が 1 つ入ります。
//	ダイエットが続いた最大日数、ダイエットを怠った最大日数を以下の形式で出力してください。
//	x y
//	・2 ≦ N ≦ 100,000
//	・0 ≦ x_i ≦ 100,000 (1 ≦ i ≦ N)
//	・x_i ≠ x_(i+1) (1 ≦ i ≦ N-1)
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int day = isValidRange(sc, 2, 100000, "日数");
			List<Integer> weightList = new ArrayList<Integer>();
			
			for (int i = 0; i < day; i++) {
				int weight = isValidRange(sc, 0, 100000, "体重");
				weightList.add(weight);
			}
			// 怠けた日の記録
			int incCount = 0;
			int maxInc = 0;
			
			// ダイエットした日の記録
			int decCount = 0;
			int maxDec = 0;
			
			for (int i = 1; i < weightList.size(); i++) {
				int previousWeight = weightList.get(i - 1);
				int targetWeight = weightList.get(i);
				
				if (previousWeight < targetWeight) { // 怠けた回数
					incCount ++;
					decCount = 0;
					// 最大カウント数を保存
					maxInc = Math.max(incCount, maxInc);
				} else if (targetWeight < previousWeight) { //頑張った回数
					decCount ++;
					incCount = 0;
					// 最大カウント数保持
					maxDec = Math.max(decCount, maxDec);
				} else { 									//同じ値なら処理終了
					return;
				}
				
			}
			System.out.println(maxDec + " " + maxInc);
			
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
