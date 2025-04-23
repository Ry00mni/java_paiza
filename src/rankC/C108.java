package rankC;

import java.util.Scanner;

public class C108 {
//	C108:【50万人記念問題】観光の計画
//	N
//	x_1
//	x_2
//	...
//	x_N
//	c_{1, 1} c_{1, 2} ... c_{1, N}
//	c_{2, 1} c_{2, 2} ... c_{2, N}
//	...
//	c_{N, 1} c_{N, 2} ... c_{N, N}
//	K
//	y_1
//	y_2
//	...
//	y_K
//	・1 行目に全ての観光名所の数を表す整数 N が与えられます。
//	・続く N 行のうちの i 行目 (1 ≦ i ≦ N) には、i 番目の観光名所の滞在時間を表す整数 x_i がこの順で半角スペース区切りで与えられます。
//	・続く N 行のうちの i 行目 (1 ≦ i ≦ N) には N 個の整数が半角スペース区切りで与えられます。i 行目の j 番目 (1 ≦ j ≦ N) の整数 c_{i, j} は i 番目の観光名所から j 番目の観光名所への移動時間を意味します。
//	・続く 1 行には、行きたい観光名所の数を表す整数 K が与えられます。
//	・続く K 行のうちの i 行目 (1 ≦ i ≦ K) には、i 番目に訪れたい観光名所を表す整数 y_i が与えられます。
//	・入力は合計で 2 × N + K + 2 行となり、入力値最終行の末尾に改行が 1 つ入ります。
//	旅行にかかる時間を整数で出力してください。
//	・1 ≦ N ≦ 100
//	・1 ≦ x_i ≦ 100 (1 ≦ i ≦ N)
//	・各 i, j (1 ≦ i, j ≦ N) について
//	　・1 ≦ c_{i, j} ≦ 100 (i ≠ j)
//	　・c_{i, j} = 0 (i = j)
//	　・c_{i, j} = c_{j, i} (i ≠ j)
//	・1 ≦ K ≦ 100
//	・1 ≦ y_i ≦ N (1 ≦ i ≦ K)
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int tourCount = isValidRange(sc, 1, 100, "観光名所の数");
			
			// 滞在時間取得
			int[] stayTimeArr = new int[tourCount]; 
			for (int i = 0; i < tourCount; i++) { 
				stayTimeArr[i] = isValidRange(sc, 1, 100, "滞在時間");
			}
			// 移動時間の表を２次元配列で取得
			int[][] durTimeArr = new int[tourCount][tourCount];
			for (int i = 0; i < tourCount; i++) {
				for (int j = 0; j < tourCount; j++) {
					if (i == j) {
						durTimeArr[i][j] = isValidRange(sc, 0, 0, "移動時間");
					} else {
					durTimeArr[i][j] = isValidRange(sc, 1, 100, "移動時間");
					}
				}
			}
			
			int wishToGo = isValidRange(sc, 1, 100, "行きたい観光名所の数");
			int[] wishArr = new int [wishToGo]; 
			// 観光地を回る順番取得(観光地は番号で管理)
			for (int i = 0; i < wishToGo; i++) {
				wishArr[i] = isValidRange(sc, 1, tourCount, "観光地ID");
			}
			
			// 観光地IDのi,i+1番目を取り出して、二次元配列の行をiで、
//			int stayTimeSum = stayTimeArr[0]; // 最初の滞在時間を初期値とする
			int stayTimeSum = stayTimeArr[wishArr[0] - 1];
			int durTimeSum = 0;
			for (int i = 1; i < wishArr.length; i++) {
				int ar = wishArr[i -1]; // 出発地点ID
				int dp = wishArr[i];// 到着地点ID
				int durTime = durTimeArr[ar - 1][dp - 1];
				durTimeSum += durTime;  // 移動時間合計値
				stayTimeSum += stayTimeArr[dp - 1]; // 移動先での滞在時間
			}
			
			System.out.println(stayTimeSum + durTimeSum);
			
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
