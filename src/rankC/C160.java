package rankC;

import java.util.Scanner;

public class C160 {
	// 降水量の平均を求める
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			// 1行目データ受け取り
			String line1 = sc.nextLine().trim();
			int boxCounts = Integer.parseInt(line1);

			if (boxCounts < 1 || boxCounts > 100) {
				System.out.println("箱の数は1個以上、100個以下で入力");
				return;
			}
			// 2行目データ受け取り
			String[] line2 = sc.nextLine().trim().split("\\s+");
			// 雨量を格納する配列宣言
			int rainFall[] = new int[boxCounts];
			if (rainFall.length < 1 || rainFall.length > boxCounts){
				System.out.println("雨量は指定した箱の個数と同じ数入力してください");
				return;
			}

			int sumRainFall = 0; // 各箱の雨量の合計値用の変数
			for (int i = 0; i < boxCounts; i++) {
				rainFall[i] = Integer.parseInt(line2[i]);
				sumRainFall += rainFall[i];
			}
			System.out.println(sumRainFall);
			System.out.println(sumRainFall / boxCounts);
			double average = (double) sumRainFall / boxCounts;
			int roundUp = (int) Math.ceil(average);
			System.out.println(roundUp);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}

}
