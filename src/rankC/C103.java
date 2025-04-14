package rankC;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C103 {
//	C103:ロボット芸人
//	N M　ロボットが作動する時間を表す整数 N　ロボットの動作の規則の数を表す整数 M
//	a_1 b_1
//	a_2 b_2
//	...
//	a_M b_M　j 番目のロボットの動作の規則を表す整数 a_j および動作名を表す文字列 b_j 
//
//	ロボットの動きのシミュレーション結果を以下の形式で出力
//	c_1
//	c_2
//	...
//	c_N
//	・1 ≦ N ≦ 1,000
//	・1 ≦ M ≦ 5
//	・各 j (1 ≦ j ≦ M) について
//	　・2 ≦ a_j ≦ 10
//	　・b_j は英字小文字から構成される文字列
//	　・1 ≦ (b_j の長さ) ≦ 10
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int actionCount = isValidRange(sc, 1, 1000, "行動回数");
			int ruleCount = isValidRange(sc, 1, 5, "規則数");
			
			int[] rule = new int[ruleCount]; // ruleの配列
			String[] action = new String[actionCount]; // actionの配列
			
			//各配列に値を取得、格納
			for (int i = 0; i < ruleCount; i++) {
				rule[i] = isValidRange(sc, 2, 10, "秒の倍数");
				String a = sc.next();
				if (a.length() < 1 || 10 < a.length()) {
					return;
				}
				action[i] = a;
			}

			for (int i = 0; i < actionCount; i++) {
				// 何も無ければ出力される数字
				int basicNum = i + 1;
				// 行動を格納するリスト
				List<String> outpuList = new ArrayList<String>();
				
				// i+1がルールの数字で割り切れるか確認
				// 割り切れなければbasicNumを出力
				boolean divisible = false;
				for (int j = 0; j < rule.length; j++) {
					if (basicNum % rule[j] == 0 ) {
						outpuList.add(action[j]);
						divisible = true;
					}
				}
				if (divisible) {
					System.out.println(String.join(" ", outpuList));
				} else {
					System.out.println(basicNum);
				}
//					for (int j = 0; j < outpuList.size(); j++) {
//						String output = outpuList.get(j);
//						// 行動が一つだけなら改行つき出力
//						if (outpuList.size() == 1) { 
//							System.out.println(output);
//						}
//						// 行動が2つ以上あれば、最後の要素までは改行を含めずに出力
//						if (outpuList.size() > 1) {
//							if (outpuList.size() - 1 == j) {
//								System.out.println(output);
//							} else {
//								System.out.print(output + " ");
//							}
//						}
//					}
//				} else {
//					System.out.println(basicNum);
//				}
			}
			
			
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
