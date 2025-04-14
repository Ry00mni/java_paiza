package rankC;

import java.util.Scanner;

public class C022 {
//	C022:ローソク足
//	n　　　　日数 n
//	s_1 e_1 h_1 l_1
//	...
//	s_n e_n h_n l_n　s_i は始値、e_i は終値、h_i は高値、l_i は安値
//	
//	n 日間の始値、終値、高値、安値を 1 つの半角スペース区切りで1行に出力
//	・1 ≦ n ≦ 1,000
//	・1 ≦ s_i, e_i, h_i, l_i ≦ 1,000,000
//	・h_i ≧ s_i, e_i, l_i
//	・l_i ≦ s_i, e_i, h_i
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int days = isValidRange(sc, 1, 1000, "日数");
			
			int[] openPrice = new int[days];
			int[] closePrice = new int[days];
			int[] highPrice = new int[days];
			int[] lowPrice = new int[days];
			
			// 各値を各配列で取得、格納
			for (int i = 0; i < lowPrice.length; i++) {
				openPrice[i] = isValidRange(sc, 1, 1000000, "始値");
				closePrice[i] = isValidRange(sc, 1, 1000000, "終値");
				highPrice[i] = isValidRange(sc, 1, 1000000, "高値");
				lowPrice[i] = isValidRange(sc, 1, 1000000, "安値");
			}
			
			int max = highPrice[0];
			int min = lowPrice[0];
			for (int i = 0; i < days; i++) {
				if (max < highPrice[i]) {
					max = highPrice[i];
				}
				if (lowPrice[i] < min) {
					min = lowPrice[i];
				}
			}
			
			System.out.print(openPrice[0] + " ");
			System.out.print(closePrice[days - 1] + " ");
			System.out.print(max + " ");
			System.out.println(min);
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
