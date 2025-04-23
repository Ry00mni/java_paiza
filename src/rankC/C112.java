package rankC;

import java.util.Scanner;

public class C112 {
//	C112:時差ボケ
//	N
//	s_1 f_1 t_1
//	s_2 f_2 t_2
//	...
//	s_N f_N t_N
//	・1 行目にパイザ氏の旅程の日数を表す整数 N が与えられます。
//	・続く N 行のうちの i 行目 (1 ≦ i ≦ N) には、整数 s_i, f_i, t_i がこの順で半角スペース区切りで与えられ、
//	これは i 日目の予定が「出発地の現地時間 s_i 時に出発し、
//	飛行機に f_i 時間乗ったのち、
//	到着地の現地時間 t_i 時に到着する」というものであるということを表します。
//	1 ≦ N ≦ 100
//	・1 ≦ s_i, f_i, t_i ≦ 23 (1 ≦ i ≦ N)
//	・ケース中に出てくる任意の 2 つのタイムゾーンのペアに対して、時差が 24 時間以上となることはない
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int days = isValidRange(sc, 1, 100, "旅行日数");
			
			int max = 0;
			int min = 0;
			int total = 0;
			
			for (int i = 0; i < days; i++) {
				int ar = isValidRange(sc, 1, 23, "出発時刻");
				int onPlane = isValidRange(sc, 1, 23, "飛行機に乗っている時間");
				int dp = isValidRange(sc, 1, 23, "到着時刻"); 
				
				int diffCheckTime = ar + onPlane; 	// 出発までの時間 + 移動時間
				int remainTime = 24 - dp; 			// 到着からの残り時間
//				int timeDiff = Math.abs(dp - diffCheckTime); // 時差
//				if (diffCheckTime == dp) {
//					total = diffCheckTime + remainTime;
//				} else if (diffCheckTime < dp) { // 到着した国の時刻が進んでいる = 短くなる
//					total = diffCheckTime + remainTime;
//				} else if (dp < diffCheckTime) { // 到着した国の時刻が遅れている = 長くなる
					total = diffCheckTime + remainTime;
//				}
				if (i == 0) {
					min = total;
				} else {
					min = Math.min(min, total);
				}
				max = Math.max(max, total);
				
			}
			System.out.println(min);
			System.out.println(max);
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
